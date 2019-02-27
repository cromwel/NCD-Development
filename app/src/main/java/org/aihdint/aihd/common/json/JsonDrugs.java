package org.aihdint.aihd.common.json;

import org.aihdint.aihd.common.DateCalendar;
import org.aihdint.aihd.common.variables.DrugsDose;
import org.aihdint.aihd.common.JSONFormBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonDrugs {

    public static JSONArray jsonArrayDrugs(DrugsDose drugsDose, JSONArray jsonArry) {

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
        JSONArray jsonArry12 = new JSONArray();
        JSONArray jsonArry13 = new JSONArray();
        JSONArray jsonArry14 = new JSONArray();
        JSONArray jsonArry15 = new JSONArray();
        JSONArray jsonArry16 = new JSONArray();
        JSONArray jsonArry17 = new JSONArray();
        JSONArray jsonArry18 = new JSONArray();
        JSONArray jsonArry19 = new JSONArray();
        JSONArray jsonArry20 = new JSONArray();
        JSONArray jsonArry21 = new JSONArray();
        JSONArray jsonArry22 = new JSONArray();
        JSONArray jsonArry23 = new JSONArray();
        JSONArray jsonArry24 = new JSONArray();
        JSONArray jsonArry25 = new JSONArray();
        JSONArray jsonArry26 = new JSONArray();
        JSONArray jsonArry27 = new JSONArray();
        JSONArray jsonArry28 = new JSONArray();
        JSONArray jsonArry29 = new JSONArray();
        JSONArray jsonArry30 = new JSONArray();
        JSONArray jsonArry31 = new JSONArray();
        JSONArray jsonArry32 = new JSONArray();
        JSONArray jsonArry33 = new JSONArray();
        JSONArray jsonArry34 = new JSONArray();
        JSONArray jsonArry35 = new JSONArray();
        JSONArray jsonArry36 = new JSONArray();
        JSONArray jsonArry37 = new JSONArray();

        jsonArry1.put(JSONFormBuilder.observations("1282", "165280", "valueCoded", drugsDose.Metformin, DateCalendar.date(), ""));
        jsonArry1.put(JSONFormBuilder.observations("1443", "165280", "valueNumeric", drugsDose.doseMetformin, DateCalendar.date(), ""));
        jsonArry1.put(JSONFormBuilder.observations("160855", "165280", "valueCoded", drugsDose.frequencyMetformin, DateCalendar.date(), ""));

        jsonArry2.put(JSONFormBuilder.observations("1282", "165281", "valueCoded", drugsDose.Glibenclamide, DateCalendar.date(), ""));
        jsonArry2.put(JSONFormBuilder.observations("1443", "165281", "valueNumeric", drugsDose.doseGlibenclamide, DateCalendar.date(), ""));
        jsonArry2.put(JSONFormBuilder.observations("160855", "165281", "valueCoded", drugsDose.frequencyGlibenclamide, DateCalendar.date(), ""));

        //Insulin
        jsonArry3.put(JSONFormBuilder.observations("1282", "165282", "valueCoded", drugsDose.Insulin, DateCalendar.date(), ""));
        jsonArry3.put(JSONFormBuilder.observations("1443", "165282", "valueNumeric", drugsDose.editTextInsulin.getText().toString(), DateCalendar.date(), ""));
        jsonArry3.put(JSONFormBuilder.observations("160855", "165282", "valueCoded", drugsDose.frequencyInsulin, DateCalendar.date(), ""));

        jsonArry4.put(JSONFormBuilder.observations("1282", "165283", "valueCoded", drugsDose.SolubleInsulin, DateCalendar.date(), ""));
        jsonArry4.put(JSONFormBuilder.observations("1443", "165283", "valueNumeric", drugsDose.editTextSolubleInsulin.getText().toString(), DateCalendar.date(), ""));
        jsonArry4.put(JSONFormBuilder.observations("160855", "165283", "valueCoded", drugsDose.frequencySolubleInsulin, DateCalendar.date(), ""));

        jsonArry5.put(JSONFormBuilder.observations("1282", "165285", "valueCoded", drugsDose.NPH, DateCalendar.date(), ""));
        jsonArry5.put(JSONFormBuilder.observations("1443", "165285", "valueNumeric", drugsDose.editTextNPH1.getText().toString(), DateCalendar.date(), ""));
        jsonArry5.put(JSONFormBuilder.observations("160855", "165285", "valueCoded", drugsDose.frequencyNPH1, DateCalendar.date(), ""));

        jsonArry6.put(JSONFormBuilder.observations("1282", "165286", "valueCoded", drugsDose.NPH2, DateCalendar.date(), ""));
        jsonArry6.put(JSONFormBuilder.observations("1443", "165286", "valueNumeric", drugsDose.editTextNPH2.getText().toString(), DateCalendar.date(), ""));
        jsonArry6.put(JSONFormBuilder.observations("160855", "165286", "valueCoded", drugsDose.frequencyNPH2, DateCalendar.date(), ""));

        //ACE
        jsonArry7.put(JSONFormBuilder.observations("1282", "165253", "valueCoded", drugsDose.Captopril, DateCalendar.date(), ""));
        jsonArry7.put(JSONFormBuilder.observations("1443", "165253", "valueNumeric", drugsDose.doseCaptopril, DateCalendar.date(), ""));
        jsonArry7.put(JSONFormBuilder.observations("160855", "165253", "valueCoded", drugsDose.frequencyCaptopril, DateCalendar.date(), ""));

        jsonArry8.put(JSONFormBuilder.observations("1282", "165254", "valueCoded", drugsDose.Enalapril, DateCalendar.date(), ""));
        jsonArry8.put(JSONFormBuilder.observations("1443", "165254", "valueNumeric", drugsDose.doseEnalapril, DateCalendar.date(), ""));
        jsonArry8.put(JSONFormBuilder.observations("160855", "165254", "valueCoded", drugsDose.frequencyEnalapril, DateCalendar.date(), ""));

        jsonArry9.put(JSONFormBuilder.observations("1282", "165255", "valueCoded", drugsDose.Lisinopril, DateCalendar.date(), ""));
        jsonArry9.put(JSONFormBuilder.observations("1443", "165255", "valueNumeric", drugsDose.doseLisinopril, DateCalendar.date(), ""));
        jsonArry9.put(JSONFormBuilder.observations("160855", "165255", "valueCoded", drugsDose.frequencyLisinopril, DateCalendar.date(), ""));

        jsonArry10.put(JSONFormBuilder.observations("1282", "165256", "valueCoded", drugsDose.Perindopril, DateCalendar.date(), ""));
        jsonArry10.put(JSONFormBuilder.observations("1443", "165256", "valueNumeric", drugsDose.dosePerindopril, DateCalendar.date(), ""));
        jsonArry10.put(JSONFormBuilder.observations("160855", "165256", "valueCoded", drugsDose.frequencyPerindopril, DateCalendar.date(), ""));

        jsonArry11.put(JSONFormBuilder.observations("1282", "165257", "valueCoded", drugsDose.Ramipril, DateCalendar.date(), ""));
        jsonArry11.put(JSONFormBuilder.observations("1443", "165257", "valueNumeric", drugsDose.doseRamipril, DateCalendar.date(), ""));
        jsonArry11.put(JSONFormBuilder.observations("160855", "165257", "valueCoded", drugsDose.frequencyRamipril, DateCalendar.date(), ""));

        //ARB
        jsonArry12.put(JSONFormBuilder.observations("1282", "165258", "valueCoded", drugsDose.Candesartan, DateCalendar.date(), ""));
        jsonArry12.put(JSONFormBuilder.observations("1443", "165258", "valueNumeric", drugsDose.doseCandesartan, DateCalendar.date(), ""));
        jsonArry12.put(JSONFormBuilder.observations("160855", "165258", "valueCoded", drugsDose.frequencyCandesartan, DateCalendar.date(), ""));

        jsonArry13.put(JSONFormBuilder.observations("1282", "165259", "valueCoded", drugsDose.Irbesartan, DateCalendar.date(), ""));
        jsonArry13.put(JSONFormBuilder.observations("1443", "165259", "valueNumeric", drugsDose.doseIrbesartan, DateCalendar.date(), ""));
        jsonArry13.put(JSONFormBuilder.observations("160855", "165259", "valueCoded", drugsDose.frequencyIrbesartan, DateCalendar.date(), ""));

        jsonArry14.put(JSONFormBuilder.observations("1282", "165260", "valueCoded", drugsDose.Losartan, DateCalendar.date(), ""));
        jsonArry14.put(JSONFormBuilder.observations("1443", "165260", "valueNumeric", drugsDose.doseLosartan, DateCalendar.date(), ""));
        jsonArry14.put(JSONFormBuilder.observations("160855", "165260", "valueCoded", drugsDose.frequencyLosartan, DateCalendar.date(), ""));

        jsonArry15.put(JSONFormBuilder.observations("1282", "165261", "valueCoded", drugsDose.Telmisartan, DateCalendar.date(), ""));
        jsonArry15.put(JSONFormBuilder.observations("1443", "165261", "valueNumeric", drugsDose.doseTelmisartan, DateCalendar.date(), ""));
        jsonArry15.put(JSONFormBuilder.observations("160855", "165261", "valueCoded", drugsDose.frequencyTelmisartan, DateCalendar.date(), ""));

        jsonArry16.put(JSONFormBuilder.observations("1282", "165262", "valueCoded", drugsDose.Valsartan, DateCalendar.date(), ""));
        jsonArry16.put(JSONFormBuilder.observations("1443", "165262", "valueNumeric", drugsDose.doseValsartan, DateCalendar.date(), ""));
        jsonArry16.put(JSONFormBuilder.observations("160855", "165262", "valueCoded", drugsDose.frequencyValsartan, DateCalendar.date(), ""));

        jsonArry17.put(JSONFormBuilder.observations("1282", "165263", "valueCoded", drugsDose.Olmesartan, DateCalendar.date(), ""));
        jsonArry17.put(JSONFormBuilder.observations("1443", "165263", "valueNumeric", drugsDose.doseOlmesartan, DateCalendar.date(), ""));
        jsonArry17.put(JSONFormBuilder.observations("160855", "165263", "valueCoded", drugsDose.frequencyOlmesartan, DateCalendar.date(), ""));

        //Beta Blockers
        jsonArry18.put(JSONFormBuilder.observations("1282", "165264", "valueCoded", drugsDose.Atenolol, DateCalendar.date(), ""));
        jsonArry18.put(JSONFormBuilder.observations("1443", "165264", "valueNumeric", drugsDose.doseAtenolol, DateCalendar.date(), ""));
        jsonArry18.put(JSONFormBuilder.observations("160855", "165264", "valueCoded", drugsDose.frequencyAtenolol, DateCalendar.date(), ""));

        jsonArry19.put(JSONFormBuilder.observations("1282", "165265", "valueCoded", drugsDose.Labetolol, DateCalendar.date(), ""));
        jsonArry19.put(JSONFormBuilder.observations("1443", "165265", "valueNumeric", drugsDose.doseLabetolol, DateCalendar.date(), ""));
        jsonArry19.put(JSONFormBuilder.observations("160855", "165265", "valueCoded", drugsDose.frequencyLabetolol, DateCalendar.date(), ""));

        jsonArry20.put(JSONFormBuilder.observations("1282", "165266", "valueCoded", drugsDose.Propranolol, DateCalendar.date(), ""));
        jsonArry20.put(JSONFormBuilder.observations("1443", "165266", "valueNumeric", drugsDose.dosePropranolol, DateCalendar.date(), ""));
        jsonArry20.put(JSONFormBuilder.observations("160855", "165266", "valueCoded", drugsDose.frequencyPropranolol, DateCalendar.date(), ""));

        jsonArry21.put(JSONFormBuilder.observations("1282", "165267", "valueCoded", drugsDose.Carvedilol, DateCalendar.date(), ""));
        jsonArry21.put(JSONFormBuilder.observations("1443", "165267", "valueNumeric", drugsDose.doseCarvedilol, DateCalendar.date(), ""));
        jsonArry21.put(JSONFormBuilder.observations("160855", "165267", "valueCoded", drugsDose.frequencyCarvedilol, DateCalendar.date(), ""));

        jsonArry22.put(JSONFormBuilder.observations("1282", "165268", "valueCoded", drugsDose.Nebivolol, DateCalendar.date(), ""));
        jsonArry22.put(JSONFormBuilder.observations("1443", "165268", "valueNumeric", drugsDose.doseNebivolol, DateCalendar.date(), ""));
        jsonArry22.put(JSONFormBuilder.observations("160855", "165268", "valueCoded", drugsDose.frequencyNebivolol, DateCalendar.date(), ""));

        jsonArry23.put(JSONFormBuilder.observations("1282", "165269", "valueCoded", drugsDose.Metoprolol, DateCalendar.date(), ""));
        jsonArry23.put(JSONFormBuilder.observations("1443", "165269", "valueNumeric", drugsDose.doseMetoprolol, DateCalendar.date(), ""));
        jsonArry23.put(JSONFormBuilder.observations("160855", "165269", "valueCoded", drugsDose.frequencyMetoprolol, DateCalendar.date(), ""));

        jsonArry24.put(JSONFormBuilder.observations("1282", "165270", "valueCoded", drugsDose.Bisoprolol, DateCalendar.date(), ""));
        jsonArry24.put(JSONFormBuilder.observations("1443", "165270", "valueNumeric", drugsDose.doseBisoprolol, DateCalendar.date(), ""));
        jsonArry24.put(JSONFormBuilder.observations("160855", "165270", "valueCoded", drugsDose.frequencyBisoprolol, DateCalendar.date(), ""));

        //Long Acting CCB
        jsonArry25.put(JSONFormBuilder.observations("1282", "165271", "valueCoded", drugsDose.Amlodipine, DateCalendar.date(), ""));
        jsonArry25.put(JSONFormBuilder.observations("1443", "165271", "valueNumeric", drugsDose.doseAmlodipine, DateCalendar.date(), ""));
        jsonArry25.put(JSONFormBuilder.observations("160855", "165271", "valueCoded", drugsDose.frequencyAmlodipine, DateCalendar.date(), ""));

        jsonArry26.put(JSONFormBuilder.observations("1282", "165272", "valueCoded", drugsDose.Felodipine, DateCalendar.date(), ""));
        jsonArry26.put(JSONFormBuilder.observations("1443", "165272", "valueNumeric", drugsDose.doseFelodipine, DateCalendar.date(), ""));
        jsonArry26.put(JSONFormBuilder.observations("160855", "165272", "valueCoded", drugsDose.frequencyFelodipine, DateCalendar.date(), ""));

        jsonArry27.put(JSONFormBuilder.observations("1282", "165273", "valueCoded", drugsDose.Nifedipine, DateCalendar.date(), ""));
        jsonArry27.put(JSONFormBuilder.observations("1443", "165273", "valueNumeric", drugsDose.doseNifedipine, DateCalendar.date(), ""));
        jsonArry27.put(JSONFormBuilder.observations("160855", "165273", "valueCoded", drugsDose.frequencyNifedipine, DateCalendar.date(), ""));

        //AntiHypersensitives
        jsonArry28.put(JSONFormBuilder.observations("1282", "165277", "valueCoded", drugsDose.Methyldopa, DateCalendar.date(), ""));
        jsonArry28.put(JSONFormBuilder.observations("1443", "165277", "valueNumeric", drugsDose.doseMethyldopa, DateCalendar.date(), ""));
        jsonArry28.put(JSONFormBuilder.observations("160855", "165277", "valueCoded", drugsDose.frequencyMethyldopa, DateCalendar.date(), ""));

        jsonArry29.put(JSONFormBuilder.observations("1282", "165278", "valueCoded", drugsDose.Hydralazine, DateCalendar.date(), ""));
        jsonArry29.put(JSONFormBuilder.observations("1443", "165278", "valueNumeric", drugsDose.doseHydralazine, DateCalendar.date(), ""));
        jsonArry29.put(JSONFormBuilder.observations("160855", "165278", "valueCoded", drugsDose.frequencyHydralazine, DateCalendar.date(), ""));

        jsonArry30.put(JSONFormBuilder.observations("1282", "165279", "valueCoded", drugsDose.Prazocin, DateCalendar.date(), ""));
        jsonArry30.put(JSONFormBuilder.observations("1443", "165279", "valueNumeric", drugsDose.dosePrazocin, DateCalendar.date(), ""));
        jsonArry30.put(JSONFormBuilder.observations("160855", "165279", "valueCoded", drugsDose.frequencyPrazocin, DateCalendar.date(), ""));

        //Thizide
        jsonArry31.put(JSONFormBuilder.observations("1282", "165274", "valueCoded", drugsDose.Chlorthalidone, DateCalendar.date(), ""));
        jsonArry31.put(JSONFormBuilder.observations("1443", "165274", "valueNumeric", drugsDose.doseChlorthalidone, DateCalendar.date(), ""));
        jsonArry31.put(JSONFormBuilder.observations("160855", "165274", "valueCoded", drugsDose.frequencyChlorthalidone, DateCalendar.date(), ""));

        jsonArry32.put(JSONFormBuilder.observations("1282", "165275", "valueCoded", drugsDose.Hydrochlorothia, DateCalendar.date(), ""));
        jsonArry32.put(JSONFormBuilder.observations("1443", "165275", "valueNumeric", drugsDose.doseHydrochlorothia, DateCalendar.date(), ""));
        jsonArry32.put(JSONFormBuilder.observations("160855", "165275", "valueCoded", drugsDose.frequencyHydrochlorothia, DateCalendar.date(), ""));

        jsonArry33.put(JSONFormBuilder.observations("1282", "165276", "valueCoded", drugsDose.Indapamide, DateCalendar.date(), ""));
        jsonArry33.put(JSONFormBuilder.observations("1443", "165276", "valueNumeric", drugsDose.doseIndapamide, DateCalendar.date(), ""));
        jsonArry33.put(JSONFormBuilder.observations("160855", "165276", "valueCoded", drugsDose.frequencyIndapamide, DateCalendar.date(), ""));

        //Other
        jsonArry34.put(JSONFormBuilder.observations("1282", "165307", "valueCoded", drugsDose.Diet, DateCalendar.date(), ""));
        jsonArry34.put(JSONFormBuilder.observations("165201", "165307", "valueText", drugsDose.editTextDiet.getText().toString(), DateCalendar.date(), ""));

        jsonArry35.put(JSONFormBuilder.observations("1282", "165308", "valueCoded", drugsDose.PhysicalExercise, DateCalendar.date(), ""));
        jsonArry35.put(JSONFormBuilder.observations("165202", "165308", "valueText", drugsDose.editTextPhysicalExercise.getText().toString(), DateCalendar.date(), ""));

        jsonArry36.put(JSONFormBuilder.observations("1282", "165309", "valueCoded", drugsDose.Herbal, DateCalendar.date(), ""));
        jsonArry36.put(JSONFormBuilder.observations("165204", "165309", "valueText", drugsDose.editTextHerbal.getText().toString(), DateCalendar.date(), ""));

        jsonArry37.put(JSONFormBuilder.observations("1282", "165310", "valueCoded", drugsDose.TreatmentOther, DateCalendar.date(), ""));
        jsonArry37.put(JSONFormBuilder.observations("165205", "165310", "valueText", drugsDose.editTextTreatmentOther.getText().toString(), DateCalendar.date(), ""));

        jsonArry.put(JSONFormBuilder.observations("161011", "", "valueText", drugsDose.editTextComment.getText().toString().trim(), DateCalendar.date(), ""));

        try {

            jsonArry1 = JSONFormBuilder.concatArray(jsonArry1);
            jsonArry2 = JSONFormBuilder.concatArray(jsonArry2);
            jsonArry3 = JSONFormBuilder.concatArray(jsonArry3);
            jsonArry4 = JSONFormBuilder.concatArray(jsonArry4);
            jsonArry5 = JSONFormBuilder.concatArray(jsonArry5);
            jsonArry6 = JSONFormBuilder.concatArray(jsonArry7);
            jsonArry7 = JSONFormBuilder.concatArray(jsonArry6);
            jsonArry8 = JSONFormBuilder.concatArray(jsonArry8);
            jsonArry9 = JSONFormBuilder.concatArray(jsonArry9);
            jsonArry10 = JSONFormBuilder.concatArray(jsonArry10);
            jsonArry11 = JSONFormBuilder.concatArray(jsonArry11);
            jsonArry12 = JSONFormBuilder.concatArray(jsonArry12);
            jsonArry13 = JSONFormBuilder.concatArray(jsonArry13);
            jsonArry14 = JSONFormBuilder.concatArray(jsonArry14);
            jsonArry15 = JSONFormBuilder.concatArray(jsonArry15);
            jsonArry16 = JSONFormBuilder.concatArray(jsonArry16);
            jsonArry17 = JSONFormBuilder.concatArray(jsonArry17);
            jsonArry18 = JSONFormBuilder.concatArray(jsonArry18);
            jsonArry19 = JSONFormBuilder.concatArray(jsonArry19);
            jsonArry20 = JSONFormBuilder.concatArray(jsonArry20);
            jsonArry21 = JSONFormBuilder.concatArray(jsonArry21);
            jsonArry22 = JSONFormBuilder.concatArray(jsonArry22);
            jsonArry23 = JSONFormBuilder.concatArray(jsonArry23);
            jsonArry24 = JSONFormBuilder.concatArray(jsonArry24);
            jsonArry25 = JSONFormBuilder.concatArray(jsonArry25);
            jsonArry26 = JSONFormBuilder.concatArray(jsonArry26);
            jsonArry27 = JSONFormBuilder.concatArray(jsonArry27);
            jsonArry28 = JSONFormBuilder.concatArray(jsonArry28);
            jsonArry29 = JSONFormBuilder.concatArray(jsonArry29);
            jsonArry30 = JSONFormBuilder.concatArray(jsonArry30);
            jsonArry31 = JSONFormBuilder.concatArray(jsonArry31);
            jsonArry32 = JSONFormBuilder.concatArray(jsonArry32);
            jsonArry33 = JSONFormBuilder.concatArray(jsonArry33);
            jsonArry34 = JSONFormBuilder.concatArray(jsonArry34);
            jsonArry35 = JSONFormBuilder.concatArray(jsonArry35);
            jsonArry36 = JSONFormBuilder.concatArray(jsonArry36);
            jsonArry37 = JSONFormBuilder.concatArray(jsonArry37);

            jsonArry = JSONFormBuilder.concatArray(jsonArry);

            jsonGroup = JSONFormBuilder.checkLength(jsonArry1, jsonGroup);
            jsonGroup = JSONFormBuilder.checkLength(jsonArry2, jsonGroup);
            jsonGroup = JSONFormBuilder.checkLength(jsonArry3, jsonGroup);
            jsonGroup = JSONFormBuilder.checkLength(jsonArry4, jsonGroup);
            jsonGroup = JSONFormBuilder.checkLength(jsonArry5, jsonGroup);
            jsonGroup = JSONFormBuilder.checkLength(jsonArry7, jsonGroup);
            jsonGroup = JSONFormBuilder.checkLength(jsonArry6, jsonGroup);
            jsonGroup = JSONFormBuilder.checkLength(jsonArry8, jsonGroup);
            jsonGroup = JSONFormBuilder.checkLength(jsonArry9, jsonGroup);
            jsonGroup = JSONFormBuilder.checkLength(jsonArry10, jsonGroup);
            jsonGroup = JSONFormBuilder.checkLength(jsonArry11, jsonGroup);
            jsonGroup = JSONFormBuilder.checkLength(jsonArry12, jsonGroup);
            jsonGroup = JSONFormBuilder.checkLength(jsonArry13, jsonGroup);
            jsonGroup = JSONFormBuilder.checkLength(jsonArry14, jsonGroup);
            jsonGroup = JSONFormBuilder.checkLength(jsonArry15, jsonGroup);
            jsonGroup = JSONFormBuilder.checkLength(jsonArry16, jsonGroup);
            jsonGroup = JSONFormBuilder.checkLength(jsonArry17, jsonGroup);
            jsonGroup = JSONFormBuilder.checkLength(jsonArry18, jsonGroup);
            jsonGroup = JSONFormBuilder.checkLength(jsonArry19, jsonGroup);
            jsonGroup = JSONFormBuilder.checkLength(jsonArry20, jsonGroup);
            jsonGroup = JSONFormBuilder.checkLength(jsonArry21, jsonGroup);
            jsonGroup = JSONFormBuilder.checkLength(jsonArry22, jsonGroup);
            jsonGroup = JSONFormBuilder.checkLength(jsonArry23, jsonGroup);
            jsonGroup = JSONFormBuilder.checkLength(jsonArry24, jsonGroup);
            jsonGroup = JSONFormBuilder.checkLength(jsonArry25, jsonGroup);
            jsonGroup = JSONFormBuilder.checkLength(jsonArry26, jsonGroup);
            jsonGroup = JSONFormBuilder.checkLength(jsonArry27, jsonGroup);
            jsonGroup = JSONFormBuilder.checkLength(jsonArry28, jsonGroup);
            jsonGroup = JSONFormBuilder.checkLength(jsonArry29, jsonGroup);
            jsonGroup = JSONFormBuilder.checkLength(jsonArry30, jsonGroup);
            jsonGroup = JSONFormBuilder.checkLength(jsonArry31, jsonGroup);
            jsonGroup = JSONFormBuilder.checkLength(jsonArry32, jsonGroup);
            jsonGroup = JSONFormBuilder.checkLength(jsonArry33, jsonGroup);
            jsonGroup = JSONFormBuilder.checkLength(jsonArry34, jsonGroup);
            jsonGroup = JSONFormBuilder.checkLength(jsonArry35, jsonGroup);
            jsonGroup = JSONFormBuilder.checkLength(jsonArry36, jsonGroup);
            jsonGroup = JSONFormBuilder.checkLength(jsonArry37, jsonGroup);

            if (jsonGroup.length() > 0) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("groups", jsonGroup);

                jsonArry.put(jsonObject);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonArry;
    }
}
