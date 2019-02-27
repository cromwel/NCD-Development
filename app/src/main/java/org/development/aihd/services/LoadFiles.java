package org.development.aihd.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.SimpleMultiPartRequest;
import com.android.volley.toolbox.Volley;

import org.development.aihd.model.Forms;
import org.json.JSONObject;

import static org.development.aihd.app.Variables.FILE_UPLOAD_URL;

public class LoadFiles extends IntentService {

    public LoadFiles() {
        super(LoadFiles.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        if (intent != null) {
            upload(intent.getStringExtra("file_path"), intent.getLongExtra("form_id", 0));
        }

    }

    public void upload(final String filePath, final long form_id) {

        SimpleMultiPartRequest smr = new SimpleMultiPartRequest(Request.Method.POST, FILE_UPLOAD_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Upload Response", response);

                        try {
                            JSONObject jObj = new JSONObject(response);
                            boolean error = jObj.getBoolean("error");
                            if (!error) {
                                // User successfully stored in MySQL
                                // Now store the user in sqlite
                                Forms form = Forms.findById(Forms.class, form_id);
                                form.status = "1";
                                form.save();
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        //
        smr.addFile("image", filePath);
        smr.setFixedStreamingMode(true);
        smr.setOnProgressListener(new Response.ProgressListener() {
            @Override
            public void onProgress(long transferredBytes, long totalSize) {
                int percentage = (int) ((transferredBytes / ((float) totalSize)) * 100);
                Log.d("Upload Percentage ", String.valueOf(percentage));

            }
        });

        RequestQueue mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        mRequestQueue.add(smr);
    }
}
