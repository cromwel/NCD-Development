package org.development.aihd.fragments.initial_view;


import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.development.aihd.R;
import org.development.aihd.common.Common;
import org.development.aihd.forms.DM_Initial_View;
import org.json.JSONArray;
import org.json.JSONObject;

public class Initial_page_view_2 extends Fragment {

    private TextView textViewMedication, textViewMedicationDose, textViewMedicationOther, textViewMedicationAdhere, textViewAdhereSpecify, textViewAllergies,
            textViewAllergySpecify, textViewTemp, textViewPulseRate, textViewPressure, textViewHip, textViewWaist, textViewHeight, textViewWeight,
            textViewRespiratoryRate, textViewGeneralExam, textViewExamOther, textViewVisualmpairment, textViewCVS, textViewRS, textViewPA, textViewCNS,
            textViewExtremities, textViewMonofilament;

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_initial_fragment_view_2, container, false);

        textViewMedication = view.findViewById(R.id.medication);
        textViewMedicationDose = view.findViewById(R.id.medicationDose);
        textViewMedicationOther = view.findViewById(R.id.medication_other);
        textViewMedicationAdhere = view.findViewById(R.id.adhere_medication);
        textViewAdhereSpecify = view.findViewById(R.id.adhere_specify);
        textViewAllergies = view.findViewById(R.id.allergy);
        textViewAllergySpecify = view.findViewById(R.id.allergy_specify);
        textViewTemp = view.findViewById(R.id.temp);
        textViewPulseRate = view.findViewById(R.id.pulse_rate);
        textViewPressure = view.findViewById(R.id.pressure);
        textViewHip = view.findViewById(R.id.hip_circ);
        textViewWaist = view.findViewById(R.id.waist_circ);
        textViewHeight = view.findViewById(R.id.height);
        textViewWeight = view.findViewById(R.id.weight);
        //TextView textViewBMI = view.findViewById(R.id.bmi);
        //TextView textViewHipWaist = view.findViewById(R.id.waist_hip_ratio);
        textViewRespiratoryRate = view.findViewById(R.id.respiratory_rate);
        textViewGeneralExam = view.findViewById(R.id.general_exam);
        textViewExamOther = view.findViewById(R.id.exams);
        textViewVisualmpairment = view.findViewById(R.id.describe_visual_impairment);
        textViewCVS = view.findViewById(R.id.describe_cvs);
        textViewRS = view.findViewById(R.id.describe_rs);
        textViewPA = view.findViewById(R.id.describe_pa);
        textViewCNS = view.findViewById(R.id.describe_cns);
        textViewExtremities = view.findViewById(R.id.extremities);
        textViewMonofilament = view.findViewById(R.id.monofilament_rf);

        viewForm(DM_Initial_View.json);

        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void viewForm(String response) {

        try {
            JSONObject jsonObj = new JSONObject(response);
            // Getting JSON Array node
            JSONArray obs = jsonObj.getJSONArray("obs");
            //Log.d("Obs", obs.toString());

            if (obs.length() > 0) {
                for (int i = 0; i < obs.length(); i++) {
                    JSONObject concept = obs.getJSONObject(i);
                    if (obs.getJSONObject(i).toString().contains("groups") && (obs.getJSONObject(i).toString().contains("1282") || obs.getJSONObject(i).toString().contains("1443"))) {

                        Log.d("groups", concept.getString("groups"));

                        JSONArray groupConcept = new JSONArray(concept.getString("groups"));
                        for (int l = 0; l < groupConcept.length(); l++) {
                            JSONArray groups = groupConcept.getJSONArray(l);

                            for (int m = 0; m < groupConcept.length(); m++) {
                                JSONObject conceptGroup = groups.getJSONObject(m);

                                Log.d("Concept", conceptGroup.getString("concept_answer"));
                                if (conceptGroup.getString("concept_id").equals("1282")) {
                                    textViewMedication.append(Common.conceptAnswer(conceptGroup, "1282") + " : \n");
                                }

                                if (conceptGroup.getString("concept_id").equals("1443")) {
                                    textViewMedicationDose.append(conceptGroup.getString("concept_answer") + "\n");
                                }
                            }
                        }
                    }


                    if (concept.optString("concept_id").length() > 0) {
                        switch (concept.getString("concept_id")) {
                            case "159460":
                                textViewMedication.setText(Common.conceptAnswer(concept, "159460"));
                                break;
                            case "165157":
                                textViewMedicationOther.setText(Common.conceptAnswer(concept, "165157"));
                                break;
                            case "165108":
                                textViewMedicationAdhere.setText(Common.conceptAnswer(concept, "165108"));
                                break;
                            case "165109":
                                textViewAdhereSpecify.setText(Common.conceptAnswer(concept, "165109"));
                                break;
                            case "165146":
                                textViewAllergies.setText(Common.conceptAnswer(concept, "165146"));
                                break;
                            case "165166":
                                textViewAllergySpecify.setText(Common.conceptAnswer(concept, "165166"));
                                break;
                            case "5088":
                                textViewTemp.setText(concept.getString("concept_answer"));
                                break;
                            case "5087":
                                textViewPulseRate.setText(concept.getString("concept_answer"));
                                break;
                            case "5085":
                                textViewPressure.append(Common.concept(concept, "5085") + "/");
                            case "5086":
                                textViewPressure.append(Common.concept(concept, "5086"));
                                break;
                            case "165111":
                                textViewPressure.append("," + Common.concept(concept, "165111") + "/");
                            case "165110":
                                textViewPressure.append(Common.concept(concept, "165110"));
                                break;
                            case "163081":
                                textViewHip.setText(Common.concept(concept, "163081"));
                                break;
                            case "163080":
                                textViewWaist.setText(Common.concept(concept, "163080"));
                                break;
                            case "5090":
                                textViewHeight.setText(Common.concept(concept, "5090"));
                                break;
                            case "5089":
                                textViewWeight.setText(Common.concept(concept, "5089"));
                                break;
                            case "5242":
                                textViewRespiratoryRate.append(Common.concept(concept, "5242"));
                                break;
                            case "1119":
                                textViewGeneralExam.append(Common.conceptAnswer(concept, "1119") + " \n");
                                break;
                            case "163042":
                                textViewExamOther.setText(concept.getString("concept_answer"));
                                break;
                            case "165206":
                                textViewVisualmpairment.append(String.format("%s:", Common.conceptAnswer(concept, "165206")));
                            case "165175":
                                textViewVisualmpairment.append(Common.concept(concept, "165175"));
                                break;
                            case "1124":
                                textViewCVS.append(String.format("%s:", Common.conceptAnswer(concept, "1124")));
                            case "165158":
                                textViewCVS.append(Common.concept(concept, "165158"));
                                break;
                            case "1123":
                                textViewRS.append(String.format("%s:", Common.conceptAnswer(concept, "1123")));
                            case "165159":
                                textViewRS.append(Common.concept(concept, "165159"));
                                break;
                            case "139549":
                                textViewPA.append(String.format("%s:", Common.conceptAnswer(concept, "139549")));
                            case "165160":
                                textViewPA.append(Common.concept(concept, "165160"));
                                break;
                            case "163109":
                                textViewCNS.append(String.format("%s:", Common.conceptAnswer(concept, "163109")));
                            case "165161":
                                textViewCNS.append(Common.concept(concept, "165161"));
                                break;
                            case "165112":
                                textViewExtremities.append(Common.conceptAnswer(concept, "165112") + "\n");
                                break;
                            case "165165":
                                textViewMonofilament.append(Common.concept(concept, "165165") + "\n");
                                break;
                            default:
                                break;
                        }
                    }
                }
            }

        } catch (Exception e) {
            // hiding the progress bar
            e.printStackTrace();
        }
    }
}
