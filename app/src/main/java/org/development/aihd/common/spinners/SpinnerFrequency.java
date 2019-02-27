package org.development.aihd.common.spinners;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.development.aihd.R;
import org.development.aihd.common.variables.DrugsDose;
import org.development.aihd.model.KeyValue;

import java.util.ArrayList;

public class SpinnerFrequency {

    private static SpinnerInterface spinnerEvent;

    public static void spinnerDataFrequency(Context context, final DrugsDose drugsDose, final Spinner spinner, final String drug, SpinnerInterface event) {

        spinnerEvent = event;
        ArrayList<KeyValue> keyvalue = new ArrayList<>();

        // adding each child node to HashMap key => value
        keyvalue.add(new KeyValue("", "Select"));

        if (spinner.getId() == R.id.spinnerDrugInsulinFrq) {
            keyvalue.add(new KeyValue("160865", "AM"));
            keyvalue.add(new KeyValue("160864", "PM"));
        } else if (spinner.getId() == R.id.spinnerDrugSolubleInsulinFrq) {
            keyvalue.add(new KeyValue("160858", "BD"));
            keyvalue.add(new KeyValue("160866", "TDS"));
        } else {
            keyvalue.add(new KeyValue("160862", "OD"));
            keyvalue.add(new KeyValue("160858", "BD"));
            keyvalue.add(new KeyValue("160866", "TDS"));
        }

        //fill data in spinner
        ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, keyvalue);
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //occupationSpinner.setSelection(adapter.getPosition(keyvalue.get(2)));//Optional to set the selected item.

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                KeyValue keyValue = (KeyValue) parent.getSelectedItem();

