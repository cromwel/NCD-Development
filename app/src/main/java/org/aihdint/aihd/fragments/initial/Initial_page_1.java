package org.aihdint.aihd.fragments.initial;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import org.aihdint.aihd.common.DateCalendar;
import org.aihdint.aihd.common.JSONFormBuilder;
import org.aihdint.aihd.R;
import org.aihdint.aihd.common.Alerts;
import org.aihdint.aihd.model.KeyValue;
import org.json.JSONArray;
import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import static org.aihdint.aihd.forms.DM_Initial.gender;

/**
 * Developed by Rodney on 24/04/2018.
 */


public class Initial_page_1 extends Fragment {

    private LinearLayout nhif_other_details;
    private RadioGroup radioGroupDiabetes, radioGroupHypertention, radioGroupTB;

    private String occupation, education_level;

    private EditText dm_initial_dateEditText, occupation_otherEditText, editTextDiagnosisDiabetes, editTextDiagnosisHypertension;

    private EditText editTextPatientStatus, editTextTBDate, editTextTBComment, editTextNHIFOther, editTextReferralComment, editTextReferralDetails,
            editTextComplaintOther, editTextLMP, editTextRiskOther;

    private RadioGroup hiv_enrolled, referral_patient;

    //Checkboxes
    private String tb_treatment, breathing, palpitations, dizziness, fainting, leg_swell, urination_fatigue, lose_consciousness,
            blurr_vision, focal_weakness, foot_complaint, headache_migraines, complaint_other;

    //RadioButtons
    private String diabetes_status, diabetes_family, diabetes_type, htn_status, htn_family, htn_type, hiv_status, enrolled_to_hiv_care, tb_status, tb_screen, nhif_status, referral_status,
            referral_inter, referral_intra, exercise, diet, smoking, drinking;

