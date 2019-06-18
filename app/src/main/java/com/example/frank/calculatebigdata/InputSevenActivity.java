package com.example.frank.calculatebigdata;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.frank.calculatebigdata.config.OriginData;
import com.example.frank.calculatebigdata.utils.CheckPermissionUtils;
import com.example.frank.calculatebigdata.utils.Tools;

import java.io.File;

public class  InputSevenActivity extends AppCompatActivity {
    public static String sdcardPath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/BigDataTempleData/";
    private int calculateResult=0;
    private EditText et1,et2,et3,et4,et5,et6,et7,et8,et9,et10,et11,et12,et13,et14,et15,et16;
    private String tagOP="";
    public  int []input1=new int[7];
    public  int []input2=new int[7];
    public  int []input3=new int[7];
    public  int []input4=new int[7];
    public  int []input5=new int[7];
    public  int []input6=new int[7];
    public  int []input7=new int[7];
    public  int []input8=new int[7];
    public  int []input9=new int[7];
    public  int []input10=new int[7];
    public  int []input11=new int[7];
    public  int []input12=new int[7];
    public  int []input13=new int[7];
    public  int []input14=new int[7];
    public  int []input15=new int[7];
    public  int []input16=new int[7];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_seven);

        tagOP=getIntent().getStringExtra("tag");
        et1=findViewById(R.id.et7_1);
        et2=findViewById(R.id.et7_2);
        et3=findViewById(R.id.et7_3);
        et4=findViewById(R.id.et7_4);
        et5=findViewById(R.id.et7_5);
        et6=findViewById(R.id.et7_6);
        et7=findViewById(R.id.et7_7);
        et8=findViewById(R.id.et7_8);
        et9=findViewById(R.id.et7_9);
        et10=findViewById(R.id.et7_10);
        et11=findViewById(R.id.et7_11);
        et12=findViewById(R.id.et7_12);
        et13=findViewById(R.id.et7_13);
        et14=findViewById(R.id.et7_14);
        et15=findViewById(R.id.et7_15);
        et16=findViewById(R.id.et7_16);

        final Button startbtn=findViewById(R.id.get7data);
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CheckPermissionUtils.verifyStoragePermissions(InputSevenActivity.this);
                deleteDir(sdcardPath);

                if (tagOP != null && tagOP.equals("21")) {
                    OriginData.isNotSeeven=false;
                    Tools.saveTempleData("" + et1.getText().toString(), "get7data");
                    Tools.saveTempleData("" + et2.getText().toString(), "get7data");
                    Tools.saveTempleData("" + et3.getText().toString(), "get7data");
                    Tools.saveTempleData("" + et4.getText().toString(), "get7data");
                    Tools.saveTempleData("" + et5.getText().toString(), "get7data");
                    Tools.saveTempleData("" + et6.getText().toString(), "get7data");
                    Tools.saveTempleData("" + et7.getText().toString(), "get7data");
                    Tools.saveTempleData("" + et8.getText().toString(), "get7data");
                    Tools.saveTempleData("" + et9.getText().toString(), "get7data");
                    Tools.saveTempleData("" + et10.getText().toString(), "get7data");
                    Tools.saveTempleData("" + et11.getText().toString(), "get7data");
                    Tools.saveTempleData("" + et12.getText().toString(), "get7data");
                    Tools.saveTempleData("" + et13.getText().toString(), "get7data");
                    Tools.saveTempleData("" + et14.getText().toString(), "get7data");
                    Tools.saveTempleData("" + et15.getText().toString(), "get7data");
                    Tools.saveTempleData("" + et16.getText().toString(), "get7data");
                    startActivity(new Intent(InputSevenActivity.this, InputTewteenActivity.class));
                    finish();
                }else {
                    OriginData.isNotSeeven=true;
                    startbtn.setEnabled(false);
                    Tools.saveTempleData("" + et1.getText().toString(), "get7data");
                    Tools.saveTempleData("" + et2.getText().toString(), "get7data");
                    Tools.saveTempleData("" + et3.getText().toString(), "get7data");
                    Tools.saveTempleData("" + et4.getText().toString(), "get7data");
                    Tools.saveTempleData("" + et5.getText().toString(), "get7data");
                    Tools.saveTempleData("" + et6.getText().toString(), "get7data");
                    Tools.saveTempleData("" + et7.getText().toString(), "get7data");
                    Tools.saveTempleData("" + et8.getText().toString(), "get7data");
                    Tools.saveTempleData("" + et9.getText().toString(), "get7data");
                    Tools.saveTempleData("" + et10.getText().toString(), "get7data");
                    Tools.saveTempleData("" + et11.getText().toString(), "get7data");
                    Tools.saveTempleData("" + et12.getText().toString(), "get7data");
                    Tools.saveTempleData("" + et13.getText().toString(), "get7data");
                    Tools.saveTempleData("" + et14.getText().toString(), "get7data");
                    Tools.saveTempleData("" + et15.getText().toString(), "get7data");
                    Tools.saveTempleData("" + et16.getText().toString(), "get7data");

                    String[] str1 = et1.getText().toString().trim().split(",");
                    String[] str2 = et2.getText().toString().trim().split(",");
                    String[] str3 = et3.getText().toString().trim().split(",");
                    String[] str4 = et4.getText().toString().trim().split(",");
                    String[] str5 = et5.getText().toString().trim().split(",");
                    String[] str6 = et6.getText().toString().trim().split(",");
                    String[] str7 = et7.getText().toString().trim().split(",");
                    String[] str8 = et8.getText().toString().trim().split(",");
                    String[] str9 = et9.getText().toString().trim().split(",");
                    String[] str10 = et10.getText().toString().trim().split(",");
                    String[] str11 = et11.getText().toString().trim().split(",");
                    String[] str12 = et12.getText().toString().trim().split(",");
                    String[] str13 = et13.getText().toString().trim().split(",");
                    String[] str14 = et14.getText().toString().trim().split(",");
                    String[] str15 = et15.getText().toString().trim().split(",");
                    String[] str16 = et16.getText().toString().trim().split(",");


                    for (int i = 0; i < str1.length; i++) {
                        input1[i] = Integer.parseInt(str1[i]);
                        input2[i] = Integer.parseInt(str2[i]);
                        input3[i] = Integer.parseInt(str3[i]);
                        input4[i] = Integer.parseInt(str4[i]);
                        input5[i] = Integer.parseInt(str5[i]);
                        input6[i] = Integer.parseInt(str6[i]);
                        input7[i] = Integer.parseInt(str7[i]);
                        input8[i] = Integer.parseInt(str8[i]);
                        input9[i] = Integer.parseInt(str9[i]);
                        input10[i] = Integer.parseInt(str10[i]);
                        input11[i] = Integer.parseInt(str11[i]);
                        input12[i] = Integer.parseInt(str12[i]);
                        input13[i] = Integer.parseInt(str13[i]);
                        input14[i] = Integer.parseInt(str14[i]);
                        input15[i] = Integer.parseInt(str15[i]);
                        input16[i] = Integer.parseInt(str16[i]);
                    }

                    String result1="",result2="",result3="",result4="",result5="",result6="",result7="",result8="",result9="",result10="",result11="",result12="",result13="",result14="",result15="",result16="";
                    int finalD=1;
                    for (int i = 0; i < input1.length; i++) {
                        for (int j = i + 1; j < input1.length; j++) {
                             finalD= (input1[i] + input1[j]);
                            if (finalD > 49) {
                                finalD %= 49;
                            }
                            result1+=finalD+",";

                            finalD= (input2[i] + input2[j]);
                            if (finalD > 49) {
                                finalD %= 49;
                            }
                            result2+=finalD+",";

                            finalD= (input3[i] + input3[j]);
                            if (finalD > 49) {
                                finalD %= 49;
                            }
                            result3+=finalD+",";

                            finalD= (input4[i] + input4[j]);
                            if (finalD > 49) {
                                finalD %= 49;
                            }
                            result4+=finalD+",";

                            finalD= (input5[i] + input5[j]);
                            if (finalD > 49) {
                                finalD %= 49;
                            }
                            result5+=finalD+",";

                            finalD= (input6[i] + input6[j]);
                            if (finalD > 49) {
                                finalD %= 49;
                            }
                            result6+=finalD+",";

                            finalD= (input7[i] + input7[j]);
                            if (finalD > 49) {
                                finalD %= 49;
                            }
                            result7+=finalD+",";

                            finalD= (input8[i] + input8[j]);
                            if (finalD > 49) {
                                finalD %= 49;
                            }
                            result8+=finalD+",";

                            finalD= (input9[i] + input9[j]);
                            if (finalD > 49) {
                                finalD %= 49;
                            }
                            result9+=finalD+",";


                            finalD= (input10[i] + input10[j]);
                            if (finalD > 49) {
                                finalD %= 49;
                            }
                            result10+=finalD+",";

                            finalD= (input11[i] + input11[j]);
                            if (finalD > 49) {
                                finalD %= 49;
                            }
                            result11+=finalD+",";

                            finalD= (input12[i] + input12[j]);
                            if (finalD > 49) {
                                finalD %= 49;
                            }
                            result12+=finalD+",";

                            finalD= (input13[i] + input13[j]);
                            if (finalD > 49) {
                                finalD %= 49;
                            }
                            result13+=finalD+",";

                            finalD= (input14[i] + input14[j]);
                            if (finalD > 49) {
                                finalD %= 49;
                            }
                            result14+=finalD+",";

                            finalD= (input15[i] + input15[j]);
                            if (finalD > 49) {
                                finalD %= 49;
                            }
                            result15+=finalD+",";

                            finalD= (input16[i] + input16[j]);
                            if (finalD > 49) {
                                finalD %= 49;
                            }
                            result16+=finalD+",";

                        }
                    }
                    Tools.saveTempleData(result1 + "", "get21data");
                    Tools.saveTempleData(result2 + "", "get21data");
                    Tools.saveTempleData(result3 + "", "get21data");
                    Tools.saveTempleData(result4 + "", "get21data");
                    Tools.saveTempleData(result5 + "", "get21data");
                    Tools.saveTempleData(result6 + "", "get21data");
                    Tools.saveTempleData(result7 + "", "get21data");
                    Tools.saveTempleData(result8 + "", "get21data");
                    Tools.saveTempleData(result9 + "", "get21data");
                    Tools.saveTempleData(result10 + "", "get21data");
                    Tools.saveTempleData(result11 + "", "get21data");
                    Tools.saveTempleData(result12 + "", "get21data");
                    Tools.saveTempleData(result13 + "", "get21data");
                    Tools.saveTempleData(result14 + "", "get21data");
                    Tools.saveTempleData(result15 + "", "get21data");
                    Tools.saveTempleData(result16 + "", "get21data");

                    OriginData.isNotAuCompute=true;
                    startActivity(new Intent(InputSevenActivity.this, InputComputeActivity.class));
                    finish();


                }
            }
        });

    }

    private void get21Data(){
        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                String result="";
                for (int i = 0; i < input1.length; i++) {
                    for (int j = i + 1; j < input1.length; j++) {
                        int finalD = (input1[i] + input1[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        }
                        result+=finalD+",";
//                                    Tools.saveTempleData(finalD + "", "get21data");
                                            /*if (isDiff) {
                                                //保存相同的数据标记
                                                Tools.saveRecord("<font color='red' size='18'>" + finalD + "</font>", DataResult.af11);
                                            } else {
                                                Tools.saveRecord("<font size='18'>" + finalD + "</font>", DataResult.af11);
                                            }*/
                    }
                }
                Tools.saveTempleData(result + "", "get21data");
                calculateResult++;
                if (calculateResult >= 16) {
                    OriginData.isNotAuCompute=true;
                    startActivity(new Intent(InputSevenActivity.this, InputComputeActivity.class));
                    finish();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                String result="";
                for (int i = 0; i < input2.length; i++) {
                    for (int j = i + 1; j < input2.length; j++) {
                        int finalD = (input2[i] + input2[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        }
                        result+=finalD+",";
//                                    Tools.saveTempleData(finalD + "", "get21data");
                                            /*if (isDiff) {
                                                //保存相同的数据标记
                                                Tools.saveRecord("<font color='red' size='18'>" + finalD + "</font>", DataResult.af21);
                                            } else {
                                                Tools.saveRecord("<font size='18'>" + finalD + "</font>", DataResult.af21);
                                            }*/
                    }
                }
                Tools.saveTempleData(result + "", "get21data");
                calculateResult++;
                if (calculateResult >= 16) {
                    OriginData.isNotAuCompute=true;
                    startActivity(new Intent(InputSevenActivity.this, InputComputeActivity.class));
                    finish();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                String result="";
                for (int i = 0; i < input3.length; i++) {
                    for (int j = i + 1; j < input3.length; j++) {
                        int finalD = (input3[i] + input3[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        }
                        result+=finalD+",";
//                                    Tools.saveTempleData(finalD + "", "get21data");
                                            /*if (isDiff) {
                                                //保存相同的数据标记
                                                Tools.saveRecord("<font color='red' size='18'>" + finalD + "</font>", DataResult.af31);
                                            } else {
                                                Tools.saveRecord("<font size='18'>" + finalD + "</font>", DataResult.af31);
                                            }*/
                    }
                }
                Tools.saveTempleData(result + "", "get21data");
                calculateResult++;
                if (calculateResult >= 16) {
                    OriginData.isNotAuCompute=true;
                    startActivity(new Intent(InputSevenActivity.this, InputComputeActivity.class));
                    finish();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                String result="";
                for (int i = 0; i < input4.length; i++) {
                    for (int j = i + 1; j < input4.length; j++) {
                        int finalD = (input4[i] + input4[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        }
                        result+=finalD+",";
//                                    Tools.saveTempleData(finalD + "", "get21data");
                                            /*if (isDiff) {
                                                //保存相同的数据标记
                                                Tools.saveRecord("<font color='red' size='18'>" + finalD + "</font>", DataResult.af41);
                                            } else {
                                                Tools.saveRecord("<font size='18'>" + finalD + "</font>", DataResult.af41);
                                            }*/
                    }
                }
                Tools.saveTempleData(result + "", "get21data");
                calculateResult++;
                if (calculateResult >= 16) {
                    OriginData.isNotAuCompute=true;
                    startActivity(new Intent(InputSevenActivity.this, InputComputeActivity.class));
                    finish();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                String result="";
                for (int i = 0; i < input5.length; i++) {
                    for (int j = i + 1; j < input5.length; j++) {
                        int finalD = (input5[i] + input5[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        }
                        result+=finalD+",";
//                                    Tools.saveTempleData(finalD + "", "get21data");
                                            /*if (isDiff) {
                                                //保存相同的数据标记
                                                Tools.saveRecord("<font color='red' size='18'>" + finalD + "</font>", DataResult.af41);
                                            } else {
                                                Tools.saveRecord("<font size='18'>" + finalD + "</font>", DataResult.af41);
                                            }*/
                    }
                }
                Tools.saveTempleData(result + "", "get21data");
                calculateResult++;
                if (calculateResult >= 16) {
                    OriginData.isNotAuCompute=true;
                    startActivity(new Intent(InputSevenActivity.this, InputComputeActivity.class));
                    finish();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                String result="";
                for (int i = 0; i < input6.length; i++) {
                    for (int j = i + 1; j < input6.length; j++) {
                        int finalD = (input6[i] + input6[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        }
                        result+=finalD+",";

//                                    Tools.saveTempleData(finalD + "", "get21data");
                                            /*if (isDiff) {
                                                //保存相同的数据标记
                                                Tools.saveRecord("<font color='red' size='18'>" + finalD + "</font>", DataResult.af41);
                                            } else {
                                                Tools.saveRecord("<font size='18'>" + finalD + "</font>", DataResult.af41);
                                            }*/
                    }
                }
                Tools.saveTempleData(result + "", "get21data");
                calculateResult++;
                if (calculateResult >= 16) {
                    OriginData.isNotAuCompute=true;
                    startActivity(new Intent(InputSevenActivity.this, InputComputeActivity.class));
                    finish();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                String result="";
                for (int i = 0; i < input7.length; i++) {
                    for (int j = i + 1; j < input7.length; j++) {
                        int finalD = (input7[i] + input7[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        }
                        result+=finalD+",";
//                                    Tools.saveTempleData(finalD + "", "get21data");
                                            /*if (isDiff) {
                                                //保存相同的数据标记
                                                Tools.saveRecord("<font color='red' size='18'>" + finalD + "</font>", DataResult.af41);
                                            } else {
                                                Tools.saveRecord("<font size='18'>" + finalD + "</font>", DataResult.af41);
                                            }*/
                    }
                }
                Tools.saveTempleData(result + "", "get21data");
                calculateResult++;
                if (calculateResult >= 16) {
                    OriginData.isNotAuCompute=true;
                    startActivity(new Intent(InputSevenActivity.this, InputComputeActivity.class));
                    finish();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                String result="";
                for (int i = 0; i < input8.length; i++) {
                    for (int j = i + 1; j < input8.length; j++) {
                        int finalD = (input8[i] + input8[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        }
                        result+=finalD+",";
//                                    Tools.saveTempleData(finalD + "", "get21data");
                                            /*if (isDiff) {
                                                //保存相同的数据标记
                                                Tools.saveRecord("<font color='red' size='18'>" + finalD + "</font>", DataResult.af41);
                                            } else {
                                                Tools.saveRecord("<font size='18'>" + finalD + "</font>", DataResult.af41);
                                            }*/
                    }
                }
                Tools.saveTempleData(result + "", "get21data");
                calculateResult++;
                if (calculateResult >= 16) {
                    OriginData.isNotAuCompute=true;
                    startActivity(new Intent(InputSevenActivity.this, InputComputeActivity.class));
                    finish();
                }
            }
        }).start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                String result="";
                for (int i = 0; i < input9.length; i++) {
                    for (int j = i + 1; j < input9.length; j++) {
                        int finalD = (input9[i] + input9[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        }
                        result+=finalD+",";
//                                    Tools.saveTempleData(finalD + "", "get21data");
                                            /*if (isDiff) {
                                                //保存相同的数据标记
                                                Tools.saveRecord("<font color='red' size='18'>" + finalD + "</font>", DataResult.af41);
                                            } else {
                                                Tools.saveRecord("<font size='18'>" + finalD + "</font>", DataResult.af41);
                                            }*/
                    }
                }
                Tools.saveTempleData(result + "", "get21data");
                calculateResult++;
                if (calculateResult >= 16) {
                    OriginData.isNotAuCompute=true;
                    startActivity(new Intent(InputSevenActivity.this, InputComputeActivity.class));
                    finish();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                String result="";
                for (int i = 0; i < input10.length; i++) {
                    for (int j = i + 1; j < input10.length; j++) {
                        int finalD = (input10[i] + input10[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        }
                        result+=finalD+",";
//                                    Tools.saveTempleData(finalD + "", "get21data");
                                            /*if (isDiff) {
                                                //保存相同的数据标记
                                                Tools.saveRecord("<font color='red' size='18'>" + finalD + "</font>", DataResult.af41);
                                            } else {
                                                Tools.saveRecord("<font size='18'>" + finalD + "</font>", DataResult.af41);
                                            }*/
                    }
                }
                Tools.saveTempleData(result + "", "get21data");
                calculateResult++;
                if (calculateResult >= 16) {
                    OriginData.isNotAuCompute=true;
                    startActivity(new Intent(InputSevenActivity.this, InputComputeActivity.class));
                    finish();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                String result="";
                for (int i = 0; i < input11.length; i++) {
                    for (int j = i + 1; j < input11.length; j++) {
                        int finalD = (input11[i] + input11[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        }
                        result+=finalD+",";
//                                    Tools.saveTempleData(finalD + "", "get21data");
                                            /*if (isDiff) {
                                                //保存相同的数据标记
                                                Tools.saveRecord("<font color='red' size='18'>" + finalD + "</font>", DataResult.af41);
                                            } else {
                                                Tools.saveRecord("<font size='18'>" + finalD + "</font>", DataResult.af41);
                                            }*/
                    }
                }
                Tools.saveTempleData(result + "", "get21data");
                calculateResult++;
                if (calculateResult >= 16) {
                    OriginData.isNotAuCompute=true;
                    startActivity(new Intent(InputSevenActivity.this, InputComputeActivity.class));
                    finish();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                String result="";
                for (int i = 0; i < input12.length; i++) {
                    for (int j = i + 1; j < input12.length; j++) {
                        int finalD = (input12[i] + input12[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        }
                        result+=finalD+",";
//                                    Tools.saveTempleData(finalD + "", "get21data");
                                            /*if (isDiff) {
                                                //保存相同的数据标记
                                                Tools.saveRecord("<font color='red' size='18'>" + finalD + "</font>", DataResult.af41);
                                            } else {
                                                Tools.saveRecord("<font size='18'>" + finalD + "</font>", DataResult.af41);
                                            }*/
                    }
                }
                Tools.saveTempleData(result + "", "get21data");
                calculateResult++;
                if (calculateResult >= 16) {
                    OriginData.isNotAuCompute=true;
                    startActivity(new Intent(InputSevenActivity.this, InputComputeActivity.class));
                    finish();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                String result="";
                for (int i = 0; i < input13.length; i++) {
                    for (int j = i + 1; j < input13.length; j++) {
                        int finalD = (input13[i] + input13[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        }
                        result+=finalD+",";
//                                    Tools.saveTempleData(finalD + "", "get21data");
                                            /*if (isDiff) {
                                                //保存相同的数据标记
                                                Tools.saveRecord("<font color='red' size='18'>" + finalD + "</font>", DataResult.af41);
                                            } else {
                                                Tools.saveRecord("<font size='18'>" + finalD + "</font>", DataResult.af41);
                                            }*/
                    }
                }
                Tools.saveTempleData(result + "", "get21data");
                calculateResult++;
                if (calculateResult >= 16) {
                    OriginData.isNotAuCompute=true;
                    startActivity(new Intent(InputSevenActivity.this, InputComputeActivity.class));
                    finish();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                String result="";
                for (int i = 0; i < input14.length; i++) {
                    for (int j = i + 1; j < input14.length; j++) {
                        int finalD = (input14[i] + input14[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        }
                        result+=finalD+",";
//                                    Tools.saveTempleData(finalD + "", "get21data");
                                            /*if (isDiff) {
                                                //保存相同的数据标记
                                                Tools.saveRecord("<font color='red' size='18'>" + finalD + "</font>", DataResult.af41);
                                            } else {
                                                Tools.saveRecord("<font size='18'>" + finalD + "</font>", DataResult.af41);
                                            }*/
                    }
                }
                Tools.saveTempleData(result + "", "get21data");
                calculateResult++;
                if (calculateResult >= 16) {
                    OriginData.isNotAuCompute=true;
                    startActivity(new Intent(InputSevenActivity.this, InputComputeActivity.class));
                    finish();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                String result="";
                for (int i = 0; i < input15.length; i++) {
                    for (int j = i + 1; j < input15.length; j++) {
                        int finalD = (input15[i] + input15[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        }
                        result+=finalD+",";
//                                    Tools.saveTempleData(finalD + "", "get21data");
                                            /*if (isDiff) {
                                                //保存相同的数据标记
                                                Tools.saveRecord("<font color='red' size='18'>" + finalD + "</font>", DataResult.af41);
                                            } else {
                                                Tools.saveRecord("<font size='18'>" + finalD + "</font>", DataResult.af41);
                                            }*/
                    }
                }
                Tools.saveTempleData(result + "", "get21data");
                calculateResult++;
                if (calculateResult >= 16) {
                    OriginData.isNotAuCompute=true;
                    startActivity(new Intent(InputSevenActivity.this, InputComputeActivity.class));
                    finish();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                String result="";
                for (int i = 0; i < input16.length; i++) {
                    for (int j = i + 1; j < input16.length; j++) {
                        int finalD = (input16[i] + input16[j]);

                        if (finalD > 49) {
                            finalD %= 49;
                        }
                        result+=finalD+",";
//                                        Tools.saveTempleData(finalD + "", "get21data");

                    }
                }
                Tools.saveTempleData(result + "", "get21data");
                calculateResult++;
                if (calculateResult >= 16) {
                    OriginData.isNotAuCompute=true;
                    startActivity(new Intent(InputSevenActivity.this, InputComputeActivity.class));
                    finish();
                }
            }
        }).start();
    }

    //删除文件夹和文件夹里面的文件
    public static void deleteDir(final String pPath) {
        File dir = new File(pPath);
        deleteDirWihtFile(dir);
    }

    public static void deleteDirWihtFile(File dir) {
        if (dir == null || !dir.exists() || !dir.isDirectory())
            return;
        for (File file : dir.listFiles()) {
            if (file.isFile())
                file.delete(); // 删除所有文件
            else if (file.isDirectory())
                deleteDirWihtFile(file); // 递规的方式删除文件夹
        }
        dir.delete();// 删除目录本身
    }
}
