package org.aihdint.aihd.fragments.followup;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import org.aihdint.aihd.R;
import org.aihdint.aihd.common.DateCalendar;
import org.aihdint.aihd.common.JSONFormBuilder;
import org.aihdint.aihd.common.Alerts;
import org.json.JSONArray;
import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Developed by Rodney on 24/04/2018.
 */

public class Followup_page_1 extends Fragment {

    private View view;
    private EditText dm_followup_date, supporter_nameEditText, supporter_phoneEditText, supporter_phone_otherEditText;
    private EditText dmDiagnosisDateEditText, dmClinicDateEditText;
    private EditText htnDiagnosisDateEditText, htnClinicDateEditText;
    private EditText editTextTBDate, editTextTBComment;
    private String dm_diagnosis, hypertension, nhif, diabetes_type, hypertension_type, tb_screen, tb_status, hiv_status;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dm_followup_fragment_1, container, false);
        tb_status = nhif = "";

        dm_followup_date = view.findViewById(R.id.dm_followup_date);
        supporter_nameEditText = view.findViewById(R.id.supporter_name);
        supporter_phoneEditText = view.findViewById(R.id.supporter_telephone);
        supporter_phone_otherEditText = view.findViewById(R.id.supporter_telephone_other);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        dm_followup_date.setText(dateFormat.format(new Date())); // current date
        DateCalendar.fulldate(getActivity(), dm_followup_date);

        dmDiagnosisDateEditText = view.findViewById(R.id.dm_diagnosis_date);

        htnDiagnosisDateEditText = view.findViewById(R.id.htn_diagnosis_date);

        editTextTBDate = view.findViewById(R.id.tb_treatment_start);
        editTextTBComment = view.findViewById(R.id.tb_comment);

        DateCalendar.date(getActivity(), dmDiagnosisDateEditText);
        DateCalendar.date(getActivity(), htnDiagnosisDateEditText);
        DateCalendar.date(getActivity(), editTextTBDate);

        textWatcher(dm_followup_date);
        textWatcher(supporter_nameEditText);
        textWatcher(supporter_phoneEditText);
        textWatcher(supporter_phone_otherEditText);
        textWatcher(dmDiagnosisDateEditText);
        textWatcher(htnDiagnosisDateEditText);
        textWatcher(editTextTBDate);
        textWatcher(editTextTBComment);

        RadioButton radioButtonDMNew = view.findViewById(R.id.radio_diabetes_new);
        RadioButton radioButtonDMKnown = view.findViewById(R.id.radio_diabetes_known);
        RadioButton radioButtonDMNA = view.findViewById(R.id.radio_diabetes_na);
        RadioButton radioButtonDMType1 = view.findViewById(R.id.radio_diabetes_type_1);
        RadioButton radioButtonDMType = view.findViewById(R.id.radio_diabetes_type_2);
        RadioButton radioButtonDMGDM = view.findViewById(R.id.radio_diabetes_GDM);
        RadioButton radioButtonDMSecondary = view.findViewById(R.id.radio_diabetes_secondary);
        RadioButton radioButtonHTNNew = view.findViewById(R.id.radio_hypertension_new);
        RadioButton radioButtonHTNKnown = view.findViewById(R.id.radio_hypertension_known);
        RadioButton radioButtonHTNNA = view.findViewById(R.id.radio_hypertension_na);
        RadioButton radioButtonHTNMild = view.findViewById(R.id.radio_hypertension_mild);
        RadioButton radioButtonHTNModerate = view.findViewById(R.id.radio_hypertension_moderate);
        RadioButton radioButtonHTNSevere = view.findViewById(R.id.radio_hypertension_severe);
        RadioButton radioButtonHTNPreeclampsia = view.findViewById(R.id.radio_hypertension_preeclampsia);
        RadioButton radioButtonNHIFYes = view.findViewById(R.id.radio_nhif_yes);
        RadioButton radioButtonNHIFNo = view.findViewById(R.id.radio_nhif_no);
        RadioButton radioButtonHIVNegative = view.findViewById(R.id.radio_hiv_negative);
        RadioButton radioButtonHIVPositive = view.findViewById(R.id.radio_hiv_positive);
        RadioButton radioButtonHIVUknown = view.findViewById(R.id.radio_hiv_unknown);
        RadioButton radioButtonTBYes = view.findViewById(R.id.radio_tb_yes);
        RadioButton radioButtonTBNo = view.findViewById(R.id.radio_tb_no);
        RadioButton radioButtonTBNa = view.findViewById(R.id.radio_tb_na);
        RadioButton radioButtonTBNegative = view.findViewById(R.id.radio_tb_status_negative);
        RadioButton radioButtonTBPositive = view.findViewById(R.id.radio_tb_status_positive);
        RadioButton radioButtonTBTreatment = view.findViewById(R.id.radio_tb_status_treatment);

        radioButtonClicked(radioButtonDMNew);
        radioButtonClicked(radioButtonDMKnown);
        radioButtonClicked(radioButtonDMNA);
        radioButtonClicked(radioButtonDMNA);
        radioButtonClicked(radioButtonDMType1);
        radioButtonClicked(radioButtonDMType);
        radioButtonClicked(radioButtonDMGDM);
        radioButtonClicked(radioButtonDMSecondary);
        radioButtonClicked(radioButtonHTNNew);
        radioButtonClicked(radioButtonHTNKnown);
        radioButtonClicked(radioButtonHTNNA);
        radioButtonClicked(radioButtonHTNMild);
        radioButtonClicked(radioButtonHTNModerate);
        radioButtonClicked(radioButtonHTNSevere);
        radioButtonClicked(radioButtonHTNPreeclampsia);
        radioButtonClicked(radioButtonNHIFYes);
        radioButtonClicked(radioButtonNHIFNo);
        radioButtonClicked(radioButtonHIVNegative);
        radioButtonClicked(radioButtonHIVPositive);
        radioButtonClicked(radioButtonHIVUknown);
        radioButtonClicked(radioButtonTBYes);
        radioButtonClicked(radioButtonTBNo);
        radioButtonClicked(radioButtonTBNa);
        radioButtonClicked(radioButtonTBNegative);
        radioButtonClicked(radioButtonTBPositive);
        radioButtonClicked(radioButtonTBTreatment);

        return view;
    }

    public void dmDiagnosis(String diagnosis) {
        LinearLayout followup_type_of_diabetes=view.findViewById(R.id.followup_type_of_diabetes);
        LinearLayout followup_year_of_diagnosis_dm=view.findViewById(R.id.followup_year_of_diagnosis_dm);

        if (diagnosis.matches("165087") | diagnosis.matches("165088")) {
           // dmDiagnosisDateEditText.setVisibility(View.GONE);
            followup_type_of_diabetes.setVisibility(View.VISIBLE);
            followup_year_of_diagnosis_dm.setVisibility(View.VISIBLE);

        } else {
            //dmDiagnosisDateEditText.setVisibility(View.VISIBLE);
            followup_type_of_diabetes.setVisibility(View.GONE);
            followup_year_of_diagnosis_dm.setVisibility(View.GONE);
        }
    }

    public void htnDiagnosis(String status) {
        Log.d("HTN Diagnosis", status);
        LinearLayout followup_type_of_hypertension=view.findViewById(R.id.followup_type_of_hypertension);
        LinearLayout followup_year_of_diagnosis_htn=view.findViewById(R.id.followup_year_of_diagnosis_htn);

        if (status.matches("165092") | status.matches("165093")) {
            //htnDiagnosisDateEditText.setVisibility(View.GONE);
           // htnClinicDateEditText.setVisibility(View.GONE);
            followup_type_of_hypertension.setVisibility(View.VISIBLE);
            followup_year_of_diagnosis_htn.setVisibility(View.VISIBLE);
        } else {
           // htnDiagnosisDateEditText.setVisibility(View.VISIBLE);
           // htnClinicDateEditText.setVisibility(View.VISIBLE);
            followup_type_of_hypertension.setVisibility(View.GONE);
            followup_year_of_diagnosis_htn.setVisibility(View.GONE);
        }
    }

    public void hivDiagnosis(String statuses) {
        LinearLayout followup_hiv_etc_treatment=view.findViewById(R.id.followup_etc_hiv_status);

        if (statuses.matches("138571")) {
            followup_hiv_etc_treatment.setVisibility(View.VISIBLE);
        } else {
            followup_hiv_etc_treatment.setVisibility(View.GONE);
        }
    }

    public void tbDiagnosis(String state) {
        LinearLayout followup_tb_status=view.findViewById(R.id.followup_status_of_tb);
        LinearLayout followup_tb_treatment=view.findViewById(R.id.followup_treatment_of_tb);

        if (state.matches("1065")) {
            followup_tb_status.setVisibility(View.VISIBLE);

        } else {
            followup_tb_status.setVisibility(View.GONE);
            followup_tb_treatment.setVisibility(View.GONE);
        }


    }

    public void tbTeatment(String treat){
        LinearLayout followup_tb_treatment=view.findViewById(R.id.followup_treatment_of_tb);
        if(treat.matches("703") | treat.matches("1662")){
            followup_tb_treatment.setVisibility(View.VISIBLE);
        }else{
            followup_tb_treatment.setVisibility(View.GONE);
        }

    }

    public void textWatcher(EditText editText) {

        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(final Editable editable) {
                updateValues();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });
    }

    public void radioButtonClicked(final RadioButton radioButton) {

        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                boolean checked = (buttonView).isChecked();
                int value = radioButton.getId();
                switch (value) {
                    case R.id.radio_diabetes_new:
                        if (checked)
                            dm_diagnosis = "165087";
                        dmDiagnosis(dm_diagnosis);
                        break;
                    case R.id.radio_diabetes_known:
                        if (checked)
                            dm_diagnosis = "165088";
                        dmDiagnosis(dm_diagnosis);
                        break;
                    case R.id.radio_diabetes_na:
                        if (checked)
                            dm_diagnosis = "1175";
                        dmDiagnosis(dm_diagnosis);
                        break;
                    case R.id.radio_hypertension_new:
                        if (checked)
                            hypertension = "165092";
                        htnDiagnosis(hypertension);
                        break;
                    case R.id.radio_hypertension_known:
                        if (checked)
                            hypertension = "165093";
                        htnDiagnosis(hypertension);
                        break;
                    case R.id.radio_hypertension_na:
                        if (checked)
                            hypertension = "1175";
                        htnDiagnosis(hypertension);
                        break;
                    case R.id.radio_nhif_yes:
                        if (checked)
                            nhif = "1065";
                        break;
                    case R.id.radio_nhif_no:
                        if (checked)
                            nhif = "1066";
                        break;
                    case R.id.radio_diabetes_type_1:
                        if (checked)
                            diabetes_type = "142474";
                        break;
                    case R.id.radio_diabetes_GDM:
                        if (checked)
                            diabetes_type = "1449";
                        break;
                    case R.id.radio_diabetes_type_2:
                        if (checked)
                            diabetes_type = "142473";
                        break;
                    case R.id.radio_diabetes_secondary:
                        if (checked)
                            diabetes_type = "165199";
                        break;
                    case R.id.radio_hypertension_mild:
                        if (checked)
                            hypertension_type = "165194";
                        break;
                    case R.id.radio_hypertension_moderate:
                        if (checked)
                            hypertension_type = "165195";
                        break;
                    case R.id.radio_hypertension_severe:
                        if (checked)
                            hypertension_type = "165196";
                        break;
                    case R.id.radio_hypertension_preeclampsia:
                        if (checked)
                            hypertension_type = "165197";
                        break;
                    case R.id.radio_tb_yes:
                        if (checked)
                            tb_screen = "1065";
                        tbDiagnosis(tb_screen);
                        break;
                    case R.id.radio_tb_no:
                        if (checked)
                            tb_screen = "1066";
                        tbDiagnosis(tb_screen);
                        break;
                    case R.id.radio_tb_na:
                        if (checked)
                            tb_screen = "1175";
                        tbDiagnosis(tb_screen);
                        break;
                    case R.id.radio_tb_status_negative:
                        if (checked)
                            tb_status = "664";
                        tbTeatment(tb_status);
                        break;
                    case R.id.radio_tb_status_positive:
                        if (checked)
                            tb_status = "703";
                        tbTeatment(tb_status);
                        break;
                    case R.id.radio_tb_status_treatment:
                        if (checked)
                            tb_status = "1662";
                        tbTeatment(tb_status);
                        break;
                    case R.id.radio_hiv_negative:
                        if (checked)
                            hiv_status = "664";
                        hivDiagnosis(hiv_status);
                        break;
                    case R.id.radio_hiv_positive:
                        if (checked)
                            hiv_status = "138571";
                        hivDiagnosis(hiv_status);
                        break;
                    case R.id.radio_hiv_unknown:
                        if (checked)
                            hiv_status = "1067";
                        hivDiagnosis(hiv_status);
                        break;
                }

                if ("1066".equals(nhif)) {
                    Alerts.errorMessage(view, "Encourage Client to Register for NHIF");
                }

                updateValues();
            }
        });
    }

    public void updateValues() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.US);
        String current_time = timeFormat.format(new Date());
        String encounter_date = dm_followup_date.getText().toString().trim() + " " + current_time;

        JSONArray jsonArry = new JSONArray();

        jsonArry.put(JSONFormBuilder.observations("160638", "", "valueText", supporter_nameEditText.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160642", "", "valueText", supporter_phoneEditText.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165209", "", "valueText", supporter_phone_otherEditText.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165086", "", "valueCoded", dm_diagnosis, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165094", "", "valueCoded", diabetes_type, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165091", "", "valueCoded", hypertension, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165094", "", "valueCoded", hypertension_type, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1917", "", "valueCoded", nhif, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("138405", "", "valueCoded", hiv_status, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("164800", "", "valueCoded", tb_screen, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1659", "", "valueCoded", tb_status, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165172", "", "valueDate", editTextTBDate.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165173", "", "valueText", editTextTBComment.getText().toString().trim(), DateCalendar.date(), ""));


        jsonArry.put(JSONFormBuilder.observations("165089", "", "valueText", dmDiagnosisDateEditText.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165090", "", "valueText", htnDiagnosisDateEditText.getText().toString().trim(), DateCalendar.date(), ""));

        try {
            jsonArry = JSONFormBuilder.concatArray(jsonArry);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("JSON FollowUp Page 1", jsonArry.toString() + " ");

        FragmentModelFollowUp.getInstance().followUpOne(encounter_date, jsonArry);
    }
}
