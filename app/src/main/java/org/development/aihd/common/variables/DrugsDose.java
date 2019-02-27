package org.development.aihd.common.variables;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import org.development.aihd.R;

public class DrugsDose {

    public CheckBox checkBoxEnalapril, checkBoxCaptopril, checkBoxLisinopril, checkBoxPerindopril, checkBoxRamipril;
    public CheckBox checkBoxCandesartan, checkBoxIrbesartan, checkBoxLosartan, checkBoxTelmisartan, checkBoxValsartan, checkBoxOlmesartan;

    public String Metformin, Glibenclamide, Insulin, SolubleInsulin, NPH, NPH2, Captopril, Enalapril, Lisinopril, Perindopril, Ramipril, Candesartan, Irbesartan, Losartan,
            Telmisartan, Valsartan, Olmesartan, Atenolol, Labetolol, Propranolol, Carvedilol, Nebivolol, Metoprolol, Bisoprolol, Amlodipine, Felodipine, Nifedipine,
            Chlorthalidone, Hydrochlorothia, Indapamide, Methyldopa, Hydralazine, Prazocin, Diet, PhysicalExercise, Herbal, TreatmentOther;

    public String doseMetformin, doseGlibenclamide, doseCaptopril, doseEnalapril, doseLisinopril, dosePerindopril, doseRamipril, doseCandesartan, doseIrbesartan, doseLosartan,
            doseTelmisartan, doseValsartan, doseOlmesartan, doseAtenolol, doseLabetolol, dosePropranolol, doseCarvedilol, doseNebivolol, doseMetoprolol, doseBisoprolol,
            doseAmlodipine, doseFelodipine, doseNifedipine, doseChlorthalidone, doseHydrochlorothia, doseIndapamide, doseMethyldopa, doseHydralazine, dosePrazocin;

    public String frequencyMetformin, frequencyGlibenclamide, frequencyCaptopril, frequencyEnalapril, frequencyLisinopril, frequencyPerindopril, frequencyRamipril,
            frequencyCandesartan, frequencyIrbesartan, frequencyLosartan, frequencyTelmisartan, frequencyValsartan, frequencyOlmesartan, frequencyAtenolol, frequencyLabetolol,
            frequencyPropranolol, frequencyCarvedilol, frequencyNebivolol, frequencyMetoprolol, frequencyBisoprolol, frequencyAmlodipine, frequencyFelodipine,
            frequencyNifedipine, frequencyChlorthalidone, frequencyHydrochlorothia, frequencyIndapamide, frequencyMethyldopa, frequencyHydralazine, frequencyPrazocin,
            frequencyInsulin, frequencySolubleInsulin, frequencyNPH1, frequencyNPH2;

    public String continueCare, urinalysis, hba, microalbumin, creatinine, potassium, ecg, treatmentTest;

    public EditText editTextInsulin, editTextSolubleInsulin, editTextNPH1, editTextNPH2;
    public EditText editTextDiet, editTextPhysicalExercise, editTextHerbal, editTextTreatmentOther, editTextComment;
    public EditText editTextACE, editTextARB, editTextBeta, editTextCCB, editTextThiazide, editTextThiazideLike, editTextAntiHypertensives, editTextOGLA, editTextInsulinOther;
    public EditText editTextReturnDate, editTextReferralLocation, editTextReferralDate, editTextReferralNote, editTextClinician;

    //SpinnerDose
    public static final String[] arraySpinnerCaptopril = new String[]{"Select", "5mg", "25mg", "50mg"};
    public static final String[] arraySpinnerEnalapril = new String[]{"Select", "5mg", "10mg", "20mg"};
    public static final String[] arraySpinnerLisinopril = new String[]{"Select", "20mg ", "40mg"};
    public static final String[] arraySpinnerPerindopril = new String[]{"Select", "2mg ", "4mg", "5mg", "8mg", "10mg"};
    public static final String[] arraySpinnerRamipril = new String[]{"Select", "1.25mg", "2.5mg", "10mg"};

