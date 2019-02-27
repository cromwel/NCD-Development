package org.aihdint.aihd.patient;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.aihdint.aihd.Home;
import org.aihdint.aihd.R;
import org.aihdint.aihd.app.AppController;
import org.aihdint.aihd.common.Alerts;
import org.aihdint.aihd.common.Common;
import org.aihdint.aihd.common.DateCalendar;
import org.aihdint.aihd.common.File_Upload;
import org.aihdint.aihd.common.JSONFormBuilder;
import org.aihdint.aihd.common.NavigationDrawerShare;
import org.aihdint.aihd.common.Validation;
import org.aihdint.aihd.model.Forms;
import org.aihdint.aihd.model.KeyValue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Admission extends AppCompatActivity {

    private String fileName, formId, patientId;
    private String reason, designation;
    private EditText editTextAdmissionDate, editTextDischargeDate, editTextDischargeBy;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_admission);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationDrawerShare navigate = new NavigationDrawerShare(this);
        navigate.createDrawer(toolbar);

        Intent intent = getIntent();
        patientId = intent.getStringExtra("patient_id");
        Log.d("PatientID", patientId);

        fileName = "ADMISSION_" + System.currentTimeMillis() + ".json";
        formId = System.currentTimeMillis() + "_" + patientId;

        editTextAdmissionDate = findViewById(R.id.admission_date);
        editTextDischargeDate = findViewById(R.id.discharge_date);
        editTextDischargeBy = findViewById(R.id.discharge_by);
        editTextDischargeBy.setText(AppController.getInstance().getSessionManager().getUserDetails().get("name"));

        textWatcher(editTextDischargeDate);
        textWatcher(editTextDischargeBy);

        EditText editTextAdmissionDate = findViewById(R.id.admission_date);
        editTextAdmissionDate.setText(DateCalendar.date());
        DateCalendar.date(this, editTextAdmissionDate);

        EditText editTextDischargeDate = findViewById(R.id.discharge_date);
        DateCalendar.date(this, editTextDischargeDate);

        Spinner spinnerDesignation = findViewById(R.id.spinnerDesignation);
        Spinner spinnerReason = findViewById(R.id.spinnerReason);

        spinnerData(spinnerDesignation, "designation");
        spinnerData(spinnerReason, "reason");
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

    public void spinnerData(final Spinner spinner, final String data) {
        ArrayList<KeyValue> keyvalue = new ArrayList<>();

        // adding each child node to HashMap key => value
        if (data.matches("reason")) {
            keyvalue.add(new KeyValue("", "Select Reason"));
            keyvalue.add(new KeyValue("165314", "Admitted with DKA"));
            keyvalue.add(new KeyValue("138061", "Admitted with Hypoglycemia"));
            keyvalue.add(new KeyValue("5622", "Other"));
        } else if (data.matches("designation")) {
            keyvalue.add(new KeyValue("", "Select Designation"));
            keyvalue.add(new KeyValue("5507", "Consultant"));
            keyvalue.add(new KeyValue("162591", "Medical officer"));
            keyvalue.add(new KeyValue("1574", "Clinical Officer"));
            keyvalue.add(new KeyValue("1577", "Nurse"));
        }

        //fill data in spinner
        ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, keyvalue);
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                KeyValue keyValue = (KeyValue) parent.getSelectedItem();

                switch (spinner.getId()) {
                    case R.id.spinnerDesignation:
                        if (data.matches("designation")) {
                            designation = keyValue.getId();
                        }
                        break;
                    case R.id.spinnerReason:
                        if (data.matches("reason")) {
                            reason = keyValue.getId();
                        }
                        break;
                    default:
                        break;
                }


                update();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public JSONArray update() {
        JSONArray jsonArry = new JSONArray();
        try {

            jsonArry.put(JSONFormBuilder.observations("1655", "", "valueCoded", reason, DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1641", "", "valueDate", editTextDischargeDate.getText().toString().trim(), DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1473", "", "valueText", editTextDischargeBy.getText().toString().trim(), DateCalendar.date(), ""));
            jsonArry.put(JSONFormBuilder.observations("1655", "", "valueCoded", designation, DateCalendar.date(), ""));

            jsonArry = JSONFormBuilder.concatArray(jsonArry);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonArry;
    }

    public void validate(View view) {

        Alerts.progressDialog(this, "Uploading Admission Form ...");

        File dir = new File(Environment.getExternalStorageDirectory() + "/aihd/admission");

        if (!dir.mkdirs()) {
            Log.e("Directory Message", "Directory not created");
        }

        File file = new File(dir, fileName);

        try {

            JSONArray jsonArray = update();
            JSONObject jsonForm = new JSONObject();
            Log.d("JSON Admission", jsonArray.toString() + " ");

            String error = Validation.admissionValidation(jsonArray);

            if (jsonArray.length() == 0) {
                error = "Please fill in required fields(*)";
            }

            if (error.length() == 0 && jsonArray.length() > 0) {
                String creator = AppController.getInstance().getSessionManager().getUserDetails().get("user_id");

                jsonForm.put("formName", "Admit Patient");
                jsonForm.put("formDescription", "Admit patient into this facility");
                jsonForm.put("formEncounterType", "e22e39fd-7db2-45e7-80f1-60fa0d5a4378");
                jsonForm.put("formUuid", "d2c7532c-fb01-11e2-8ff2-fd54ab5fdb2a");
                jsonForm.put("formVersion", "1.0");
                jsonForm.put("formUILocation", "patientDashboard.overallActions");
                jsonForm.put("formOrder", "3");
                jsonForm.put("encounterDate", editTextAdmissionDate.getText().toString());
                jsonForm.put("encounterProvider", creator);
                jsonForm.put("location_id", Common.locationId());
                jsonForm.put("patient_id", patientId);
                jsonForm.put("obs", jsonArray);

                FileOutputStream f = new FileOutputStream(file);

                PrintWriter pw = new PrintWriter(f);

                pw.println(jsonForm.toString());

                pw.flush();
                pw.close();
                f.close();

                Forms forms = new Forms(formId, fileName, creator, patientId, "admission", DateCalendar.date(), "0");
                long id = forms.save();

                Toast.makeText(getBaseContext(), "Admission Encounter file saved", Toast.LENGTH_SHORT).show();


                boolean isConnected = File_Upload.connectivity(getApplicationContext());

                if (isConnected) {
                    File_Upload.upload(this, Environment.getExternalStorageDirectory() + "/aihd/admission/" + fileName, id, null);
                } else {
                    Alerts.errorMessage(view, "No Internet Connection,Unable to upload file");
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

        Alerts.hideDialog();

    }
}
