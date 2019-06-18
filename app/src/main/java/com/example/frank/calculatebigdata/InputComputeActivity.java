package com.example.frank.calculatebigdata;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.frank.calculatebigdata.config.OriginData;
import com.example.frank.calculatebigdata.utils.CheckPermissionUtils;
import com.example.frank.calculatebigdata.utils.DataResult;
import com.example.frank.calculatebigdata.utils.Tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class InputComputeActivity extends AppCompatActivity {
    private String sevenSourcePath="",tweenSourcePath="";
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

    public  int []input21=new int[21];
    public  int []input22=new int[21];
    public  int []input23=new int[21];
    public  int []input24=new int[21];
    public  int []input25=new int[21];
    public  int []input26=new int[21];
    public  int []input27=new int[21];
    public  int []input28=new int[21];
    public  int []input29=new int[21];
    public  int []input210=new int[21];
    public  int []input211=new int[21];
    public  int []input212=new int[21];
    public  int []input213=new int[21];
    public  int []input214=new int[21];
    public  int []input215=new int[21];
    public  int []input216=new int[21];
    public  int calculateResult=0;
    public static String sdcardPath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/BigDataCalculateAll/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_compute);

        CheckPermissionUtils.verifyStoragePermissions(InputComputeActivity.this);
        deleteDir(sdcardPath);
        OriginData.hadCompute=false;
        /*new Thread(new Runnable() {
            @Override
            public void run() {*/
                if (OriginData.isNotAuCompute){
                    OriginData.isNotAuCompute=false;
                    sevenSourcePath=InputSevenActivity.sdcardPath+"get7data.txt";
                    tweenSourcePath=InputSevenActivity.sdcardPath+"get21data.txt";
                    System.out.println("开始计算……");
                    Log.e("qq", "onCreate: 开始计算……" );
                    clickStart();
                }else {
                    OriginData.isNotAuCompute=false;
                    sevenSourcePath=SelectDataActivity.sevenSourcePath;
                    tweenSourcePath=SelectDataActivity.tweenSourcePath;
                    clickStart();
                }
         /*   }
        }).start();*/

    }

    private void clickStart(){


        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    File file = new File(sevenSourcePath);
                    InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
                    BufferedReader bf = new BufferedReader(inputReader);
                    String str= "";
                    str = bf.readLine();
                    String []data=str.split(",");
                    for (int i=0;i<data.length;i++){
                        input1[i]=Integer.parseInt(data[i]);
                    }

                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<data.length;i++){
                        input2[i]=Integer.parseInt(data[i]);
                    }
                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<data.length;i++){
                        input3[i]=Integer.parseInt(data[i]);
                    }

                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<data.length;i++){
                        input4[i]=Integer.parseInt(data[i]);
                    }

                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<data.length;i++){
                        input5[i]=Integer.parseInt(data[i]);
                    }

                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<data.length;i++){
                        input6[i]=Integer.parseInt(data[i]);
                    }

                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<data.length;i++){
                        input7[i]=Integer.parseInt(data[i]);
                    }

                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<data.length;i++){
                        input8[i]=Integer.parseInt(data[i]);
                    }
                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<data.length;i++){
                        input9[i]=Integer.parseInt(data[i]);
                    }
                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<data.length;i++){
                        input10[i]=Integer.parseInt(data[i]);
                    }
                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<data.length;i++){
                        input11[i]=Integer.parseInt(data[i]);
                    }
                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<data.length;i++){
                        input12[i]=Integer.parseInt(data[i]);
                    }
                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<data.length;i++){
                        input13[i]=Integer.parseInt(data[i]);
                    }
                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<data.length;i++){
                        input14[i]=Integer.parseInt(data[i]);
                    }
                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<data.length;i++){
                        input15[i]=Integer.parseInt(data[i]);
                    }
                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<data.length;i++){
                        input16[i]=Integer.parseInt(data[i]);
                    }

                    bf.close();
                    inputReader.close();

                }catch (Exception e){
                    e.printStackTrace();
                }


                try {
                    File file = new File(tweenSourcePath);
                    InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
                    BufferedReader bf = new BufferedReader(inputReader);
                    String str= "";
                    str = bf.readLine();
                    String []data=str.split(",");
                    for (int i=0;i<21;i++){
                        input21[i]=Integer.parseInt(data[i]);
                    }

                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<21;i++){
                        input22[i]=Integer.parseInt(data[i]);
                    }
                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<21;i++){
                        input23[i]=Integer.parseInt(data[i]);
                    }

                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<21;i++){
                        input24[i]=Integer.parseInt(data[i]);
                    }

                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<21;i++){
                        input25[i]=Integer.parseInt(data[i]);
                    }

                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<21;i++){
                        input26[i]=Integer.parseInt(data[i]);
                    }

                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<21;i++){
                        input27[i]=Integer.parseInt(data[i]);
                    }

                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<21;i++){
                        input28[i]=Integer.parseInt(data[i]);
                    }
                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<21;i++){
                        input29[i]=Integer.parseInt(data[i]);
                    }
                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<21;i++){
                        input210[i]=Integer.parseInt(data[i]);
                    }
                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<21;i++){
                        input211[i]=Integer.parseInt(data[i]);
                    }
                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<21;i++){
                        input212[i]=Integer.parseInt(data[i]);
                    }

                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<21;i++){
                        input213[i]=Integer.parseInt(data[i]);
                    }
                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<21;i++){
                        input214[i]=Integer.parseInt(data[i]);
                    }
                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<21;i++){
                        input215[i]=Integer.parseInt(data[i]);
                    }
                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<21;i++){
                        input216[i]=Integer.parseInt(data[i]);
                    }
                    bf.close();
                    inputReader.close();

                }catch (Exception e){
                    e.printStackTrace();
                }

                if (OriginData.isNotSeeven){
                    System.out.println("开始裂变……");
                    Log.e("qq", "run: 开始裂变……");
                    startChange1();


                }else {
                    startChange2();
                }


            }
        }).start();
    }

    private void startChange1(){
        //7个数的裂变。

        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input1.length; i++) {
                    for (int j = i + 1; j < input1.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input1[i] + input1[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input2)) {
                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a11);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af11);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af11);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a11 + ".txt", DataResult.a12, input2, DataResult.af12);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a12 + ".txt", DataResult.a13, input2, DataResult.af13);

                calculateResult++;
                System.out.println("当前值："+calculateResult);

                if (calculateResult >= 16) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);

