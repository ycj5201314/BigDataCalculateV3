package com.example.frank.calculatebigdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.frank.calculatebigdata.config.OriginData;
import com.example.frank.calculatebigdata.utils.Tools;

public class InputTewteenActivity extends AppCompatActivity {

    private EditText et1,et2,et3,et4,et5,et6,et7,et8,et9,et10,et11,et12,et13,et14,et15,et16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_tewteen);

        et1=findViewById(R.id.et21_1);
        et2=findViewById(R.id.et21_2);
        et3=findViewById(R.id.et21_3);
        et4=findViewById(R.id.et21_4);
        et5=findViewById(R.id.et21_5);
        et6=findViewById(R.id.et21_6);
        et7=findViewById(R.id.et21_7);
        et8=findViewById(R.id.et21_8);
        et9=findViewById(R.id.et21_9);
        et10=findViewById(R.id.et21_10);
        et11=findViewById(R.id.et21_11);
        et12=findViewById(R.id.et21_12);
        et13=findViewById(R.id.et21_13);
        et14=findViewById(R.id.et21_14);
        et15=findViewById(R.id.et21_15);
        et16=findViewById(R.id.et21_16);

        findViewById(R.id.get21data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tools.saveTempleData(""+et1.getText().toString(), "get21data");
                Tools.saveTempleData(""+et2.getText().toString(), "get21data");
                Tools.saveTempleData(""+et3.getText().toString(), "get21data");
                Tools.saveTempleData(""+et4.getText().toString(), "get21data");
                Tools.saveTempleData(""+et5.getText().toString(), "get21data");
                Tools.saveTempleData(""+et6.getText().toString(), "get21data");
                Tools.saveTempleData(""+et7.getText().toString(), "get21data");
                Tools.saveTempleData(""+et8.getText().toString(), "get21data");
                Tools.saveTempleData(""+et9.getText().toString(), "get21data");
                Tools.saveTempleData(""+et10.getText().toString(), "get21data");
                Tools.saveTempleData(""+et11.getText().toString(), "get21data");
                Tools.saveTempleData(""+et12.getText().toString(), "get21data");
                Tools.saveTempleData(""+et13.getText().toString(), "get21data");
                Tools.saveTempleData(""+et14.getText().toString(), "get21data");
                Tools.saveTempleData(""+et15.getText().toString(), "get21data");
                Tools.saveTempleData(""+et16.getText().toString(), "get21data");
                OriginData.isNotAuCompute=true;
//                startActivity(new Intent(InputTewteenActivity.this,SelectDataActivity.class));
                startActivity(new Intent(InputTewteenActivity.this,InputComputeActivity.class));
                finish();
            }
        });
    }
}
