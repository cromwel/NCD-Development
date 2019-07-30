package org.development.aihd.patient;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.development.aihd.R;
import org.development.aihd.Resources.AttachmentActivity;
import org.development.aihd.common.Common;
import org.development.aihd.common.DateCalendar;
import org.development.aihd.common.NavigationDrawerShare;
import org.development.aihd.forms.DM_FollowUp;
import org.development.aihd.forms.DM_Initial;
import org.development.aihd.model.KeyValue;
import org.development.aihd.model.PatientProfile;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class Profile extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private String patient_id;
    private String gender;
    private String records;
    private String isDeceased = null;
    private String cause_of_death;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationDrawerShare navigate = new NavigationDrawerShare(this);
        navigate.createDrawer(toolbar);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String identifier = intent.getStringExtra("identifier");
        String telephone = intent.getStringExtra("telephone");
        patient_id = intent.getStringExtra("patient_id");
        gender = intent.getStringExtra("gender");

        List<PatientProfile> patient = PatientProfile.findWithQuery(PatientProfile.class, "SELECT * FROM PATIENT_PROFILE WHERE patient_id = ? ", patient_id);

        for (PatientProfile pn : patient) {
            records = pn.getMedicationFile();
            Log.d("Records", records + "");
        }

        TextView textViewName = findViewById(R.id.patient_name);
        textViewName.setText(name);

        TextView textViewIdentifier = findViewById(R.id.patient_identifier);
        if (!identifier.isEmpty()) {
            textViewIdentifier.setText(identifier);
        }

       /* TextView textViewTelephone = findViewById(R.id.patient_telephone);
        if (!telephone.isEmpty()) {
            textViewTelephone.setText(telephone);
        }*/

    }


    public void summary(View view) {

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        @SuppressLint("InflateParams") final View dialogView = inflater.inflate(R.layout.patient_summary, null);
        alertDialogBuilder.setMessage("Patient Summary");

        TextView textViewAppointment = dialogView.findViewById(R.id.appointment);
        LinearLayout linearLayoutDiabetes = dialogView.findViewById(R.id.diabetes);
        LinearLayout linearLayoutHypertension = dialogView.findViewById(R.id.hypertension);

        TextView textViewTreatment = dialogView.findViewById(R.id.treatment);
        TextView textViewDrug = dialogView.findViewById(R.id.drug);
        TextView textViewFrequency = dialogView.findViewById(R.id.frequency);

        TextView textViewVitals = dialogView.findViewById(R.id.textViewVitals);

        Log.d("Range", String.valueOf(DateCalendar.dateRange(DateCalendar.date(), "2018-10-05")));

        final Button showDrugs = dialogView.findViewById(R.id.showDrugs);
        final Button hideDrugs = dialogView.findViewById(R.id.hideDrugs);
        final LinearLayout drugs = dialogView.findViewById(R.id.drugs);

        final Button showVitals = dialogView.findViewById(R.id.showVitals);
        final Button hideVitals = dialogView.findViewById(R.id.hideVitals);
        final LinearLayout vitals = dialogView.findViewById(R.id.vitals);

        try {
            JSONObject jsonObj = new JSONObject(records);

            // Getting JSON Array node
            JSONArray obs = jsonObj.getJSONArray("obs");

            if (obs.length() > 0) {
                for (int i = 0; i < obs.length(); i++) {
                    JSONObject concept = obs.getJSONObject(i);

                    switch (concept.optString("concept_id")) {
                        case "165086":
                            if (!concept.optString("concept_answer").equals("1175")) {
                                linearLayoutDiabetes.setVisibility(View.VISIBLE);
                            }
                            break;
                        case "165091":
                            if (!concept.optString("concept_answer").equals("1175")) {
                                linearLayoutHypertension.setVisibility(View.VISIBLE);
                            }
                            break;
                        case "1282":
                            textViewTreatment.append(Common.conceptAnswer(concept, "1282") + " \n");
                            break;
                        case "1443":
                            textViewDrug.append(String.format("%s mg", concept.getString("concept_answer")) + " \n");
                            break;
                        case "160855":
                            textViewFrequency.append(Common.conceptAnswer(concept, "160855") + " \n");
                            break;
                        case "5096":
                            if (DateCalendar.dateRange(DateCalendar.date(), concept.optString("concept_answer")) > 0) {
                                textViewAppointment.setTextColor(getResources().getColor(R.color.light_green));
                                textViewAppointment.append("Appointment Date: ");
                            } else {
                                textViewAppointment.setTextColor(getResources().getColor(R.color.orange));
                                textViewAppointment.append("Missed Appointment: ");
                            }
                            textViewAppointment.append(concept.optString("concept_answer"));
                            break;
                        case "5089":
                            textViewVitals.append("Weight: " + concept.optString("concept_answer") + " \n");
                            break;
                        case "5085":
                            textViewVitals.append("Blood Pressure: " + concept.optString("concept_answer") + "/");
                            break;
                        case "5086":
                            textViewVitals.append(concept.optString("concept_answer") + " \n");
                            break;

                        default:
                            break;
                    }
                }
            }


        } catch (Exception e) {
            // hiding the progress bar
            e.printStackTrace();
        }

        showDrugs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drugs.setVisibility(View.VISIBLE);
                showDrugs.setVisibility(View.GONE);
                hideDrugs.setVisibility(View.VISIBLE);
            }
        });

        hideDrugs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drugs.setVisibility(View.GONE);
                hideDrugs.setVisibility(View.GONE);
                showDrugs.setVisibility(View.VISIBLE);
            }
        });

        showVitals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vitals.setVisibility(View.VISIBLE);
                showVitals.setVisibility(View.GONE);
                hideVitals.setVisibility(View.VISIBLE);
            }
        });

        hideVitals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vitals.setVisibility(View.GONE);
                hideVitals.setVisibility(View.GONE);
                showVitals.setVisibility(View.VISIBLE);
            }
        });

        //alertDialogBuilder.setView(dialogView);

        alertDialogBuilder.setView(dialogView).setPositiveButton("OKAY", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                //Dismiss
                arg0.dismiss();
            }
        });

        final AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                final Button positiveButton = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                positiveButton.setBackgroundResource(R.drawable.rounded_button);
                positiveButton.setTextColor(Color.WHITE);
                LinearLayout.LayoutParams positiveButtonLL = (LinearLayout.LayoutParams) positiveButton.getLayoutParams();
                positiveButtonLL.gravity = positiveButtonLL.width = ViewGroup.LayoutParams.MATCH_PARENT;
                positiveButton.setLayoutParams(positiveButtonLL);
            }
        });
        alertDialog.show();
    }

    public void dmInitial(View view) {
        Intent dm_initial = new Intent(getApplicationContext(), DM_Initial.class);
        dm_initial.putExtra("patient_id", patient_id);
        dm_initial.putExtra("gender", gender);
        startActivity(dm_initial);
        finish();
    }

    public void dmFollowup(View view) {
        Intent dm_followup = new Intent(getApplicationContext(), DM_FollowUp.class);
        dm_followup.putExtra("patient_id", patient_id);
        startActivity(dm_followup);
        finish();
    }

    public void transfer(View view) {

        Intent transfer = new Intent(getApplicationContext(), Transfer.class);
        transfer.putExtra("patient_id", patient_id);
        startActivity(transfer);
        finish();
    }

    public void deceased(View view) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();

        // Set Dialog Title
        alertDialog.setTitle("Patient Deceased");

        // Set Dialog Message
        alertDialog.setMessage("Patient Status?");
        LinearLayout lp = new LinearLayout(this);
        lp.setOrientation(LinearLayout.VERTICAL);

        CheckBox checkBox = new CheckBox(this);
        checkBox.setOnCheckedChangeListener(this);
        checkBox.setId(R.id.checkBoxDeceased);
        checkBox.setText(R.string.deceased);

        Spinner spinnerCOD = view.findViewById(R.id.spinnerCOD);
        spinnerData(this, spinnerCOD, "cause_of_death");


        EditText editText = new EditText(this);
        editText.setId(R.id.editTextDeath);
        editText.setInputType(InputType.TYPE_CLASS_TEXT);
        editText.setHint("Cause of death?");

        EditText editTextDOD = new EditText(this);
        editTextDOD.setId(R.id.dod_date);
        editTextDOD.setText(DateCalendar.date());

        lp.addView(checkBox);
        lp.addView(editText);
        lp.addView(editTextDOD);
        lp.setPadding(30, 60, 30, 60);

        alertDialog.setView(lp);

        // Set OK Button
        alertDialog.setButton("SUBMIT", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                if (isDeceased.length() > 0) {
                    Toast.makeText(getApplicationContext(), "Status Updated", Toast.LENGTH_LONG).show();
                }
            }
        });

        // Show Alert Message
        alertDialog.show();

    }

    public void spinnerData(Context context, final Spinner spinner, final String data) {
        ArrayList<KeyValue> keyvalue = new ArrayList<>();

        if (data.matches("cause_of_death")) {
            // adding each child node to HashMap key => value
            keyvalue.add(new KeyValue("", "Select Cause of Death"));
            keyvalue.add(new KeyValue("", "HTN Complications"));
            keyvalue.add(new KeyValue("", "DM Complications"));
            keyvalue.add(new KeyValue("", "Other"));
        }

        ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, keyvalue);
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                KeyValue value = (KeyValue) parent.getSelectedItem();
                switch (spinner.getId()) {
                    case R.id.spinnerCOD:
                        if (data.matches("cause_of_death")) {
                            cause_of_death = value.getId();
                        }
                        break;
                }
            }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
    }

   public void attachment(View view) {
        Intent attachment = new Intent(getApplicationContext(), AttachmentActivity.class);
        attachment.putExtra("patient_id", patient_id);
        startActivity(attachment);
        finish();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (b) {
            isDeceased = "1";
        }
    }

}