//                    startAddData();
                    startActivity(new Intent(InputComputeActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input2.length; i++) {
                    for (int j = i + 1; j < input2.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input2[i] + input2[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input3)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a21);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af21);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af21);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a21 + ".txt", DataResult.a22, input3, DataResult.af22);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a22 + ".txt", DataResult.a23, input3, DataResult.af23);

                calculateResult++;
                System.out.println("当前值："+calculateResult);

                if (calculateResult >= 16) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(InputComputeActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input3.length; i++) {
                    for (int j = i + 1; j < input3.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input3[i] + input3[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input4)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a31);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af31);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af31);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a31 + ".txt", DataResult.a32, input4, DataResult.af32);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a32 + ".txt", DataResult.a33, input4, DataResult.af33);

                calculateResult++;
                System.out.println("当前值："+calculateResult);

                if (calculateResult >= 16) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(InputComputeActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input4.length; i++) {
                    for (int j = i + 1; j < input4.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input4[i] + input4[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input5)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a41);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af41);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af41);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a41 + ".txt", DataResult.a42, input5, DataResult.af42);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a42 + ".txt", DataResult.a43, input5, DataResult.af43);

                calculateResult++;
                System.out.println("当前值："+calculateResult);

                if (calculateResult >= 16) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(InputComputeActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input5.length; i++) {
                    for (int j = i + 1; j < input5.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input5[i] + input5[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input6)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a51);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af51);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af51);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a51 + ".txt", DataResult.a52, input6, DataResult.af52);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a52 + ".txt", DataResult.a53, input6, DataResult.af53);

                calculateResult++;
                System.out.println("当前值："+calculateResult);

                if (calculateResult >= 16) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(InputComputeActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input6.length; i++) {
                    for (int j = i + 1; j < input6.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input6[i] + input6[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input7)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a61);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af61);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af61);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a61 + ".txt", DataResult.a62, input7, DataResult.af62);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a62 + ".txt", DataResult.a63, input7, DataResult.af63);

                calculateResult++;
                System.out.println("当前值："+calculateResult);

                if (calculateResult >= 16) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(InputComputeActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input7.length; i++) {
                    for (int j = i + 1; j < input7.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input7[i] + input7[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input8)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a71);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af71);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af71);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a71 + ".txt", DataResult.a72, input8, DataResult.af72);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a72 + ".txt", DataResult.a73, input8, DataResult.af73);

                calculateResult++;
                System.out.println("当前值："+calculateResult);

                if (calculateResult >= 16) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(InputComputeActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input8.length; i++) {
                    for (int j = i + 1; j < input8.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input8[i] + input8[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input9)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a81);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af81);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af81);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a81 + ".txt", DataResult.a82, input9, DataResult.af82);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a82 + ".txt", DataResult.a83, input9, DataResult.af83);

                calculateResult++;
                System.out.println("当前值："+calculateResult);

                if (calculateResult >= 16) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(InputComputeActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input9.length; i++) {
                    for (int j = i + 1; j < input9.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input9[i] + input9[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input10)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a91);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af91);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af91);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a91 + ".txt", DataResult.a92, input10, DataResult.af92);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a92 + ".txt", DataResult.a93, input10, DataResult.af93);

                calculateResult++;
                System.out.println("当前值："+calculateResult);

                if (calculateResult >= 16) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(InputComputeActivity.this,ComputeAllActivity.class));
                    finish();
                }

                startChange11();
            }
        }).start();



    }

    private void startChange11(){
        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input10.length; i++) {
                    for (int j = i + 1; j < input10.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input10[i] + input10[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input11)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a101);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af101);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af101);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a101 + ".txt", DataResult.a102, input11, DataResult.af102);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a102 + ".txt", DataResult.a103, input11, DataResult.af103);

                calculateResult++;
                System.out.println("当前值："+calculateResult);

                if (calculateResult >= 16) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(InputComputeActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input11.length; i++) {
                    for (int j = i + 1; j < input11.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input11[i] + input11[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input12)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a111);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af111);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af111);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a111 + ".txt", DataResult.a112, input12, DataResult.af112);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a112 + ".txt", DataResult.a113, input12, DataResult.af113);

                calculateResult++;
                System.out.println("当前值："+calculateResult);

                if (calculateResult >= 16) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(InputComputeActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input12.length; i++) {
                    for (int j = i + 1; j < input12.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input12[i] + input12[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input13)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a121);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af121);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af121);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a121 + ".txt", DataResult.a122, input13, DataResult.af122);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a122 + ".txt", DataResult.a123, input13, DataResult.af123);

                calculateResult++;
                System.out.println("当前值："+calculateResult);

                if (calculateResult >= 16) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(InputComputeActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input13.length; i++) {
                    for (int j = i + 1; j < input13.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input13[i] + input13[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input14)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a131);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af131);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af131);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a131 + ".txt", DataResult.a132, input14, DataResult.af132);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a132 + ".txt", DataResult.a133, input14, DataResult.af133);

                calculateResult++;
                System.out.println("当前值："+calculateResult);

                if (calculateResult >= 16) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(InputComputeActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input14.length; i++) {
                    for (int j = i + 1; j < input14.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input14[i] + input14[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input15)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a141);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af141);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af141);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a141 + ".txt", DataResult.a142, input15, DataResult.af142);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a142 + ".txt", DataResult.a143, input15, DataResult.af143);

                calculateResult++;
                System.out.println("当前值："+calculateResult);
                if (calculateResult >= 16) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(InputComputeActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input15.length; i++) {
                    for (int j = i + 1; j < input15.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input15[i] + input15[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input16)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a151);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af151);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af151);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a151 + ".txt", DataResult.a152, input16, DataResult.af152);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a152 + ".txt", DataResult.a153, input16, DataResult.af153);

                calculateResult++;
                System.out.println("当前值："+calculateResult);

                if (calculateResult >= 16) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(InputComputeActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input16.length; i++) {
                    for (int j = i + 1; j < input16.length; j++) {
                        int finalD = (input16[i] + input16[j]);
                        if (finalD>0) {
                            if (finalD > 49) {
                                finalD %= 49;
                            }
                            Tools.saveRecordData(finalD + "", DataResult.a161);
                        }else {
                            Tools.saveRecordData(49 + "", DataResult.a161);
                        }
                    }
                }

                //第二次裂变
                caculateDataLast(sdcardPath + DataResult.a161 + ".txt", DataResult.a162);
                //第三次裂变
                caculateDataLast(sdcardPath + DataResult.a162 + ".txt", DataResult.a163);

                calculateResult++;
                System.out.println("当前值："+calculateResult);

                if (calculateResult >= 16) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);

