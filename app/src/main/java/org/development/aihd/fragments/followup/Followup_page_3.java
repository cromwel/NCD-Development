package org.development.aihd.fragments.followup;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;

import org.development.aihd.R;
import org.development.aihd.common.Common;
import org.development.aihd.common.DateCalendar;
import org.development.aihd.common.JSONFormBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import customfonts.TextView_Roboto_Bold;

/**
 * Developed by Rodney on 24/04/2018.
 */

public class Followup_page_3 extends Fragment {

    private View view;
    private EditText editTextSystolic, editTextDiastolic;
    private EditText editTextWaist, editTextHip, editTextHeight, editTextWeight, editTextNutrition;
    private TextView_Roboto_Bold textViewBMI, textViewWaistHipRatio;
    private String foot_exam, eye_exam, dental_exam, eye_checkup;
    private String cardiovascular_disease, high_blood_pressure, high_cholestrol, peripheral_vascular_disease,
            peripheral_neuropathy, autonomic_neuropathy, retinopathy, kidney_disease, asthma_COPD,
            arthritis, foot, assesment_other, foot_amputation;
    private EditText editTextCardiovascularDisease, editTextHBP, editTextHighCholestrol, editTextVascularDisease, editTextPNeuropathy, editTextANeuropathy,
            editTextRetinopathy, editTextKidneyDisease, editTextAsthma, editTextArthritis, editTextFoot, editTextOther;
    private EditText editTextFBS, editTextRBS, editTextHBA, editTextHDL, editTextLDL, editTextTriglycerides, editTextUECUrea, editTextUECElectrolytes, editTextUECChloride, editTextUECPotassium, editTextUECCreatinine, editTextUrinalysis;
    private EditText editTextDateFBS, editTextDateRBS, editTextDateHBA, editTextDateHDL, editTextDateLDL, editTextDateTriglycerides, editTextDateUECUrea, editTextDateUECElectrolytes, editTextDateUECChloride, editTextDateUECPotassium, editTextDateUECCreatinine, editTextDateUrinalysis;
   // private TextView_Roboto_Bold textViewUreaFlag;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dm_followup_fragment_3, container, false);

       // textViewUreaFlag = view.findViewById(R.id.urea_flag);

        editTextSystolic = view.findViewById(R.id.followup_systolic);
        editTextDiastolic = view.findViewById(R.id.followup_diastolic);

        editTextWaist = view.findViewById(R.id.followup_waist_circ);
        editTextHip = view.findViewById(R.id.followup_hip_circ);
        editTextHeight = view.findViewById(R.id.followup_height);
        editTextWeight = view.findViewById(R.id.followup_weight);
        editTextNutrition = view.findViewById(R.id.followup_nutrition);

        editTextCardiovascularDisease = view.findViewById(R.id.details_cardiovascular_disease);
        editTextHBP = view.findViewById(R.id.details_high_bp);
        editTextHighCholestrol = view.findViewById(R.id.details_high_cholestrol);
        editTextVascularDisease = view.findViewById(R.id.details_peripheral_vascular_disease);
        editTextPNeuropathy = view.findViewById(R.id.details_peripheral_neuropathy);
        editTextANeuropathy = view.findViewById(R.id.details_autonomic_neuropathy);
        editTextRetinopathy = view.findViewById(R.id.details_retinopathy);
        editTextKidneyDisease = view.findViewById(R.id.details_kidney_disease);
        editTextAsthma = view.findViewById(R.id.details_asthma_COPD);
        editTextArthritis = view.findViewById(R.id.details_arthritis);
        editTextFoot = view.findViewById(R.id.details_foot);
        editTextOther = view.findViewById(R.id.details_assesment_other);

        editTextFBS = view.findViewById(R.id.followup_fbs);
        editTextRBS = view.findViewById(R.id.followup_rbs);
        editTextHBA = view.findViewById(R.id.followup_hba);
        editTextHDL = view.findViewById(R.id.followup_hdl);
        editTextLDL = view.findViewById(R.id.followup_ldl);
        editTextTriglycerides = view.findViewById(R.id.followup_triglycerides);
        editTextUECUrea = view.findViewById(R.id.followup_uec_urea);
        editTextUECElectrolytes = view.findViewById(R.id.followup_uec_electrolytes);
        editTextUECChloride = view.findViewById(R.id.followup_uec_chloride);
        editTextUECPotassium = view.findViewById(R.id.followup_uec_potassium);
        editTextUECCreatinine = view.findViewById(R.id.followup_uec_creatinine);
        editTextUrinalysis = view.findViewById(R.id.followup_urinalysis);

