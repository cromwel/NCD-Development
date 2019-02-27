package org.aihdint.aihd.Resources;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import org.aihdint.aihd.MainActivity;
import org.aihdint.aihd.R;
import org.aihdint.aihd.app.CustomDividerItemDecoration;
import org.aihdint.aihd.common.NavigationDrawerShare;

public class ResourcesActivity extends AppCompatActivity {

    Button btn_pdf1, btn_pdf2, btn_pdf3;

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


        btn_pdf1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent i1 = new Intent(ResourcesActivity.this, Pdf1.class);
                startActivity(i1);

            }
        });

        btn_pdf2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent i2 = new Intent(ResourcesActivity.this, Pdf2.class);
                startActivity(i2);

            }
        });

        btn_pdf3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent i3 = new Intent(ResourcesActivity.this, Pdf3.class);
                startActivity(i3);

            }
        });
    }
}
