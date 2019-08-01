package org.development.aihd.fragments.initial;

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
import android.widget.LinearLayout;
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

public class Initial_page_2 extends Fragment {

    private View view;
    private LinearLayout linearLayoutPastCurrentMedication, linearLayoutOtherPastCurrentMedication, linearLayoutExamOther, linearLayoutExtremities, linearLayoutExtremitiesDescription;

    private EditText editTextMetformin, editTextGlibenclamide, editTextInsulin, editTextNPH, editTextSolubleInsulin, editTextEnalapril, editTextHCTZ, editTextLosartan, editTextNifedipine, editTextAtenolol, editTextMedicationOther,
            editTextAdhereSpecify, editTextAllergySpecify;

    private EditText getEditTextRespiratoryRate, editTextTemp, editTextPulseRate, editTextSystolicOne, editTextDiastolicOne, editTextSystolicTwo, editTextDiastolicTwo, editTextWaist,
            editTextHip, editTextHeight, editTextWeight, editTextMUAC, editTextRespiratoryRate, editTextExamOther, editTextVisual, editTextPulses, editTextJVP, editTextPallor, editTextHeartSounds, editTextPR, editTextAirEntry, editTextAbnormalSounds,
            editTextOrganomegally, editTextAscities, editTextMotor, editTextSensory, editTextAutonomic, editTextGumDisease, editTextOralFessions, editTextDepression, editTextSleepDisorders, editTextSubstanceAbuse, editTextRS, editTextPA,
            editTextCNS, editTextExtremeties, editTextFootExamAB, editTextMonofilamentRF, editTextMonofilamentLF, editTextFootRiskComments, editTextFootExamComments;

    private TextView_Roboto_Bold bmi, waist_hip_ratio;

    private String medication_none, medication_metformin, medication_glibenclamide, medication_insulin, medication_nph, medication_soluble_insulin,
            medication_enalapril, medication_hctz, medication_losartan, medication_nifedipine, medication_atenolol, medication_other, adhere_medication, allergies;

    private String general_exam, pallor_cb, jaundice, cyanosis, lymphadenopathy, oedema, dehydration, exam_other, visual_impairment, pulses, jvp, pallor, heart_sounds, pr, air_entry, abnormal_sounds, organomegally, ascities, motor, sensory,
            autonomic, gum_disease, oral_fessions, depression, sleep_disorders, substance_abuse, rs, pa, cns, extremities;