        editTextDateFBS = view.findViewById(R.id.date_fbs);
        editTextDateRBS = view.findViewById(R.id.date_rbs);
        editTextDateHBA = view.findViewById(R.id.date_hba);
        editTextDateHDL = view.findViewById(R.id.date_hdl);
        editTextDateLDL = view.findViewById(R.id.date_ldl);
        editTextDateTriglycerides = view.findViewById(R.id.date_triglycerides);
        editTextDateUECUrea = view.findViewById(R.id.date_uec_urea);
        editTextDateUECElectrolytes = view.findViewById(R.id.date_uec_electrolytes);
        editTextDateUECChloride = view.findViewById(R.id.date_uec_chloride);
        editTextDateUECPotassium = view.findViewById(R.id.date_uec_potassium);
        editTextDateUECCreatinine = view.findViewById(R.id.date_uec_creatinine);
        editTextDateUrinalysis = view.findViewById(R.id.date_urinalysis);

        DateCalendar.date(getActivity(), editTextDateFBS);
        DateCalendar.date(getActivity(), editTextDateRBS);
        DateCalendar.date(getActivity(), editTextDateHBA);
        DateCalendar.date(getActivity(), editTextDateHDL);
        DateCalendar.date(getActivity(), editTextDateLDL);
        DateCalendar.date(getActivity(), editTextDateTriglycerides);
        DateCalendar.date(getActivity(), editTextDateUECUrea);
        DateCalendar.date(getActivity(), editTextDateUECElectrolytes);
        DateCalendar.date(getActivity(), editTextDateUECChloride);
        DateCalendar.date(getActivity(), editTextDateUECPotassium);
        DateCalendar.date(getActivity(), editTextDateUECCreatinine);
        DateCalendar.date(getActivity(), editTextDateUrinalysis);

        textWatcher(editTextSystolic, "blood_pressure");
        textWatcher(editTextDiastolic, "blood_pressure");

        textViewBMI = view.findViewById(R.id.followup_bmi);
        textViewWaistHipRatio = view.findViewById(R.id.followup_hip_waist_ratio);

        textWatcher(editTextSystolic, "blood_pressure");
        textWatcher(editTextDiastolic, "blood_pressure");

        textWatcher(editTextHeight, "bmi");
        textWatcher(editTextWeight, "bmi");
        textWatcher(editTextWaist, "whr");
        textWatcher(editTextHip, "whr");

        textWatcher(editTextCardiovascularDisease, "");
        textWatcher(editTextHBP, "");
        textWatcher(editTextHighCholestrol, "");
        textWatcher(editTextVascularDisease, "");
        textWatcher(editTextPNeuropathy, "");
        textWatcher(editTextANeuropathy, "");
        textWatcher(editTextRetinopathy, "");
        textWatcher(editTextKidneyDisease, "");
        textWatcher(editTextAsthma, "");
        textWatcher(editTextArthritis, "");
        textWatcher(editTextFoot, "");
        textWatcher(editTextOther, "");

        textWatcher(editTextFBS, "");
        textWatcher(editTextRBS, "");
        textWatcher(editTextHBA, "");
        textWatcher(editTextHDL, "");
        textWatcher(editTextLDL, "");
        textWatcher(editTextTriglycerides, "");
        textWatcher(editTextUECUrea, "");
        textWatcher(editTextUECElectrolytes, "");
        textWatcher(editTextUECChloride, "");
        textWatcher(editTextUECPotassium, "");
        textWatcher(editTextUECCreatinine, "");
        textWatcher(editTextUrinalysis, "");

        textWatcher(editTextDateFBS, "");
        textWatcher(editTextDateRBS, "");
        textWatcher(editTextDateHBA, "");
        textWatcher(editTextDateHDL, "");
        textWatcher(editTextDateLDL, "");
        textWatcher(editTextDateTriglycerides, "");
        textWatcher(editTextDateUECUrea, "");
        textWatcher(editTextDateUECElectrolytes, "");
        textWatcher(editTextDateUECChloride, "");
        textWatcher(editTextDateUECPotassium, "");
        textWatcher(editTextDateUECCreatinine, "");
        textWatcher(editTextDateUrinalysis, "");

