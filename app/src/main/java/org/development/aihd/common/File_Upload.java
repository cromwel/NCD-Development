package org.development.aihd.common;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.SimpleMultiPartRequest;
import com.android.volley.toolbox.Volley;

import org.development.aihd.Home;
import org.development.aihd.model.Forms;
import org.development.aihd.model.KeyValue;
import org.json.JSONObject;

import java.util.ArrayList;

import static org.development.aihd.app.Variables.FILE_UPLOAD_URL;

public class File_Upload {


    // Progress dialog
    public static ProgressDialog showProgressDialog(Context context, String message) {
        ProgressDialog m_Dialog = new ProgressDialog(context);
        m_Dialog.setMessage(message);
        m_Dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        m_Dialog.setCancelable(false);
        m_Dialog.show();
        return m_Dialog;
    }


    public static boolean connectivity(final Context mContext) {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);

        assert connectivityManager != null;
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ConnectivityManager.setProcessDefaultNetwork(null);
        }

        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }


    public static void upload(final Context mContext, final String filePath, final long form_id, ArrayList<KeyValue> keyValues) {

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

                                Toast.makeText(mContext, "Form successfully uploaded!", Toast.LENGTH_LONG).show();

                                // Launch login activity
                                Intent intent = new Intent(mContext, Home.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                mContext.startActivity(intent);
                                ((Activity) mContext).finish();
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        if (keyValues != null) {
            for (KeyValue keyValue : keyValues) {
                smr.addStringParam(keyValue.getId(), keyValue.getName());
            }
        }
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

        RequestQueue mRequestQueue = Volley.newRequestQueue(mContext);
        mRequestQueue.add(smr);
    }


    /*
    public static void testString(ArrayList<KeyValue> keyValues) {
        for (KeyValue keyValue : keyValues) {
            Log.d("KeyValue Pair ", keyValue.getId() + " : " + keyValue.getName());
        }
    }
    ArrayList<KeyValue> keyvalueParams = new ArrayList<>();

    keyvalueParams.add(new KeyValue("1540", "Employed"));
    keyvalueParams.add(new KeyValue("165170", "Unemployed"));

    File_Upload.testString(keyvalueParams);
    */
}
