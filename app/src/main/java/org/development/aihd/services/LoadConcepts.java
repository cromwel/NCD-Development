package org.development.aihd.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.orm.query.Select;

import org.development.aihd.model.Concepts;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.List;

public class LoadConcepts extends IntentService {
    public LoadConcepts() {
        super(LoadConcepts.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        loadJSONConcepts();
    }


    public void loadJSONConcepts() {

        String json;

        try {

            List<Concepts> concept_count = Select.from(Concepts.class).list();
            if (concept_count.size() > 0) {
                Concepts.deleteAll(Concepts.class);
            }

            InputStream is = getAssets().open("concepts.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            //noinspection ResultOfMethodCallIgnored
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");


            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject conceptObj = jsonArray.getJSONObject(i);

                String concept_id = conceptObj.getString("Concept ID");
                String concept = conceptObj.getString("Concept");

                Concepts concepts = new Concepts(concept_id, concept);
                concepts.save();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
