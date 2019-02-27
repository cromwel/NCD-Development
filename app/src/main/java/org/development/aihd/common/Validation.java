package org.development.aihd.common;

import org.json.JSONArray;

public class Validation {

    private static StringBuilder error;

    public static String initialValidation(JSONArray jsonArray) {

        try {
            error = new StringBuilder(1000);

            if (jsonArray.length() > 0) {

                String obs = jsonArray.toString();

                validate(obs, "Page(1) Education Level", "1712");
                validate(obs, "Page(1) Occupation", "1542");
                validate(obs, "Page(1) Diabetes Status", "165086");
                validate(obs, "Page(1) Diabetes runs in the family", "140228");
                validate(obs, "Page(1) Hypertension status", "165091");
                validate(obs, "Page(1) Hypertension runs in the family", "165191");
                validate(obs, "Page(1) HIV Status", "138405");
                validate(obs, "Page(1) NHIF status", "1917");
                validate(obs, "Page(1) Patient referral status", "1648");
                validate(obs, "Page(1) Do you exercise question", "165208");
                validate(obs, "Page(1) Do you follow a balanced diet question", "165207");
                validate(obs, "Page(1) Do you smoke cigarettes question", "152722");
                validate(obs, "Page(1) Do you drink alcohol question", "159449");

                validate(obs, "Page(4) Nutrition counselling/education", "1380");
                validate(obs, "Page(4) Physical activity counselling/education", "159364");

            }

        } catch (Exception e) {
            // hiding the progress bar
            e.printStackTrace();
        }

        return error.toString();
    }


    public static String followupValidation(JSONArray jsonArray) {

        try {
            error = new StringBuilder(1000);

            if (jsonArray.length() > 0) {
                String obs = jsonArray.toString();

                validate(obs, "Page(1) Diabetes Status", "165086");
                //validate(obs, "Page(1) Diabetes runs in the family", "140228");
                validate(obs, "Page(1) Hypertension status", "165091");
                //validate(obs, "Page(1) Hypertension runs in the family", "165191");
                validate(obs, "Page(1) HIV Status", "138405");
                validate(obs, "Page(1) NHIF status", "1917");
            }

        } catch (Exception e) {
            // hiding the progress bar
            e.printStackTrace();
        }

        return error.toString();
    }


    public static String admissionValidation(JSONArray jsonArray) {

        try {
            error = new StringBuilder(1000);

            if (jsonArray.length() > 0) {
                String obs = jsonArray.toString();

                validate(obs, "Reason for Admission", "1655");
            }

        } catch (Exception e) {
            // hiding the progress bar
            e.printStackTrace();
        }

        return error.toString();
    }


    private static void validate(String obs, String response, String concept_id) {

        if (!obs.contains(concept_id)) {
            error.append(response).append("  is required. \n\n");
        }
    }

}