    public static final String[] arraySpinnerCandesartan = new String[]{"Select", "4mg", "8mg", "16mg", "32mg"};
    public static final String[] arraySpinnerIrbesartan = new String[]{"Select", "75mg", "150mg ", "300mg"};
    public static final String[] arraySpinnerLosartan = new String[]{"Select", "50mg", "100mg"};
    public static final String[] arraySpinnerTelmisartan = new String[]{"Select", "20mg", "40mg", "80mg"};
    public static final String[] arraySpinnerValsartan = new String[]{"Select", "40mg", "80mg ", "160mg", "320mg"};
    public static final String[] arraySpinnerOlmesartan = new String[]{"Select", "5mg", "20mg", "40mg"};

    public static final String[] arraySpinnerAtenolol = new String[]{"Select", "25mg", "50mg", "100mg"};
    public static final String[] arraySpinnerLabetolol = new String[]{"Select", "100mg", "200mg", "300mg"};
    public static final String[] arraySpinnerPropranolol = new String[]{"Select", "40mg", "80mg"};
    public static final String[] arraySpinnerCarvedilol = new String[]{"Select", "3.125mg", "6.25mg", "12.5mg", "10mg", "20mg", "25mg ", "40mg", "80mg"};
    public static final String[] arraySpinnerNebivolol = new String[]{"Select", "2.5mg", "5mg", "10mg", "20mg"};
    public static final String[] arraySpinnerMetoprolol = new String[]{"Select", "25mg", "37.5mg", "50mg", "75mg", "100mg ", "200mg"};
    public static final String[] arraySpinnerBisoprolol = new String[]{"Select", "5mg", "10mg"};

    public static final String[] arraySpinnerAmlodipine = new String[]{"Select", "2.5mg", "5mg", "10mg"};
    public static final String[] arraySpinnerFelodipine = new String[]{"Select", "2.5mg", "5mg", "10mg"};
    public static final String[] arraySpinnerNifedipine = new String[]{"Select", "10mg", "20mg"};

    public static final String[] arraySpinnerChlorthalidone = new String[]{"Select", "25mg", "50mg"};
    public static final String[] arraySpinnerHydrochlorothia = new String[]{"Select", "12.5mg ", "25mg"};
    public static final String[] arraySpinnerIndapamide = new String[]{"Select", "1.5mg", "2.5mg", "5mg"};

    public static final String[] arraySpinnerMethyldopa = new String[]{"Select", "250mg", "500mg"};
    public static final String[] arraySpinnerHydralazine = new String[]{"Select", "25mg",};
    public static final String[] arraySpinnerPrazocin = new String[]{"Select", "0.5mg", "1mg"};

    public static final String[] arraySpinnerMetformin = new String[]{"Select", "500mg", "850mg", "1000mg"};
    public static final String[] arraySpinnerGlibenclamide = new String[]{"Select", "5mg"};

    public DrugsDose(Context mContext) {
    }

    public void initializeDrugs(View view) {

        editTextInsulin = view.findViewById(R.id.editTextInsulin);
        editTextSolubleInsulin = view.findViewById(R.id.editTextSolubleInsulin);
        editTextNPH1 = view.findViewById(R.id.editTextNPH1);
        editTextNPH2 = view.findViewById(R.id.editTextNPH2);

        editTextDiet = view.findViewById(R.id.treatment_diet_specify);
        editTextPhysicalExercise = view.findViewById(R.id.treatment_physical_exercise_specify);
        editTextHerbal = view.findViewById(R.id.treatment_herbal_specify);
        editTextTreatmentOther = view.findViewById(R.id.treatment_other_specify);
        editTextComment = view.findViewById(R.id.treatment_comment);

        editTextComment = view.findViewById(R.id.treatment_comment);

        checkBoxEnalapril = view.findViewById(R.id.treatment_enalapril);
        checkBoxCaptopril = view.findViewById(R.id.treatment_captopril);
        checkBoxLisinopril = view.findViewById(R.id.treatment_lisinopril);
        checkBoxPerindopril = view.findViewById(R.id.treatment_perindopril);
        checkBoxRamipril = view.findViewById(R.id.treatment_ramipril);

        checkBoxCandesartan = view.findViewById(R.id.treatment_candesartan);
        checkBoxIrbesartan = view.findViewById(R.id.treatment_irbesartan);
        checkBoxLosartan = view.findViewById(R.id.treatment_losartan);
        checkBoxTelmisartan = view.findViewById(R.id.treatment_telmisartan);
        checkBoxValsartan = view.findViewById(R.id.treatment_valsartan);
        checkBoxOlmesartan = view.findViewById(R.id.treatment_olmesartan);

    }

}
