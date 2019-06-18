package com.example.frank.calculatebigdata;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

import com.example.frank.calculatebigdata.config.OriginData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static com.example.frank.calculatebigdata.utils.DataResult.allTimes;
import static com.example.frank.calculatebigdata.utils.DataResult.caculateTag;

public class StepComputeActivity extends AppCompatActivity {

    //public static ConcurrentHashMap<String,String> computeDataResult=new ConcurrentHashMap<>();
//    public static HashMap<String,String> computeDataResult=new HashMap<>();
   /* public static HashMap<String,String> computeDataResult1=new HashMap<>();
    public static HashMap<String,String> computeDataResult2=new HashMap<>();
    public static HashMap<String,String> computeDataResult3=new HashMap<>();*/

    private TextView computeResultText;
    private String tagFile="";
    private  String dd="";
    private int activeCount=0,threadPoolSize=200;
//    private int caculateTag=0;

//    Executor pool= Executors.newCachedThreadPool();
//    Executor pool= Executors.newFixedThreadPool(200);
    ThreadPoolExecutor pool = new ThreadPoolExecutor(threadPoolSize, threadPoolSize, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_compute);

        computeResultText=findViewById(R.id.textView9);

        /*if (!OriginData.lookAllResult) {
            //查看部分结果
            tagFile = getIntent().getStringExtra("tag");
            computeData(tagFile);
        }else {
            //查看所有的结果
            Toast.makeText(StepComputeActivity.this,"正在计算，请稍候",Toast.LENGTH_LONG).show();
            OriginData.lookAllResult=false;
            for (int i=1;i<211;i++){
                computeDataAll(i+"");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //computeDataAll(times+"");
        }*/


//        在一个线程中调用

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                if (OriginData.hadCompute){
                    startActivity(new Intent(StepComputeActivity.this,ResultActivity.class));
                    finish();
                }else {
                    for (int i=1;i<allTimes;i++) {
                        computeDataAll("s" + i);
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();*/

//        循环调用
        /*if (caculateTag<allTimes){
//            computeResultText.setText("正在统计第"+caculateTag+"次数据，请稍候……");
            computeResultText.setText("正在统计数据，请稍候……");

            computeDataAll("s" + caculateTag);
        }else {
            startActivity(new Intent(StepComputeActivity.this,ResultActivity.class));
            finish();
        }*/

        pool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    if (OriginData.hadCompute){
                        startActivity(new Intent(StepComputeActivity.this,ResultActivity.class));
                        finish();
                    }else {
                        for (int i=1;i<211;i++){
                            computeDataAll("s"+i);

                            activeCount = pool.getActiveCount();
                            while (activeCount>=threadPoolSize-1){
                                Thread.sleep(5000);
                                activeCount = pool.getActiveCount();
                            }

                            if (i%10==0){
                                /*Thread.sleep(8000);
                                System.out.println("第一次休眠结束");
                                Thread.sleep(8000);
                                System.out.println("第二次休眠结束");*/
                                /*Thread.sleep(8000);
                                System.out.println("第一次休眠结束");
                                Thread.sleep(8000);
                                System.out.println("第二次休眠结束");*/
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });




        //最后的方案，你能够顺利执行
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                if (OriginData.index<211){
                    computeDataAll(OriginData.index+"");
                }else {
                    //startActivity(new Intent(StepComputeActivity.this,StepComputeActivity.class));
                    startActivity(new Intent(StepComputeActivity.this,ResultActivity.class));
                    finish();
                }
            }
        }).start();*/




    }

    public  void computeData(final String tag){


        new Thread(new Runnable() {
            @Override
            public void run() {

                String saveFileNameFinal[]=new String[11];
                for (int k=0;k<11;k++){
                    saveFileNameFinal[k]=SelectDataActivity.sdcardPath+(k+1)+"ChangeFinal"+tag+".txt";
                    System.out.println("保存路径："+saveFileNameFinal[k]);
                }
                try{
                    File file1 = new File(saveFileNameFinal[0]);
                    InputStreamReader inputReader1 = new InputStreamReader(new FileInputStream(file1));
                    BufferedReader bf1 = new BufferedReader(inputReader1);

                    File file2 = new File(saveFileNameFinal[1]);
                    InputStreamReader inputReader2 = new InputStreamReader(new FileInputStream(file2));
                    BufferedReader bf2 = new BufferedReader(inputReader2);

                    File file3 = new File(saveFileNameFinal[2]);
                    InputStreamReader inputReader3 = new InputStreamReader(new FileInputStream(file3));
                    BufferedReader bf3 = new BufferedReader(inputReader3);

                    File file4 = new File(saveFileNameFinal[3]);
                    InputStreamReader inputReader4 = new InputStreamReader(new FileInputStream(file4));
                    BufferedReader bf4 = new BufferedReader(inputReader4);

                    File file5 = new File(saveFileNameFinal[4]);
                    InputStreamReader inputReader5 = new InputStreamReader(new FileInputStream(file5));
                    BufferedReader bf5 = new BufferedReader(inputReader5);

                    File file6 = new File(saveFileNameFinal[5]);
                    InputStreamReader inputReader6 = new InputStreamReader(new FileInputStream(file6));
                    BufferedReader bf6 = new BufferedReader(inputReader6);

                    File file7 = new File(saveFileNameFinal[6]);
                    InputStreamReader inputReader7 = new InputStreamReader(new FileInputStream(file7));
                    BufferedReader bf7 = new BufferedReader(inputReader7);

                    File file8 = new File(saveFileNameFinal[7]);
                    InputStreamReader inputReader8 = new InputStreamReader(new FileInputStream(file8));
                    BufferedReader bf8 = new BufferedReader(inputReader8);

                    File file9 = new File(saveFileNameFinal[8]);
                    InputStreamReader inputReader9 = new InputStreamReader(new FileInputStream(file9));
                    BufferedReader bf9 = new BufferedReader(inputReader9);

                    File file10 = new File(saveFileNameFinal[9]);
                    InputStreamReader inputReader10 = new InputStreamReader(new FileInputStream(file10));
                    BufferedReader bf10 = new BufferedReader(inputReader10);

                    File file11 = new File(SelectDataActivity.sdcardPath+"11Change"+tag+".txt");
                    InputStreamReader inputReader11 = new InputStreamReader(new FileInputStream(file11));
                    BufferedReader bf11 = new BufferedReader(inputReader11);

                    String str1="",str2="",str3="",str4="",str5="",str6="",str7="",str8="",str9="",str10="",str11="";

                    while ((str1 = bf1.readLine()) != null) {
                        str2=bf2.readLine();
                        str3=bf3.readLine();
                        str4=bf4.readLine();
                        str5=bf5.readLine();
                        str6=bf6.readLine();
                        str7=bf7.readLine();
                        str8=bf8.readLine();
                        str9=bf9.readLine();
                        str10=bf10.readLine();
                        str11=bf11.readLine();

                        if(computeFrequency(str1,str2,str3,str4,str5,str6,str7,str8,str9,str10,str11)){
                            int currentD=Integer.parseInt(str11),finalD;
                            if (currentD>9){
                                finalD=currentD/10+currentD%10;

                            }else {
                                finalD=currentD;
                            }
                            finalD%=10;
                            String key="10/"+finalD+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }else if(computeFrequency(str2,str3,str4,str5,str6,str7,str8,str9,str10,str11)){
                            int currentD=Integer.parseInt(str11),finalD;
                            if (currentD>9){
                                finalD=currentD/10+currentD%10;

                            }else {
                                finalD=currentD;
                            }
                            finalD%=10;
                            String key="9/"+finalD+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }else if(computeFrequency(str3,str4,str5,str6,str7,str8,str9,str10,str11)){
                            int currentD=Integer.parseInt(str11),finalD;
                            if (currentD>9){
                                finalD=currentD/10+currentD%10;

                            }else {
                                finalD=currentD;
                            }
                            finalD%=10;
                            String key="8/"+finalD+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }else if(computeFrequency(str4,str5,str6,str7,str8,str9,str10,str11)){
                            int currentD=Integer.parseInt(str11),finalD;
                            if (currentD>9){
                                finalD=currentD/10+currentD%10;

                            }else {
                                finalD=currentD;
                            }
                            finalD%=10;
                            String key="7/"+finalD+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }else if(computeFrequency(str5,str6,str7,str8,str9,str10,str11)){
                            int currentD=Integer.parseInt(str11),finalD;
                            if (currentD>9){
                                finalD=currentD/10+currentD%10;

                            }else {
                                finalD=currentD;
                            }
                            finalD%=10;
                            String key="6/"+finalD+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }else if(computeFrequency(str6,str7,str8,str9,str10,str11)){
                            int currentD=Integer.parseInt(str11),finalD;
                            if (currentD>9){
                                finalD=currentD/10+currentD%10;

                            }else {
                                finalD=currentD;
                            }
                            finalD%=10;
                            String key="5/"+finalD+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }else if(computeFrequency(str7,str8,str9,str10,str11)){
                            int currentD=Integer.parseInt(str11),finalD;
                            if (currentD>9){
                                finalD=currentD/10+currentD%10;

                            }else {
                                finalD=currentD;
                            }
                            finalD%=10;
                            String key="4/"+finalD+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }else if(computeFrequency(str8,str9,str10,str11)){
                            int currentD=Integer.parseInt(str11),finalD;
                            if (currentD>9){
                                finalD=currentD/10+currentD%10;

                            }else {
                                finalD=currentD;
                            }
                            finalD%=10;
                            String key="3/"+finalD+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }
                        /*else if(computeFrequency(str9,str10,str11)){
                            String key="2/"+str11+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }*/

                    }
                    /*inputReader1.close();
                    bf1.close();

                    inputReader2.close();
                    bf2.close();

                    inputReader3.close();
                    bf3.close();

                    inputReader4.close();
                    bf4.close();

                    inputReader5.close();
                    bf5.close();

                    inputReader6.close();
                    bf6.close();

                    inputReader7.close();
                    bf7.close();

                    inputReader8.close();
                    bf8.close();

                    inputReader9.close();
                    bf9.close();

                    inputReader10.close();
                    bf10.close();

                    inputReader11.close();
                    bf11.close();*/

                }catch(Exception e){
                    e.printStackTrace();
                }

                OriginData.index++;
                if (OriginData.index>=211){
                    String dd="";
                    Iterator iter =OriginData.computeDataResult.entrySet().iterator();
                    while (iter.hasNext()) {
                        Map.Entry entry = (Map.Entry) iter.next();
                        dd=dd + entry.getKey()+entry.getValue()+"\n";
                    }
                    //dd=dd+"第 "+tag+" 次裂变统计完成！";
                    computeResultText.setText(dd);
                }
            }
        }).start();

    }

    public void computeDataAll(final String tagtag){


        pool.execute(new Runnable() {
            @Override
            public void run() {

                String saveFileNameFinal[]=new String[16];
                for (int k=0;k<15;k++){
                    if (OriginData.isNotSeeven){
                        saveFileNameFinal[k]=SelectDataActivity.sdcardPath + "af"+(k+1) + "3"+tagtag+".txt";
                    }else {
                        saveFileNameFinal[k]=SelectDataActivity.sdcardPath + "af"+(k+1) + "3for21"+tagtag+".txt";
                    }
//                    saveFileNameFinal[k]=SelectDataActivity.sdcardPath+(k+1)+"ChangeFinal"+tag+".txt";
                    System.out.println("保存路径："+saveFileNameFinal[k]);
                }

                if (OriginData.isNotSeeven){
                    saveFileNameFinal[15]=SelectDataActivity.sdcardPath + "a163"+tagtag+".txt";
                }else {
                    saveFileNameFinal[15]=SelectDataActivity.sdcardPath + "a163for21"+tagtag+".txt";
                }

                try{
                    File file1 = new File(saveFileNameFinal[0]);
                    InputStreamReader inputReader1 = new InputStreamReader(new FileInputStream(file1));
                    BufferedReader bf1 = new BufferedReader(inputReader1);

                    File file2 = new File(saveFileNameFinal[1]);
                    InputStreamReader inputReader2 = new InputStreamReader(new FileInputStream(file2));
                    BufferedReader bf2 = new BufferedReader(inputReader2);

                    File file3 = new File(saveFileNameFinal[2]);
                    InputStreamReader inputReader3 = new InputStreamReader(new FileInputStream(file3));
                    BufferedReader bf3 = new BufferedReader(inputReader3);

                    File file4 = new File(saveFileNameFinal[3]);
                    InputStreamReader inputReader4 = new InputStreamReader(new FileInputStream(file4));
                    BufferedReader bf4 = new BufferedReader(inputReader4);

                    File file5 = new File(saveFileNameFinal[4]);
                    InputStreamReader inputReader5 = new InputStreamReader(new FileInputStream(file5));
                    BufferedReader bf5 = new BufferedReader(inputReader5);

                    File file6 = new File(saveFileNameFinal[5]);
                    InputStreamReader inputReader6 = new InputStreamReader(new FileInputStream(file6));
                    BufferedReader bf6 = new BufferedReader(inputReader6);

                    File file7 = new File(saveFileNameFinal[6]);
                    InputStreamReader inputReader7 = new InputStreamReader(new FileInputStream(file7));
                    BufferedReader bf7 = new BufferedReader(inputReader7);

                    File file8 = new File(saveFileNameFinal[7]);
                    InputStreamReader inputReader8 = new InputStreamReader(new FileInputStream(file8));
                    BufferedReader bf8 = new BufferedReader(inputReader8);

                    File file9 = new File(saveFileNameFinal[8]);
                    InputStreamReader inputReader9 = new InputStreamReader(new FileInputStream(file9));
                    BufferedReader bf9 = new BufferedReader(inputReader9);

                    File file10 = new File(saveFileNameFinal[9]);
                    InputStreamReader inputReader10 = new InputStreamReader(new FileInputStream(file10));
                    BufferedReader bf10 = new BufferedReader(inputReader10);

                    File file11 = new File(saveFileNameFinal[10]);
                    InputStreamReader inputReader11 = new InputStreamReader(new FileInputStream(file11));
                    BufferedReader bf11 = new BufferedReader(inputReader11);

                    File file12 = new File(saveFileNameFinal[11]);
                    InputStreamReader inputReader12 = new InputStreamReader(new FileInputStream(file12));
                    BufferedReader bf12 = new BufferedReader(inputReader12);

                    File file13 = new File(saveFileNameFinal[12]);
                    InputStreamReader inputReader13 = new InputStreamReader(new FileInputStream(file13));
                    BufferedReader bf13 = new BufferedReader(inputReader13);

                    File file14 = new File(saveFileNameFinal[13]);
                    InputStreamReader inputReader14 = new InputStreamReader(new FileInputStream(file14));
                    BufferedReader bf14 = new BufferedReader(inputReader14);

                    File file15 = new File(saveFileNameFinal[14]);
                    InputStreamReader inputReader15 = new InputStreamReader(new FileInputStream(file15));
                    BufferedReader bf15 = new BufferedReader(inputReader15);

                    /*File file11 = new File(SelectDataActivity.sdcardPath+"11Change"+tag+".txt");
                    InputStreamReader inputReader11 = new InputStreamReader(new FileInputStream(file11));
                    BufferedReader bf11 = new BufferedReader(inputReader11);*/

                    File file16 = new File(saveFileNameFinal[15]);
                    InputStreamReader inputReader16= new InputStreamReader(new FileInputStream(file16));
                    BufferedReader bf16 = new BufferedReader(inputReader16);

                    String str1="",str2="",str3="",str4="",str5="",str6="",str7="",str8="",str9="",str10="",str11="",str12="",str13="",str14="",str15="",str16="";

                    while ((str1 = bf1.readLine()) != null) {
                        str2=bf2.readLine();
                        str3=bf3.readLine();
                        str4=bf4.readLine();
                        str5=bf5.readLine();
                        str6=bf6.readLine();
                        str7=bf7.readLine();
                        str8=bf8.readLine();
                        str9=bf9.readLine();
                        str10=bf10.readLine();
                        str11=bf11.readLine();
                        str12=bf12.readLine();
                        str13=bf13.readLine();
                        str14=bf14.readLine();
                        str15=bf15.readLine();
                        str16=bf16.readLine();
                        if (Integer.parseInt(str16)<1){
                            continue;
                        }

                        if(computeFrequency(str1,str2,str3,str4,str5,str6,str7,str8,str9,str10,str11,str12,str13,str14,str15,str16)){
                            int currentD=Integer.parseInt(str16),finalD;
                            if (currentD>9){
                                finalD=currentD/10+currentD%10;

                            }else {
                                finalD=currentD;
                            }
                            finalD%=10;
                            String key="15/"+finalD+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }else if(computeFrequency(str2,str3,str4,str5,str6,str7,str8,str9,str10,str11,str12,str13,str14,str15,str16)){
                            int currentD=Integer.parseInt(str16),finalD;
                            if (currentD>9){
                                finalD=currentD/10+currentD%10;

                            }else {
                                finalD=currentD;
                            }
                            finalD%=10;
                            String key="14/"+finalD+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }else if(computeFrequency(str3,str4,str5,str6,str7,str8,str9,str10,str11,str12,str13,str14,str15,str16)){
                            int currentD=Integer.parseInt(str16),finalD;
                            if (currentD>9){
                                finalD=currentD/10+currentD%10;

                            }else {
                                finalD=currentD;
                            }
                            finalD%=10;
                            String key="13/"+finalD+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }else if(computeFrequency(str4,str5,str6,str7,str8,str9,str10,str11,str12,str13,str14,str15,str16)){
                            int currentD=Integer.parseInt(str16),finalD;
                            if (currentD>9){
                                finalD=currentD/10+currentD%10;

                            }else {
                                finalD=currentD;
                            }
                            finalD%=10;
                            String key="12/"+finalD+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }else if(computeFrequency(str5,str6,str7,str8,str9,str10,str11,str12,str13,str14,str15,str16)){
                            int currentD=Integer.parseInt(str16),finalD;
                            if (currentD>9){
                                finalD=currentD/10+currentD%10;

                            }else {
                                finalD=currentD;
                            }
                            finalD%=10;
                            String key="11/"+finalD+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }else if(computeFrequency(str6,str7,str8,str9,str10,str11,str12,str13,str14,str15,str16)){
                            int currentD=Integer.parseInt(str16),finalD;
                            if (currentD>9){
                                finalD=currentD/10+currentD%10;

                            }else {
                                finalD=currentD;
                            }
                            finalD%=10;
                            String key="10/"+finalD+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }else if(computeFrequency(str7,str8,str9,str10,str11,str12,str13,str14,str15,str16)){
                            int currentD=Integer.parseInt(str16),finalD;
                            if (currentD>9){
                                finalD=currentD/10+currentD%10;

                            }else {
                                finalD=currentD;
                            }
                            finalD%=10;
                            String key="9/"+finalD+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }/*else if(computeFrequency(str3,str4,str5,str6,str7,str8,str9,str10,str11)){
                            int currentD=Integer.parseInt(str11),finalD;
                            if (currentD>9){
                                finalD=currentD/10+currentD%10;

                            }else {
                                finalD=currentD;
                            }
                            finalD%=10;
                            String key="8/"+finalD+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }else if(computeFrequency(str4,str5,str6,str7,str8,str9,str10,str11)){
                            int currentD=Integer.parseInt(str11),finalD;
                            if (currentD>9){
                                finalD=currentD/10+currentD%10;

                            }else {
                                finalD=currentD;
                            }
                            finalD%=10;
                            String key="7/"+finalD+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }else if(computeFrequency(str5,str6,str7,str8,str9,str10,str11)){
                            int currentD=Integer.parseInt(str11),finalD;
                            if (currentD>9){
                                finalD=currentD/10+currentD%10;

                            }else {
                                finalD=currentD;
                            }
                            finalD%=10;
                            String key="6/"+finalD+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }else if(computeFrequency(str6,str7,str8,str9,str10,str11)){
                            int currentD=Integer.parseInt(str11),finalD;
                            if (currentD>9){
                                finalD=currentD/10+currentD%10;

                            }else {
                                finalD=currentD;
                            }
                            finalD%=10;
                            String key="5/"+finalD+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }else if(computeFrequency(str7,str8,str9,str10,str11)){
                            int currentD=Integer.parseInt(str11),finalD;
                            if (currentD>9){
                                finalD=currentD/10+currentD%10;

                            }else {
                                finalD=currentD;
                            }
                            finalD%=10;
                            String key="4/"+finalD+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }else if(computeFrequency(str8,str9,str10,str11)){
                            int currentD=Integer.parseInt(str11),finalD;
                            if (currentD>9){
                                finalD=currentD/10+currentD%10;

                            }else {
                                finalD=currentD;
                            }
                            finalD%=10;
                            String key="3/"+finalD+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }
                        else if(computeFrequency(str9,str10,str11)){
                            String key="2/"+str11+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }*/

                    }
                    inputReader1.close();
                    bf1.close();

                    inputReader2.close();
                    bf2.close();

                    inputReader3.close();
                    bf3.close();

                    inputReader4.close();
                    bf4.close();

                    inputReader5.close();
                    bf5.close();

                    inputReader6.close();
                    bf6.close();

                    inputReader7.close();
                    bf7.close();

                    inputReader8.close();
                    bf8.close();

                    inputReader9.close();
                    bf9.close();

                    inputReader10.close();
                    bf10.close();

                    inputReader11.close();
                    bf11.close();

                }catch(Exception e){
                    e.printStackTrace();
                }

                caculateTag++;
                if (caculateTag>=allTimes-1){
                    OriginData.hadCompute=true;
                    startActivity(new Intent(StepComputeActivity.this,ResultActivity.class));
                    finish();
                }/*else {
                    startActivity(new Intent(StepComputeActivity.this,StepComputeActivity.class));
                    finish();
                }*/



                /*OriginData.index++;
                if (OriginData.index>=210){
                    startActivity(new Intent(StepComputeActivity.this,ResultActivity.class));
                    finish();
                }*/
                /*else {
                    startActivity(new Intent(StepComputeActivity.this,StepComputeActivity.class));
                    finish();
                }*/


               /* if (index<211){
                    computeDataAll(index+"");
                }*/
            }
        });

    }

    public static boolean computeFrequency(String a,String b,String c,String d,String e,String f,String g,String h,String i,
                                           String j,String k,String l,String m,String n,String o,String p){
        boolean tag=false;
        if(a.contains("color=")&&b.contains("color=")&&c.contains("color=")&&d.contains("color=")&&e.contains("color=")
                &&f.contains("color=")&&g.contains("color=")&&h.contains("color=")&&i.contains("color=")&&j.contains("color=")
                &&k.contains("color=")&&l.contains("color=")&&m.contains("color=")&&n.contains("color=")&&o.contains("color=")){
            tag=true;
        }
        return tag;
    }
    public static boolean computeFrequency(String a,String b,String c,String d,String e,String f,String g,String h,String i,
                                           String j,String k,String l,String m,String n,String o){
        boolean tag=false;
        if(a.contains("color=")&&b.contains("color=")&&c.contains("color=")&&d.contains("color=")&&e.contains("color=")
                &&f.contains("color=")&&g.contains("color=")&&h.contains("color=")&&i.contains("color=")&&j.contains("color=")
                &&k.contains("color=")&&l.contains("color=")&&m.contains("color=")&&n.contains("color=")){
            tag=true;
        }
        return tag;
    }
    public static boolean computeFrequency(String a,String b,String c,String d,String e,String f,String g,String h,String i,
                                           String j,String k,String l,String m,String n){
        boolean tag=false;
        if(a.contains("color=")&&b.contains("color=")&&c.contains("color=")&&d.contains("color=")&&e.contains("color=")
                &&f.contains("color=")&&g.contains("color=")&&h.contains("color=")&&i.contains("color=")&&j.contains("color=")
                &&k.contains("color=")&&l.contains("color=")&&m.contains("color=")){
            tag=true;
        }
        return tag;
    }
    public static boolean computeFrequency(String a,String b,String c,String d,String e,String f,String g,String h,String i,
                                           String j,String k,String l,String m){
        boolean tag=false;
        if(a.contains("color=")&&b.contains("color=")&&c.contains("color=")&&d.contains("color=")&&e.contains("color=")
                &&f.contains("color=")&&g.contains("color=")&&h.contains("color=")&&i.contains("color=")&&j.contains("color=")
                &&k.contains("color=")&&l.contains("color=")){
            tag=true;
        }
        return tag;
    }
    public static boolean computeFrequency(String a,String b,String c,String d,String e,String f,String g,String h,String i,
                                           String j,String k,String l){
        boolean tag=false;
        if(a.contains("color=")&&b.contains("color=")&&c.contains("color=")&&d.contains("color=")&&e.contains("color=")
                &&f.contains("color=")&&g.contains("color=")&&h.contains("color=")&&i.contains("color=")&&j.contains("color=")&&k.contains("color=")){
            tag=true;
        }
        return tag;
    }

    public static boolean computeFrequency(String a,String b,String c,String d,String e,String f,String g,String h,String i,String j,String k){
        boolean tag=false;
        if(a.contains("color=")&&b.contains("color=")&&c.contains("color=")&&d.contains("color=")&&e.contains("color=")
                &&f.contains("color=")&&g.contains("color=")&&h.contains("color=")&&i.contains("color=")&&j.contains("color=")){
            tag=true;
        }
        return tag;
    }

    public static boolean computeFrequency(String a,String b,String c,String d,String e,String f,String g,String h,String i,String j){
        boolean tag=false;
        if(a.contains("color=")&&b.contains("color=")&&c.contains("color=")&&d.contains("color=")&&e.contains("color=")
                &&f.contains("color=")&&g.contains("color=")&&h.contains("color=")&&i.contains("color=")){
            tag=true;
        }
        return tag;
    }

    public static boolean computeFrequency(String a,String b,String c,String d,String e,String f,String g,String h,String i){
        boolean tag=false;
        if(a.contains("color=")&&b.contains("color=")&&c.contains("color=")&&d.contains("color=")&&e.contains("color=")
                &&f.contains("color=")&&g.contains("color=")&&h.contains("color=")){
            tag=true;
        }
        return tag;
    }

    public static boolean computeFrequency(String a,String b,String c,String d,String e,String f,String g,String h){
        boolean tag=false;
        if(a.contains("color=")&&b.contains("color=")&&c.contains("color=")&&d.contains("color=")&&e.contains("color=")
                &&f.contains("color=")&&g.contains("color=")){
            tag=true;
        }
        return tag;
    }
    public static boolean computeFrequency(String a,String b,String c,String d,String e,String f,String g){
        boolean tag=false;
        if(a.contains("color=")&&b.contains("color=")&&c.contains("color=")&&d.contains("color=")&&e.contains("color=")
                &&f.contains("color=")){
            tag=true;
        }
        return tag;
    }
    public static boolean computeFrequency(String a,String b,String c,String d,String e,String f){
        boolean tag=false;
        if(a.contains("color=")&&b.contains("color=")&&c.contains("color=")&&d.contains("color=")&&e.contains("color=")){
            tag=true;
        }
        return tag;
    }
    public static boolean computeFrequency(String a,String b,String c,String d,String e){
        boolean tag=false;
        if(a.contains("color=")&&b.contains("color=")&&c.contains("color=")&&d.contains("color=")){
            tag=true;
        }
        return tag;
    }

    public static boolean computeFrequency(String a,String b,String c,String d){
        boolean tag=false;
        if(a.contains("color=")&&b.contains("color=")&&c.contains("color=")){
            tag=true;
        }
        return tag;
    }


    public static boolean computeFrequency(String a,String b,String c){
        boolean tag=false;
        if(a.contains("color=")&&b.contains("color=")){
            tag=true;
        }
        return tag;
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode==event.KEYCODE_BACK){
            new AlertDialog.Builder(StepComputeActivity.this).setTitle("系统提示")
                    .setMessage("数据正在计算，您是否确定要终止运行？")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    }).setNegativeButton("取消",null).show();
        }
        return super.onKeyDown(keyCode, event);
    }
}
