package org.aihdint.aihd.fragments.initial;

import android.content.Context;
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
import android.widget.Spinner;

import org.aihdint.aihd.R;
import org.aihdint.aihd.app.AppController;
import org.aihdint.aihd.common.DateCalendar;
import org.aihdint.aihd.common.JSONFormBuilder;
import org.aihdint.aihd.model.KeyValue;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Developed by Rodney on 24/04/2018.
 */

public class Initial_page_6 extends Fragment {

    private EditText editTextReturnDate, editTextFacility, editTextDateReffered, editTextHealthFacility, editTextDateOut, editTextReffered, editTextRefferalReason, editTextSupportGroup,
            editTextProvider;

    private CheckBox checkBoxContinueCare, checkBoxReferFacility, checkBoxTransferFacility, checkBoxManagementDM, checkBoxManagementHTN, checkBoxEyeReview, checkBoxSurgicalReview, checkBoxRenalReview,
            checkBoxCVDReview, checkBoxNutrition, checkBoxPhysiotherapy, checkBoxFollowUpOther;

    private String continueCare, referFacility, transferFacility, managementDM, managementHTN, eyeReview, surgicalReview, renalReview,
            cvdReview, nutrition, physiotherapy, followUpOther;

    private String supportGroup, designation;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_initial_fragment_6, container, false);

        //Follow Up Plan
        checkBoxContinueCare = view.findViewById(R.id.followup_continue);
        checkBoxReferFacility = view.findViewById(R.id.followup_refer);
        checkBoxTransferFacility = view.findViewById(R.id.followup_transfer);
        checkBoxManagementDM = view.findViewById(R.id.followup_further_management_dm);
        checkBoxManagementHTN = view.findViewById(R.id.followup_further_management_htn);
        checkBoxEyeReview = view.findViewById(R.id.followup_eye_review);
        checkBoxSurgicalReview = view.findViewById(R.id.followup_surgical_review);
        checkBoxRenalReview = view.findViewById(R.id.followup_renal_review);
        checkBoxCVDReview = view.findViewById(R.id.followup_cvd_review);
        checkBoxNutrition = view.findViewById(R.id.followup_nutrition);
        checkBoxPhysiotherapy = view.findViewById(R.id.followup_physiotherapy);
        checkBoxFollowUpOther = view.findViewById(R.id.followup_other);

        checkBoxTreatment(checkBoxContinueCare);
        checkBoxTreatment(checkBoxReferFacility);
        checkBoxTreatment(checkBoxTransferFacility);
        checkBoxTreatment(checkBoxManagementDM);
        checkBoxTreatment(checkBoxManagementHTN);
        checkBoxTreatment(checkBoxEyeReview);
        checkBoxTreatment(checkBoxSurgicalReview);
        checkBoxTreatment(checkBoxRenalReview);
        checkBoxTreatment(checkBoxCVDReview);
        checkBoxTreatment(checkBoxNutrition);
        checkBoxTreatment(checkBoxPhysiotherapy);
        checkBoxTreatment(checkBoxFollowUpOther);

        editTextReturnDate = view.findViewById(R.id.followup_date);
        editTextFacility = view.findViewById(R.id.facility);
        editTextDateReffered = view.findViewById(R.id.date_referred);
        editTextHealthFacility = view.findViewById(R.id.health_center);
        editTextDateOut = view.findViewById(R.id.date_transfer);
        editTextReffered = view.findViewById(R.id.reason_reffered);
        editTextRefferalReason = view.findViewById(R.id.followup_other_reason);
        editTextSupportGroup = view.findViewById(R.id.support_group);
        editTextProvider = view.findViewById(R.id.provider_name);
        editTextProvider.setText(AppController.getInstance().getSessionManager().getUserDetails().get("name"));

        DateCalendar.date(getActivity(), editTextReturnDate);
        DateCalendar.date(getActivity(), editTextDateReffered);
        DateCalendar.date(getActivity(), editTextDateOut);

        textWatcher(editTextReturnDate);
        textWatcher(editTextFacility);
        textWatcher(editTextDateReffered);
        textWatcher(editTextHealthFacility);
        textWatcher(editTextDateOut);
        textWatcher(editTextReffered);
        textWatcher(editTextRefferalReason);
        textWatcher(editTextSupportGroup);
        textWatcher(editTextProvider);

        Spinner spinnerSupportGroup = view.findViewById(R.id.spinnerSupportGroup);
        Spinner spinnerDesignation = view.findViewById(R.id.spinnerDesignation);

        spinnerData(getContext(), spinnerSupportGroup, "support_group");
        spinnerData(getContext(), spinnerDesignation, "designation");

        return view;
    }

    public void spinnerData(Context context, final Spinner spinner, final String data) {
        ArrayList<KeyValue> keyvalue = new ArrayList<>();

        if (data.matches("support_group")) {
            // adding each child node to HashMap key => value
            keyvalue.add(new KeyValue("", "Select Support Group"));
            keyvalue.add(new KeyValue("1065", "Yes"));
            keyvalue.add(new KeyValue("1066", "No"));
            keyvalue.add(new KeyValue("5622", "Unknown"));
        } else if (data.matches("designation")) {
            keyvalue.add(new KeyValue("", "Select Designation"));
            keyvalue.add(new KeyValue("", "Consultant"));
            keyvalue.add(new KeyValue("", "Medical officer"));
            keyvalue.add(new KeyValue("", "Clinical Officer"));
            keyvalue.add(new KeyValue("", "Nurse"));
        }

        //fill data in spinner
        ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, keyvalue);
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //occupationSpinner.setSelection(adapter.getPosition(keyvalue.get(2)));//Optional to set the selected item.

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                KeyValue value = (KeyValue) parent.getSelectedItem();
                switch (spinner.getId()) {
                    case R.id.spinnerSupportGroup:
                        if (data.matches("support_group")) {
                            supportGroup = value.getId();
                        }
                        break;
                    case R.id.spinnerDesignation:
                        if (data.matches("designation")) {
                            designation = value.getId();
                        }
                        break;
                    default:
                        break;
                }
                updateValues();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void textWatcher(EditText editText) {

        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(final Editable editable) {
                updateValues();
            }


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });
    }

    public void checkBoxTreatment(final CheckBox checkBox) {

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                boolean checked = (buttonView).isChecked();
                int value = checkBox.getId();

                //Check which checkbox was clicked
                switch (value) {
                    case R.id.followup_continue:
                        if (checked) {
                            continueCare = "165132";
                        } else {
                            continueCare = "";
                        }
                    case R.id.followup_refer:
                        if (checked) {
                            referFacility = "164165";
                        } else {
                            referFacility = "";
                        }
                    case R.id.followup_transfer:
                        if (checked) {
                            transferFacility = "1285";
                        } else {
                            transferFacility = "";
                        }
                    case R.id.followup_further_management_dm:
                        if (checked) {
                            managementDM = "165133";
                        } else {
                            managementDM = "";
                        }
                    case R.id.followup_further_management_htn:
                        if (checked) {
                            managementHTN = "165135";
                        } else {
                            managementHTN = "";
                        }
                    case R.id.followup_eye_review:
                        if (checked) {
                            eyeReview = "165138";
                        } else {
                            eyeReview = "";
                        }
                    case R.id.followup_surgical_review:
                        if (checked) {
                            surgicalReview = "165137";
                        } else {
                            surgicalReview = "";
                        }
                    case R.id.followup_renal_review:
                        if (checked) {
                            renalReview = "165136";
                        } else {
                            renalReview = "";
                        }
                    case R.id.followup_cvd_review:
                        if (checked) {
                            cvdReview = "119270";
                        } else {
                            cvdReview = "";
                        }
                    case R.id.followup_nutrition:
                        if (checked) {
                            nutrition = "160552";
                        } else {
                            nutrition = "";
                        }
                    case R.id.followup_physiotherapy:
                        if (checked) {
                            physiotherapy = "165134";
                        } else {
                            physiotherapy = "";
                        }
                    case R.id.followup_other:
                        if (checked) {
                            followUpOther = "5622";
                        } else {
                            followUpOther = "";
                        }
                    default:
                        break;

                }

                updateValues();
            }
        });

    }

    public void updateValues() {

        JSONArray jsonArry = new JSONArray();

        jsonArry.put(JSONFormBuilder.observations("165122", "", "valueCoded", continueCare, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("5096", "", "valueDate", editTextReturnDate.getText().toString(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165122", "", "valueCoded", referFacility, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("", "", "valueText", editTextDateReffered.getText().toString(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165167", "", "valueText", editTextFacility.getText().toString(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165122", "", "valueCoded", transferFacility, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("159495", "", "valueText", editTextHealthFacility.getText().toString(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("160649", "", "valueDate", editTextDateOut.getText().toString(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("165168", "", "valueText", editTextReffered.getText().toString(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1887", "", "valueCoded", managementDM, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1887", "", "valueCoded", managementHTN, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1887", "", "valueCoded", eyeReview, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1887", "", "valueCoded", surgicalReview, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1887", "", "valueCoded", renalReview, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1887", "", "valueCoded", cvdReview, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1887", "", "valueCoded", nutrition, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1887", "", "valueCoded", physiotherapy, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("1887", "", "valueCoded", followUpOther, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165139", "", "valueText", editTextRefferalReason.getText().toString(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("163766", "", "valueCoded", supportGroup, DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("165169", "", "valueText", editTextSupportGroup.getText().toString(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("1473", "", "valueText", editTextProvider.getText().toString(), DateCalendar.date(), ""));
        jsonArry.put(JSONFormBuilder.observations("163556", "", "valueCoded", designation, DateCalendar.date(), ""));


        try {
            jsonArry = JSONFormBuilder.concatArray(jsonArry);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Log.d("JSON Initial Page 6", jsonArry.toString() + " ");

        FragmentModelInitial.getInstance().initialSix(jsonArry);
      //  greyOutEntry();

    }

    public void greyOutEntry(){
        //edit texts
        editTextReturnDate.setEnabled(false);
        editTextFacility.setEnabled(false);
        editTextDateReffered.setEnabled(false);
        editTextHealthFacility.setEnabled(false);
        editTextDateOut.setEnabled(false);
        editTextReffered.setEnabled(false);
        editTextRefferalReason.setEnabled(false);
        editTextSupportGroup.setEnabled(false);
        editTextProvider.setEnabled(false);

        //checkboxes
        checkBoxContinueCare.setEnabled(false);
        checkBoxReferFacility.setEnabled(false);
        checkBoxTransferFacility.setEnabled(false);
        checkBoxManagementDM.setEnabled(false);
        checkBoxManagementHTN.setEnabled(false);
        checkBoxEyeReview.setEnabled(false);
        checkBoxSurgicalReview.setEnabled(false);
        checkBoxRenalReview.setEnabled(false);
        checkBoxCVDReview.setEnabled(false);
        checkBoxNutrition.setEnabled(false);
        checkBoxPhysiotherapy.setEnabled(false);
        checkBoxFollowUpOther.setEnabled(false);

    }
}
