package org.development.aihd.fragments.initial_view;


import android.os.Bundle;
import android.support.annotation.NonNull;
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

public class Initial_page_view_4 extends Fragment {

    private TextView textViewComplications;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_initial_fragment_view_4, container, false);

        textViewComplications = view.findViewById(R.id.complication);

        allComplication(DM_Initial_View.json);

        return view;
    }


    public void allComplication(String response) {
        try {
            JSONObject jsonObj = new JSONObject(response);

            // Getting JSON Array node
            JSONArray obs = jsonObj.getJSONArray("obs");

            if (obs.length() > 0) {
                for (int i = 0; i < obs.length(); i++) {
                    JSONObject concept = obs.getJSONObject(i);
                    if (obs.getJSONObject(i).toString().contains("groups") && obs.getJSONObject(i).toString().contains("6042")) {

                        JSONArray groupConcept = new JSONArray(concept.getString("groups"));
                        for (int l = 0; l < groupConcept.length(); l++) {
                            JSONArray groups = groupConcept.getJSONArray(l);

                            for (int m = 0; m < groups.length(); m++) {
                                JSONObject conceptGroup = groups.getJSONObject(m);

                                switch (Integer.valueOf(conceptGroup.getString("concept_id"))) {
                                    case 6042:
                                        textViewComplications.append(Common.conceptAnswer(conceptGroup, "6042") + ",");
                                        break;
                                    case 159948:
                                        textViewComplications.append(Common.concept(conceptGroup, "159948") + "\n");
                                        break;
                                    case 165127:
                                        Log.d("conceptAnswer", conceptGroup.getString("concept_answer"));
                                        textViewComplications.append(Common.conceptAnswer(conceptGroup, "165127") + "\n" + conceptGroup.getString("comment") + "\n\n");
                                        break;
                                    default:
                                        break;
                                }

                            }
                        }
                    }

                    if (concept.optString("concept_id").length() > 0) {

                        switch (concept.getString("concept_id")) {
                            case "159460":
                                //textViewMedication.setText(Common.conceptAnswer(concept, "159460"));
                                break;
                            case "165157":
                                //textViewMedicationOther.setText(Common.conceptAnswer(concept, "165157"));
                                break;
                            case "165108":
                                //textViewMedicationAdhere.setText(Common.conceptAnswer(concept, "165108"));
                                break;
                            case "165109":
                                //textViewAdhereSpecify.setText(Common.conceptAnswer(concept, "165109"));
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
