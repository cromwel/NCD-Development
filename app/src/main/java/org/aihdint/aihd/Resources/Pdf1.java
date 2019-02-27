package org.aihdint.aihd.Resources;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

import org.aihdint.aihd.R;

public class Pdf1 extends AppCompatActivity {

    PDFView pdf1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf1);

        pdf1=(PDFView)findViewById(R.id.pdf_file1);
        pdf1.fromAsset("AIHD SOPs & Job Aids.pdf").load();

    }
}