        DateCalendar.date(getActivity(), editTextDateFBS);
        DateCalendar.date(getActivity(), editTextDateRBS);
        DateCalendar.date(getActivity(), editTextDateHBA);
        DateCalendar.date(getActivity(), editTextDateHDL);
        DateCalendar.date(getActivity(), editTextDateLDL);
        DateCalendar.date(getActivity(), editTextDateTriglycerides);
        DateCalendar.date(getActivity(), editTextDateUECUrea);
        DateCalendar.date(getActivity(), editTextDateUECElectrolytes);
        DateCalendar.date(getActivity(), editTextDateUECChloride);
        DateCalendar.date(getActivity(), editTextDateUECPotassium);
        DateCalendar.date(getActivity(), editTextDateUECCreatinine);
        DateCalendar.date(getActivity(), editTextDateUrinalysis);

        editTextDateFBS.setText(DateCalendar.date());
        editTextDateRBS.setText(DateCalendar.date());
        editTextDateHBA.setText(DateCalendar.date());
        editTextDateHDL.setText(DateCalendar.date());
        editTextDateLDL.setText(DateCalendar.date());
        editTextDateTriglycerides.setText(DateCalendar.date());
        editTextDateUECUrea.setText(DateCalendar.date());
        editTextDateUECElectrolytes.setText(DateCalendar.date());
        editTextDateUECChloride.setText(DateCalendar.date());
        editTextDateUECPotassium.setText(DateCalendar.date());
        editTextDateUECCreatinine.setText(DateCalendar.date());
        editTextDateUrinalysis.setText(DateCalendar.date());

        textViewBMI = view.findViewById(R.id.followup_bmi);
        textViewWaistHipRatio = view.findViewById(R.id.followup_hip_waist_ratio);

        CheckBox checkBoxCardiovascularDisease = view.findViewById(R.id.checkbox_cardiovascular_disease);
        CheckBox checkBoxHBP = view.findViewById(R.id.checkbox_high_BP);
        CheckBox checkBoxHighCholestrol = view.findViewById(R.id.checkbox_high_cholestrol);
        CheckBox checkBoxVascularDisease = view.findViewById(R.id.checkbox_peripheral_vascular_disease);
        CheckBox checkBoxPNeuropathy = view.findViewById(R.id.checkbox_peripheral_neuropathy);
        CheckBox checkBoxANeuropathy = view.findViewById(R.id.checkbox_autonomic_neuropathy);
        CheckBox checkBoxRetinopathy = view.findViewById(R.id.checkbox_retinopathy);
        CheckBox checkBoxKidneyDisease = view.findViewById(R.id.checkbox_kidney_disease);
        CheckBox checkBoxAsthma = view.findViewById(R.id.checkbox_asthma_COPD);
        CheckBox checkBoxArthritis = view.findViewById(R.id.checkbox_arthritis);
        CheckBox checkBoxFoot = view.findViewById(R.id.checkbox_foot);
        CheckBox checkBoxOther = view.findViewById(R.id.checkbox_assesment_other);

        checkBox(checkBoxCardiovascularDisease);
        checkBox(checkBoxHBP);
        checkBox(checkBoxHighCholestrol);
        checkBox(checkBoxVascularDisease);
        checkBox(checkBoxPNeuropathy);
        checkBox(checkBoxANeuropathy);
        checkBox(checkBoxRetinopathy);
        checkBox(checkBoxKidneyDisease);
        checkBox(checkBoxAsthma);
        checkBox(checkBoxArthritis);
        checkBox(checkBoxFoot);
        checkBox(checkBoxOther);

        RadioButton radioButtonFootAmputationYes = view.findViewById(R.id.radio_foot_amputations_yes);
        RadioButton radioButtonFootAmputationNo = view.findViewById(R.id.radio_foot_amputations_no);

        radioButtonClicked(radioButtonFootAmputationYes);
        radioButtonClicked(radioButtonFootAmputationNo);

