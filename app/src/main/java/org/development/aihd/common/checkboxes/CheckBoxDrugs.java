package org.development.aihd.common.checkboxes;

import android.widget.CheckBox;
import android.widget.CompoundButton;

import org.development.aihd.R;
import org.development.aihd.common.variables.DrugsDose;

public class CheckBoxDrugs {

    private static CheckBoxInterface checkBoxEvent;

    public static void checkBoxTreatment(final DrugsDose drugsDose, final CheckBox checkBox, CheckBoxInterface event) {
        checkBoxEvent = event;

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                boolean checked = (buttonView).isChecked();

                //Check which checkbox was clicked
                switch (checkBox.getId()) {
                    case R.id.treatment_metformin:
                        if (checked) {
                            drugsDose.Metformin = "79651";
                        } else {
                            drugsDose.Metformin = "";
                        }
                        break;
                    case R.id.treatment_glibenclamide:
                        if (checked) {
                            drugsDose.Glibenclamide = "77071";
                        } else {
                            drugsDose.Glibenclamide = "";
                        }
                        break;
                    case R.id.treatment_insulin:
                        if (checked) {
                            drugsDose.Insulin = "159459";
                        } else {
                            drugsDose.Insulin = "";
                        }
                        break;
                    case R.id.treatment_soluble_insulin:
                        if (checked) {
                            drugsDose.SolubleInsulin = "282";
                        } else {
                            drugsDose.SolubleInsulin = "";
                        }
                        break;
                    case R.id.treatment_nph:
                        if (checked) {
                            drugsDose.NPH = "165284";
                        } else {
                            drugsDose.NPH = "";
                        }
                        break;
                    case R.id.treatment_nph_2:
                        if (checked) {
                            drugsDose.NPH2 = "165287";
                        } else {
                            drugsDose.NPH2 = "";
                        }
                        break;
                    case R.id.treatment_captopril:
                        if (checked) {
                            hideGroup(drugsDose, "ace");
                            drugsDose.Captopril = "72806";
                        } else {
                            drugsDose.Captopril = "";
                        }
                        break;
                    case R.id.treatment_enalapril:
                        if (checked) {
                            hideGroup(drugsDose, "ace");
                            drugsDose.Enalapril = "75633";
                        } else {
                            drugsDose.Enalapril = "";
                        }
                        break;
                    case R.id.treatment_lisinopril:
                        if (checked) {
                            hideGroup(drugsDose, "ace");
                            drugsDose.Lisinopril = "78945";
                        } else {
                            drugsDose.Lisinopril = "";
                        }
                        break;
                    case R.id.treatment_perindopril:
                        if (checked) {
                            hideGroup(drugsDose, "ace");
                            drugsDose.Perindopril = "81822";
                        } else {
                            drugsDose.Perindopril = "";
                        }
                        break;
                    case R.id.treatment_ramipril:
                        if (checked) {
                            hideGroup(drugsDose, "ace");
                            drugsDose.Ramipril = "83067";
                        } else {
                            drugsDose.Ramipril = "";
                        }
                        break;
                    case R.id.treatment_candesartan:
                        if (checked) {
                            hideGroup(drugsDose, "arb");
                            drugsDose.Candesartan = "72758";
                        } else {
                            drugsDose.Candesartan = "";
                        }
                        break;
                    case R.id.treatment_irbesartan:
                        if (checked) {
                            hideGroup(drugsDose, "arb");
                            drugsDose.Irbesartan = "78210";
                        } else {
                            drugsDose.Irbesartan = "";
                        }
                        break;
                    case R.id.treatment_losartan:
                        if (checked) {
                            hideGroup(drugsDose, "arb");
                            drugsDose.Losartan = "79074";
                        } else {
                            drugsDose.Losartan = "";
                        }
                        break;
                    case R.id.treatment_telmisartan:
                        if (checked) {
                            hideGroup(drugsDose, "arb");
                            drugsDose.Telmisartan = "84764";
                        } else {
                            drugsDose.Telmisartan = "";
                        }
                        break;
                    case R.id.treatment_valsartan:
                        if (checked) {
                            hideGroup(drugsDose, "arb");
                            drugsDose.Valsartan = "86056";
                        } else {
                            drugsDose.Valsartan = "";
                        }
                        break;
                    case R.id.treatment_olmesartan:
                        if (checked) {
                            hideGroup(drugsDose, "arb");
                            drugsDose.Olmesartan = "165229";
                        } else {
                            drugsDose.Olmesartan = "";
                        }
                        break;
                    case R.id.treatment_atenolol:
                        if (checked) {
                            drugsDose.Atenolol = "71652";
                        } else {
                            drugsDose.Atenolol = "";
                        }
                        break;
                    case R.id.treatment_labetolol:
                        if (checked) {
                            drugsDose.Labetolol = "78599";
                        } else {
                            drugsDose.Labetolol = "";
                        }
                        break;
                    case R.id.treatment_propranolol:
                        if (checked) {
                            drugsDose.Propranolol = "82732";
                        } else {
                            drugsDose.Propranolol = "";
                        }
                        break;
                    case R.id.treatment_carvedilol:
                        if (checked) {
                            drugsDose.Carvedilol = "72944";
                        } else {
                            drugsDose.Carvedilol = "";
                        }
                        break;
                    case R.id.treatment_nebivolol:
                        if (checked) {
                            drugsDose.Nebivolol = "80470";
                        } else {
                            drugsDose.Nebivolol = "";
                        }
                        break;
                    case R.id.treatment_metoprolol:
                        if (checked) {
                            drugsDose.Metoprolol = "79764";
                        } else {
                            drugsDose.Metoprolol = "";
                        }
                        break;
                    case R.id.treatment_bisoprolol:
                        if (checked) {
                            drugsDose.Bisoprolol = "72247";
                        } else {
                            drugsDose.Bisoprolol = "";
                        }
                        break;
                    case R.id.treatment_amlodipine:
                        if (checked) {
                            drugsDose.Amlodipine = "71137";
                        } else {
                            drugsDose.Amlodipine = "";
                        }
                        break;
                    case R.id.treatment_felodipine:
                        if (checked) {
                            drugsDose.Felodipine = "76211";
                        } else {
                            drugsDose.Felodipine = "";
                        }
                        break;
                    case R.id.treatment_nifedipine:
                        if (checked) {
                            drugsDose.Nifedipine = "80637";
                        } else {
                            drugsDose.Nifedipine = "";
                        }
                        break;
                    case R.id.treatment_methyldopa:
                        if (checked) {
                            drugsDose.Methyldopa = "79723";
                        } else {
                            drugsDose.Methyldopa = "";
                        }
                        break;
                    case R.id.treatment_hydralazine:
                        if (checked) {
                            drugsDose.Hydralazine = "77675";
                        } else {
                            drugsDose.Hydralazine = "";
                        }
                        break;
                    case R.id.treatment_prazocin:
                        if (checked) {
                            drugsDose.Prazocin = "77985";
                        } else {
                            drugsDose.Prazocin = "";
                        }
                        break;
                    case R.id.treatment_chlorthalidone:
                        if (checked) {
                            drugsDose.Chlorthalidone = "73338";
                        } else {
                            drugsDose.Chlorthalidone = "";
                        }
                        break;
                    case R.id.treatment_hydrochlorothia:
                        if (checked) {
                            drugsDose.Hydrochlorothia = "77696";
                        } else {
                            drugsDose.Hydrochlorothia = "";
                        }
                        break;
                    case R.id.treatment_indapamide:
                        if (checked) {
                            drugsDose.Indapamide = "77985";
                        } else {
                            drugsDose.Indapamide = "";
                        }
                        break;
                    case R.id.treatment_diet:
                        if (checked) {
                            drugsDose.Diet = "165200";
                        } else {
                            drugsDose.Diet = "";
                        }
                        break;
                    case R.id.treatment_physical_exercise:
                        if (checked) {
                            drugsDose.PhysicalExercise = "159364";
                        } else {
                            drugsDose.PhysicalExercise = "";
                        }
                        break;
                    case R.id.treatment_herbal:
                        if (checked) {
                            drugsDose.Herbal = "165203";
                        } else {
                            drugsDose.Herbal = "";
                        }
                        break;
                    case R.id.treatment_other:
                        if (checked) {
                            drugsDose.TreatmentOther = "5622";
                        } else {
                            drugsDose.TreatmentOther = "";
                        }
                        break;
                    case R.id.treatment_urinalysis:
                        if (checked) {
                            drugsDose.urinalysis = "302";
                        } else {
                            drugsDose.urinalysis = "";
                        }
                        break;
                    case R.id.treatment_hba:
                        if (checked) {
                            drugsDose.hba = "159644";
                        } else {
                            drugsDose.hba = "";
                        }
                        break;
                    case R.id.treatment_microalbumin:
                        if (checked) {
                            drugsDose.microalbumin = "164938";
                        } else {
                            drugsDose.microalbumin = "";
                        }
                        break;
                    case R.id.treatment_creatinine:
                        if (checked) {
                            drugsDose.creatinine = "1011";
                        } else {
                            drugsDose.creatinine = "";
                        }
                        break;
                    case R.id.treatment_potassium:
                        if (checked) {
                            drugsDose.potassium = "159659";
                        } else {
                            drugsDose.potassium = "";
                        }
                        break;
                    case R.id.treatment_ecg:
                        if (checked) {
                            drugsDose.ecg = "161157";
                        } else {
                            drugsDose.ecg = "";
                        }
                        break;
                    case R.id.followup_continue:
                        if (checked) {
                            drugsDose.continueCare = "165132";
                        } else {
                            drugsDose.continueCare = "";
                        }
                        break;
                    default:
                        break;
                }

                checkBoxEvent.checkBoxClick();
            }
        });
    }


    private static void hideGroup(DrugsDose drugsDose, String group) {
        if (group.matches("ace")) {
            drugsDose.checkBoxCandesartan.setChecked(false);
            drugsDose.checkBoxIrbesartan.setChecked(false);
            drugsDose.checkBoxLosartan.setChecked(false);
            drugsDose.checkBoxTelmisartan.setChecked(false);
            drugsDose.checkBoxValsartan.setChecked(false);
            drugsDose.checkBoxOlmesartan.setChecked(false);
        } else if (group.matches("arb")) {
            drugsDose.checkBoxEnalapril.setChecked(false);
            drugsDose.checkBoxCaptopril.setChecked(false);
            drugsDose.checkBoxLisinopril.setChecked(false);
            drugsDose.checkBoxPerindopril.setChecked(false);
            drugsDose.checkBoxRamipril.setChecked(false);
        }
    }

}
