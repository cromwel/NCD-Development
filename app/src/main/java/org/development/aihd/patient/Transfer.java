package org.development.aihd.patient;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.development.aihd.R;
import org.development.aihd.Home;
import org.development.aihd.app.AppController;
import org.development.aihd.common.Alerts;
import org.development.aihd.common.Common;
import org.development.aihd.common.DateCalendar;
import org.development.aihd.common.File_Upload;
import org.development.aihd.common.JSONFormBuilder;
import org.development.aihd.common.NavigationDrawerShare;
import org.development.aihd.common.Validation;
import org.development.aihd.model.Forms;
import org.development.aihd.model.KeyValue;
import org.development.aihd.model.Location;
import org.development.aihd.model.PatientProfile;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static org.development.aihd.common.Alerts.hideDialog;

public class Transfer extends AppCompatActivity {

    private String location_id, reason;
    private String encounter_date, file_name, form_id, patient_id;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_discontinue);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationDrawerShare navigate = new NavigationDrawerShare(this);
        navigate.createDrawer(toolbar);

        Intent intent = getIntent();
        patient_id = intent.getStringExtra("patient_id");
        Log.d("PatientID", patient_id);

        file_name = "ADMISSION_" + System.currentTimeMillis() + ".json";
        form_id = System.currentTimeMillis() + "_" + patient_id;

        EditText editTextTransferredDate = findViewById(R.id.transferred_out_date);
        DateCalendar.date(this, editTextTransferredDate);

        Spinner spinnerReason = findViewById(R.id.spinnerReason);
        Spinner spinnerLocation = findViewById(R.id.spinnerLocation);
        spinnerData(this, spinnerReason, "reason");
        spinnerData(this, spinnerLocation, "location");

        final Button button = findViewById(R.id.submit_transfer);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                validateTransfer();
            }
        });
    }

    public void spinnerData(Context context, final Spinner spinner, final String data) {
        ArrayList<KeyValue> keyvalue = new ArrayList<>();

        // adding each child node to HashMap key => value
        if (data.matches("reason")) {
            keyvalue.add(new KeyValue("", "Select Reason"));
            keyvalue.add(new KeyValue("1655", "Transferred Out"));
            keyvalue.add(new KeyValue("1655", "Unknown"));
        } else if (data.matches("location")) {
            //Add locations
            keyvalue.add(new KeyValue("", "Select Location"));
            List<Location> locations = Location.findWithQuery(Location.class, "SELECT * from LOCATION ORDER BY _name ASC ");
            for (Location ln : locations) {
                // adding each child node to HashMap key => value
                keyvalue.add(new KeyValue(ln.getID(), ln.getName()));
            }
        }

        //fill data in spinner
        ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, keyvalue);
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                KeyValue keyValue = (KeyValue) parent.getSelectedItem();

                if (!keyValue.getId().isEmpty()) {

                    KeyValue value = (KeyValue) parent.getSelectedItem();
                    switch (spinner.getId()) {
                        case R.id.spinnerDesignation:
                            if (data.matches("reason")) {
                                reason = "1655";
                                Log.d("value", value.getId());
                            }
                            break;
                        case R.id.spinnerLocation:
                            if (data.matches("location")) {
                                location_id = value.getId();
                            }
                            break;
                        default:
                            break;
                    }
                    update();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Nothing selected
            }
        });
    }

    public JSONArray update() {
        JSONArray jsonArray = new JSONArray();

        jsonArray.put(JSONFormBuilder.observations("1655", "", "valueCoded", reason, DateCalendar.date(), ""));
       // jsonArray.put(JSONFormBuilder.observations("", "", "valueCoded", location_id, DateCalendar.date(), ""));

        try {
            Log.d("JSON Array1", jsonArray.toString() + " ");
            jsonArray = JSONFormBuilder.concatArray(jsonArray);
            Log.d("JSON Array", jsonArray.toString() + " ");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonArray;

    }

    public void validateTransfer() {
        Alerts.progressDialog(this, "Uploading DM Admission Form ...");
        File dir = new File(Environment.getExternalStorageDirectory() + "/aihd/admission");
        if (!dir.mkdirs()) {
            Log.e("Directory Message", "Directory not created");
        }

        File file = new File(dir, file_name);

        try {

            JSONArray jsonArray = update();
            JSONObject jsonForm = new JSONObject();
            Log.d("JSON Admission", jsonArray.toString() + " ");

           /* String error = Validation.admissionValidation(jsonArray);

            if (jsonArray.length() == 0) {
                error = "Please fill in required fields(*)";
            }*/

            if ( jsonArray.length() >= 0) {
                String creator = AppController.getInstance().getSessionManager().getUserDetails().get("user_id");

                jsonForm.put("formDescription", "Admit patient into this facility");
                jsonForm.put("formEncounterType", "e22e39fd-7db2-45e7-80f1-60fa0d5a4378");
                jsonForm.put("formUuid", "d2c7532c-fb01-11e2-8ff2-fd54ab5fdb2a");
                jsonForm.put("formVersion", "1.0");
                jsonForm.put("formUILocation", "patientDashboard.overallActions");
                jsonForm.put("formOrder", "3");
                jsonForm.put("encounterDate", DateCalendar.date());
                jsonForm.put("encounterProvider", creator);
                jsonForm.put("location_id", Common.locationId());
                jsonForm.put("patient_id", patient_id);
                jsonForm.put("obs", jsonArray);

                FileOutputStream f = new FileOutputStream(file);
                PrintWriter pw = new PrintWriter(f);
                pw.println(jsonForm.toString());
                pw.flush();
                pw.close();
                f.close();

                Forms forms = new Forms(form_id, file_name, creator, patient_id, "admission", DateCalendar.date(), "0");
                long id = forms.save();

                if ((int) PatientProfile.count(PatientProfile.class, "patient_id = ?", new String[]{patient_id}) == 0) {
                    PatientProfile patientProfile = new PatientProfile(patient_id, jsonForm.toString());
                    patientProfile.save();
                }

                Toast.makeText(getBaseContext(), "Transfer Encounter file saved", Toast.LENGTH_SHORT).show();

                boolean isConnected = File_Upload.connectivity(getApplicationContext());
                Log.d("file to upload", String.valueOf(isConnected));

                if (isConnected) {
                    File_Upload.upload(this, Environment.getExternalStorageDirectory() + "/aihd/transfer/" + file_name, id, null);
                } else {
                   // Alerts.errorMessage(view, "No Internet Connection,Unable to upload file");
                }

                // Launch login activity
                Intent intent = new Intent(this, Home.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();

            } else {
                Toast.makeText(getBaseContext(), "Failed to Upload", Toast.LENGTH_SHORT).show();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.i("Error", "*** File not found. Did you add a WRITE_EXTERNAL_STORAGE permission to the manifest?");
        } catch (Exception e) {
            e.printStackTrace();
        }

        hideDialog();

    }

}
