package org.development.aihd.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.orm.query.Select;

import org.development.aihd.model.Location;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.List;

public class LoadLocations extends IntentService {
    public LoadLocations() {
        super(LoadLocations.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        loadJSONLocation();
    }


    public void loadJSONLocation() {

        String json;

        try {

            List<Location> location_count = Select.from(Location.class).list();
            if (location_count.size() > 0) {
                Location.deleteAll(Location.class);
            }

            InputStream is = getAssets().open("locations.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            //noinspection ResultOfMethodCallIgnored
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");


            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject locationObj = jsonArray.getJSONObject(i);

                //String location_id = locationObj.getString("location_id");
                String mfl_code = String.valueOf(locationObj.getInt("MFL Code"));
                String name = locationObj.getString("Facility Name");
                String location_id = name;
                location_id = location_id.toLowerCase();
                location_id = location_id.replace(".", "");
                location_id = location_id.replace(" ", "_");

                Location location = new Location(location_id, name, mfl_code);
                location.save();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
