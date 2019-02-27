package org.aihdint.aihd;

/*
 * Developed by Rodney on 02/03/2018.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.StringRequest;

import org.aihdint.aihd.common.Alerts;
import org.aihdint.aihd.common.File_Upload;
import org.aihdint.aihd.app.AppController;
import org.aihdint.aihd.app.Variables;
import org.aihdint.aihd.services.LoadPatients;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static org.aihdint.aihd.common.Alerts.hideDialog;


public class Login extends Activity {
    private static final String TAG = Login.class.getSimpleName();
    private EditText inputUsername;
    private EditText inputPassword;
    //private SessionManager session;
    private LinearLayout linearLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        linearLayout = findViewById(R.id.linearLayout);

        inputUsername = findViewById(R.id.username);
        inputPassword = findViewById(R.id.password);

    }


    public void login(View view) {

        String username = inputUsername.getText().toString().trim();
        String password = inputPassword.getText().toString().trim();

        // Check for empty data in the form
        //&& !location_id.isEmpty()
        if (!username.isEmpty() && !password.isEmpty()) {
            // login user
            boolean isConnected = File_Upload.connectivity(getApplicationContext());

            if (isConnected) {
                loginServer(username, password);
            } else {
                Alerts.errorMessage(linearLayout, "No Internet Connection,Unable to Log In");
            }

        } else {
            // Prompt user to enter credentials
            Alerts.errorMessage(linearLayout, "Please enter your credentials!");
        }
    }

    /**
     * function to verify login details in mysql db
     */
    private void loginServer(final String username, final String password) {
        // Tag used to cancel the request
        String tag_string_req = "req_login";

        Alerts.progressDialog(this, "Logging in ...");

        StringRequest strReq = new StringRequest(Request.Method.GET,
                Variables.LOGIN_URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Login Response: " + response);
                hideDialog();

                try {
                    JSONObject jObj = new JSONObject(response);
                    String authenticated = jObj.getString("authenticated");

                    // Check for error node in json
                    if (authenticated.matches("true")) {
                        // user successfully logged in

                        // Now store the user in SQLite
                        //String uuid = jObj.getString("uid");

                        JSONObject user = jObj.getJSONObject("user");
                        String name = user.getString("display");
                        String uuid = user.getString("uuid");

                        LoadLocation(uuid, name);

                    } else {
                        // Error in login. Get the error message
                        Alerts.errorMessage(linearLayout, "Username/Password Invalid");
                    }
                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Login Error: " + error.getMessage());
                Alerts.errorMessage(linearLayout, "Unable to Log In. Contact System administrator");
                hideDialog();
            }
        }) {

            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> headers = new HashMap<>();
                String credentials = username + ":" + password;
                String auth = "Basic "
                        + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
                headers.put("Content-Type", "application/json");
                headers.put("Authorization", auth);
                return headers;
            }


            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                // since we don't know which of the two underlying network vehicles
                // will Volley use, we have to handle and store session cookies manually
                Log.i("response", response.headers.toString());
                Map<String, String> responseHeaders = response.headers;
                String rawCookies = responseHeaders.get("Set-Cookie");
                Log.i("cookies", rawCookies);
                return super.parseNetworkResponse(response);
            }

        };

        //Adding request to request queue
        AppController.getInstance().getRequestQueue().getCache().clear();
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }


    private void LoadLocation(final String uuid, final String name) {

        StringRequest req = new StringRequest(Request.Method.POST, Variables.LOGIN_LOCATION, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    Log.d("Location", response);
                    JSONObject jsonObj = new JSONObject(response);

                    boolean error = jsonObj.getBoolean("error");
                    if (!error) {

                        JSONObject locations = jsonObj.getJSONObject("message");
                        String mfl = locations.getString("mfl");
                        String location_name = locations.getString("name");

                        Intent servicePatients = new Intent(getApplicationContext(), LoadPatients.class);
                        servicePatients.putExtra("uuid", uuid);
                        servicePatients.putExtra("mfl", mfl);
                        startService(servicePatients);

                        // Create login session
                        AppController.getInstance().getSessionManager().setLogin(true);
                        AppController.getInstance().getSessionManager().createLogin(uuid, name, location_name, mfl);
                        //session.setLogin(true);
                        //session.createLogin(uuid, name, location_name, mfl);

                        // Launch main activity
                        Intent intent = new Intent(Login.this, Home.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Alerts.errorMessage(linearLayout, jsonObj.getString("message"));
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
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> params = new HashMap<>();
                params.put("uuid", uuid);

                JSONObject JSONparams = new JSONObject(params);
                Log.d("Params", JSONparams.toString());

                return params;
            }

        };
        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(req);

    }
}