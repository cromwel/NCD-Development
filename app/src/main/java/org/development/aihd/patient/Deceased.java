package org.development.aihd.patient;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.development.aihd.Home;
import org.development.aihd.R;
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
import org.development.aihd.model.PatientProfile;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import static org.development.aihd.common.Alerts.hideDialog;

public class Deceased extends AppCompatActivity {

    private String patient_id, cause_of_death, file_name, form_id, deceased;
    private EditText editTextOtherCauseOfDeath, editTextDeathDate;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //View view = inflater.inflate(R.layout.activity_deceased, container, false);

        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_deceased);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationDrawerShare navigate = new NavigationDrawerShare(this);
        navigate.createDrawer(toolbar);

        Intent intent = getIntent();
        patient_id = intent.getStringExtra("patient_id");
        Log.d("PatientID", patient_id);

        file_name = "DECEASED" + System.currentTimeMillis() + ".json";
        form_id = System.currentTimeMillis() + "_" + patient_id;

        EditText editTextDeathDate = findViewById(R.id.death_date);
        DateCalendar.fulldate(this, editTextDeathDate);

        editTextOtherCauseOfDeath = findViewById(R.id.other_cause_of_death);
        textWatcher(editTextOtherCauseOfDeath);

        Spinner spinnerCauseOfDeath = findViewById(R.id.spinner_cause_of_death);
        spinnerData(this, spinnerCauseOfDeath, "cause_of_death");

        CheckBox checkBoxDeceased = findViewById(R.id.checkbox_deceased);
        checkBox(checkBoxDeceased);


        final Button button = findViewById(R.id.submit_deceased);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                validateTransfer();
            }
        });
    }

    public void spinnerData(Context context, final Spinner spinner, final String data) {
        ArrayList<KeyValue> keyvalue = new ArrayList<>();

        if (data.matches("cause_of_death")) {
            // adding each child node to HashMap key => value
            keyvalue.add(new KeyValue("0", "Select Cause of Death"));
            keyvalue.add(new KeyValue("1", "HTN Complications"));
            keyvalue.add(new KeyValue("2", "DM Complications"));
            keyvalue.add(new KeyValue("3", "Other"));
        }

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
                    case R.id.spinner_cause_of_death:
                        if (data.matches("cause_of_death")) {
                            cause_of_death = value.getId();
                        }
                        break;
                }
                update();
            }
        }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void textWatcher(EditText editText) {

        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(final Editable editable) {
                update();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

            }
        });
    }

    public void checkBox(final CheckBox checkBox) {

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                boolean checked = (buttonView).isChecked();

                //Check which checkbox was clicked
                switch (checkBox.getId()) {
                    case R.id.checkbox_tb_status:
                        if (checked) {
                            deceased = "1";
                        } else {
                            deceased = "0";
                        }
                        break;
                }

                update();
            }
        });
    }

    public JSONArray update() {
        JSONArray jsonArray = new JSONArray();

        jsonArray.put(JSONFormBuilder.observations("", "", "valueCoded", cause_of_death, DateCalendar.date(), ""));
        jsonArray.put(JSONFormBuilder.observations("", "", "valueCoded", deceased, DateCalendar.date(), ""));
        jsonArray.put(JSONFormBuilder.observations("", "", "valueText", editTextOtherCauseOfDeath.getText().toString().trim(), DateCalendar.date(), ""));

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
        Alerts.progressDialog(this, "Uploading Deceased Form ...");
        File dir = new File(Environment.getExternalStorageDirectory() + "/aihd/deceased");
        if (!dir.mkdirs()) {
            Log.e("Directory Message", "Directory not created");
        }

        File file = new File(dir, file_name);

        try {

            JSONArray jsonArray = update();
            JSONObject jsonForm = new JSONObject();
            Log.d("JSON Deceased", jsonArray.toString() + " ");

            String error = Validation.admissionValidation(jsonArray);

            if (jsonArray.length() < 0) {
                error = "Please fill in required fields(*)";
            }

            if (jsonArray.length() > 0) {
                String creator = AppController.getInstance().getSessionManager().getUserDetails().get("user_id");

                jsonForm.put("formDescription", "Retire patient");
                jsonForm.put("formEncounterType", "");
                jsonForm.put("formUuid", "");
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

                Forms forms = new Forms(form_id, file_name, creator, patient_id, "deceased", DateCalendar.date(), "0");
                long id = forms.save();

                if ((int) PatientProfile.count(PatientProfile.class, "patient_id = ?", new String[]{patient_id}) == 0) {
                    PatientProfile patientProfile = new PatientProfile(patient_id, jsonForm.toString());
                    patientProfile.save();
                }

                Toast.makeText(getBaseContext(), "Retire patient file saved", Toast.LENGTH_SHORT).show();

                boolean isConnected = File_Upload.connectivity(getApplicationContext());
                Log.d("file to upload", String.valueOf(isConnected));

                if (isConnected) {
                    File_Upload.upload(this, Environment.getExternalStorageDirectory() + "/aihd/deceased/" + file_name, id, null);
                } else {
                    // Alerts.errorMessage(view, "No Internet Connection,Unable to upload file");
                }

                // Launch login activity
                Intent intent = new Intent(this, Home.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();

            } else {
                Alerts.alert_msg(this, "Validation Error", error);
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
