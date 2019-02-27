package org.aihdint.aihd.introSlider;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.karan.churi.PermissionManager.PermissionManager;

import org.aihdint.aihd.Login;
import org.aihdint.aihd.R;
import org.aihdint.aihd.app.AppController;

import agency.tango.materialintroscreen.MaterialIntroActivity;
import agency.tango.materialintroscreen.SlideFragmentBuilder;
import agency.tango.materialintroscreen.animations.IViewTranslation;

public class IntroActivity extends MaterialIntroActivity {

protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enableLastSlideAlphaExitTransition(true);

        getBackButtonTranslationWrapper()
                .setEnterTranslation(new IViewTranslation() {
                    @Override
                    public void translate(View view, @FloatRange(from = 0, to = 1.0) float percentage) {
                        view.setAlpha(percentage);
                    }
                });

        addSlide(new CustomSlide());

        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.yellow)
                .buttonsColor(R.color.permission_buttons)
                .possiblePermissions(new String[]{})
                .neededPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_NETWORK_STATE})
                .image(R.drawable.logo)
                .title("Permissions required")
                .description("1. File Access: Photos, media and \nfiles on device \n2. Storage Access: Read and modify \ncontents of the SD \n3. Network Access: full network access,\nview network connections \n4. System Function: Control vibration")
                .build());
    }

    @Override
    public void onFinish() {
        super.onFinish();

        AppController.getInstance().getSessionManager().setIntro(true);

        Intent intent = new Intent(IntroActivity.this, Login.class);
        startActivity(intent);
    }
}