    private String pc_peripheralNeuro, pc_ulcers, pc_amputation, pc_acute_joint, fra_low_risk, fra_at_risk, fra_high_risk, fra_ulcerated_foot, fra_foot_emergency, fe_pedalPulse, fe_periheralNeuro, fe_deformity, fe_footUlcer, fe_amputation, fe_acuteJoint, fe_lossOfSensation, ulcers, callouses, hardened_nails, fungus, cellulitis, edema, dry;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dm_initial_fragment_2, container, false);

        linearLayoutPastCurrentMedication = view.findViewById(R.id.past_current_medication);
        linearLayoutOtherPastCurrentMedication = view.findViewById(R.id.other_past_current_medication);
        linearLayoutExamOther = view.findViewById(R.id.linearLayoutExamOther);
        //linearLayoutExtremities = view.findViewById(R.id.extremitiesLinearLayout);
        //linearLayoutExtremitiesDescription = view.findViewById(R.id.describe_extremities_layout);

        CheckBox checkBoxNone = view.findViewById(R.id.checkbox_medication_none);
        CheckBox checkBoxMetformin = view.findViewById(R.id.checkbox_medication_metformin);
        CheckBox checkBoxGlibenclamide = view.findViewById(R.id.checkbox_medication_glibenclamide);
        CheckBox checkBoxInsulin = view.findViewById(R.id.checkbox_medication_insulin);
        CheckBox checkBoxNPH = view.findViewById(R.id.checkbox_medication_nph);
        CheckBox checkBoxSoluble_insulin = view.findViewById(R.id.checkbox_medication_soluble_insulin);
        CheckBox checkBoxEnalapril = view.findViewById(R.id.checkbox_medication_enalapril);
        CheckBox checkBoxHCTZ = view.findViewById(R.id.checkbox_medication_hctz);
        CheckBox checkBoxLosartan = view.findViewById(R.id.checkbox_medication_losartan);
        CheckBox checkBoxNifedipine = view.findViewById(R.id.checkbox_medication_nifedipine);
        CheckBox checkBoxAtenolol = view.findViewById(R.id.checkbox_medication_atenolol);
        CheckBox checkBoxMedicationOther = view.findViewById(R.id.checkbox_medication_other);

        CheckBox checkBoxPallor = view.findViewById(R.id.checkbox_exam_pallor);
        CheckBox checkBoxJaundice = view.findViewById(R.id.checkbox_exam_jaundice);
        CheckBox checkBoxCyanosis = view.findViewById(R.id.checkbox_exam_cyanosis);
        CheckBox checkBoxLymphadenopathy = view.findViewById(R.id.checkbox_exam_lymphadenopathy);
        CheckBox checkBoxOedema = view.findViewById(R.id.checkbox_exam_oedema);
        CheckBox checkBoxDehydration = view.findViewById(R.id.checkbox_exam_dehydration);
        CheckBox checkBoxExamOther = view.findViewById(R.id.checkbox_exam_other);

        CheckBox checkBoxPeripheralNeuro = view.findViewById(R.id.checkbox_pc_peripheral_neuropathy);
        CheckBox checkBoxUlcers = view.findViewById(R.id.checkbox_pc_ulcers);
        CheckBox checkBoxAmputation = view.findViewById(R.id.checkbox_pc_amputation);
        CheckBox checkBoxAcuteJoint = view.findViewById(R.id.checkbox_pc_acute_joint);

        CheckBox checkBoxFRALowRisk = view.findViewById(R.id.checkbox_fra_low_risk);
        CheckBox checkBoxFRAAtRisk = view.findViewById(R.id.checkbox_fra_at_risk);
        CheckBox checkBoxFRAHighRisk = view.findViewById(R.id.checkbox_fra_high_risk);
        CheckBox checkBoxFRAFootUlcer = view.findViewById(R.id.checkbox_fra_ulcerated_foot);
        CheckBox checkBoxFRAFootEmergency = view.findViewById(R.id.checkbox_fra_foot_emergency);

        checkBox(checkBoxNone);
        checkBox(checkBoxMetformin);
        checkBox(checkBoxGlibenclamide);
        checkBox(checkBoxInsulin);
        checkBox(checkBoxNPH);
        checkBox(checkBoxSoluble_insulin);
        checkBox(checkBoxEnalapril);
        checkBox(checkBoxHCTZ);
        checkBox(checkBoxLosartan);
        checkBox(checkBoxNifedipine);
        checkBox(checkBoxAtenolol);
        checkBox(checkBoxMedicationOther);

        checkBox(checkBoxPallor);
        checkBox(checkBoxJaundice);
        checkBox(checkBoxCyanosis);
        checkBox(checkBoxLymphadenopathy);
        checkBox(checkBoxOedema);
        checkBox(checkBoxDehydration);
        checkBox(checkBoxExamOther);

        checkBox(checkBoxPeripheralNeuro);
        checkBox(checkBoxUlcers);
        checkBox(checkBoxAmputation);
        checkBox(checkBoxAcuteJoint);


        editTextMetformin = view.findViewById(R.id.medication_metformin);
        editTextGlibenclamide = view.findViewById(R.id.medication_glibenclamide);
        editTextInsulin = view.findViewById(R.id.medication_insulin);
        editTextNPH = view.findViewById(R.id.medication_nph);
        editTextSolubleInsulin = view.findViewById(R.id.medication_soluble_insulin);
        editTextEnalapril = view.findViewById(R.id.medication_enalapril);
        editTextHCTZ = view.findViewById(R.id.medication_hctz);
        editTextLosartan = view.findViewById(R.id.medication_losartan);
        editTextNifedipine = view.findViewById(R.id.medication_nifedipine);
        editTextAtenolol = view.findViewById(R.id.medication_atenolol);
        editTextMedicationOther = view.findViewById(R.id.medication_other);
        editTextAdhereSpecify = view.findViewById(R.id.adhere_specify);
        editTextAllergySpecify = view.findViewById(R.id.allergy_specify);
        editTextFootRiskComments = view.findViewById(R.id.foot_risk_comments);
        editTextFootExamComments = view.findViewById(R.id.foot_exam_comments);

        editTextRespiratoryRate = view.findViewById(R.id.respiratory_rate);
        editTextTemp = view.findViewById(R.id.temp);
        editTextPulseRate = view.findViewById(R.id.pulse_rate);

        editTextSystolicOne = view.findViewById(R.id.bp_systolic_one);
        editTextDiastolicOne = view.findViewById(R.id.bp_diastolic_one);
        editTextSystolicTwo = view.findViewById(R.id.bp_systolic_two);
        editTextDiastolicTwo = view.findViewById(R.id.bp_diastolic_two);

        editTextWaist = view.findViewById(R.id.waist_circ);
        editTextHip = view.findViewById(R.id.hip_circ);
        editTextHeight = view.findViewById(R.id.height);
        editTextWeight = view.findViewById(R.id.weight);

        editTextExamOther = view.findViewById(R.id.other_general_exam);

        editTextVisual = view.findViewById(R.id.describe_visual_impairment);
       /* editTextPulses = view.findViewById(R.id.describe_pulses);
        editTextJVP = view.findViewById(R.id.describe_jvp);
        editTextPallor = view.findViewById(R.id.describe_pallor);
        editTextHeartSounds = view.findViewById(R.id.describe_heart_sounds);
        editTextPR = view.findViewById(R.id.describe_pr);
        editTextAirEntry = view.findViewById(R.id.describe_air_entry);
        editTextAbnormalSounds = view.findViewById(R.id.describe_abnormal_sounds);
        editTextOrganomegally = view.findViewById(R.id.describe_organomegally);
        editTextAscities = view.findViewById(R.id.describe_ascities);
        editTextMotor = view.findViewById(R.id.describe_motor);
        editTextSensory = view.findViewById(R.id.describe_sensory);
        editTextAutonomic = view.findViewById(R.id.describe_autonomic);
        editTextGumDisease = view.findViewById(R.id.describe_gum_disease);
        editTextOralFessions = view.findViewById(R.id.describe_oral_fessions);
        editTextDepression = view.findViewById(R.id.describe_depression);
        editTextSleepDisorders = view.findViewById(R.id.describe_sleep_disorders);
        editTextSubstanceAbuse = view.findViewById(R.id.describe_substance_abuse);*/
        editTextFootExamAB = view.findViewById(R.id.foot_exam_ab);
        editTextMonofilamentRF = view.findViewById(R.id.monofilament_rf);
        editTextMonofilamentLF = view.findViewById(R.id.monofilament_lf);

        textWatcher(editTextMetformin, "");
        textWatcher(editTextGlibenclamide, "");
        textWatcher(editTextInsulin, "");
        textWatcher(editTextNPH, "");
        textWatcher(editTextSolubleInsulin, "");
        textWatcher(editTextEnalapril, "");
        textWatcher(editTextHCTZ, "");
        textWatcher(editTextLosartan, "");
        textWatcher(editTextNifedipine, "");
        textWatcher(editTextAtenolol, "");
        textWatcher(editTextMedicationOther, "");
        textWatcher(editTextAdhereSpecify, "");
        textWatcher(editTextAllergySpecify, "");
        textWatcher(editTextFootRiskComments, "");
        textWatcher(editTextFootExamComments, "");

        textWatcher(editTextRespiratoryRate, "respRate");
        textWatcher(editTextTemp, "temp");
        textWatcher(editTextPulseRate, "pulseRate");
        textWatcher(editTextSystolicOne, "blood_pressure");
        textWatcher(editTextSystolicTwo, "blood_pressure");
        textWatcher(editTextDiastolicOne, "blood_pressure");
        textWatcher(editTextDiastolicTwo, "blood_pressure");
        textWatcher(editTextHeight, "bmi");
        textWatcher(editTextWeight, "bmi");
        textWatcher(editTextWaist, "whr");
        textWatcher(editTextHip, "whr");
        textWatcher(editTextExamOther, "");
        textWatcher(editTextVisual, "");
        textWatcher(editTextFootExamAB, "");
        textWatcher(editTextMonofilamentRF, "monofilament");
        textWatcher(editTextMonofilamentLF, "monofilament");

        RadioButton radioButtonAdhereMedicationYes = view.findViewById(R.id.radio_adhere_yes);
        RadioButton radioButtonAdhereMedicationNo = view.findViewById(R.id.radio_adhere_no);
        RadioButton radioButtonAdhereMedicationNA = view.findViewById(R.id.radio_adhere_na);
        RadioButton radioButtonAllergiesYes = view.findViewById(R.id.radio_allergies_yes);
        RadioButton radioButtonAllergiesNo = view.findViewById(R.id.radio_allergies_no);

        RadioButton radioButtonExamFair = view.findViewById(R.id.radio_exam_fair);
        RadioButton radioButtonExamGood = view.findViewById(R.id.radio_exam_good);
        RadioButton radioButtonExamSick = view.findViewById(R.id.radio_exam_sick);
        RadioButton radioButtonVisualYes = view.findViewById(R.id.radio_visual_impairment_yes);
        RadioButton radioButtonVisualNo = view.findViewById(R.id.radio_visual_impairment_no);

        RadioButton radioButtonFETreatmentPedalPulse = view.findViewById(R.id.radio_foot_exam_treatment_pedal_pulse);
        RadioButton radioButtonFEResolvedPedalPulse = view.findViewById(R.id.radio_foot_exam_resolved_pedal_pulse);
        RadioButton radioButtonFEReferralPedalPulse = view.findViewById(R.id.radio_foot_exam_referral_pedal_pulse);
        RadioButton radioButtonFESavedPedalPulse = view.findViewById(R.id.radio_foot_exam_saved_pedal_pulse);

        RadioButton radioButtonFETreatmentPeripheralNeuro = view.findViewById(R.id.radio_foot_exam_treatment_peripheral_neuropathy);
        RadioButton radioButtonFEResolvedPeripheralNeuro = view.findViewById(R.id.radio_foot_exam_resolved_peripheral_neuropathy);
        RadioButton radioButtonFEReferralPeripheralNeuro = view.findViewById(R.id.radio_foot_exam_referral_peripheral_neuropathy);
        RadioButton radioButtonFESavedPeripheralNeuro = view.findViewById(R.id.radio_foot_exam_saved_peripheral_neuropathy);

        RadioButton radioButtonFETreatmentDeformity = view.findViewById(R.id.radio_foot_exam_treatment_deformity);
        RadioButton radioButtonFEResolvedDeformity = view.findViewById(R.id.radio_foot_exam_resolved_deformity);
        RadioButton radioButtonFEReferralDeformity = view.findViewById(R.id.radio_foot_exam_referral_deformity);
        RadioButton radioButtonFESavedDeformity = view.findViewById(R.id.radio_foot_exam_saved_deformity);

        RadioButton radioButtonFETreatmentFootUlcer = view.findViewById(R.id.radio_foot_exam_treatment_foot_ulcer);
        RadioButton radioButtonFEResolvedFootUlcer = view.findViewById(R.id.radio_foot_exam_resolved_foot_ulcer);
        RadioButton radioButtonFEReferralFootUlcer = view.findViewById(R.id.radio_foot_exam_referral_foot_ulcer);
        RadioButton radioButtonFESavedFootUlcer = view.findViewById(R.id.radio_foot_exam_saved_foot_ulcer);

        RadioButton radioButtonFETreatmentAmputation = view.findViewById(R.id.radio_foot_exam_treatment_amputation);
        RadioButton radioButtonFEResolvedAmputation = view.findViewById(R.id.radio_foot_exam_resolved_amputation);
        RadioButton radioButtonFEReferralAmputation = view.findViewById(R.id.radio_foot_exam_referral_amputation);
        RadioButton radioButtonFESavedAmputation = view.findViewById(R.id.radio_foot_exam_saved_amputation);

        RadioButton radioButtonFETreatmentAcuteJoint = view.findViewById(R.id.radio_foot_exam_treatment_acute_joint);
        RadioButton radioButtonFEResolvedAcuteJoint = view.findViewById(R.id.radio_foot_exam_resolved_acute_joint);
        RadioButton radioButtonFEReferralAcuteJoint = view.findViewById(R.id.radio_foot_exam_referral_acute_joint);
        RadioButton radioButtonFESavedAcuteJoint = view.findViewById(R.id.radio_foot_exam_saved_acute_joint);

        RadioButton radioButtonFETreatmentSensation = view.findViewById(R.id.radio_foot_exam_treatment_loss_of_sensation);
        RadioButton radioButtonFEResolvedSensation = view.findViewById(R.id.radio_foot_exam_resolved_loss_of_sensation);
        RadioButton radioButtonFEReferralSensation = view.findViewById(R.id.radio_foot_exam_referral_loss_of_sensation);
        RadioButton radioButtonFESavedSensation = view.findViewById(R.id.radio_foot_exam_saved_loss_of_sensation);

        radioButton(radioButtonAdhereMedicationYes);
        radioButton(radioButtonAdhereMedicationNo);
        radioButton(radioButtonAdhereMedicationNA);
        radioButton(radioButtonAllergiesYes);
        radioButton(radioButtonAllergiesNo);

        radioButton(radioButtonExamFair);
        radioButton(radioButtonExamGood);
        radioButton(radioButtonExamSick);
        radioButton(radioButtonVisualYes);
        radioButton(radioButtonVisualNo);

        radioButton(radioButtonFETreatmentPedalPulse);
        radioButton(radioButtonFEResolvedPedalPulse);
        radioButton(radioButtonFEReferralPedalPulse);
        radioButton(radioButtonFESavedPedalPulse);

        radioButton(radioButtonFETreatmentPeripheralNeuro);
        radioButton(radioButtonFEResolvedPeripheralNeuro);
        radioButton(radioButtonFEReferralPeripheralNeuro);
        radioButton(radioButtonFESavedPeripheralNeuro);

        radioButton(radioButtonFETreatmentDeformity);
        radioButton(radioButtonFEResolvedDeformity);
        radioButton(radioButtonFEReferralDeformity);
        radioButton(radioButtonFESavedDeformity);

        radioButton(radioButtonFETreatmentFootUlcer);
        radioButton(radioButtonFEResolvedFootUlcer);
        radioButton(radioButtonFEReferralFootUlcer);
        radioButton(radioButtonFESavedFootUlcer);

        radioButton(radioButtonFETreatmentAmputation);
        radioButton(radioButtonFEResolvedAmputation);
        radioButton(radioButtonFEReferralAmputation);
        radioButton(radioButtonFESavedAmputation);

        radioButton(radioButtonFETreatmentAcuteJoint);
        radioButton(radioButtonFEResolvedAcuteJoint);
        radioButton(radioButtonFEReferralAcuteJoint);
        radioButton(radioButtonFESavedAcuteJoint);

        radioButton(radioButtonFETreatmentSensation);
        radioButton(radioButtonFEResolvedSensation);
        radioButton(radioButtonFEReferralSensation);
        radioButton(radioButtonFESavedSensation);

        bmi = view.findViewById(R.id.bmi);
        waist_hip_ratio = view.findViewById(R.id.waist_hip_ratio);

        //editTextMUAC = view.findViewById(R.id.muac);
        //editTextRespiratoryRate = view.findViewById(R.id.respiratory_rate);
        // editTextExtremeties = view.findViewById(R.id.describe_extremities);

        //CheckBox checkBoxGumDisease = view.findViewById(R.id.checkbox_gum_disease);
        // CheckBox checkBoxOralFesions = view.findViewById(R.id.checkbox_oral_fessions);
        // CheckBox checkBoxDepression = view.findViewById(R.id.checkbox_depression);
        //CheckBox checkBoxSleepDisorder = view.findViewById(R.id.checkbox_sleep_disorder);*/

        // checkBox(checkBoxGumDisease);
        //  checkBox(checkBoxOralFesions);
        // checkBox(checkBoxDepression);
        // checkBox(checkBoxSleepDisorder);

        //textWatcher(editTextMUAC, "");
        //textWatcher(editTextRespiratoryRate, "");*/

        //textWatcher(editTextPulses, "");
        //textWatcher(editTextJVP, "");
        // textWatcher(editTextPallor, "");
        //textWatcher(editTextHeartSounds, "");
        //textWatcher(editTextPR, "");
        //textWatcher(editTextAirEntry, "");
        //textWatcher(editTextAbnormalSounds, "");
        //textWatcher(editTextOrganomegally, "");
        //textWatcher(editTextAscities, "");
        //textWatcher(editTextMotor, "");
        //textWatcher(editTextSensory, "");
        // textWatcher(editTextAutonomic, "");
        // textWatcher(editTextGumDisease, "");
        // textWatcher(editTextOralFessions, "");
        // textWatcher(editTextDepression, "");
        // textWatcher(editTextSleepDisorders, "");
        // textWatcher(editTextSubstanceAbuse, "");*/
        // textWatcher(editTextExtremeties, "");

        //RadioButton radioButtonPulsesNormal = view.findViewById(R.id.radio_pulses_normal);
        // RadioButton radioButtonPulsesAbnormal = view.findViewById(R.id.radio_pulses_abnormal);
        //  RadioButton radioButtonJVPNormal = view.findViewById(R.id.radio_jvp_normal);
        // RadioButton radioButtonJVPAbnormal = view.findViewById(R.id.radio_jvp_abnormal);
        //  RadioButton radioButtonPallorNormal = view.findViewById(R.id.radio_pallor_normal);
        // RadioButton radioButtonPallorAbnormal = view.findViewById(R.id.radio_pallor_abnormal);
        //  RadioButton radioButtonHeartSoundsNormal = view.findViewById(R.id.radio_heart_sounds_normal);
        //  RadioButton radioButtonHeartSoundsAbnormal = view.findViewById(R.id.radio_heart_sounds_abnormal);*/
        // RadioButton radioButtonPRNormal = view.findViewById(R.id.radio_pr_normal);
        // RadioButton radioButtonPRAbnormal = view.findViewById(R.id.radio_pr_abnormal);
        //  RadioButton radioButtonAirEntryNormal = view.findViewById(R.id.radio_air_entry_normal);
        //  RadioButton radioButtonAirEntryAbnormal = view.findViewById(R.id.radio_air_entry_abnormal);
        // RadioButton radioButtonAbnormalSoundsNormal = view.findViewById(R.id.radio_abnormal_sounds_normal);
        //   RadioButton radioButtonAbnormalSoundsAbnormal = view.findViewById(R.id.radio_abnormal_sounds_abnormal);
        //  RadioButton radioButtonOrganomegallyNormal = view.findViewById(R.id.radio_organomegally_normal);
        //  RadioButton radioButtonOrganomegallyAbnormal = view.findViewById(R.id.radio_organomegally_abnormal);
        //  RadioButton radioButtonAscitiesNormal = view.findViewById(R.id.radio_ascities_normal);
        //  RadioButton radioButtonAscitiesAbnormal = view.findViewById(R.id.radio_ascities_abnormal);
        //  RadioButton radioButtonMotorNormal = view.findViewById(R.id.radio_motor_normal);
        //  RadioButton radioButtonMotorAbnormal = view.findViewById(R.id.radio_motor_abnormal);
        //  RadioButton radioButtonSensoryNormal = view.findViewById(R.id.radio_sensory_normal);
        //  RadioButton radioButtonSensoryAbnormal = view.findViewById(R.id.radio_sensory_abnormal);
        // RadioButton radioButtonAutonomicNormal = view.findViewById(R.id.radio_autonomic_normal);
        //  RadioButton radioButtonAutonomicAbnormal = view.findViewById(R.id.radio_autonomic_abnormal);*/
        // RadioButton radioButtonExtremitiesNormal = view.findViewById(R.id.radio_extremities_normal);
        //  RadioButton radioButtonExtremitiesAbnormal = view.findViewById(R.id.radio_extremities_abnormal);


        // radioButton(radioButtonPulsesNormal);
        // radioButton(radioButtonPulsesAbnormal);
        // radioButton(radioButtonJVPNormal);
        //   radioButton(radioButtonJVPAbnormal);
        //  radioButton(radioButtonPallorNormal);
        //   radioButton(radioButtonPallorAbnormal);
        //  radioButton(radioButtonHeartSoundsNormal);
        // radioButton(radioButtonHeartSoundsAbnormal);*/
        // radioButton(radioButtonPRNormal);
        //  radioButton(radioButtonPRAbnormal);
        // radioButton(radioButtonAirEntryNormal);
        // radioButton(radioButtonAirEntryAbnormal);
        //  radioButton(radioButtonAbnormalSoundsNormal);
        //  radioButton(radioButtonAbnormalSoundsAbnormal);
        //  radioButton(radioButtonOrganomegallyNormal);
        //  radioButton(radioButtonOrganomegallyAbnormal);
        //   radioButton(radioButtonAscitiesNormal);
        //   radioButton(radioButtonAscitiesAbnormal);
        //   radioButton(radioButtonMotorNormal);
        //  radioButton(radioButtonMotorAbnormal);
        //  radioButton(radioButtonSensoryNormal);
        //  radioButton(radioButtonSensoryAbnormal);
        //  radioButton(radioButtonAutonomicNormal);
        //  radioButton(radioButtonAutonomicAbnormal);*/
        // radioButton(radioButtonExtremitiesNormal);
        //  radioButton(radioButtonExtremitiesAbnormal);

        //  CheckBox checkBoxUlcers = view.findViewById(R.id.checkbox_extremities_ulcers);
        // CheckBox checkBoxCallouses = view.findViewById(R.id.checkbox_extremities_callouses);
        //CheckBox checkBoxHardenedNails = view.findViewById(R.id.checkbox_extremities_nails);
        // CheckBox checkBoxFungus = view.findViewById(R.id.checkbox_extremities_fungus);
        // CheckBox checkBoxCellutis = view.findViewById(R.id.checkbox_extremities_cellulitis);
        // CheckBox checkBoxEdema = view.findViewById(R.id.checkbox_extremities_edema);
        // CheckBox checkBoxDry = view.findViewById(R.id.checkbox_extremities_dry);

        //checkBox(checkBoxUlcers);
        // checkBox(checkBoxCallouses);
        //  checkBox(checkBoxHardenedNails);
        //  checkBox(checkBoxFungus);
        //   checkBox(checkBoxCellutis);
        //  checkBox(checkBoxEdema);
        //  checkBox(checkBoxDry);*/

        return view;
    }

    public void medicationNone(String status) {
        if (status.matches("1107")) {
            linearLayoutPastCurrentMedication.setVisibility(View.GONE);
        } else {
            linearLayoutPastCurrentMedication.setVisibility(View.VISIBLE);
        }
    }

    public void medicationOther(String status) {
        if (status.matches("5622")) {
            linearLayoutOtherPastCurrentMedication.setVisibility(View.VISIBLE);
        } else {
            linearLayoutOtherPastCurrentMedication.setVisibility(View.GONE);
        }
    }

    public void examOther(String status) {
        if (status.matches("161602")) {
            linearLayoutExamOther.setVisibility(View.VISIBLE);
        } else {
            linearLayoutExamOther.setVisibility(View.GONE);
        }
    }

    public void extremitiesStatus(String status) {
        if (status.matches("1116")) {
            linearLayoutExtremities.setVisibility(View.VISIBLE);
            linearLayoutExtremitiesDescription.setVisibility((View.VISIBLE));
        } else {
            linearLayoutExtremities.setVisibility(View.GONE);
            linearLayoutExtremitiesDescription.setVisibility(view.GONE);
        }
    }

    public void textWatcher(EditText editText, final String check) {

        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(final Editable editable) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        switch (check) {
                            case "respRate":
                                Common.checkRespRate(linearLayoutPastCurrentMedication, editable.toString());
                                break;
                            case "temp":
                                Common.checkTemp(linearLayoutPastCurrentMedication, editable.toString());
                                break;
                            case "pulseRate":
                                Common.checkPR(linearLayoutPastCurrentMedication, editable.toString());
                                break;
                            case "blood_pressure":
                                if (editTextSystolicTwo != null && editTextDiastolicTwo != null) {
                                    Common.checkBP(view, editTextSystolicTwo, editTextDiastolicTwo);
                                }

                                if (editTextSystolicOne != null && editTextDiastolicOne != null) {
                                    Common.checkBP(view, editTextSystolicOne, editTextDiastolicOne);
                                }
                                break;
                            case "bmi":
                                Common.bmi(getContext(), editTextHeight, editTextWeight, bmi);
                                break;
                            case "whr":
                                Common.whr(editTextWaist, editTextHip, waist_hip_ratio);
                                break;
                            case "monofilament":
                                Common.monofilament(view, editable.toString());
                                break;
                            case "Monofilament":
                                Common.monofilament(view, editable.toString());
                                break;
                            default:
                                break;
                        }
                    }
                }, 4000);

                updateValues();
            }


            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                /*Check text Change before typing*/
                // TODO: No current action
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                /*Check text Change while typing*/
                // TODO: No current action
            }
        });
    }

    public void metformin(String status) {
        if (!status.matches("79651")) {
            editTextMetformin.setVisibility(View.INVISIBLE);
        } else {
            editTextMetformin.setVisibility(View.VISIBLE);
            editTextMetformin.setText("");
        }
    }

    public void glibenclamide(String status) {
        if (!status.matches("77071")) {
            editTextGlibenclamide.setVisibility(View.INVISIBLE);
        } else {
            editTextGlibenclamide.setVisibility(View.VISIBLE);
            editTextGlibenclamide.setText("");
        }
    }

    public void insulin(String status) {
        if (!status.matches("159459")) {
            editTextInsulin.setVisibility(View.INVISIBLE);
        } else {
            editTextInsulin.setVisibility(View.VISIBLE);
            editTextInsulin.setText("");
        }
    }

    public void nph(String status) {
        if (!status.matches("78068")) {
            editTextNPH.setVisibility(View.INVISIBLE);
        } else {
            editTextNPH.setVisibility(View.VISIBLE);
            editTextNPH.setText("");
        }
    }

    public void solubleInsulin(String status) {
        if (!status.matches("282")) {
            editTextSolubleInsulin.setVisibility(View.INVISIBLE);
        } else {
            editTextSolubleInsulin.setVisibility(View.VISIBLE);
            editTextSolubleInsulin.setText("");
        }
    }

    public void enalapril(String status) {
        if (!status.matches("75633")) {
            editTextEnalapril.setVisibility(View.INVISIBLE);
        } else {
            editTextEnalapril.setVisibility(View.VISIBLE);
            editTextEnalapril.setText("");
        }
    }

    public void hctz(String status) {
        if (!status.matches("77696")) {
            editTextHCTZ.setVisibility(View.INVISIBLE);
        } else {
            editTextHCTZ.setVisibility(View.VISIBLE);
            editTextHCTZ.setText("");
        }
    }

    public void losartan(String status) {
        if (!status.matches("79074")) {
            editTextLosartan.setVisibility(View.INVISIBLE);
        } else {
            editTextLosartan.setVisibility(View.VISIBLE);
            editTextLosartan.setText("");
        }
    }

    public void nifedipine(String status) {
        if (!status.matches("80637")) {
            editTextNifedipine.setVisibility(View.INVISIBLE);
        } else {
            editTextNifedipine.setVisibility(View.VISIBLE);
            editTextNifedipine.setText("");
        }
    }

    public void atenolol(String status) {
        if (!status.matches("71652")) {
            editTextAtenolol.setVisibility(View.INVISIBLE);
        } else {
            editTextAtenolol.setVisibility(View.VISIBLE);
            editTextAtenolol.setText("");
        }
    }

    public void checkBox(final CheckBox checkBox) {

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                boolean checked = (buttonView).isChecked();
                int value = checkBox.getId();

                //Check which checkbox was clicked
                switch (value) {
                    case R.id.checkbox_medication_none:
                        if (checked) {
                            medication_none = "1107";
                            medicationNone(medication_none);
                        } else {
                            medication_none = "";
                            medicationNone(medication_none);
                        }
                        break;
                    case R.id.checkbox_medication_metformin:
                        if (checked) {
                            medication_metformin = "79651";
                        } else {
                            medication_metformin = "";
                        }
                        metformin(medication_metformin);
                        break;
                    case R.id.checkbox_medication_glibenclamide:
                        if (checked) {
                            medication_glibenclamide = "77071";
                        } else {
                            medication_glibenclamide = "";
                        }
                        glibenclamide(medication_glibenclamide);
                        break;
                    case R.id.checkbox_medication_insulin:
                        if (checked) {
                            medication_insulin = "159459";
                        } else {
                            medication_insulin = "";
                        }
                        insulin(medication_insulin);
                        break;
                    case R.id.checkbox_medication_nph:
                        if (checked) {
                            medication_nph = "78068";
                        } else {
                            medication_nph = "";
                        }
                        nph(medication_nph);
                        break;
                    case R.id.checkbox_medication_soluble_insulin:
                        if (checked) {
                            medication_soluble_insulin = "282";
                        } else {
                            medication_soluble_insulin = "";
                        }
                        solubleInsulin(medication_soluble_insulin);
                        break;
                    case R.id.checkbox_medication_enalapril:
                        if (checked) {
                            medication_enalapril = "75633";
                        } else {
                            medication_enalapril = "";
                        }
                        enalapril(medication_enalapril);
                        break;
                    case R.id.checkbox_medication_hctz:
                        if (checked) {
                            medication_hctz = "77696";
                        } else {
                            medication_hctz = "";
                        }
                        hctz(medication_hctz);
                        break;
                    case R.id.checkbox_medication_losartan:
                        if (checked) {
                            medication_losartan = "79074";
                        } else {
                            medication_losartan = "";
                        }
                        losartan(medication_losartan);
                        break;
                    case R.id.checkbox_medication_nifedipine:
                        if (checked) {
                            medication_nifedipine = "80637";
                        } else {
                            medication_nifedipine = "";
                        }
                        nifedipine(medication_nifedipine);
                        break;
                    case R.id.checkbox_medication_atenolol:
                        if (checked) {
                            medication_atenolol = "71652";
                        } else {
                            medication_atenolol = "";
                        }
                        atenolol(medication_atenolol);
                        break;
                    case R.id.checkbox_medication_other:
                        if (checked) {
                            medication_other = "5622";
                        } else {
                            medication_other = "";
                        }
                        medicationOther(medication_other);
                        break;
                    case R.id.checkbox_exam_pallor:
                        if (checked) {
                            pallor_cb = "5245";
                        } else {
                            pallor_cb = "";
                        }
                        break;
                    case R.id.checkbox_exam_jaundice:
                        if (checked) {
                            jaundice = "136443";
                        } else {
                            jaundice = "";
                        }
                        break;
                    case R.id.checkbox_exam_cyanosis:
                        if (checked) {
                            cyanosis = "143050";
                        } else {
                            cyanosis = "";
                        }
                        break;
                    case R.id.checkbox_exam_lymphadenopathy:
                        if (checked) {
                            lymphadenopathy = "135488";
                        } else {
                            lymphadenopathy = "";
                        }
                        break;
                    case R.id.checkbox_exam_oedema:
                        if (checked) {
                            oedema = "460";
                        } else {
                            oedema = "";
                        }
                        break;
                    case R.id.checkbox_exam_dehydration:
                        if (checked) {
                            dehydration = "142630";
                        } else {
                            dehydration = "";
                        }
                        break;
                    case R.id.checkbox_exam_other:
                        if (checked) {
                            exam_other = "161602";
                            examOther(exam_other);
                        } else {
                            exam_other = "";
                            examOther(exam_other);
                        }
                        break;
                    case R.id.checkbox_pc_peripheral_neuropathy:
                        if (checked) {
                            pc_peripheralNeuro = "118983";
                        } else {
                            pc_peripheralNeuro = "";
                        }
                        break;
                    case R.id.checkbox_pc_ulcers:
                        if (checked) {
                            pc_ulcers = "123919";
                        } else {
                            pc_ulcers = "";
                        }
                        break;
                    case R.id.checkbox_pc_amputation:
                        if (checked) {
                            pc_amputation = "164009";
                        } else {
                            pc_amputation = "";
                        }
                        break;
                    case R.id.checkbox_pc_acute_joint:
                        if (checked) {
                            pc_acute_joint = "165317";
                        } else {
                            pc_acute_joint = "";
                        }
                        break;
                    case R.id.checkbox_fra_low_risk:
                        if (checked) {
                            fra_low_risk = "165338";
                        } else {
                            fra_low_risk = "";
                        }
                        break;
                    case R.id.checkbox_fra_at_risk:
                        if (checked) {
                            fra_at_risk = "165321";
                        } else {
                            fra_at_risk = "";
                        }
                        break;
                    case R.id.checkbox_fra_high_risk:
                        if (checked) {
                            fra_high_risk = "165320";
                        } else {
                            fra_high_risk = "";
                        }
                        break;
                    case R.id.checkbox_fra_ulcerated_foot:
                        if (checked) {
                            fra_ulcerated_foot = "163411";
                        } else {
                            fra_ulcerated_foot = "";
                        }
                        break;
                    case R.id.checkbox_fra_foot_emergency:
                        if (checked) {
                            fra_foot_emergency = "165319";
                        } else {
                            fra_foot_emergency = "";
                        }
                        break;

                }

                updateValues();
            }
        });
    }

    public void radioButton(final RadioButton radioButton) {

        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Is the button now checked?
                boolean checked = (buttonView).isChecked();
                int value = radioButton.getId();

                // Check which radio button was clicked
                switch (value) {
                    case R.id.radio_adhere_yes:
                        if (checked)
                            adhere_medication = "1065";
                        break;
                    case R.id.radio_adhere_no:
                        if (checked)
                            adhere_medication = "1066";
                        break;
                    case R.id.radio_adhere_na:
                        if (checked)
                            adhere_medication = "1175";
                        break;
                    case R.id.radio_allergies_yes:
                        if (checked)
                            allergies = "1065";
                        break;
                    case R.id.radio_allergies_no:
                        if (checked)
                            allergies = "1066";
                        break;
                    case R.id.radio_exam_fair:
                        if (checked)
                            general_exam = "162133";
                        break;
                    case R.id.radio_exam_good:
                        if (checked)
                            general_exam = "1855";
                        break;
                    case R.id.radio_exam_sick:
                        if (checked)
                            general_exam = "163293";
                        break;
                    case R.id.radio_visual_impairment_yes:
                        if (checked)
                            visual_impairment = "1065";
                        break;
                    case R.id.radio_visual_impairment_no:
                        if (checked)
                            visual_impairment = "1066";
                        break;
                   /* case R.id.radio_pulses_normal:
                        if (checked)
                            pulses = "1115";
                        break;
                    case R.id.radio_pulses_abnormal:
                        if (checked)
                            pulses = "1116";
                        break;
                    case R.id.radio_jvp_normal:
                        if (checked)
                            jvp = "1115";
                        break;
                    case R.id.radio_jvp_abnormal:
                        if (checked)
                            jvp = "1116";
                        break;
                    case R.id.radio_pallor_normal:
                        if (checked)
                            pallor = "1115";
                        break;
                    case R.id.radio_pallor_abnormal:
                        if (checked)
                            pallor = "1116";
                        break;
                    case R.id.radio_heart_sounds_normal:
                        if (checked)
                            heart_sounds = "1115";
                        break;
                    case R.id.radio_heart_sounds_abnormal:
                        if (checked)
                            heart_sounds = "1116";
                        break;
                    case R.id.radio_air_entry_normal:
                        if (checked)
                            air_entry = "1115";
                        break;
                    case R.id.radio_air_entry_abnormal:
                        if (checked)
                            air_entry = "1116";
                        break;
                    case R.id.radio_abnormal_sounds_normal:
                        if (checked)
                            abnormal_sounds = "1115";
                        break;
                    case R.id.radio_abnormal_sounds_abnormal:
                        if (checked)
                            abnormal_sounds = "1116";
                        break;
                    case R.id.radio_organomegally_normal:
                        if (checked)
                            organomegally = "1115";
                        break;
                    case R.id.radio_organomegally_abnormal:
                        if (checked)
                            organomegally = "1116";
                        break;
                    case R.id.radio_ascities_normal:
                        if (checked)
                            ascities = "1115";
                        break;
                    case R.id.radio_ascities_abnormal:
                        if (checked)
                            ascities = "1116";
                        break;
                    case R.id.radio_motor_normal:
                        if (checked)
                            motor = "1115";
                        break;
                    case R.id.radio_motor_abnormal:
                        if (checked)
                            motor = "1116";
                        break;
                    case R.id.radio_sensory_normal:
                        if (checked)
                            sensory = "1115";
                        break;
                    case R.id.radio_sensory_abnormal:
                        if (checked)
                            sensory = "1116";
                        break;
                    case R.id.radio_autonomic_normal:
                        if (checked)
                            autonomic = "1115";
                        break;
                    case R.id.radio_autonomic_abnormal:
                        if (checked)
                            autonomic = "1116";
                        break;*/

                    case R.id.radio_foot_exam_treatment_pedal_pulse:
                        if (checked)
                            fe_pedalPulse = "160749";
                        break;
                    case R.id.radio_foot_exam_resolved_pedal_pulse:
                        if (checked)
                            fe_pedalPulse = "6097";
                        break;
                    case R.id.radio_foot_exam_referral_pedal_pulse:
                        if (checked)
                            fe_pedalPulse = "165192";
                        break;
                    case R.id.radio_foot_exam_saved_pedal_pulse:
                        if (checked)
                            fe_pedalPulse = "165329";
                        break;

                    case R.id.radio_foot_exam_treatment_peripheral_neuropathy:
                        if (checked)
                            fe_periheralNeuro = "160749";
                        break;
                    case R.id.radio_foot_exam_resolved_peripheral_neuropathy:
                        if (checked)
                            fe_periheralNeuro = "6097";
                        break;
                    case R.id.radio_foot_exam_referral_peripheral_neuropathy:
                        if (checked)
                            fe_periheralNeuro = "165192";
                        break;
                    case R.id.radio_foot_exam_saved_peripheral_neuropathy:
                        if (checked)
                            fe_periheralNeuro = "165329";
                        break;

                    case R.id.radio_foot_exam_treatment_deformity:
                        if (checked)
                            fe_deformity = "160749";
                        break;
                    case R.id.radio_foot_exam_resolved_deformity:
                        if (checked)
                            fe_deformity = "6097";
                        break;
                    case R.id.radio_foot_exam_referral_deformity:
                        if (checked)
                            fe_deformity = "165192";
                        break;
                    case R.id.radio_foot_exam_saved_deformity:
                        if (checked)
                            fe_deformity = "165329";
                        break;

                    case R.id.radio_foot_exam_treatment_foot_ulcer:
                        if (checked)
                            fe_footUlcer = "160749";
                        break;
                    case R.id.radio_foot_exam_resolved_foot_ulcer:
                        if (checked)
                            fe_footUlcer = "6097";
                        break;
                    case R.id.radio_foot_exam_referral_foot_ulcer:
                        if (checked)
                            fe_footUlcer = "165192";
                        break;
                    case R.id.radio_foot_exam_saved_foot_ulcer:
                        if (checked)
                            fe_footUlcer = "165329";
                        break;

                    case R.id.radio_foot_exam_treatment_amputation:
                        if (checked)
                            fe_amputation = "160749";
                        break;
                    case R.id.radio_foot_exam_resolved_amputation:
                        if (checked)
                            fe_amputation = "6097";
                        break;
                    case R.id.radio_foot_exam_referral_amputation:
                        if (checked)
                            fe_amputation = "165192";
                        break;
                    case R.id.radio_foot_exam_saved_amputation:
                        if (checked)
                            fe_amputation = "165329";
                        break;

                    case R.id.radio_foot_exam_treatment_acute_joint:
                        if (checked)
                            fe_acuteJoint = "160749";
                        break;
                    case R.id.radio_foot_exam_resolved_acute_joint:
                        if (checked)
                            fe_acuteJoint = "6097";
                        break;
                    case R.id.radio_foot_exam_referral_acute_joint:
                        if (checked)
                            fe_acuteJoint = "165192";
                        break;
                    case R.id.radio_foot_exam_saved_acute_joint:
                        if (checked)
                            fe_acuteJoint = "165329";
                        break;

                    case R.id.radio_foot_exam_treatment_loss_of_sensation:
                        if (checked)
                            fe_lossOfSensation = "160749";
                        break;
                    case R.id.radio_foot_exam_resolved_loss_of_sensation:
                        if (checked)
                            fe_lossOfSensation = "6097";
                        break;
                    case R.id.radio_foot_exam_referral_loss_of_sensation:
                        if (checked)
                            fe_lossOfSensation = "165192";
                        break;
                    case R.id.radio_foot_exam_saved_loss_of_sensation:
                        if (checked)
                            fe_lossOfSensation = "165329";
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
        JSONArray jsonArry3 = new JSONArray();
        JSONArray jsonArry4 = new JSONArray();
        JSONArray jsonArry5 = new JSONArray();
        JSONArray jsonArry6 = new JSONArray();
        JSONArray jsonArry7 = new JSONArray();
        JSONArray jsonArry8 = new JSONArray();
        JSONArray jsonArry9 = new JSONArray();
        JSONArray jsonArry10 = new JSONArray();
        JSONArray jsonArry11 = new JSONArray();

        jsonArry.put(JSONFormBuilder.observations("159460", "", "valueCoded", medication_none, DateCalendar.date(), ""));
        jsonArry1.put(JSONFormBuilder.observations("1282", "1442", "valueCoded", medication_metformin, DateCalendar.date(), ""));
        jsonArry2.put(JSONFormBuilder.observations("1282", "1442", "valueCoded", medication_glibenclamide, DateCalendar.date(), ""));
        jsonArry3.put(JSONFormBuilder.observations("1282", "1442", "valueCoded", medication_insulin, DateCalendar.date(), ""));
        jsonArry4.put(JSONFormBuilder.observations("1282", "1442", "valueCoded", medication_nph, DateCalendar.date(), ""));
        jsonArry5.put(JSONFormBuilder.observations("1282", "1442", "valueCoded", medication_soluble_insulin, DateCalendar.date(), ""));
        jsonArry6.put(JSONFormBuilder.observations("1282", "1442", "valueCoded", medication_enalapril, DateCalendar.date(), ""));
        jsonArry7.put(JSONFormBuilder.observations("1282", "1442", "valueCoded", medication_hctz, DateCalendar.date(), ""));
        jsonArry8.put(JSONFormBuilder.observations("1282", "1442", "valueCoded", medication_losartan, DateCalendar.date(), ""));
        jsonArry9.put(JSONFormBuilder.observations("1282", "1442", "valueCoded", medication_nifedipine, DateCalendar.date(), ""));
        jsonArry10.put(JSONFormBuilder.observations("1282", "1442", "valueCoded", medication_atenolol, DateCalendar.date(), ""));
        jsonArry11.put(JSONFormBuilder.observations("1282", "1442", "valueCoded", medication_other, DateCalendar.date(), ""));

        jsonArry1.put(JSONFormBuilder.observations("165313", "1442", "valueText", editTextMetformin.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry2.put(JSONFormBuilder.observations("165313", "1442", "valueText", editTextGlibenclamide.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry3.put(JSONFormBuilder.observations("165313", "1442", "valueText", editTextInsulin.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry4.put(JSONFormBuilder.observations("165313", "1442", "valueText", editTextNPH.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry5.put(JSONFormBuilder.observations("165313", "1442", "valueText", editTextSolubleInsulin.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry6.put(JSONFormBuilder.observations("165313", "1442", "valueText", editTextEnalapril.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry7.put(JSONFormBuilder.observations("165313", "1442", "valueText", editTextHCTZ.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry8.put(JSONFormBuilder.observations("165313", "1442", "valueText", editTextLosartan.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry9.put(JSONFormBuilder.observations("165313", "1442", "valueText", editTextNifedipine.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry10.put(JSONFormBuilder.observations("165313", "1442", "valueText", editTextAtenolol.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165157", "", "valueText", editTextMedicationOther.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165108", "", "valueCoded", adhere_medication, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165109", "", "valueText", editTextAdhereSpecify.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165146", "", "valueCoded", allergies, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165166", "", "valueText", editTextAllergySpecify.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("", "", "valueNumeric", editTextRespiratoryRate.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("5088", "", "valueNumeric", editTextTemp.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("5087", "", "valueNumeric", editTextPulseRate.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("5085", "", "valueNumeric", editTextSystolicOne.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("5086", "", "valueNumeric", editTextDiastolicOne.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165111", "", "valueNumeric", editTextSystolicTwo.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165110", "", "valueNumeric", editTextDiastolicTwo.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("163081", "", "valueNumeric", editTextHip.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("163080", "", "valueNumeric", editTextWaist.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("5090", "", "valueNumeric", editTextHeight.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("5089", "", "valueNumeric", editTextWeight.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165316", "", "valueCoded", pc_peripheralNeuro, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165316", "", "valueCoded", pc_ulcers, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165316", "", "valueCoded", pc_amputation, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165316", "", "valueCoded", pc_acute_joint, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165318", "", "valueCoded", fra_low_risk, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165318", "", "valueCoded", fra_at_risk, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165318", "", "valueCoded", fra_high_risk, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165318", "", "valueCoded", fra_ulcerated_foot, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165318", "", "valueCoded", fra_foot_emergency, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165324", "", "valueCoded", fe_pedalPulse, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165324", "", "valueCoded", fe_periheralNeuro, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165325", "", "valueCoded", fe_deformity, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165326", "", "valueCoded", fe_footUlcer, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165340", "", "valueCoded", fe_amputation, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165327", "", "valueCoded", fe_acuteJoint, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165328", "", "valueCoded", fe_lossOfSensation, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1119", "", "valueCoded", general_exam, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1119", "", "valueCoded", pallor_cb, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1119", "", "valueCoded", jaundice, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1119", "", "valueCoded", cyanosis, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1119", "", "valueCoded", lymphadenopathy, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1119", "", "valueCoded", oedema, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1119", "", "valueCoded", dehydration, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1119", "", "valueCoded", exam_other, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("163042", "", "valueText", editTextExamOther.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165206", "", "valueCoded", visual_impairment, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165175", "", "valueText", editTextVisual.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165335", "", "valueText", editTextFootExamAB.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165117", "", "valueText", editTextMonofilamentLF.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165116", "", "valueText", editTextMonofilamentRF.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165337", "", "valueText", editTextFootRiskComments.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165336", "", "valueText", editTextFootExamComments.getText().toString().trim(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165112", "", "valueCoded", ulcers, DateCalendar.date(), ""));


        // jsonArry.put(JSONFormBuilder.observations("5242", "", "valueNumeric", editTextMUAC.getText().toString().trim(), DateCalendar.date(), ""));
        // jsonArry.put(JSONFormBuilder.observations("5242", "", "valueNumeric", editTextRespiratoryRate.getText().toString().trim(), DateCalendar.date(), ""));
        // jsonArry.put(JSONFormBuilder.observations("165190", "", "valueText", "", DateCalendar.date(), ""));


        //    jsonArry.put(JSONFormBuilder.observations("1124", "", "valueCoded", pulses, DateCalendar.date(), ""));
        //   jsonArry.put(JSONFormBuilder.observations("165158", "", "valueText", editTextPulses.getText().toString().trim(), DateCalendar.date(), ""));
        //   jsonArry.put(JSONFormBuilder.observations("1124", "", "valueCoded", jvp, DateCalendar.date(), ""));
        //   jsonArry.put(JSONFormBuilder.observations("165158", "", "valueText", editTextJVP.getText().toString().trim(), DateCalendar.date(), ""));
        //   jsonArry.put(JSONFormBuilder.observations("1124", "", "valueCoded", pallor, DateCalendar.date(), ""));
        //   jsonArry.put(JSONFormBuilder.observations("165158", "", "valueText", editTextPallor.getText().toString().trim(), DateCalendar.date(), ""));
        //   jsonArry.put(JSONFormBuilder.observations("1124", "", "valueCoded", heart_sounds, DateCalendar.date(), ""));
        //   jsonArry.put(JSONFormBuilder.observations("165158", "", "valueText", editTextHeartSounds.getText().toString().trim(), DateCalendar.date(), ""));
        //    jsonArry.put(JSONFormBuilder.observations("1124", "", "valueCoded", pr, DateCalendar.date(), ""));
        //   jsonArry.put(JSONFormBuilder.observations("165158", "", "valueText", editTextPR.getText().toString().trim(), DateCalendar.date(), ""));
        //    jsonArry.put(JSONFormBuilder.observations("1124", "", "valueCoded", air_entry, DateCalendar.date(), ""));
        //    jsonArry.put(JSONFormBuilder.observations("165158", "", "valueText", editTextAirEntry.getText().toString().trim(), DateCalendar.date(), ""));
        //   jsonArry.put(JSONFormBuilder.observations("1124", "", "valueCoded", abnormal_sounds, DateCalendar.date(), ""));
        //     jsonArry.put(JSONFormBuilder.observations("165158", "", "valueText", editTextAbnormalSounds.getText().toString().trim(), DateCalendar.date(), ""));
        //   jsonArry.put(JSONFormBuilder.observations("1124", "", "valueCoded", organomegally, DateCalendar.date(), ""));
        //   jsonArry.put(JSONFormBuilder.observations("165158", "", "valueText", editTextOrganomegally.getText().toString().trim(), DateCalendar.date(), ""));
        //   jsonArry.put(JSONFormBuilder.observations("1124", "", "valueCoded", ascities, DateCalendar.date(), ""));
        //   jsonArry.put(JSONFormBuilder.observations("165158", "", "valueText", editTextAscities.getText().toString().trim(), DateCalendar.date(), ""));
        //   jsonArry.put(JSONFormBuilder.observations("1124", "", "valueCoded", motor, DateCalendar.date(), ""));
        //    jsonArry.put(JSONFormBuilder.observations("165158", "", "valueText", editTextMotor.getText().toString().trim(), DateCalendar.date(), ""));
        //    jsonArry.put(JSONFormBuilder.observations("1124", "", "valueCoded", sensory, DateCalendar.date(), ""));
        //   jsonArry.put(JSONFormBuilder.observations("165158", "", "valueText", editTextSensory.getText().toString().trim(), DateCalendar.date(), ""));
        //   jsonArry.put(JSONFormBuilder.observations("1124", "", "valueCoded", autonomic, DateCalendar.date(), ""));
        //   jsonArry.put(JSONFormBuilder.observations("165158", "", "valueText", editTextAutonomic.getText().toString().trim(), DateCalendar.date(), ""));
        //   jsonArry.put(JSONFormBuilder.observations("1124", "", "valueCoded", gum_disease, DateCalendar.date(), ""));
        //   jsonArry.put(JSONFormBuilder.observations("165158", "", "valueText", editTextGumDisease.getText().toString().trim(), DateCalendar.date(), ""));
        //   jsonArry.put(JSONFormBuilder.observations("1124", "", "valueCoded", oral_fessions, DateCalendar.date(), ""));
        //    jsonArry.put(JSONFormBuilder.observations("165158", "", "valueText", editTextOralFessions.getText().toString().trim(), DateCalendar.date(), ""));
        //    jsonArry.put(JSONFormBuilder.observations("1124", "", "valueCoded", depression, DateCalendar.date(), ""));
        //    jsonArry.put(JSONFormBuilder.observations("165158", "", "valueText", editTextDepression.getText().toString().trim(), DateCalendar.date(), ""));
        //    jsonArry.put(JSONFormBuilder.observations("1124", "", "valueCoded", sleep_disorders, DateCalendar.date(), ""));
        //    jsonArry.put(JSONFormBuilder.observations("165158", "", "valueText", editTextSleepDisorders.getText().toString().trim(), DateCalendar.date(), ""));
        //    jsonArry.put(JSONFormBuilder.observations("1124", "", "valueCoded", substance_abuse, DateCalendar.date(), ""));
        //    jsonArry.put(JSONFormBuilder.observations("165158", "", "valueText", editTextSubstanceAbuse.getText().toString().trim(), DateCalendar.date(), ""));*/

        // jsonArry.put(JSONFormBuilder.observations("165112", "", "valueCoded", extremities, DateCalendar.date(), ""));
        // jsonArry.put(JSONFormBuilder.observations("165161", "", "valueText", editTextExtremeties.getText().toString().trim(), DateCalendar.date(), ""));

        // jsonArry.put(JSONFormBuilder.observations("165112", "", "valueCoded", callouses, DateCalendar.date(), ""));
        // jsonArry.put(JSONFormBuilder.observations("165112", "", "valueCoded", hardened_nails, DateCalendar.date(), ""));
        // jsonArry.put(JSONFormBuilder.observations("165112", "", "valueCoded", fungus, DateCalendar.date(), ""));
        //jsonArry.put(JSONFormBuilder.observations("165112", "", "valueCoded", cellulitis, DateCalendar.date(), ""));
        // jsonArry.put(JSONFormBuilder.observations("165112", "", "valueCoded", edema, DateCalendar.date(), ""));
        // jsonArry.put(JSONFormBuilder.observations("165112", "", "valueCoded", dry, DateCalendar.date(), ""));*/

        try {

            jsonArry1 = JSONFormBuilder.concatArray(jsonArry1);
            jsonArry2 = JSONFormBuilder.concatArray(jsonArry2);

            jsonArry = JSONFormBuilder.concatArray(jsonArry);

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

        Log.d("JSON Initial Page 2", jsonArry.toString() + "");

        FragmentModelInitial.getInstance().initialTwo(jsonArry);
    }
}
