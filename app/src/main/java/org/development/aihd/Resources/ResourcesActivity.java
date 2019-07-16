package org.development.aihd.Resources;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import org.development.aihd.R;
import org.development.aihd.common.NavigationDrawerShare;

public class ResourcesActivity extends AppCompatActivity {

    Button btn_pdf1, btn_pdf2, btn_pdf3, btn_pdf4, btn_pdf5;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationDrawerShare navigate = new NavigationDrawerShare(this);
        navigate.createDrawer(toolbar);

        btn_pdf1=(Button)findViewById(R.id.pdf1);
        btn_pdf2=(Button)findViewById(R.id.pdf2);
        btn_pdf3=(Button)findViewById(R.id.pdf3);
        btn_pdf4=(Button)findViewById(R.id.pdf4);
        btn_pdf5=(Button)findViewById(R.id.pdf5);

        //AIHD SOPs & Job Aids.pdf
        btn_pdf1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://drive.google.com/file/d/0BwCgoCrRaZhXRjJHMjk3eU5qTFJlV3lNTF8yLVRhcm50S1hR/view?usp=sharing";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        //NCD QM EMS FAQs.pdf
        btn_pdf2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                String url = "https://docs.google.com/document/d/e/2PACX-1vQdsQKZN5D0amPPtDcMs2ulKEuTk5IK7J5vZ1aEIRGDlph1deKBX020qicYGe0cT6ulWOCCNLF8sIUG/pub";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        //NCD QM EMS Terms & Conditions.pdf
        btn_pdf3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                String url = "https://docs.google.com/document/d/e/2PACX-1vTA3YtRJpZh0SrIknBB6XTrIG3bTt1zPCT-8F2-ZE5Xqh6HVsJTzFQbo-jIdYfcQAk0g-7u75-ISDot/pub";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        //Diabetes Clinical Guidelines 2018.pdf
        btn_pdf4.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                String url = "https://drive.google.com/file/d/1s_k1fR4gXwRRpz5qOAqc8IuMTZjB5yXt/view?usp=sharing";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        //Cardiovascular Guidelines 2018.pdf
        btn_pdf5.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                String url = "https://drive.google.com/file/d/1PVfj068osz9k4AYXC-JB5mciQCt8_sCB/view?usp=sharing";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}