        return view;
    }

    public void textWatcher(EditText editText, final String check) {

        editText.addTextChangedListener(new TextWatcher() {

            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void afterTextChanged(final Editable editable) {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        switch (check) {
                            case "blood_pressure":
                                if (editTextSystolic != null && editTextDiastolic != null) {
                                    Common.checkBP(view, editTextSystolic, editTextDiastolic);
                                }
                                break;
                            case "bmi":
                                Common.bmi(getContext(), editTextHeight, editTextWeight, textViewBMI);
                                break;
                            case "whr":
                                Common.whr(editTextWaist, editTextHip, textViewWaistHipRatio);
                                break;
                            default:
                                break;
                        }

                    }
                }, 3000);

                updateValues();
            }


            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                /* Do nothing*/
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                /* Do nothing*/
            }
        });
    }

    public void radioButtonClicked(final RadioButton radioButton) {

        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                boolean checked = (buttonView).isChecked();
                switch (radioButton.getId()) {
                    case R.id.radio_foot_amputations_yes:
                        if (checked) {
                            foot_amputation = "1065";
                        }
                        break;
                    case R.id.radio_foot_amputations_no:
                        if (checked) {
                            foot_amputation = "1066";
                        }
                        break;
                    default:
                        break;
                }
                updateValues();
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
                    case R.id.checkbox_foot_exam:
                        if (checked) {
                            foot_exam = "165099";
                        } else {
                            foot_exam = "";
                        }
                        break;
                    case R.id.checkbox_eye_exam:
                        if (checked) {
                            eye_exam = "165100";
                        } else {
                            eye_exam = "";
                        }
                        break;
                    case R.id.checkbox_dental_exam:
                        if (checked) {
                            dental_exam = "165101";
                        } else {
                            dental_exam = "";
                        }
                        break;
                    case R.id.checkbox_eye_check_up:
                        if (checked) {
                            eye_checkup = "165102";
                        } else {
                            eye_checkup = "";
                        }
                        break;
                    case R.id.checkbox_cardiovascular_disease:
                        if (checked) {
                            cardiovascular_disease = "119270";
                        } else {
                            cardiovascular_disease = "";
                        }
                        break;
                    case R.id.checkbox_high_BP:
                        if (checked) {
                            high_blood_pressure = "117399";
                        } else {
                            high_blood_pressure = "";
                        }
                        break;
                    case R.id.checkbox_high_cholestrol:
                        if (checked) {
                            high_cholestrol = "117460";
                        } else {
                            high_cholestrol = "";
                        }
                        break;
                    case R.id.checkbox_peripheral_vascular_disease:
                        if (checked) {
                            peripheral_vascular_disease = "114212";
                        } else {
                            peripheral_vascular_disease = "";
                        }
                        break;
                    case R.id.checkbox_peripheral_neuropathy:
                        if (checked) {
                            peripheral_neuropathy = "118983";
                        } else {
                            peripheral_neuropathy = "";
                        }
                        break;
                    case R.id.checkbox_autonomic_neuropathy:
                        if (checked) {
                            autonomic_neuropathy = "155215";
                        } else {
                            autonomic_neuropathy = "";
                        }
                        break;
                    case R.id.checkbox_retinopathy:
                        if (checked) {
                            retinopathy = "113257";
                        } else {
                            retinopathy = "";
                        }
                        break;
                    case R.id.checkbox_kidney_disease:
                        if (checked) {
                            kidney_disease = "6033";
                        } else {
                            kidney_disease = "";
                        }
                        break;
                    case R.id.checkbox_asthma_COPD:
                        if (checked) {
                            asthma_COPD = "121375";
                        } else {
                            asthma_COPD = "";
                        }
                        break;
                    case R.id.checkbox_arthritis:
                        if (checked) {
                            arthritis = "148432";
                        } else {
                            arthritis = "";
                        }
                        break;
                    case R.id.checkbox_foot:
                        if (checked) {
                            foot = "165104";
                        } else {
                            foot = "";
                        }
                        break;
                    case R.id.checkbox_assesment_other:
                        if (checked) {
                            assesment_other = "5622";
                        } else {
                            assesment_other = "";
                        }
                        break;
                    default:
                        break;
                }
                updateValues();
            }
        });
    }

    public void updateValues() {

        JSONArray jsonArry = new JSONArray();
        JSONArray jsonGroup = new JSONArray();

        JSONArray jsonArry1 = new JSONArray();
        JSONArray jsonArry2 = new JSONArray();

        jsonArry.put(JSONFormBuilder.observations("5090", "", "valueNumeric", editTextHeight.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("5089", "", "valueNumeric", editTextWeight.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("5085", "", "valueNumeric", editTextSystolic.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("5086", "", "valueNumeric", editTextDiastolic.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("163081", "", "valueNumeric", editTextHip.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("163080", "", "valueNumeric", editTextWaist.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165190", "", "valueText", editTextNutrition.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1391", "", "valueCoded", foot_exam, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1391", "", "valueCoded", eye_exam, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1391", "", "valueCoded", dental_exam, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1391", "", "valueCoded", eye_checkup, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", cardiovascular_disease, DateCalendar.date(), editTextCardiovascularDisease.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", high_blood_pressure, DateCalendar.date(), editTextHBP.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", high_cholestrol, DateCalendar.date(), editTextHighCholestrol.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", peripheral_vascular_disease, DateCalendar.date(), editTextVascularDisease.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", peripheral_neuropathy, DateCalendar.date(), editTextPNeuropathy.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", autonomic_neuropathy, DateCalendar.date(), editTextANeuropathy.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", retinopathy, DateCalendar.date(), editTextRetinopathy.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", kidney_disease, DateCalendar.date(), editTextKidneyDisease.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", asthma_COPD, DateCalendar.date(), editTextAsthma.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", arthritis, DateCalendar.date(), editTextArthritis.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", foot, DateCalendar.date(), editTextFoot.getText().toString().trim()));
        jsonArry.put(JSONFormBuilder.observations("165106", "", "valueCoded", assesment_other, DateCalendar.date(), editTextOther.getText().toString().trim()));

        jsonArry.put(JSONFormBuilder.observations("165104", "", "valueCoded", foot_amputation, DateCalendar.date(), ""));

        jsonArry1.put(JSONFormBuilder.observations("160912", "161487", "valueNumeric", editTextFBS.getText().toString().trim(), editTextDateFBS.getText().toString().trim(), ""));
        jsonArry1.put(JSONFormBuilder.observations("887", "161487", "valueNumeric", editTextRBS.getText().toString().trim(), editTextDateRBS.getText().toString().trim(), ""));
        jsonArry.put(JSONFormBuilder.observations("159644", "", "valueNumeric", editTextHBA.getText().toString().trim(), editTextDateHBA.getText().toString().trim(), ""));
        jsonArry2.put(JSONFormBuilder.observations("1007", "161487", "valueNumeric", editTextHDL.getText().toString().trim(), editTextDateHDL.getText().toString().trim(), ""));
        jsonArry2.put(JSONFormBuilder.observations("1008", "161487", "valueNumeric", editTextLDL.getText().toString().trim(), editTextDateLDL.getText().toString().trim(), ""));
        jsonArry.put(JSONFormBuilder.observations("1009", "", "valueNumeric", editTextTriglycerides.getText().toString().trim(), editTextDateTriglycerides.getText().toString().trim(), ""));
        jsonArry.put(JSONFormBuilder.observations("164364", "", "valueNumeric", editTextUECUrea.getText().toString().trim(), editTextDateUECUrea.getText().toString().trim(), ""));
        jsonArry.put(JSONFormBuilder.observations("164364", "", "valueNumeric", editTextUECElectrolytes.getText().toString().trim(), editTextDateUECElectrolytes.getText().toString().trim(), ""));
        jsonArry.put(JSONFormBuilder.observations("164364", "", "valueNumeric", editTextUECChloride.getText().toString().trim(), editTextDateUECChloride.getText().toString().trim(), ""));
        jsonArry.put(JSONFormBuilder.observations("164364", "", "valueNumeric", editTextUECPotassium.getText().toString().trim(), editTextDateUECPotassium.getText().toString().trim(), ""));
        jsonArry.put(JSONFormBuilder.observations("164364", "", "valueNumeric", editTextUECCreatinine.getText().toString().trim(), editTextDateUECCreatinine.getText().toString().trim(), ""));
        jsonArry.put(JSONFormBuilder.observations("160987", "", "valueText", editTextUrinalysis.getText().toString().trim(), editTextDateUrinalysis.getText().toString().trim(), ""));

        try {
            jsonArry = JSONFormBuilder.concatArray(jsonArry);
            jsonArry1 = JSONFormBuilder.concatArray(jsonArry1);
            jsonArry2 = JSONFormBuilder.concatArray(jsonArry2);

            jsonGroup = JSONFormBuilder.checkLength(jsonArry1, jsonGroup);
            jsonGroup = JSONFormBuilder.checkLength(jsonArry2, jsonGroup);

            if (jsonGroup.length() > 0) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("groups", jsonGroup);

                jsonArry.put(jsonObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d("JSON FollowUp Page 3", jsonArry.toString() + " ");

        FragmentModelFollowUp.getInstance().followUpThree(jsonArry);

        /*flags();*/
    }

   /* public void flags(){
        int UECUrea = Integer.parseInt(editTextUECUrea.getText().toString().trim());
        if( UECUrea >= 2.7 && UECUrea <= 8.0 ){
            textViewUreaFlag.setVisibility(View.VISIBLE);
        }else{
            textViewUreaFlag.setVisibility(View.GONE);
        }
    }*/

}