//                    startAddData();
                    startActivity(new Intent(InputComputeActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        }).start();

    }


    private void startChange2(){
        // 21个数的裂变

        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input21.length; i++) {
                    boolean isDiff = false;
                    if (isDifferent(input21[i], input2)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(input21[i] + "", DataResult.a11for21);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + input21[i] + "</font>", DataResult.af11for21);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + input21[i] + "</font>", DataResult.af11for21);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a11for21 + ".txt", DataResult.a12for21, input2, DataResult.af12for21);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a12for21 + ".txt", DataResult.a13for21, input2, DataResult.af13for21);

                calculateResult++;
                System.out.println("当前值："+calculateResult);

                if (calculateResult >= 16) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(InputComputeActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input22.length; i++) {
                    boolean isDiff = false;
                    if (isDifferent(input22[i], input3)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(input22[i] + "", DataResult.a21for21);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + input22[i] + "</font>", DataResult.af21for21);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + input22[i] + "</font>", DataResult.af21for21);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a21for21 + ".txt", DataResult.a22for21, input3, DataResult.af22for21);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a22for21 + ".txt", DataResult.a23for21, input3, DataResult.af23for21);

                calculateResult++;
                System.out.println("当前值："+calculateResult);

                if (calculateResult >= 16) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(InputComputeActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input23.length; i++) {
                    boolean isDiff = false;
                    if (isDifferent(input23[i], input4)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(input23[i] + "", DataResult.a31for21);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + input23[i] + "</font>", DataResult.af31for21);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + input23[i] + "</font>", DataResult.af31for21);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a31for21 + ".txt", DataResult.a32for21, input4, DataResult.af32for21);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a32for21 + ".txt", DataResult.a33for21, input4, DataResult.af33for21);

                calculateResult++;
                System.out.println("当前值："+calculateResult);

                if (calculateResult >= 16) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(InputComputeActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input24.length; i++) {
                    boolean isDiff = false;
                    if (isDifferent(input24[i], input5)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(input24[i] + "", DataResult.a41for21);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + input24[i] + "</font>", DataResult.af41for21);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + input24[i] + "</font>", DataResult.af41for21);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a41for21 + ".txt", DataResult.a42for21, input5, DataResult.af42for21);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a42for21 + ".txt", DataResult.a43for21, input5, DataResult.af43for21);

                calculateResult++;
                System.out.println("当前值："+calculateResult);

                if (calculateResult >= 16) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(InputComputeActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input25.length; i++) {
                    boolean isDiff = false;
                    if (isDifferent(input25[i], input6)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(input25[i] + "", DataResult.a51for21);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + input25[i] + "</font>", DataResult.af51for21);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + input25[i] + "</font>", DataResult.af51for21);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a51for21 + ".txt", DataResult.a52for21, input6, DataResult.af52for21);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a52for21 + ".txt", DataResult.a53for21, input6, DataResult.af53for21);

                calculateResult++;
                System.out.println("当前值："+calculateResult);

                if (calculateResult >= 16) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(InputComputeActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input26.length; i++) {
                    boolean isDiff = false;
                    if (isDifferent(input26[i], input7)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(input26[i] + "", DataResult.a61for21);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + input26[i] + "</font>", DataResult.af61for21);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + input26[i] + "</font>", DataResult.af61for21);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a61for21 + ".txt", DataResult.a62for21, input7, DataResult.af62for21);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a62for21 + ".txt", DataResult.a63for21, input7, DataResult.af63for21);

                calculateResult++;
                System.out.println("当前值："+calculateResult);

                if (calculateResult >= 16) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(InputComputeActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input27.length; i++) {
                    boolean isDiff = false;
                    if (isDifferent(input27[i], input8)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(input27[i] + "", DataResult.a71for21);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + input27[i] + "</font>", DataResult.af71for21);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + input27[i] + "</font>", DataResult.af71for21);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a71for21 + ".txt", DataResult.a72for21, input8, DataResult.af72for21);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a72for21 + ".txt", DataResult.a73for21, input8, DataResult.af73for21);

                calculateResult++;
                System.out.println("当前值："+calculateResult);

                if (calculateResult >= 16) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(InputComputeActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input28.length; i++) {
                    boolean isDiff = false;
                    if (isDifferent(input28[i], input9)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(input28[i] + "", DataResult.a81for21);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + input28[i] + "</font>", DataResult.af81for21);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + input28[i] + "</font>", DataResult.af81for21);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a81for21 + ".txt", DataResult.a82for21,input9, DataResult.af82for21);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a82for21 + ".txt", DataResult.a83for21, input9, DataResult.af83for21);

                calculateResult++;
                System.out.println("当前值："+calculateResult);

                if (calculateResult >= 16) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(InputComputeActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input29.length; i++) {
                    boolean isDiff = false;
                    if (isDifferent(input29[i], input10)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(input29[i] + "", DataResult.a91for21);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + input29[i] + "</font>", DataResult.af91for21);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + input29[i] + "</font>", DataResult.af91for21);
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a91for21 + ".txt", DataResult.a92for21, input10, DataResult.af92for21);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a92for21 + ".txt", DataResult.a93for21, input10, DataResult.af93for21);

                calculateResult++;
                System.out.println("当前值："+calculateResult);

                if (calculateResult >= 16) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(InputComputeActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        }).start();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input210.length; i++) {
                    boolean isDiff = false;
                    if (isDifferent(input210[i], input11)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(input210[i] + "", DataResult.a101for21);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + input210[i] + "</font>", DataResult.af101for21);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + input210[i] + "</font>", DataResult.af101for21);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a101for21 + ".txt", DataResult.a102for21, input11, DataResult.af102for21);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a102for21 + ".txt", DataResult.a103for21, input11, DataResult.af103for21);

                calculateResult++;
                System.out.println("当前值："+calculateResult);

                if (calculateResult >= 16) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(InputComputeActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input211.length; i++) {
                    boolean isDiff = false;
                    if (isDifferent(input211[i], input12)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(input211[i] + "", DataResult.a111for21);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + input211[i] + "</font>", DataResult.af111for21);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + input211[i] + "</font>", DataResult.af111for21);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a111for21 + ".txt", DataResult.a112for21, input12, DataResult.af112for21);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a112for21 + ".txt", DataResult.a113for21, input12, DataResult.af113for21);

                calculateResult++;
                System.out.println("当前值："+calculateResult);

                if (calculateResult >= 16) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(InputComputeActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input212.length; i++) {
                    boolean isDiff = false;
                    if (isDifferent(input212[i], input13)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(input212[i] + "", DataResult.a121for21);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + input212[i] + "</font>", DataResult.af121for21);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + input212[i] + "</font>", DataResult.af121for21);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a121for21 + ".txt", DataResult.a122for21, input13, DataResult.af122for21);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a122for21 + ".txt", DataResult.a123for21, input13, DataResult.af123for21);

                calculateResult++;
                System.out.println("当前值："+calculateResult);

                if (calculateResult >= 16) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(InputComputeActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input213.length; i++) {
                    boolean isDiff = false;
                    if (isDifferent(input213[i], input14)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(input213[i] + "", DataResult.a131for21);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + input213[i] + "</font>", DataResult.af131for21);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + input213[i] + "</font>", DataResult.af131for21);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a131for21 + ".txt", DataResult.a132for21, input14, DataResult.af132for21);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a132for21 + ".txt", DataResult.a133for21, input14, DataResult.af133for21);

                calculateResult++;
                System.out.println("当前值："+calculateResult);

                if (calculateResult >= 16) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(InputComputeActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input214.length; i++) {
                    boolean isDiff = false;
                    if (isDifferent(input214[i], input15)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(input214[i] + "", DataResult.a141for21);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + input214[i] + "</font>", DataResult.af141for21);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + input214[i] + "</font>", DataResult.af141for21);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a141for21 + ".txt", DataResult.a142for21, input15, DataResult.af142for21);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a142for21 + ".txt", DataResult.a143for21, input15, DataResult.af143for21);

                calculateResult++;
                System.out.println("当前值："+calculateResult);

                if (calculateResult >= 16) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(InputComputeActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input215.length; i++) {
                    boolean isDiff = false;
                    if (isDifferent(input215[i], input16)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(input215[i] + "", DataResult.a151for21);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + input215[i] + "</font>", DataResult.af151for21);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + input215[i] + "</font>", DataResult.af151for21);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a151for21 + ".txt", DataResult.a152for21, input16, DataResult.af152for21);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a152for21 + ".txt", DataResult.a153for21, input16, DataResult.af153for21);

                calculateResult++;
                System.out.println("当前值："+calculateResult);

                if (calculateResult >= 16) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(InputComputeActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input216.length; i++) {

                    if (input216[i] > 49) {
                        input216[i] %= 49;
                    }
                    Tools.saveRecordFor21Data(input216[i] + "", DataResult.a161for21);

                }

                //第二次裂变
                caculateDataLast(sdcardPath + DataResult.a161for21 + ".txt", DataResult.a162for21);
                //第三次裂变
                caculateDataLast(sdcardPath + DataResult.a162for21 + ".txt", DataResult.a163for21);

                calculateResult++;
                System.out.println("当前值："+calculateResult);

                if (calculateResult >= 16) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);

