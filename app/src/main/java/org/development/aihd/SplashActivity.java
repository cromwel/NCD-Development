package org.development.aihd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import org.development.aihd.app.AppController;
import org.development.aihd.introSlider.IntroActivity;
import org.development.aihd.services.LoadConcepts;
import org.development.aihd.services.LoadLocations;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onStart() {
        super.onStart();

        // Check if user is already logged in or not
        if (AppController.getInstance().getSessionManager().isIntro()) {
            // User is already logged in. Take him to main activity
            Intent intent = new Intent(SplashActivity.this, Login.class);
            startActivity(intent);
            //finish();
        } else {
            Intent serviceConcept = new Intent(this, LoadConcepts.class);
            startService(serviceConcept);

            Intent serviceLocation = new Intent(this, LoadLocations.class);
            startService(serviceLocation);

            Intent intent = new Intent(SplashActivity.this, IntroActivity.class);
            startActivity(intent);
        }
    }
}
