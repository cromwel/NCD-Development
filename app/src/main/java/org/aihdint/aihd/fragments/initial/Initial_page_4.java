package org.aihdint.aihd.fragments.initial;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;

import org.aihdint.aihd.common.DateCalendar;
import org.aihdint.aihd.common.JSONFormBuilder;
import org.aihdint.aihd.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Developed by Rodney on 24/04/2018.
 */

public class Initial_page_4 extends Fragment {

    //Checkboxes
    private String stroke, heart, kidney, neuropahty, visual, ulcers, erectile, other, gastrology, cataracts, dental, other_counselling, nutrition, activity, psychosocial, diagnosis_stroke, diagnosis_heart, diagnosis_kidney,
            diagnosis_neuropahty, diagnosis_visual, diagnosis_ulcers, diagnosis_erectile, diagnosis_gastrology, diagnosis_cataracts, diagnosis_dental, diagnosis_other;

    //RadioButtons
    private EditText editTextStroke, editTextHeart, editTextKidney, editTextNeuropahty, editTextVisual, editTextUlcers, editTextErectile, editTextGatrology, editTextCataracts, editTextDental, editTextOtherComplication,
            editTextStrokeDate, editTextHeartDate, editTextKidneyDate, editTextNeuropahtyDate, editTextVisualDate, editTextUlcersDate, editTextErectileDate,
            editTextGatrologyDate, editTextCataractsDate, editTextDentalDate, editTextOtherComplicationDate, editTextOtherProvision;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_initial_fragment_4, container, false);

        CheckBox checkBoxStroke = view.findViewById(R.id.checkbox_complication_stroke);
        CheckBox checkBoxHeart = view.findViewById(R.id.checkbox_complication_heart);
        CheckBox checkBoxKidney = view.findViewById(R.id.checkbox_complication_kidney);
        CheckBox checkBoxNeuropahty = view.findViewById(R.id.checkbox_complication_neuropathy);
        CheckBox checkBoxVisual = view.findViewById(R.id.checkbox_complication_visual);
        CheckBox checkBoxUlcers = view.findViewById(R.id.checkbox_complication_foot_ulcer);
        CheckBox checkBoxErectile = view.findViewById(R.id.checkbox_complication_erectile);
        CheckBox checkBoxGastrology = view.findViewById(R.id.checkbox_complication_gastropathy);
        CheckBox checkBoxCataracts = view.findViewById(R.id.checkbox_complication_cataracts);
        CheckBox checkBoxDental = view.findViewById(R.id.checkbox_complication_dental);
        CheckBox checkBoxOther = view.findViewById(R.id.checkbox_complication_other);
        CheckBox checkBoxNutrition = view.findViewById(R.id.checkbox_nutrition);
        CheckBox checkBoxActivity = view.findViewById(R.id.checkbox_physical_activity);
        CheckBox checkBoxPsychosocial = view.findViewById(R.id.checkbox_psychosocial);
        CheckBox checkBoxCounsellingOther = view.findViewById(R.id.checkbox_other);

        checkBox(checkBoxStroke);
        checkBox(checkBoxHeart);
        checkBox(checkBoxKidney);
        checkBox(checkBoxNeuropahty);
        checkBox(checkBoxVisual);
        checkBox(checkBoxUlcers);
        checkBox(checkBoxErectile);
        checkBox(checkBoxGastrology);
        checkBox(checkBoxCataracts);
        checkBox(checkBoxDental);
        checkBox(checkBoxOther);
        checkBox(checkBoxNutrition);
        checkBox(checkBoxActivity);
        checkBox(checkBoxPsychosocial);
        checkBox(checkBoxCounsellingOther);

        RadioButton radioButtonStrokeResolved = view.findViewById(R.id.radio_diagnosis_stroke_resolved);
        RadioButton radioButtonHeartResolved = view.findViewById(R.id.radio_diagnosis_heart_failure_resolved);
        RadioButton radioButtonKidneyResolved = view.findViewById(R.id.radio_diagnosis_kidney_failure_resolved);
        RadioButton radioButtonNeuropahtyResolved = view.findViewById(R.id.radio_diagnosis_neuropathy_resolved);
        RadioButton radioButtonVisualResolved = view.findViewById(R.id.radio_diagnosis_visual_resolved);
        RadioButton radioButtonUlcersResolved = view.findViewById(R.id.radio_diagnosis_foot_ulcer_resolved);
        RadioButton radioButtonErectileResolved = view.findViewById(R.id.radio_diagnosis_erectile_resolved);
        RadioButton radioButtonGastrologyResolved = view.findViewById(R.id.radio_diagnosis_gastropathy_resolved);
        RadioButton radioButtonCataractResolved = view.findViewById(R.id.radio_diagnosis_cataracts_resolved);
        RadioButton radioButtonDentalResolved = view.findViewById(R.id.radio_diagnosis_dental_resolved);
        RadioButton radioButtonOtherResolved = view.findViewById(R.id.radio_diagnosis_other_resolved);

        RadioButton radioButtonStrokeReferral = view.findViewById(R.id.radio_diagnosis_stroke_referral);
        RadioButton radioButtonHeartReferral = view.findViewById(R.id.radio_diagnosis_heart_failure_referral);
        RadioButton radioButtonKidneyReferral = view.findViewById(R.id.radio_diagnosis_kidney_failure_referral);
        RadioButton radioButtonNeuropahtyReferral = view.findViewById(R.id.radio_diagnosis_neuropathy_referral);
        RadioButton radioButtonVisualReferral = view.findViewById(R.id.radio_diagnosis_visual_referral);
        RadioButton radioButtonUlcersReferral = view.findViewById(R.id.radio_diagnosis_foot_ulcer_referral);
        RadioButton radioButtonErectileReferral = view.findViewById(R.id.radio_diagnosis_erectile_referral);
        RadioButton radioButtonGastrologyReferral = view.findViewById(R.id.radio_diagnosis_gastropathy_referral);
        RadioButton radioButtonCataractReferral = view.findViewById(R.id.radio_diagnosis_cataracts_referral);
        RadioButton radioButtonDentalReferral = view.findViewById(R.id.radio_diagnosis_dental_referral);
        RadioButton radioButtonOtherReferral = view.findViewById(R.id.radio_diagnosis_other_referral);

        radioButton(radioButtonStrokeResolved);
        radioButton(radioButtonHeartResolved);
        radioButton(radioButtonKidneyResolved);
        radioButton(radioButtonNeuropahtyResolved);
        radioButton(radioButtonVisualResolved);
        radioButton(radioButtonUlcersResolved);
        radioButton(radioButtonErectileResolved);
        radioButton(radioButtonGastrologyResolved);
        radioButton(radioButtonCataractResolved);
        radioButton(radioButtonDentalResolved);
        radioButton(radioButtonOtherResolved);

        radioButton(radioButtonStrokeReferral);
        radioButton(radioButtonHeartReferral);
        radioButton(radioButtonKidneyReferral);
        radioButton(radioButtonNeuropahtyReferral);
        radioButton(radioButtonVisualReferral);
        radioButton(radioButtonUlcersReferral);
        radioButton(radioButtonErectileReferral);
        radioButton(radioButtonGastrologyReferral);
        radioButton(radioButtonCataractReferral);
        radioButton(radioButtonDentalReferral);
        radioButton(radioButtonOtherReferral);

        editTextStroke = view.findViewById(R.id.diagnosis_comment_stroke);
        editTextHeart = view.findViewById(R.id.diagnosis_comment_heart_failure);
        editTextKidney = view.findViewById(R.id.diagnosis_comment_kidney_failure);
        editTextNeuropahty = view.findViewById(R.id.diagnosis_comment_neuropathy);
        editTextVisual = view.findViewById(R.id.diagnosis_comment_visual);
        editTextUlcers = view.findViewById(R.id.diagnosis_comment_foot_ulcer);
        editTextErectile = view.findViewById(R.id.diagnosis_comment_erectile);
        editTextGatrology = view.findViewById(R.id.diagnosis_comment_gastropathy);
        editTextCataracts = view.findViewById(R.id.diagnosis_comment_cataracts);
        editTextDental = view.findViewById(R.id.diagnosis_comment_dental);
        editTextOtherComplication = view.findViewById(R.id.diagnosis_comment_other);
        editTextOtherProvision = view.findViewById(R.id.provision_other);

        editTextStrokeDate = view.findViewById(R.id.diagnosis_date_stroke);
        editTextHeartDate = view.findViewById(R.id.diagnosis_date_heart_failure);
        editTextKidneyDate = view.findViewById(R.id.diagnosis_date_kidney_failure);
        editTextNeuropahtyDate = view.findViewById(R.id.diagnosis_date_neuropathy);
        editTextVisualDate = view.findViewById(R.id.diagnosis_date_visual);
        editTextUlcersDate = view.findViewById(R.id.diagnosis_date_foot_ulcer);
        editTextErectileDate = view.findViewById(R.id.diagnosis_date_erectile);
        editTextGatrologyDate = view.findViewById(R.id.diagnosis_date_gastropathy);
        editTextCataractsDate = view.findViewById(R.id.diagnosis_date_cataracts);
        editTextDentalDate = view.findViewById(R.id.diagnosis_date_dental);
        editTextOtherComplicationDate = view.findViewById(R.id.diagnosis_date_other);

        DateCalendar.date(getActivity(), editTextStrokeDate);
        DateCalendar.date(getActivity(), editTextHeartDate);
        DateCalendar.date(getActivity(), editTextKidneyDate);
        DateCalendar.date(getActivity(), editTextNeuropahtyDate);
        DateCalendar.date(getActivity(), editTextVisualDate);
        DateCalendar.date(getActivity(), editTextUlcersDate);
        DateCalendar.date(getActivity(), editTextErectileDate);
        DateCalendar.date(getActivity(), editTextGatrologyDate);
        DateCalendar.date(getActivity(), editTextCataractsDate);
        DateCalendar.date(getActivity(), editTextDentalDate);
        DateCalendar.date(getActivity(), editTextOtherComplicationDate);

        textWatcher(editTextStroke);
        textWatcher(editTextHeart);
        textWatcher(editTextKidney);
        textWatcher(editTextNeuropahty);
        textWatcher(editTextVisual);
        textWatcher(editTextUlcers);
        textWatcher(editTextErectile);
        textWatcher(editTextGatrology);
        textWatcher(editTextCataracts);
        textWatcher(editTextDental);
        textWatcher(editTextOtherComplication);

        textWatcher(editTextStrokeDate);
        textWatcher(editTextHeartDate);
        textWatcher(editTextKidneyDate);
        textWatcher(editTextNeuropahtyDate);
        textWatcher(editTextVisualDate);
        textWatcher(editTextUlcersDate);
        textWatcher(editTextErectileDate);
        textWatcher(editTextGatrologyDate);
        textWatcher(editTextCataractsDate);
        textWatcher(editTextDentalDate);
        textWatcher(editTextOtherProvision);

        return view;
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


    public void checkBox(final CheckBox checkBox) {

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                boolean checked = (buttonView).isChecked();
                int value = checkBox.getId();

                //Check which checkbox was clicked
                switch (value) {
                    case R.id.checkbox_complication_stroke:
                        if (checked) {
                            stroke = "111103";
                        } else {
                            stroke = "";
                        }
                        break;
                    case R.id.checkbox_complication_heart:
                        if (checked) {
                            heart = "139069";
                        } else {
                            heart = "";
                        }
                        break;
                    case R.id.checkbox_complication_kidney:
                        if (checked) {
                            kidney = "113338";
                        } else {
                            kidney = "";
                        }
                        break;
                    case R.id.checkbox_complication_neuropathy:
                        if (checked) {
                            neuropahty = "118983";
                        } else {
                            neuropahty = "";
                        }
                        break;
                    case R.id.checkbox_complication_visual:
                        if (checked) {
                            visual = "159298";
                        } else {
                            visual = "";
                        }
                        break;
                    case R.id.checkbox_complication_foot_ulcer:
                        if (checked) {
                            ulcers = "163411";
                        } else {
                            ulcers = "";
                        }
                        break;
                    case R.id.checkbox_complication_erectile:
                        if (checked) {
                            erectile = "156162";
                        } else {
                            erectile = "";
                        }
                        break;
                    case R.id.checkbox_complication_gastropathy:
                        if (checked) {
                            gastrology = "145339";
                        } else {
                            gastrology = "";
                        }
                        break;
                    case R.id.checkbox_complication_cataracts:
                        if (checked) {
                            cataracts = "120860";
                        } else {
                            cataracts = "";
                        }
                        break;
                    case R.id.checkbox_complication_dental:
                        if (checked) {
                            dental = "165331";
                        } else {
                            dental = "";
                        }
                        break;
                    case R.id.checkbox_complication_other:
                        if (checked) {
                            other = "5622";
                        } else {
                            other = "";
                        }
                        break;
                    case R.id.checkbox_nutrition:
                        if (checked) {
                            nutrition = "1380";
                        } else {
                            nutrition = "";
                        }
                        break;
                    case R.id.checkbox_physical_activity:
                        if (checked) {
                            activity = "159364";
                        } else {
                            activity = "";
                        }
                        break;
                    case R.id.checkbox_psychosocial:
                        if (checked) {
                            psychosocial = "5490";
                        } else {
                            psychosocial = "";
                        }
                        break;
                    case R.id.checkbox_other:
                        if (checked) {
                            other_counselling = "5622";
                        } else {
                            other_counselling = "";
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

                // Check which radio button was clicked
                switch (radioButton.getId()) {
                    case R.id.radio_diagnosis_stroke_resolved:
                        if (checked)
                            diagnosis_stroke = "6097";
                        break;
                    case R.id.radio_diagnosis_stroke_referral:
                        if (checked)
                            diagnosis_stroke = "165192";
                        break;
                    case R.id.radio_diagnosis_heart_failure_resolved:
                        if (checked)
                            diagnosis_heart = "6097";
                        break;
                    case R.id.radio_diagnosis_heart_failure_referral:
                        if (checked)
                            diagnosis_heart = "165192";
                        break;
                    case R.id.radio_diagnosis_kidney_failure_resolved:
                        if (checked)
                            diagnosis_kidney = "6097";
                        break;
                    case R.id.radio_diagnosis_kidney_failure_referral:
                        if (checked)
                            diagnosis_kidney = "165192";
                        break;
                    case R.id.radio_diagnosis_neuropathy_resolved:
                        if (checked)
                            diagnosis_neuropahty = "6097";
                        break;
                    case R.id.radio_diagnosis_neuropathy_referral:
                        if (checked)
                            diagnosis_neuropahty = "165192";
                        break;
                    case R.id.radio_diagnosis_visual_resolved:
                        if (checked)
                            diagnosis_visual = "6097";
                        break;
                    case R.id.radio_diagnosis_visual_referral:
                        if (checked)
                            diagnosis_visual = "165192";
                        break;
                    case R.id.radio_diagnosis_foot_ulcer_resolved:
                        if (checked)
                            diagnosis_ulcers = "6097";
                        break;
                    case R.id.radio_diagnosis_foot_ulcer_referral:
                        if (checked)
                            diagnosis_ulcers = "165192";
                        break;
                    case R.id.radio_diagnosis_erectile_resolved:
                        if (checked)
                            diagnosis_erectile = "6097";
                        break;
                    case R.id.radio_diagnosis_erectile_referral:
                        if (checked)
                            diagnosis_erectile = "165192";
                        break;
                    case R.id.radio_diagnosis_gastropathy_resolved:
                        if (checked)
                            diagnosis_gastrology = "6097";
                        break;
                    case R.id.radio_diagnosis_gastropathy_referral:
                        if (checked)
                            diagnosis_gastrology = "165192";
                        break;
                    case R.id.radio_diagnosis_cataracts_resolved:
                        if (checked)
                            diagnosis_cataracts = "6097";
                        break;
                    case R.id.radio_diagnosis_cataracts_referral:
                        if (checked)
                            diagnosis_cataracts = "165192";
                        break;
                    case R.id.radio_diagnosis_dental_resolved:
                        if (checked)
                            diagnosis_dental = "6097";
                        break;
                    case R.id.radio_diagnosis_dental_referral:
                        if (checked)
                            diagnosis_dental = "165192";
                        break;
                    case R.id.radio_diagnosis_other_resolved:
                        if (checked)
                            diagnosis_other = "6097";
                        break;
                    case R.id.radio_diagnosis_other_referral:
                        if (checked)
                            diagnosis_other = "165192";
                        break;
                }

                updateValues();
            }
        });

    }

    public void updateValues() {

        JSONArray jsonArry = new JSONArray();
        JSONArray jsonObs = new JSONArray();
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

        jsonArry1.put(JSONFormBuilder.observations("6042", "165124", "valueCoded", stroke, DateCalendar.date(), ""));
        jsonArry1.put(JSONFormBuilder.observations("159948", "165124", "valueDate", editTextStrokeDate.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry1.put(JSONFormBuilder.observations("165127", "165124", "valueCoded", diagnosis_stroke, DateCalendar.date(), editTextStroke.getText().toString().trim()));

        jsonArry2.put(JSONFormBuilder.observations("6042", "165124", "valueCoded", heart, DateCalendar.date(), ""));
        jsonArry2.put(JSONFormBuilder.observations("159948", "165124", "valueDate", editTextHeartDate.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry2.put(JSONFormBuilder.observations("165127", "165124", "valueCoded", diagnosis_heart, DateCalendar.date(), editTextHeart.getText().toString().trim()));

        jsonArry3.put(JSONFormBuilder.observations("6042", "165124", "valueCoded", kidney, DateCalendar.date(), ""));
        jsonArry3.put(JSONFormBuilder.observations("159948", "165124", "valueDate", editTextKidneyDate.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry3.put(JSONFormBuilder.observations("165127", "165124", "valueCoded", diagnosis_kidney, DateCalendar.date(), editTextKidney.getText().toString().trim()));

        jsonArry4.put(JSONFormBuilder.observations("6042", "165124", "valueCoded", neuropahty, DateCalendar.date(), ""));
        jsonArry4.put(JSONFormBuilder.observations("159948", "165124", "valueDate", editTextNeuropahtyDate.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry4.put(JSONFormBuilder.observations("165127", "165124", "valueCoded", diagnosis_neuropahty, DateCalendar.date(), editTextNeuropahty.getText().toString().trim()));

        jsonArry5.put(JSONFormBuilder.observations("6042", "165124", "valueCoded", visual, DateCalendar.date(), ""));
        jsonArry5.put(JSONFormBuilder.observations("159948", "165124", "valueDate", editTextVisualDate.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry5.put(JSONFormBuilder.observations("165127", "165124", "valueCoded", diagnosis_visual, DateCalendar.date(), editTextVisual.getText().toString().trim()));

        jsonArry6.put(JSONFormBuilder.observations("6042", "165124", "valueCoded", ulcers, DateCalendar.date(), ""));
        jsonArry6.put(JSONFormBuilder.observations("159948", "165124", "valueDate", editTextUlcersDate.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry6.put(JSONFormBuilder.observations("165127", "165124", "valueCoded", diagnosis_ulcers, DateCalendar.date(), editTextUlcers.getText().toString().trim()));

        jsonArry7.put(JSONFormBuilder.observations("6042", "165124", "valueCoded", erectile, DateCalendar.date(), ""));
        jsonArry7.put(JSONFormBuilder.observations("159948", "165124", "valueDate", editTextErectileDate.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry7.put(JSONFormBuilder.observations("165127", "165124", "valueCoded", diagnosis_erectile, DateCalendar.date(), editTextErectile.getText().toString().trim()));

        jsonArry8.put(JSONFormBuilder.observations("6042", "165124", "valueCoded", gastrology, DateCalendar.date(), ""));
        jsonArry8.put(JSONFormBuilder.observations("159948", "165124", "valueDate", editTextGatrologyDate.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry8.put(JSONFormBuilder.observations("165127", "165124", "valueCoded", diagnosis_gastrology, DateCalendar.date(), editTextGatrology.getText().toString().trim()));

        jsonArry9.put(JSONFormBuilder.observations("6042", "165124", "valueCoded", cataracts, DateCalendar.date(), ""));
        jsonArry9.put(JSONFormBuilder.observations("159948", "165124", "valueDate", editTextCataractsDate.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry9.put(JSONFormBuilder.observations("165127", "165124", "valueCoded", diagnosis_cataracts, DateCalendar.date(), editTextCataracts.getText().toString().trim()));

        jsonArry10.put(JSONFormBuilder.observations("6042", "165124", "valueCoded", dental, DateCalendar.date(), ""));
        jsonArry10.put(JSONFormBuilder.observations("159948", "165124", "valueDate", editTextDentalDate.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry10.put(JSONFormBuilder.observations("165127", "165124", "valueCoded", diagnosis_dental, DateCalendar.date(), editTextDental.getText().toString().trim()));

        jsonArry11.put(JSONFormBuilder.observations("6042", "165124", "valueCoded", other, DateCalendar.date(), ""));
        jsonArry11.put(JSONFormBuilder.observations("159948", "165124", "valueDate", editTextOtherComplicationDate.getText().toString().trim(), DateCalendar.date(), ""));
        jsonArry11.put(JSONFormBuilder.observations("165127", "165124", "valueCoded", diagnosis_other, DateCalendar.date(), editTextOtherComplication.getText().toString().trim()));

        jsonArry.put(JSONFormBuilder.observations("1379", "", "valueCoded", nutrition, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1379", "", "valueCoded", activity, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1379", "", "valueCoded", psychosocial, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1379", "", "valueCoded", other_counselling, DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165176", "", "valueText", editTextOtherProvision.getText().toString().trim(), DateCalendar.date(), ""));


        try {
            jsonArry1 = JSONFormBuilder.concatArray(jsonArry1);
            jsonArry2 = JSONFormBuilder.concatArray(jsonArry2);
            jsonArry3 = JSONFormBuilder.concatArray(jsonArry3);
            jsonArry4 = JSONFormBuilder.concatArray(jsonArry4);
            jsonArry5 = JSONFormBuilder.concatArray(jsonArry5);
            jsonArry6 = JSONFormBuilder.concatArray(jsonArry6);
            jsonArry7 = JSONFormBuilder.concatArray(jsonArry7);
            jsonArry8 = JSONFormBuilder.concatArray(jsonArry8);
            jsonArry9 = JSONFormBuilder.concatArray(jsonArry9);
            jsonArry10 = JSONFormBuilder.concatArray(jsonArry10);
            jsonArry11 = JSONFormBuilder.concatArray(jsonArry11);

            jsonArry = JSONFormBuilder.concatArray(jsonArry);

            jsonObs = JSONFormBuilder.checkLength(jsonArry1, jsonObs);
            jsonObs = JSONFormBuilder.checkLength(jsonArry2, jsonObs);
            jsonObs = JSONFormBuilder.checkLength(jsonArry3, jsonObs);
            jsonObs = JSONFormBuilder.checkLength(jsonArry4, jsonObs);
            jsonObs = JSONFormBuilder.checkLength(jsonArry5, jsonObs);
            jsonObs = JSONFormBuilder.checkLength(jsonArry6, jsonObs);
            jsonObs = JSONFormBuilder.checkLength(jsonArry7, jsonObs);
            jsonObs = JSONFormBuilder.checkLength(jsonArry8, jsonObs);
            jsonObs = JSONFormBuilder.checkLength(jsonArry9, jsonObs);
            jsonObs = JSONFormBuilder.checkLength(jsonArry10, jsonObs);
            jsonObs = JSONFormBuilder.checkLength(jsonArry11, jsonObs);

            if (jsonObs.length() > 0) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("groups", jsonObs);

                jsonArry.put(jsonObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Log.d("JSON Initial Page 4", jsonArry.toString() + "");

        FragmentModelInitial.getInstance().initialFour(jsonArry);
    }

}