//                    startAddData();

                    startActivity(new Intent(InputComputeActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        }).start();

    }

    private void startAddData() {

        //開始累积加，进行存储
        for (int k=1;k<11;k++){
            String fileName1=sdcardPath+"a"+k+"2"+".txt";
            String fileName2=sdcardPath+"a"+k+"2for21"+".txt";

            int []input=input1;
            if (k==1){
                input=input2;
            }else if (k==2){
                input=input3;
            }else if (k==3){
                input=input4;
            }else if (k==4){
                input=input5;
            }else if (k==5){
                input=input6;
            }else if (k==6){
                input=input7;
            }else if (k==7){
                input=input8;
            }else if (k==8){
                input=input9;
            }else if (k==9){
                input=input10;
            }else if (k==10){
                input=input11;
            }
            try {
                File file1 = new File(fileName1);
                File file2 = new File(fileName2);
                InputStreamReader inputReader1 = new InputStreamReader(new FileInputStream(file1));
                BufferedReader bf1 = new BufferedReader(inputReader1);

                // 按行读取字符串
                String str, strTem;
                int a = 0,b=0,tag=0,index=0;
                //两个循环分别得到两万一千个数的和。
                while ((str = bf1.readLine()) != null) {
                    index++;
                    InputStreamReader inputReader2 = new InputStreamReader(new FileInputStream(file2));
                    BufferedReader bf2 = new BufferedReader(inputReader2);
                    String saveFileName=k+"Change"+index;
                    String saveFileNameFinal=k+"ChangeFinal"+index;


                    while ((strTem=bf2.readLine())!=null){
                        a=Integer.parseInt(str);
                        b=Integer.parseInt(strTem);
                        boolean isDiff=false;
                        int finalD=a+b;

                        //进行数据判断
                        if(finalD>49){
                            finalD%=49;
                            if (a!=49&&b!=49){
                                if(isDifferent(finalD,input)){
                                    isDiff=true;
                                }
                            }
                        }else{
                            if(isDifferent(finalD,input)){
                                isDiff=true;
                            }
                        }
                        Tools.saveRecordData(finalD+"", saveFileName);
                        if(isDiff){
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>"+finalD+"</font>", saveFileNameFinal);
                        }else{
                            Tools.saveRecordData("<font size='18'>"+finalD+"</font>", saveFileNameFinal);
                        }

                    }
                    bf2.close();
                    inputReader2.close();

                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }


        try {
            File file = new File(sdcardPath+"a112"+".txt");
            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
            BufferedReader bf = new BufferedReader(inputReader);

            // 按行读取字符串
            String str,strTem;
            int tag=0,index=0;
            while ((str = bf.readLine()) != null) {
                index++;
                File file2 = new File(sdcardPath+"a112for21"+".txt");
                InputStreamReader inputReaderTem=new InputStreamReader(new FileInputStream(file2));
                BufferedReader bfTem=new BufferedReader(inputReaderTem);
                while((strTem = bfTem.readLine()) != null) {
                    int finalD=Integer.parseInt(str)+Integer.parseInt(strTem);
                    //进行数据判断
                    if(finalD>49){
                        finalD%=49;
                    }
                    Tools.saveRecordData(finalD+"", "11Change"+index);
                }
                bfTem.close();
                inputReaderTem.close();
            }

            bf.close();
            inputReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        startActivity(new Intent(InputComputeActivity.this,ComputeAllActivity.class));
        finish();


    }

    public static void caculateData(String originFileName,String newFileName,int[] input,String finalFileName){
        try {
            File file = new File(originFileName);
            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
            BufferedReader bf = new BufferedReader(inputReader);

            InputStreamReader inputReaderTem=null;
            BufferedReader bfTem=null;

            // 按行读取字符串
            String str,strTem;
            int tag=0;
            while ((str = bf.readLine()) != null) {
                tag++;
                if(bfTem!=null){
                    bfTem.close();
                }
                if(inputReaderTem!=null){
                    inputReaderTem.close();
                }

                inputReaderTem=new InputStreamReader(new FileInputStream(file));
                bfTem= new BufferedReader(inputReaderTem);
                for(int k=0;k<tag;k++){
                    if((strTem = bfTem.readLine()) != null){

                    }else{
                        return;
                        //break;
                    }
                }

                int originD=Integer.parseInt(str);
                while((strTem = bfTem.readLine()) != null) {
                    boolean isDiff=false;
                    int finalD=originD+Integer.parseInt(strTem);
                    //进行数据判断
                    if(finalD>49){
                        finalD%=49;
                        if (originD!=49&&Integer.parseInt(strTem)!=49){
                            if(isDifferent(finalD,input)){
                                isDiff=true;
                            }
                        }
                    }else{
                        if(isDifferent(finalD,input)){

                            isDiff=true;
                        }
                    }
                    /*int currentD=finalD;
                    if (currentD>9){
                        finalD=currentD/10+currentD%10;

                    }else {
                        finalD=currentD;
                    }
                    finalD%=10;*/
                    Tools.saveRecordData(finalD+"", newFileName);
                    if(isDiff){
                        //保存相同的数据标记
                        Tools.saveRecordData("<font color='red' size='18'>"+finalD+"</font>", finalFileName);
                    }else{
                        Tools.saveRecordData("<font size='18'>"+finalD+"</font>", finalFileName);
                    }
                }
            }
            bf.close();
            inputReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void caculateDataLast(String originFileName,String newFileName){
        try {
            File file = new File(originFileName);
            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
            BufferedReader bf = new BufferedReader(inputReader);

            InputStreamReader inputReaderTem=null;
            BufferedReader bfTem=null;


            // 按行读取字符串
            String str,strTem;
            int tag=0;
            while ((str = bf.readLine()) != null) {
                tag++;
                if(bfTem!=null){
                    bfTem.close();
                }
                if(inputReaderTem!=null){
                    inputReaderTem.close();
                }

                inputReaderTem=new InputStreamReader(new FileInputStream(file));
                bfTem= new BufferedReader(inputReaderTem);
                for(int k=0;k<tag;k++){
                    if((strTem = bfTem.readLine()) != null){

                    }else{
                        return;
                    }
                }

                int originD=Integer.parseInt(str);
                while((strTem = bfTem.readLine()) != null) {
                    int finalD=originD+Integer.parseInt(strTem);
                    if (finalD>0) {
                        //进行数据判断
                        if (finalD > 49) {
                            finalD %= 49;
                        }
                        /*int currentD=finalD;
                        if (currentD>9){
                            finalD=currentD/10+currentD%10;

                        }else {
                            finalD=currentD;
                        }
                        finalD%=10;*/
                        Tools.saveRecordData(finalD + "", newFileName);
                    }else {
                        Tools.saveRecordData(49 + "", newFileName);
                    }
                }
            }
            bf.close();
            inputReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static boolean isDifferent (int currentD,int[]dataSet){
        boolean tag=false;
        int finalD=0;
        if (currentD>9){
            finalD=currentD/10+currentD%10;

        }else {
            finalD=currentD;
        }
        finalD%=10;
        for(int i=0;i<dataSet.length;i++){
            if(finalD==(dataSet[i]%10)){
                tag=true;
                break;
            }
        }
        return !tag;
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