    private CheckBox checkBoxTBStatus;

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_initial_fragment_1, container, false);

        diabetes_status = htn_status = hiv_status = nhif_status = referral_status = referral_inter = tb_status = tb_screen = complaint_other = "";

        //RadioGroup
        hiv_enrolled = view.findViewById(R.id.hiv_enrolled);
        referral_patient = view.findViewById(R.id.interreferral_details);
        radioGroupTB = view.findViewById(R.id.radioGroupTB);
        radioGroupDiabetes = view.findViewById(R.id.radioGroupDiabetes);
        radioGroupHypertention = view.findViewById(R.id.radioGroupHypertension);

        //LinearLayout
        nhif_other_details = view.findViewById(R.id.nhif_other_details);
        LinearLayout lmp = view.findViewById(R.id.linearLayoutLMP);
        //hiv_status_details = view.findViewById(R.id.hiv_status_details);

        if (gender != null && gender.equals("F")) {
            lmp.setVisibility(View.VISIBLE);
        }

        //EditText
        dm_initial_dateEditText = view.findViewById(R.id.dm_initial_date);
        occupation_otherEditText = view.findViewById(R.id.occupation_other);
        editTextDiagnosisDiabetes = view.findViewById(R.id.diagnosis_diabetes_date);
        editTextDiagnosisHypertension = view.findViewById(R.id.diagnosis_hypertension_date);
        editTextPatientStatus = view.findViewById(R.id.hiv_other_status);
        editTextTBDate = view.findViewById(R.id.tb_treatment_start);
        editTextTBComment = view.findViewById(R.id.tb_comment);
        editTextNHIFOther = view.findViewById(R.id.nhif_other);
        editTextReferralComment = view.findViewById(R.id.referral_other);
        editTextReferralDetails = view.findViewById(R.id.referral_other_details);
        editTextComplaintOther = view.findViewById(R.id.complaint_other);
        editTextLMP = view.findViewById(R.id.complaint_lmp);
        editTextRiskOther = view.findViewById(R.id.abuse_other);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        dm_initial_dateEditText.setText(dateFormat.format(new Date())); // it will show 16/07/2013

        DateCalendar.fulldate(getActivity(), dm_initial_dateEditText);
        DateCalendar.date(getActivity(), editTextTBDate);
        DateCalendar.date(getActivity(), editTextLMP);

        textWatcher(dm_initial_dateEditText);
        textWatcher(occupation_otherEditText);
        textWatcher(editTextDiagnosisDiabetes);
        textWatcher(editTextDiagnosisHypertension);
        textWatcher(editTextPatientStatus);
        textWatcher(editTextTBDate);
        textWatcher(editTextTBComment);
        textWatcher(editTextNHIFOther);
        textWatcher(editTextReferralComment);
        textWatcher(editTextReferralDetails);
        textWatcher(editTextComplaintOther);
        textWatcher(editTextLMP);
        textWatcher(editTextRiskOther);

        //RadioButton
        RadioButton radioButtonDMNew = view.findViewById(R.id.radio_new_dm_patient);
        RadioButton radioButtonDNKnown = view.findViewById(R.id.radio_known_dm_patient);
        RadioButton radioButtonDMNa = view.findViewById(R.id.radio_na_dm_patient);
        RadioButton radioButtonDMFamYes = view.findViewById(R.id.radio_dm_patient_family_yes);
        RadioButton radioButtonDMFamNo = view.findViewById(R.id.radio_dm_patient_family_no);
        RadioButton radioButtonDMType1 = view.findViewById(R.id.radio_diabetes_type_1);
        RadioButton radioButtonDMType2 = view.findViewById(R.id.radio_diabetes_type_2);
        RadioButton radioButtonDMGDM = view.findViewById(R.id.radio_diabetes_GDM);
        RadioButton radioButtonDMSecondary = view.findViewById(R.id.radio_diabetes_secondary);
        RadioButton radioButtonHTNNew = view.findViewById(R.id.radio_new_htn_patient);
        RadioButton radioButtonHTNKnown = view.findViewById(R.id.radio_known_htn_patient);
        RadioButton radioButtonHTNNa = view.findViewById(R.id.radio_na_htn_patient);
        RadioButton radioButtonHTNFamYes = view.findViewById(R.id.radio_htn_patient_family_yes);
        RadioButton radioButtonHTNFamNo = view.findViewById(R.id.radio_htn_patient_family_no);
        RadioButton radioButtonHTNMild = view.findViewById(R.id.radio_hypertension_mild);
        RadioButton radioButtonHTNModerate = view.findViewById(R.id.radio_hypertension_moderate);
        RadioButton radioButtonHTNSevere = view.findViewById(R.id.radio_hypertension_severe);
        RadioButton radioButtonHTNPreeclampsia = view.findViewById(R.id.radio_hypertension_preeclampsia);
        RadioButton radioButtonHIV_N = view.findViewById(R.id.radio_hiv_negative);
        RadioButton radioButtonHIV_P = view.findViewById(R.id.radio_hiv_positive);
        RadioButton radioButtonHIVUknown = view.findViewById(R.id.radio_hiv_unknown);
        RadioButton radioButtonErolledYes = view.findViewById(R.id.radio_enrolled_yes);
        RadioButton radioButtonEnrolledNo = view.findViewById(R.id.radio_enrolled_no);
        RadioButton radioButtonNHIFYes = view.findViewById(R.id.radio_nhif_yes);
        RadioButton radioButtonNHIFNo = view.findViewById(R.id.radio_nhif_no);
        RadioButton radioButtonNHIFOther = view.findViewById(R.id.radio_nhif_other);
        RadioButton radioButtonReferralYes = view.findViewById(R.id.radio_referral_yes);
        RadioButton radioButtonReferralNo = view.findViewById(R.id.radio_referral_no);
        RadioButton radioButtonReferralCHW = view.findViewById(R.id.radio_referral_chw);
        RadioButton radioButtonDispensary = view.findViewById(R.id.radio_referral_dispensary);
        RadioButton radioButtonMaternity = view.findViewById(R.id.radio_referral_maternity);
        RadioButton radioButtonInPatient = view.findViewById(R.id.radio_referral_inpatient);
        RadioButton radioButtonOPD = view.findViewById(R.id.radio_referral_opd);
        RadioButton radioButtonCasualty = view.findViewById(R.id.radio_referral_casualty);
        RadioButton radioButtonCCC = view.findViewById(R.id.radio_referral_ccc);
        RadioButton radioButtonOther = view.findViewById(R.id.radio_referral_other);
        RadioButton radioButtonExerciseYes = view.findViewById(R.id.radio_exercise_yes);
        RadioButton radioButtonExerciseNo = view.findViewById(R.id.radio_exercise_no);
        RadioButton radioButtonExerciseStopped = view.findViewById(R.id.radio_exercise_stopped);
        RadioButton radioButtonDietYes = view.findViewById(R.id.radio_diet_yes);
        RadioButton radioButtonDietNo = view.findViewById(R.id.radio_diet_no);
        RadioButton radioButtonDietStopped = view.findViewById(R.id.radio_diet_stopped);
        RadioButton radioButtonCigarettesYes = view.findViewById(R.id.radio_smoke_yes);
        RadioButton radioButtonCigarettesNo = view.findViewById(R.id.radio_smoke_no);
        RadioButton radioButtonCigarettesStopped = view.findViewById(R.id.radio_smoke_stopped);
        RadioButton radioButtonAlcoholYes = view.findViewById(R.id.radio_drink_yes);
        RadioButton radioButtonAlcoholNo = view.findViewById(R.id.radio_drink_no);
        RadioButton radioButtonAlcoholStopped = view.findViewById(R.id.radio_drink_stopped);
        RadioButton radioButtonTBYes = view.findViewById(R.id.radio_tb_yes);
        RadioButton radioButtonTBNo = view.findViewById(R.id.radio_tb_no);
        RadioButton radioButtonTBNa = view.findViewById(R.id.radio_tb_na);
        RadioButton radioButtonTBNegative = view.findViewById(R.id.radio_tb_status_negative);
        RadioButton radioButtonTBPositive = view.findViewById(R.id.radio_tb_status_positive);
        RadioButton radioButtonTBUknown = view.findViewById(R.id.radio_tb_status_unknown);

        radioCheck(radioButtonDMNew);
        radioCheck(radioButtonDNKnown);
        radioCheck(radioButtonDMNa);
        radioCheck(radioButtonDMFamYes);
        radioCheck(radioButtonDMFamNo);
        radioCheck(radioButtonDMType1);
        radioCheck(radioButtonDMType2);
        radioCheck(radioButtonDMGDM);
        radioCheck(radioButtonDMSecondary);
        radioCheck(radioButtonHTNNew);
        radioCheck(radioButtonHTNKnown);
        radioCheck(radioButtonHTNNa);
        radioCheck(radioButtonHTNFamYes);
        radioCheck(radioButtonHTNFamNo);
        radioCheck(radioButtonHTNMild);
        radioCheck(radioButtonHTNModerate);
        radioCheck(radioButtonHTNSevere);
        radioCheck(radioButtonHTNPreeclampsia);
        radioCheck(radioButtonHIV_N);
        radioCheck(radioButtonHIV_P);
        radioCheck(radioButtonHIVUknown);
        radioCheck(radioButtonErolledYes);
        radioCheck(radioButtonEnrolledNo);
        radioCheck(radioButtonNHIFYes);
        radioCheck(radioButtonNHIFNo);
        radioCheck(radioButtonNHIFOther);
        radioCheck(radioButtonReferralYes);
        radioCheck(radioButtonReferralNo);
        radioCheck(radioButtonReferralCHW);
        radioCheck(radioButtonDispensary);
        radioCheck(radioButtonMaternity);
        radioCheck(radioButtonInPatient);
        radioCheck(radioButtonOPD);
        radioCheck(radioButtonCasualty);
        radioCheck(radioButtonCCC);
        radioCheck(radioButtonOther);
        radioCheck(radioButtonExerciseYes);
        radioCheck(radioButtonExerciseNo);
        radioCheck(radioButtonExerciseStopped);
        radioCheck(radioButtonDietYes);
        radioCheck(radioButtonDietNo);
        radioCheck(radioButtonDietStopped);
        radioCheck(radioButtonCigarettesYes);
        radioCheck(radioButtonCigarettesNo);
        radioCheck(radioButtonCigarettesStopped);
        radioCheck(radioButtonAlcoholYes);
        radioCheck(radioButtonAlcoholNo);
        radioCheck(radioButtonAlcoholStopped);
        radioCheck(radioButtonTBYes);
        radioCheck(radioButtonTBNo);
        radioCheck(radioButtonTBNa);
        radioCheck(radioButtonTBNegative);
        radioCheck(radioButtonTBPositive);
        radioCheck(radioButtonTBUknown);

        //Checkboxes
        checkBoxTBStatus = view.findViewById(R.id.checkbox_tb_status);
        CheckBox checkBoxBreathing = view.findViewById(R.id.checkbox_complaint_breath);
        CheckBox checkBoxPalpitations = view.findViewById(R.id.checkbox_complaint_palpitations);
        CheckBox checkBoxDizziness = view.findViewById(R.id.checkbox_complaint_dizziness);
        CheckBox checkBoxFainting = view.findViewById(R.id.checkbox_complaint_fainting);
        CheckBox checkBoxLegSwell = view.findViewById(R.id.checkbox_complaint_leg_swell);
        CheckBox checkBoxUrinationFatigue = view.findViewById(R.id.checkbox_complaint_urination_fatigue);
        CheckBox checkBoxLoseConsciousness = view.findViewById(R.id.checkbox_complaint_lose_consciousness);
        CheckBox checkBoxBlurrVision = view.findViewById(R.id.checkbox_complaint_blurr_vision);
        CheckBox checkBoxFocalWeakness = view.findViewById(R.id.checkbox_complaint_focal_weakness);
        CheckBox checkBoxFootComplaint = view.findViewById(R.id.checkbox_foot_complaint);
        CheckBox checkBoxHeadacheMigraines = view.findViewById(R.id.checkbox_complaint_headache_migraines);
        CheckBox checkBoxComplaintOther = view.findViewById(R.id.checkbox_complaint_other);

        checkBox(checkBoxTBStatus);
        checkBox(checkBoxBreathing);
        checkBox(checkBoxPalpitations);
        checkBox(checkBoxDizziness);
        checkBox(checkBoxFainting);
        checkBox(checkBoxLegSwell);
        checkBox(checkBoxUrinationFatigue);
        checkBox(checkBoxLoseConsciousness);
        checkBox(checkBoxBlurrVision);
        checkBox(checkBoxFocalWeakness);
        checkBox(checkBoxFootComplaint);
        checkBox(checkBoxHeadacheMigraines);
        checkBox(checkBoxComplaintOther);

        //Spinner
        Spinner educationLevelSpinner = view.findViewById(R.id.spinnerEducation);
        Spinner occupationSpinner = view.findViewById(R.id.spinnerOccupation);

        spinnerValue(getContext(), educationLevelSpinner, "education");
        spinnerValue(getContext(), occupationSpinner, "occupations");

        return view;
    }

    public void spinnerValue(Context context, Spinner spinner, final String choice) {

        ArrayList<KeyValue> keyvalue = new ArrayList<>();

        // adding each child node to HashMap key => value
        if ("occupations".equals(choice)) {
            keyvalue.add(new KeyValue("", "Select Occupation"));
            keyvalue.add(new KeyValue("1540", "Employed"));
            keyvalue.add(new KeyValue("165170", "Unemployed"));
            keyvalue.add(new KeyValue("161382", "Self Employed"));
            keyvalue.add(new KeyValue("159465", "Student"));
            keyvalue.add(new KeyValue("5622", "Other"));

        } else if ("education".equals(choice)) {
            // adding each child node to HashMap key => value
            keyvalue.add(new KeyValue("", "Select Education Level"));
            keyvalue.add(new KeyValue("1107", "None"));
            keyvalue.add(new KeyValue("160290", "Incomplete Primary"));
            keyvalue.add(new KeyValue("1713", "Primary"));
            keyvalue.add(new KeyValue("1714", "Secondary"));
            keyvalue.add(new KeyValue("160292", "Tertiary education"));
        }

        //fill data in spinner
        ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, keyvalue);
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //occupationSpinner.setSelection(adapter.getPosition(keyvalueOccupation.get(2)));//Optional to set the selected item.

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                KeyValue value = (KeyValue) parent.getSelectedItem();
                if ("occupations".equals(choice)) {
                    occupation = value.getId();
                } else if ("education".equals(choice)) {
                    education_level = value.getId();
                }

                updateValues();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }


    public void diabetes(String status) {

        if (status.matches("165088")) {
            editTextDiagnosisDiabetes.setVisibility(View.VISIBLE);
            radioGroupDiabetes.setVisibility(View.VISIBLE);
        } else if (status.matches("165087")) {
            radioGroupDiabetes.setVisibility(View.VISIBLE);
        } else {
            editTextDiagnosisDiabetes.setVisibility(View.GONE);
            radioGroupDiabetes.setVisibility(View.GONE);
        }

    }

    public void hypertension(String status) {
        if (status.matches("165093")) {
            editTextDiagnosisHypertension.setVisibility(View.VISIBLE);
            radioGroupHypertention.setVisibility(View.VISIBLE);
        } else if (status.matches("165092")) {
            radioGroupHypertention.setVisibility(View.VISIBLE);
        } else {
            editTextDiagnosisHypertension.setVisibility(View.GONE);
            radioGroupHypertention.setVisibility(View.GONE);
        }
    }

    public void hivStatus(String status) {
        if (status.matches("138571")) {
            hiv_enrolled.setVisibility(View.VISIBLE);
        } else {
            hiv_enrolled.setVisibility(View.GONE);
        }
    }

    public void nhifStatus(String status) {
        if (status.matches("5622")) {
            nhif_other_details.setVisibility(View.VISIBLE);
        } else {
            nhif_other_details.setVisibility(View.GONE);
        }
    }

    public void referralStatus(String status) {

        if (status.matches("1065")) {
            referral_patient.setVisibility(View.VISIBLE);
        } else {
            referral_patient.setVisibility(View.GONE);
        }
    }

    public void complaint(String status) {
        if (status.matches("5622")) {
            editTextComplaintOther.setVisibility(View.VISIBLE);
        } else {
            editTextComplaintOther.setVisibility(View.GONE);
        }
    }

    public void tbScreen(String status) {
        if (status.matches("1065")) {
            radioGroupTB.setVisibility(View.VISIBLE);
        } else {
            radioGroupTB.setVisibility(View.GONE);
        }
    }

    public void tbStatus(String status) {
        if (status.matches("1065")) {
            checkBoxTBStatus.setVisibility(View.VISIBLE);
            editTextTBDate.setVisibility(View.VISIBLE);
        } else {
            checkBoxTBStatus.setVisibility(View.GONE);
            editTextTBDate.setVisibility(View.GONE);
        }
    }


    public void textWatcher(EditText editText) {

        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(final Editable editable) {
                updateValues();
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

    public void radioCheck(final RadioButton radioButton) {

        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Is the button now checked?
                boolean checked = (buttonView).isChecked();

                // Check which radio button was clicked
                switch (radioButton.getId()) {
                    case R.id.radio_new_dm_patient:
                        if (checked)
                            diabetes_status = "165087";
                        break;
                    case R.id.radio_known_dm_patient:
                        if (checked)
                            diabetes_status = "165088";
                        break;
                    case R.id.radio_na_dm_patient:
                        if (checked)
                            diabetes_status = "1175";
                        break;
                    case R.id.radio_dm_patient_family_yes:
                        if (checked)
                            diabetes_family = "1065";
                        break;
                    case R.id.radio_dm_patient_family_no:
                        if (checked)
                            diabetes_family = "1066";
                        break;
                    case R.id.radio_diabetes_type_1:
                        if (checked)
                            diabetes_type = "142474";
                        break;
                    case R.id.radio_diabetes_type_2:
                        if (checked)
                            diabetes_type = "142473";
                        break;
                    case R.id.radio_diabetes_GDM:
                        if (checked)
                            diabetes_type = "1449";
                        break;
                    case R.id.radio_diabetes_secondary:
                        if (checked)
                            diabetes_type = "165199";
                        break;
                    case R.id.radio_new_htn_patient:
                        if (checked)
                            htn_status = "165092";
                        break;
                    case R.id.radio_known_htn_patient:
                        if (checked)
                            htn_status = "165093";
                        break;
                    case R.id.radio_na_htn_patient:
                        if (checked)
                            htn_status = "1175";
                        break;
                    case R.id.radio_htn_patient_family_yes:
                        if (checked)
                            htn_family = "1065";
                        break;
                    case R.id.radio_htn_patient_family_no:
                        if (checked)
                            htn_family = "1066";
                        break;
                    case R.id.radio_hypertension_mild:
                        if (checked)
                            htn_type = "165194";
                        break;
                    case R.id.radio_hypertension_moderate:
                        if (checked)
                            htn_type = "165195";
                        break;
                    case R.id.radio_hypertension_severe:
                        if (checked)
                            htn_type = "165196";
                        break;
                    case R.id.radio_hypertension_preeclampsia:
                        if (checked)
                            htn_type = "165197";
                        break;
                    case R.id.radio_hiv_negative:
                        if (checked)
                            hiv_status = "664";
                        break;
                    case R.id.radio_hiv_positive:
                        if (checked)
                            hiv_status = "138571";
                        break;
                    case R.id.radio_hiv_unknown:
                        if (checked)
                            hiv_status = "1067";
                        break;
                    case R.id.radio_enrolled_yes:
                        if (checked)
                            enrolled_to_hiv_care = "1065";
                        break;
                    case R.id.radio_enrolled_no:
                        if (checked)
                            enrolled_to_hiv_care = "1066";
                        break;
                    case R.id.radio_nhif_yes:
                        if (checked)
                            nhif_status = "1065";
                        break;
                    case R.id.radio_nhif_no:
                        if (checked)
                            nhif_status = "1066";
                        //Alerts.alert_msg(getContext(), "NHIF Registration", "Encourage Client to Register for NHIF");
                        break;
                    case R.id.radio_tb_yes:
                        if (checked)
                            tb_screen = "1065";
                        break;
                    case R.id.radio_tb_no:
                        if (checked)
                            tb_screen = "1066";
                        break;
                    case R.id.radio_tb_na:
                        if (checked)
                            tb_screen = "1175";
                        break;
                    case R.id.radio_tb_status_negative:
                        if (checked)
                            tb_status = "1066";
                        break;
                    case R.id.radio_tb_status_positive:
                        if (checked)
                            tb_status = "1065";
                        break;
                    case R.id.radio_tb_status_unknown:
                        if (checked)
                            tb_status = "1175";
                        break;
                    case R.id.radio_nhif_other:
                        if (checked)
                            nhif_status = "5622";
                        break;
                    case R.id.radio_referral_yes:
                        if (checked)
                            referral_status = "1065";
                        break;
                    case R.id.radio_referral_no:
                        if (checked)
                            referral_status = "1066";
                        break;
                    case R.id.radio_referral_chw:
                        if (checked)
                            referral_intra = "1759";
                        break;
                    case R.id.radio_referral_dispensary:
                        if (checked)
                            referral_intra = "165107";
                        break;
                    case R.id.radio_referral_maternity:
                        if (checked)
                            referral_inter = "163146";
                        break;
                    case R.id.radio_referral_inpatient:
                        if (checked)
                            referral_inter = "160551";
                        break;
                    case R.id.radio_referral_opd:
                        if (checked)
                            referral_inter = "160542";
                        break;
                    case R.id.radio_referral_casualty:
                        if (checked)
                            referral_inter = "160473";
                        break;
                    case R.id.radio_referral_ccc:
                        if (checked)
                            referral_inter = "162050";
                        break;
                    case R.id.radio_referral_other:
                        if (checked)
                            referral_inter = "5622";
                        break;
                    case R.id.radio_exercise_yes:
                        if (checked)
                            exercise = "1065";
                        break;
                    case R.id.radio_exercise_no:
                        if (checked)
                            exercise = "1066";
                        break;
                    case R.id.radio_exercise_stopped:
                        if (checked)
                            exercise = "158939";
                        break;
                    case R.id.radio_diet_yes:
                        if (checked)
                            diet = "1065";
                        break;
                    case R.id.radio_diet_no:
                        if (checked)
                            diet = "1066";
                        break;
                    case R.id.radio_diet_stopped:
                        if (checked)
                            diet = "158939";
                        break;
                    case R.id.radio_smoke_yes:
                        if (checked)
                            smoking = "1065";
                        break;
                    case R.id.radio_smoke_no:
                        if (checked)
                            smoking = "1066";
                        break;
                    case R.id.radio_smoke_stopped:
                        if (checked)
                            smoking = "158939";
                        break;
                    case R.id.radio_drink_yes:
                        if (checked)
                            drinking = "159450";
                        break;
                    case R.id.radio_drink_no:
                        if (checked)
                            drinking = "1090";
                        break;
                    case R.id.radio_drink_stopped:
                        if (checked)
                            drinking = "159452";
                        break;
                    default:
                        break;
                }


                if ("1066".equals(nhif_status)) {
                    Alerts.alert_msg(getContext(), "NHIF Registration", "Encourage Client to Register for NHIF");
                }

                diabetes(diabetes_status);
                hypertension(htn_status);
                hivStatus(hiv_status);
                tbScreen(tb_screen);
                tbStatus(tb_status);
                nhifStatus(nhif_status);
                referralStatus(referral_status);
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
                    case R.id.checkbox_tb_status:
                        if (checked) {
                            tb_treatment = "1662";
                        } else {
                            tb_treatment = "";
                        }
                        break;
                    case R.id.checkbox_complaint_breath:
                        if (checked) {
                            breathing = "110265";
                        } else {
                            breathing = "";
                        }
                        break;
                    case R.id.checkbox_complaint_palpitations:
                        if (checked) {
                            palpitations = "158627";
                        } else {
                            palpitations = "";
                        }
                        break;
                    case R.id.checkbox_complaint_dizziness:
                        if (checked) {
                            dizziness = "156046";
                        } else {
                            dizziness = "";
                        }
                        break;
                    case R.id.checkbox_complaint_fainting:
                        if (checked) {
                            fainting = "112961";
                        } else {
                            fainting = "";
                        }
                        break;
                    case R.id.checkbox_complaint_leg_swell:
                        if (checked) {
                            leg_swell = "135966";
                        } else {
                            leg_swell = "";
                        }
                        break;
                    case R.id.checkbox_complaint_urination_fatigue:
                        if (checked) {
                            urination_fatigue = "134185";
                        } else {
                            urination_fatigue = "";
                        }
                        break;
                    case R.id.checkbox_complaint_lose_consciousness:
                        if (checked) {
                            lose_consciousness = "135592";
                        } else {
                            lose_consciousness = "";
                        }
                        break;
                    case R.id.checkbox_complaint_blurr_vision:
                        if (checked) {
                            blurr_vision = "147104";
                        } else {
                            blurr_vision = "";
                        }
                        break;
                    case R.id.checkbox_complaint_focal_weakness:
                        if (checked) {
                            focal_weakness = "6005";
                        } else {
                            focal_weakness = "";
                        }
                        break;
                    case R.id.checkbox_foot_complaint:
                        if (checked) {
                            foot_complaint = "164529";
                        } else {
                            foot_complaint = "";
                        }
                        break;
                    case R.id.checkbox_complaint_headache_migraines:
                        if (checked) {
                            headache_migraines = "115782";
                        } else {
                            headache_migraines = "";
                        }
                        break;
                    case R.id.checkbox_complaint_other:
                        if (checked) {
                            complaint_other = "5622";
                        } else {
                            complaint_other = "";
                        }
                        break;
                    default:
                        break;
                }

                complaint(complaint_other);
                updateValues();
            }
        });
    }

    public void updateValues() {

        JSONArray jsonArry = new JSONArray();

        jsonArry.put(JSONFormBuilder.observations("1712", "", "valueCoded", education_level, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1542", "", "valueCoded", occupation, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165171", "", "valueText", occupation_otherEditText.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165086", "", "valueCoded", diabetes_status, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("140228", "", "valueCoded", diabetes_family, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165153", "", "valueText", editTextDiagnosisDiabetes.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165094", "", "valueCoded", diabetes_type, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165091", "", "valueCoded", htn_status, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165191", "", "valueCoded", htn_family, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165154", "", "valueText", editTextDiagnosisHypertension.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165198", "", "valueCoded", htn_type, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("138405", "", "valueCoded", hiv_status, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("159811", "", "valueCoded", enrolled_to_hiv_care, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165155", "", "valueText", editTextPatientStatus.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("164800", "", "valueCoded", tb_screen, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165330", "", "valueCoded", tb_status, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1659", "", "valueCoded", tb_treatment, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165172", "", "valueDate", editTextTBDate.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165173", "", "valueText", editTextTBComment.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1917", "", "valueCoded", nhif_status, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165162", "", "valueText", editTextNHIFOther.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1648", "", "valueCoded", referral_status, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("164408", "", "valueCoded", referral_inter, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165163", "", "valueCoded", referral_intra, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165164", "", "valueText", editTextReferralComment.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165156", "", "valueText", editTextReferralDetails.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("6042", "", "valueCoded", breathing, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("6042", "", "valueCoded", palpitations, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("6042", "", "valueCoded", dizziness, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("6042", "", "valueCoded", fainting, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("6042", "", "valueCoded", leg_swell, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("6042", "", "valueCoded", urination_fatigue, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("6042", "", "valueCoded", lose_consciousness, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("6042", "", "valueCoded", blurr_vision, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("6042", "", "valueCoded", focal_weakness, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("6042", "", "valueCoded", foot_complaint, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("6042", "", "valueCoded", headache_migraines, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("6042", "", "valueCoded", complaint_other, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165174", "", "valueText", editTextComplaintOther.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1427", "", "valueDate", editTextLMP.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165208", "", "valueCoded", exercise, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165207", "", "valueCoded", diet, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("152722", "", "valueCoded", smoking, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("159449", "", "valueCoded", drinking, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165165", "", "valueText", editTextRiskOther.getText().toString().trim(), DateCalendar.date(), ""));

        try {
            jsonArry = JSONFormBuilder.concatArray(jsonArry);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Log.d("JSON FollowUp Page 1", jsonArry.toString() + " ");

        FragmentModelInitial.getInstance().initialOne(dm_initial_dateEditText.getText().toString().trim() + " " + DateCalendar.time(), jsonArry);
    }
}
