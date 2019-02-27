package org.development.aihd.common.spinners;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.development.aihd.R;
import org.development.aihd.common.variables.DrugsDose;

public class SpinnerDose {


    private static SpinnerInterface spinnerEvent;

    public static void spinnerDoseData(Context context, final DrugsDose drugsDose, final Spinner spinner, String[] arraySpinner, final String drug, SpinnerInterface event) {

        spinnerEvent = event;
        //fill data in spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, arraySpinner);
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //KeyValue value = (KeyValue) parent.getSelectedItem();
                String dose = parent.getSelectedItem().toString().replace("Select", "");
                dose = dose.replace("mg", "");
                dose = dose.replaceAll("\\s+", " ");

                //Log.d("Dose", dose + " ");

                switch (spinner.getId()) {
                    case R.id.spinnerDrugMetformin:
                        if (drug.matches("Metformin")) {
                            drugsDose.doseMetformin = dose;
                        } else {
                            drugsDose.doseMetformin = "";
                        }
                        break;
                    case R.id.spinnerDrugGlibenclamide:
                        if (drug.matches("Glibenclamide")) {
                            drugsDose.doseGlibenclamide = dose;
                        } else {
                            drugsDose.doseGlibenclamide = "";
                        }
                        break;
                    case R.id.spinnerDrugEnalapril:
                        if (drug.matches("Enalapril")) {
                            drugsDose.doseEnalapril = dose;
                        } else {
                            drugsDose.doseEnalapril = "";
                        }
                        break;
                    case R.id.spinnerDrugCaptopril:
                        if (drug.matches("Captopril")) {
                            drugsDose.doseCaptopril = dose;
                        } else {
                            drugsDose.doseCaptopril = "";
                        }
                        break;
                    case R.id.spinnerDrugLisinopril:
                        if (drug.matches("Lisinopril")) {
                            drugsDose.doseLisinopril = dose;
                        } else {
                            drugsDose.doseLisinopril = "";
                        }
                        break;
                    case R.id.spinnerDrugPerindopril:
                        if (drug.matches("Perindopril")) {
                            drugsDose.dosePerindopril = dose;
                        } else {
                            drugsDose.dosePerindopril = "";
                        }
                        break;
                    case R.id.spinnerDrugRamipril:
                        if (drug.matches("Ramipril")) {
                            drugsDose.doseRamipril = dose;
                        } else {
                            drugsDose.doseRamipril = "";
                        }
                        break;
                    case R.id.spinnerDrugCandesartan:
                        if (drug.matches("Candesartan")) {
                            drugsDose.doseCandesartan = dose;
                        } else {
                            drugsDose.doseCandesartan = "";
                        }
                        break;
                    case R.id.spinnerDrugIrbesartan:
                        if (drug.matches("Irbesartan")) {
                            drugsDose.doseIrbesartan = dose;
                        } else {
                            drugsDose.doseIrbesartan = "";
                        }
                        break;
                    case R.id.spinnerDrugLosartan:
                        if (drug.matches("Losartan")) {
                            drugsDose.doseLosartan = dose;
                        } else {
                            drugsDose.doseLosartan = "";
                        }
                        break;
                    case R.id.spinnerDrugTelmisartan:
                        if (drug.matches("Telmisartan")) {
                            drugsDose.doseTelmisartan = dose;
                        } else {
                            drugsDose.doseTelmisartan = "";
                        }
                        break;
                    case R.id.spinnerDrugValsartan:
                        if (drug.matches("Valsartan")) {
                            drugsDose.doseValsartan = dose;
                        } else {
                            drugsDose.doseValsartan = "";
                        }
                        break;
                    case R.id.spinnerDrugOlmesartan:
                        if (drug.matches("Olmesartan")) {
                            drugsDose.doseOlmesartan = dose;
                        } else {
                            drugsDose.doseOlmesartan = "";
                        }
                        break;
                    case R.id.spinnerDrugAtenolol:
                        if (drug.matches("Atenolol")) {
                            drugsDose.doseAtenolol = dose;
                        } else {
                            drugsDose.doseAtenolol = "";
                        }
                        break;
                    case R.id.spinnerDrugLabetolol:
                        if (drug.matches("Labetolol")) {
                            drugsDose.doseLabetolol = dose;
                        } else {
                            drugsDose.doseLabetolol = "";
                        }
                        break;
                    case R.id.spinnerDrugPropranolol:
                        if (drug.matches("Propranolol")) {
                            drugsDose.dosePropranolol = dose;
                        } else {
                            drugsDose.dosePropranolol = "";
                        }
                        break;
                    case R.id.spinnerDrugCarvedilol:
                        if (drug.matches("Carvedilol")) {
                            drugsDose.doseCarvedilol = dose;
                        } else {
                            drugsDose.doseCarvedilol = "";
                        }
                        break;
                    case R.id.spinnerDrugNebivolol:
                        if (drug.matches("Nebivolol")) {
                            drugsDose.doseNebivolol = dose;
                        } else {
                            drugsDose.doseNebivolol = "";
                        }
                        break;
                    case R.id.spinnerDrugMetoprolol:
                        if (drug.matches("Metoprolol")) {
                            drugsDose.doseMetoprolol = dose;
                        } else {
                            drugsDose.doseMetoprolol = "";
                        }
                        break;
                    case R.id.spinnerDrugBisoprolol:
                        if (drug.matches("Bisoprolol")) {
                            drugsDose.doseBisoprolol = dose;
                        } else {
                            drugsDose.doseBisoprolol = "";
                        }
                        break;
                    case R.id.spinnerDrugAmlodipine:
                        if (drug.matches("Amlodipine")) {
                            drugsDose.doseAmlodipine = dose;
                        } else {
                            drugsDose.doseAmlodipine = "";
                        }
                        break;
                    case R.id.spinnerDrugFelodipine:
                        if (drug.matches("Felodipine")) {
                            drugsDose.doseFelodipine = dose;
                        } else {
                            drugsDose.doseFelodipine = "";
                        }
                        break;
                    case R.id.spinnerDrugNifedipine:
                        if (drug.matches("Nifedipine")) {
                            drugsDose.doseNifedipine = dose;
                        } else {
                            drugsDose.doseNifedipine = "";
                        }
                        break;
                    case R.id.spinnerDrugMethyldopa:
                        if (drug.matches("Methyldopa")) {
                            drugsDose.doseMethyldopa = dose;
                        } else {
                            drugsDose.doseMethyldopa = "";
                        }

                        break;
                    case R.id.spinnerDrugHydralazine:
                        if (drug.matches("Hydralazine")) {
                            drugsDose.doseHydralazine = dose;
                        } else {
                            drugsDose.doseHydralazine = "";
                        }
                        break;
                    case R.id.spinnerDrugPrazocin:
                        if (drug.matches("Prazocin")) {
                            drugsDose.dosePrazocin = dose;
                        } else {
                            drugsDose.dosePrazocin = "";
                        }
                        break;
                    case R.id.spinnerDrugChlorthalidone:
                        if (drug.matches("Chlorthalidone")) {
                            drugsDose.doseChlorthalidone = dose;
                        } else {
                            drugsDose.doseChlorthalidone = "";
                        }
                        break;
                    case R.id.spinnerDrugHydrochlorothia:
                        if (drug.matches("Hydrochlorothia")) {
                            drugsDose.doseHydrochlorothia = dose;
                        } else {
                            drugsDose.doseHydrochlorothia = "";
                        }
                        break;
                    case R.id.spinnerDrugIndapamide:
                        if (drug.matches("Indapamide")) {
                            drugsDose.doseIndapamide = dose;
                        } else {
                            drugsDose.doseIndapamide = "";
                        }
                        break;
                    default:
                        break;

                }
                spinnerEvent.spinnerClick();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                /* Do nothing */
            }
        });

    }
}