                switch (spinner.getId()) {
                    case R.id.spinnerDrugMetforminFrq:
                        if (drug.matches("Metformin")) {
                            drugsDose.frequencyMetformin = keyValue.getId();
                        } else {
                            drugsDose.frequencyMetformin = "";
                        }
                        break;
                    case R.id.spinnerDrugGlibenclamideFrq:
                        if (drug.matches("Glibenclamide")) {
                            drugsDose.frequencyGlibenclamide = keyValue.getId();
                        } else {
                            drugsDose.frequencyGlibenclamide = "";
                        }
                        break;
                    case R.id.spinnerDrugEnalaprilFrq:
                        if (drug.matches("Enalapril")) {
                            drugsDose.frequencyEnalapril = keyValue.getId();
                        } else {
                            drugsDose.frequencyEnalapril = "";
                        }
                        break;
                    case R.id.spinnerDrugCaptoprilFrq:
                        if (drug.matches("Captopril")) {
                            drugsDose.frequencyCaptopril = keyValue.getId();
                        } else {
                            drugsDose.frequencyCaptopril = "";
                        }
                        break;
                    case R.id.spinnerDrugLisinoprilFrq:
                        if (drug.matches("Lisinopril")) {
                            drugsDose.frequencyLisinopril = keyValue.getId();
                        } else {
                            drugsDose.frequencyLisinopril = "";
                        }
                        break;
                    case R.id.spinnerDrugPerindoprilFrq:
                        if (drug.matches("Perindopril")) {
                            drugsDose.frequencyPerindopril = keyValue.getId();
                        } else {
                            drugsDose.frequencyPerindopril = "";
                        }
                        break;
                    case R.id.spinnerDrugRamiprilFrq:
                        if (drug.matches("Ramipril")) {
                            drugsDose.frequencyRamipril = keyValue.getId();
                        } else {
                            drugsDose.frequencyRamipril = "";
                        }
                        break;
                    case R.id.spinnerDrugCandesartanFrq:
                        if (drug.matches("Candesartan")) {
                            drugsDose.frequencyCandesartan = keyValue.getId();
                        } else {
                            drugsDose.frequencyCandesartan = "";
                        }
                        break;
                    case R.id.spinnerDrugIrbesartanFrq:
                        if (drug.matches("Irbesartan")) {
                            drugsDose.frequencyIrbesartan = keyValue.getId();
                        } else {
                            drugsDose.frequencyIrbesartan = "";
                        }
                        break;
                    case R.id.spinnerDrugLosartanFrq:
                        if (drug.matches("Losartan")) {
                            drugsDose.frequencyLosartan = keyValue.getId();
                        } else {
                            drugsDose.frequencyLosartan = "";
                        }
                        break;
                    case R.id.spinnerDrugTelmisartanFrq:
                        if (drug.matches("Telmisartan")) {
                            drugsDose.frequencyTelmisartan = keyValue.getId();
                        } else {
                            drugsDose.frequencyTelmisartan = "";
                        }
                        break;
                    case R.id.spinnerDrugValsartanFrq:
                        if (drug.matches("Valsartan")) {
                            drugsDose.frequencyValsartan = keyValue.getId();
                        } else {
                            drugsDose.frequencyValsartan = "";
                        }
                        break;
                    case R.id.spinnerDrugOlmesartanFrq:
                        if (drug.matches("Olmesartan")) {
                            drugsDose.frequencyOlmesartan = keyValue.getId();
                        } else {
                            drugsDose.frequencyOlmesartan = "";
                        }
                        break;
                    case R.id.spinnerDrugAtenololFrq:
                        if (drug.matches("Atenolol")) {
                            drugsDose.frequencyAtenolol = keyValue.getId();
                        } else {
                            drugsDose.frequencyAtenolol = "";
                        }
                        break;
                    case R.id.spinnerDrugLabetololFrq:
                        if (drug.matches("Labetolol")) {
                            drugsDose.frequencyLabetolol = keyValue.getId();
                        } else {
                            drugsDose.frequencyLabetolol = "";
                        }
                        break;
                    case R.id.spinnerDrugPropranololFrq:
                        if (drug.matches("Propranolol")) {
                            drugsDose.frequencyPropranolol = keyValue.getId();
                        } else {
                            drugsDose.frequencyPropranolol = "";
                        }
                        break;
                    case R.id.spinnerDrugCarvedilolFrq:
                        if (drug.matches("Carvedilol")) {
                            drugsDose.frequencyCarvedilol = keyValue.getId();
                        } else {
                            drugsDose.frequencyCarvedilol = "";
                        }
                        break;
                    case R.id.spinnerDrugNebivololFrq:
                        if (drug.matches("Nebivolol")) {
                            drugsDose.frequencyNebivolol = keyValue.getId();
                        } else {
                            drugsDose.frequencyNebivolol = "";
                        }
                        break;
                    case R.id.spinnerDrugMetoprololFrq:
                        if (drug.matches("Metoprolol")) {
                            drugsDose.frequencyMetoprolol = keyValue.getId();
                        } else {
                            drugsDose.frequencyMetoprolol = "";
                        }
                        break;
                    case R.id.spinnerDrugBisoprololFrq:
                        if (drug.matches("Bisoprolol")) {
                            drugsDose.frequencyBisoprolol = keyValue.getId();
                        } else {
                            drugsDose.frequencyBisoprolol = "";
                        }
                        break;
                    case R.id.spinnerDrugAmlodipineFrq:
                        if (drug.matches("Amlodipine")) {
                            drugsDose.frequencyAmlodipine = keyValue.getId();
                        } else {
                            drugsDose.frequencyAmlodipine = "";
                        }
                        break;
                    case R.id.spinnerDrugFelodipineFrq:
                        if (drug.matches("Felodipine")) {
                            drugsDose.frequencyFelodipine = keyValue.getId();
                        } else {
                            drugsDose.frequencyFelodipine = "";
                        }
                        break;
                    case R.id.spinnerDrugNifedipineFrq:
                        if (drug.matches("Nifedipine")) {
                            drugsDose.frequencyNifedipine = keyValue.getId();
                        } else {
                            drugsDose.frequencyNifedipine = "";
                        }
                        break;
                    case R.id.spinnerDrugMethyldopaFrq:
                        if (drug.matches("Methyldopa")) {
                            drugsDose.frequencyMethyldopa = keyValue.getId();
                        } else {
                            drugsDose.frequencyMethyldopa = "";
                        }

                        break;
                    case R.id.spinnerDrugHydralazineFrq:
                        if (drug.matches("Hydralazine")) {
                            drugsDose.frequencyHydralazine = keyValue.getId();
                        } else {
                            drugsDose.frequencyHydralazine = "";
                        }
                        break;
                    case R.id.spinnerDrugPrazocinFrq:
                        if (drug.matches("Prazocin")) {
                            drugsDose.frequencyPrazocin = keyValue.getId();
                        } else {
                            drugsDose.frequencyPrazocin = "";
                        }
                        break;
                    case R.id.spinnerDrugChlorthalidoneFrq:
                        if (drug.matches("Chlorthalidone")) {
                            drugsDose.frequencyChlorthalidone = keyValue.getId();
                        } else {
                            drugsDose.frequencyChlorthalidone = "";
                        }
                        break;
                    case R.id.spinnerDrugHydrochlorothiaFrq:
                        if (drug.matches("Hydrochlorothia")) {
                            drugsDose.frequencyHydrochlorothia = keyValue.getId();
                        } else {
                            drugsDose.frequencyHydrochlorothia = "";
                        }
                        break;
                    case R.id.spinnerDrugIndapamideFrq:
                        if (drug.matches("Indapamide")) {
                            drugsDose.frequencyIndapamide = keyValue.getId();
                        } else {
                            drugsDose.frequencyIndapamide = "";
                        }
                        break;
                    case R.id.spinnerDrugInsulinFrq:
                        if (drug.matches("Insulin")) {
                            drugsDose.frequencyInsulin = keyValue.getId();
                        } else {
                            drugsDose.frequencyInsulin = "";
                        }
                        break;
                    case R.id.spinnerDrugSolubleInsulinFrq:
                        if (drug.matches("SolubleInsulin")) {
                            drugsDose.frequencySolubleInsulin = keyValue.getId();
                        } else {
                            drugsDose.frequencySolubleInsulin = "";
                        }
                        break;
                    case R.id.spinnerDrugNPH1Frq:
                        if (drug.matches("NPH")) {
                            drugsDose.frequencyNPH1 = keyValue.getId();
                        } else {
                            drugsDose.frequencyNPH1 = "";
                        }
                        break;
                    case R.id.spinnerDrugNPH2Frq:
                        if (drug.matches("NPH2")) {
                            drugsDose.frequencyNPH2 = keyValue.getId();
                        } else {
                            drugsDose.frequencyNPH2 = "";
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
