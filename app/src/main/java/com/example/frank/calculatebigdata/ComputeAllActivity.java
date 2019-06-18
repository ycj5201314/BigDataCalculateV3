package com.example.frank.calculatebigdata;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.frank.calculatebigdata.config.OriginData;
import com.example.frank.calculatebigdata.utils.DataResult;
import com.example.frank.calculatebigdata.utils.Tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static com.example.frank.calculatebigdata.utils.DataResult.allTimes;
import static com.example.frank.calculatebigdata.utils.DataResult.cycleTimes;
import static com.example.frank.calculatebigdata.utils.DataResult.calculateResult;
import static com.example.frank.calculatebigdata.utils.DataResult.excuteTimes;
import static com.example.frank.calculatebigdata.utils.DataResult.resultTag;

public class ComputeAllActivity extends AppCompatActivity {

    private ListView lv_trip_info;
    private MyAdapter myAdapter;

    private String sevenSourcePath="",tweenSourcePath="";
    public static String sdcardPath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/BigDataCalculateAll/";
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

   /* public  int []origin_input1=new int[7];
    public  int []origin_input2=new int[7];
    public  int []origin_input3=new int[7];
    public  int []origin_input4=new int[7];
    public  int []origin_input5=new int[7];
    public  int []origin_input6=new int[7];
    public  int []origin_input7=new int[7];
    public  int []origin_input8=new int[7];
    public  int []origin_input9=new int[7];
    public  int []origin_input10=new int[7];
    public  int []origin_input11=new int[7];
    public  int []origin_input12=new int[7];
    public  int []origin_input13=new int[7];
    public  int []origin_input14=new int[7];
    public  int []origin_input15=new int[7];
    public  int []origin_input16=new int[7];*/

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

    private TextView tiptext;
//    private int countExcute=1;
    private int countExcute=21;
    private int activeCount=0,threadPoolSize=200;

    //    private int cycleTimes=15,excuteTimes=16;
//    private int calculateResult=0;
//    Executor pool= Executors.newCachedThreadPool();
//    Executor pool= Executors.newFixedThreadPool(200);
    ThreadPoolExecutor pool = new ThreadPoolExecutor(threadPoolSize, threadPoolSize, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compute_all);

        allTimes+=21;
        if (allTimes>210){
            allTimes=211;
        }
        cycleTimes=allTimes-1;
        excuteTimes=allTimes;

        lv_trip_info=findViewById(R.id.lv_compute_result);
        myAdapter=new MyAdapter(ComputeAllActivity.this);
        //Log.i("图片url", "onCreate: "+SecondHInfo.sencondHandInfo.getPicUrl());
        lv_trip_info.setAdapter(myAdapter);
        lv_trip_info.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*OriginData.lookAllResult=true;
                Intent intent=new Intent(ComputeAllActivity.this,StepComputeActivity.class);
                intent.putExtra("tag",(position+1)+"");
                startActivity(intent);*/
            }
        });

        tiptext=findViewById(R.id.textView12);
        String info="";
//        myAdapter.list.add("查看全部统计结果");
        //分组统计结果
        /*for (int i=1;i<212;i++){
            info="第 "+i+" 组统计结果";
            myAdapter.list.add(info);
        }*/

        //myAdapter.notifyDataSetChanged();
        sevenSourcePath=InputSevenActivity.sdcardPath+"get7data.txt";
        tweenSourcePath=InputSevenActivity.sdcardPath+"get21data.txt";


//        循环调用
        if (resultTag<excuteTimes){
//            tiptext.setText("正在计算第 "+resultTag+" 组数据，请稍候……");
            tiptext.setText("正在计算数据，请稍候……");
            clickStart();
        }else {
            startActivity(new Intent(ComputeAllActivity.this,StepComputeActivity.class));
            finish();
        }




    }


    //累积210个数加 7个数，得到新的210组数，开始新的裂变
    private void startChange() throws IOException {
        pool.execute(new Runnable() {
            @Override
            public void run() {


                int i=1;
                String addTag="";
                if (OriginData.isNotSeeven){

                }else {
                    addTag="for21" ;
                }
                String filePath1=SelectDataActivity.sdcardPath +DataResult.a12+addTag+".txt";
                String filePath2=SelectDataActivity.sdcardPath +DataResult.a22+addTag+".txt";
                String filePath3=SelectDataActivity.sdcardPath +DataResult.a32+addTag+".txt";
                String filePath4=SelectDataActivity.sdcardPath +DataResult.a42+addTag+".txt";
                String filePath5=SelectDataActivity.sdcardPath +DataResult.a52+addTag+".txt";
                String filePath6=SelectDataActivity.sdcardPath +DataResult.a62+addTag+".txt";
                String filePath7=SelectDataActivity.sdcardPath +DataResult.a72+addTag+".txt";
                String filePath8=SelectDataActivity.sdcardPath +DataResult.a82+addTag+".txt";
                String filePath9=SelectDataActivity.sdcardPath +DataResult.a92+addTag+".txt";
                String filePath10=SelectDataActivity.sdcardPath +DataResult.a102+addTag+".txt";
                String filePath11=SelectDataActivity.sdcardPath +DataResult.a112+addTag+".txt";
                String filePath12=SelectDataActivity.sdcardPath +DataResult.a122+addTag+".txt";
                String filePath13=SelectDataActivity.sdcardPath +DataResult.a132+addTag+".txt";
                String filePath14=SelectDataActivity.sdcardPath +DataResult.a142+addTag+".txt";
                String filePath15=SelectDataActivity.sdcardPath +DataResult.a152+addTag+".txt";
                String filePath16=SelectDataActivity.sdcardPath +DataResult.a162+addTag+".txt";
                try {


                    File file = new File(filePath1);
                    InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
                    BufferedReader bf1 = new BufferedReader(inputReader);
                    String str1= "",str2="",str3="",str4="",str5="",str6="",str7="",str8="",str9="",str10="",str11="",str12="",str13="",str14="",str15="",str16="";
                    BufferedReader bf2= new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath2))));
                    BufferedReader bf3= new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath3))));
                    BufferedReader bf4= new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath4))));
                    BufferedReader bf5= new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath5))));
                    BufferedReader bf6= new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath6))));
                    BufferedReader bf7= new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath7))));
                    BufferedReader bf8= new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath8))));
                    BufferedReader bf9= new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath9))));
                    BufferedReader bf10= new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath10))));
                    BufferedReader bf11= new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath11))));
                    BufferedReader bf12= new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath12))));
                    BufferedReader bf13= new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath13))));
                    BufferedReader bf14= new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath14))));
                    BufferedReader bf15= new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath15))));
                    BufferedReader bf16= new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath16))));

                    while ((str1 = bf1.readLine()) != null&&i<excuteTimes) {
                        if (i<resultTag){
                            i++;
                            continue;
                        }
                        str2= bf2.readLine();
                        str3= bf3.readLine();
                        str4= bf4.readLine();
                        str5= bf5.readLine();
                        str6= bf6.readLine();
                        str7= bf7.readLine();
                        str8= bf8.readLine();
                        str9= bf9.readLine();
                        str10= bf10.readLine();
                        str11= bf11.readLine();
                        str12= bf12.readLine();
                        str13= bf13.readLine();
                        str14= bf14.readLine();
                        str15= bf15.readLine();
                        str16= bf16.readLine();



                        resultTag++;
                        if (OriginData.isNotSeeven){
                            startChange1(i,str1,str2,str3,str4,str5,str6,str7,str8,str9,str10,str11,str12,str13,str14,str15,str16);

                        }else {
                            startChange2(i,str1,str2,str3,str4,str5,str6,str7,str8,str9,str10,str11,str12,str13,str14,str15,str16);

                        }


                        /*if (resultTag%10==0){
                            try {
                                Thread.sleep(8000);
                                System.out.println("第一次休眠结束");
                                Thread.sleep(8000);
                                System.out.println("第二次休眠结束");
                                Thread.sleep(8000);
                                System.out.println("第三次休眠结束");
                                Thread.sleep(8000);
                                System.out.println("第三次休眠结束");


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }*/


                        activeCount = pool.getActiveCount();
                        while (activeCount>=threadPoolSize-1){
                            Thread.sleep(5000);
                            activeCount = pool.getActiveCount();
                        }


                    }


                }catch (Exception e){

                }

            }
        });

    }


    private class MyAdapter extends BaseAdapter {

        private LayoutInflater layoutInflater;
        List<String> list=new ArrayList<>();

        public MyAdapter(Context context){
            this.layoutInflater=LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            final ViewHolder holder;
            if (convertView==null){
                convertView=layoutInflater.inflate(R.layout.item_compute,null);
                holder=new ViewHolder();
                holder.computeResult=convertView.findViewById(R.id.btn_item_compute);


                convertView.setTag(holder);
            }
            else {
                holder=(ViewHolder)convertView.getTag();
            }

            holder.computeResult.setText(""+list.get(position));

            holder.computeResult.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.computeResult.setEnabled(false);
                    OriginData.lookAllResult=true;
                    Intent intent=new Intent(ComputeAllActivity.this,StepComputeActivity.class);
                    intent.putExtra("tag",(position+1)+"");
                    startActivity(intent);
                    holder.computeResult.setEnabled(true);
                }
            });


            return convertView;
        }
    }

    public final class ViewHolder{
        public Button computeResult;

    }




    private void clickStart(){

        pool.execute(new Runnable() {
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
                    for (int i=0;i<data.length;i++){
                        input21[i]=Integer.parseInt(data[i]);
                    }

                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<data.length;i++){
                        input22[i]=Integer.parseInt(data[i]);
                    }
                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<data.length;i++){
                        input23[i]=Integer.parseInt(data[i]);
                    }

                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<data.length;i++){
                        input24[i]=Integer.parseInt(data[i]);
                    }

                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<data.length;i++){
                        input25[i]=Integer.parseInt(data[i]);
                    }

                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<data.length;i++){
                        input26[i]=Integer.parseInt(data[i]);
                    }

                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<data.length;i++){
                        input27[i]=Integer.parseInt(data[i]);
                    }

                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<data.length;i++){
                        input28[i]=Integer.parseInt(data[i]);
                    }
                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<data.length;i++){
                        input29[i]=Integer.parseInt(data[i]);
                    }
                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<data.length;i++){
                        input210[i]=Integer.parseInt(data[i]);
                    }
                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<data.length;i++){
                        input211[i]=Integer.parseInt(data[i]);
                    }
                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<data.length;i++){
                        input212[i]=Integer.parseInt(data[i]);
                    }

                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<data.length;i++){
                        input213[i]=Integer.parseInt(data[i]);
                    }
                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<data.length;i++){
                        input214[i]=Integer.parseInt(data[i]);
                    }
                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<data.length;i++){
                        input215[i]=Integer.parseInt(data[i]);
                    }
                    str = bf.readLine();
                    data=str.split(",");
                    for (int i=0;i<data.length;i++){
                        input216[i]=Integer.parseInt(data[i]);
                    }
                    bf.close();
                    inputReader.close();

                }catch (Exception e){
                    e.printStackTrace();
                }

                try {
                    startChange();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                /*if (OriginData.isNotSeeven){
                    startChange1();
                }else {
                    startChange2();
                }*/


            }
        });
    }



    private void startChange1(final int tag, final String str1, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final String str8, final String str9, final String str10, final String str11, final String str12, final String str13, final String str14, final String str15, final String str16){
        //7个数的裂变。

//        pool.execute();
        pool.execute(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input1.length; i++) {
                    for (int j = i + 1; j < input1.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input1[i] + input1[j])+Integer.parseInt(str1);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input2)) {
                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a11+"s"+tag);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af11+"s"+tag);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af11+"s"+tag);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a11+"s"+tag + ".txt", DataResult.a12+"s"+tag, input2, DataResult.af12+"s"+tag);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a12+"s"+tag + ".txt", DataResult.a13+"s"+tag, input2, DataResult.af13+"s"+tag);

                calculateResult++;
                if (calculateResult >= 16*cycleTimes) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);

//                    startAddData();
                    startActivity(new Intent(ComputeAllActivity.this,StepComputeActivity.class));
                    finish();
//                    myAdapter.notifyDataSetChanged();
                }else if (calculateResult%(16*countExcute)==0){
                    startActivity(new Intent(ComputeAllActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input2.length; i++) {
                    for (int j = i + 1; j < input2.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input2[i] + input2[j])+Integer.parseInt(str2);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input3)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a21+"s"+tag);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af21+"s"+tag);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af21+"s"+tag);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a21 +"s"+tag+ ".txt", DataResult.a22+"s"+tag, input3, DataResult.af22+"s"+tag);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a22 +"s"+tag+ ".txt", DataResult.a23+"s"+tag, input3, DataResult.af23+"s"+tag);

                calculateResult++;
                if (calculateResult >= 16*cycleTimes) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(ComputeAllActivity.this,StepComputeActivity.class));
                    finish();
//                    myAdapter.notifyDataSetChanged();
                }else if (calculateResult%(16*countExcute)==0){
                    startActivity(new Intent(ComputeAllActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input3.length; i++) {
                    for (int j = i + 1; j < input3.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input3[i] + input3[j])+Integer.parseInt(str3);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input4)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a31+"s"+tag);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af31+"s"+tag);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af31+"s"+tag);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a31+"s"+tag + ".txt", DataResult.a32+"s"+tag, input4, DataResult.af32+"s"+tag);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a32 +"s"+tag+ ".txt", DataResult.a33+"s"+tag, input4, DataResult.af33+"s"+tag);

                calculateResult++;
                if (calculateResult >= 16*cycleTimes) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(ComputeAllActivity.this,StepComputeActivity.class));
                    finish();
//                    myAdapter.notifyDataSetChanged();
                }else if (calculateResult%(16*countExcute)==0){
                    startActivity(new Intent(ComputeAllActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input4.length; i++) {
                    for (int j = i + 1; j < input4.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input4[i] + input4[j])+Integer.parseInt(str4);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input5)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a41+"s"+tag);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af41+"s"+tag);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af41+"s"+tag);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a41+"s"+tag + ".txt", DataResult.a42+"s"+tag, input5, DataResult.af42+"s"+tag);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a42 +"s"+tag+ ".txt", DataResult.a43+"s"+tag, input5, DataResult.af43+"s"+tag);

                calculateResult++;
                if (calculateResult >= 16*cycleTimes) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(ComputeAllActivity.this,StepComputeActivity.class));
                    finish();
//                    myAdapter.notifyDataSetChanged();
                }else if (calculateResult%(16*countExcute)==0){
                    startActivity(new Intent(ComputeAllActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input5.length; i++) {
                    for (int j = i + 1; j < input5.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input5[i] + input5[j])+Integer.parseInt(str5);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input6)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a51+"s"+tag);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af51+"s"+tag);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af51+"s"+tag);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a51+"s"+tag + ".txt", DataResult.a52+"s"+tag, input6, DataResult.af52+"s"+tag);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a52 +"s"+tag+ ".txt", DataResult.a53+"s"+tag, input6, DataResult.af53+"s"+tag);

                calculateResult++;
                if (calculateResult >= 16*cycleTimes) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(ComputeAllActivity.this,StepComputeActivity.class));
                    finish();
//                    myAdapter.notifyDataSetChanged();
                }else if (calculateResult%(16*countExcute)==0){
                    startActivity(new Intent(ComputeAllActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input6.length; i++) {
                    for (int j = i + 1; j < input6.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input6[i] + input6[j])+Integer.parseInt(str6);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input7)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a61+"s"+tag);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af61+"s"+tag);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af61+"s"+tag);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a61 +"s"+tag+ ".txt", DataResult.a62+"s"+tag, input7, DataResult.af62+"s"+tag);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a62 +"s"+tag+ ".txt", DataResult.a63+"s"+tag, input7, DataResult.af63+"s"+tag);

                calculateResult++;
                if (calculateResult >= 16*cycleTimes) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(ComputeAllActivity.this,StepComputeActivity.class));
                    finish();
//                    myAdapter.notifyDataSetChanged();
                }else if (calculateResult%(16*countExcute)==0){
                    startActivity(new Intent(ComputeAllActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input7.length; i++) {
                    for (int j = i + 1; j < input7.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input7[i] + input7[j])+Integer.parseInt(str7);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input8)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a71+"s"+tag);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af71+"s"+tag);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af71+"s"+tag);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a71 +"s"+tag+ ".txt", DataResult.a72+"s"+tag, input8, DataResult.af72+"s"+tag);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a72 +"s"+tag+ ".txt", DataResult.a73+"s"+tag, input8, DataResult.af73+"s"+tag);

                calculateResult++;
                if (calculateResult >= 16*cycleTimes) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(ComputeAllActivity.this,StepComputeActivity.class));
                    finish();
//                    myAdapter.notifyDataSetChanged();
                }else if (calculateResult%(16*countExcute)==0){
                    startActivity(new Intent(ComputeAllActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input8.length; i++) {
                    for (int j = i + 1; j < input8.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input8[i] + input8[j])+Integer.parseInt(str8);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input9)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a81+"s"+tag);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af81+"s"+tag);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af81+"s"+tag);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a81 +"s"+tag+ ".txt", DataResult.a82+"s"+tag, input9, DataResult.af82+"s"+tag);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a82 +"s"+tag+ ".txt", DataResult.a83+"s"+tag, input9, DataResult.af83+"s"+tag);

                calculateResult++;
                if (calculateResult >= 16*cycleTimes) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(ComputeAllActivity.this,StepComputeActivity.class));
                    finish();
//                    myAdapter.notifyDataSetChanged();
                }else if (calculateResult%(16*countExcute)==0){
                    startActivity(new Intent(ComputeAllActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input9.length; i++) {
                    for (int j = i + 1; j < input9.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input9[i] + input9[j])+Integer.parseInt(str9);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input10)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a91+"s"+tag);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af91+"s"+tag);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af91+"s"+tag);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a91 +"s"+tag+ ".txt", DataResult.a92+"s"+tag, input10, DataResult.af92+"s"+tag);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a92+"s"+tag + ".txt", DataResult.a93+"s"+tag, input10, DataResult.af93+"s"+tag);

                calculateResult++;
                if (calculateResult >= 16*cycleTimes) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(ComputeAllActivity.this,StepComputeActivity.class));
                    finish();
//                    myAdapter.notifyDataSetChanged();
                }else if (calculateResult%(16*countExcute)==0){
                    startActivity(new Intent(ComputeAllActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input10.length; i++) {
                    for (int j = i + 1; j < input10.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input10[i] + input10[j])+Integer.parseInt(str10);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input11)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a101+"s"+tag);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af101+"s"+tag);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af101+"s"+tag);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a101 +"s"+tag+ ".txt", DataResult.a102+"s"+tag, input11, DataResult.af102+"s"+tag);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a102 +"s"+tag+ ".txt", DataResult.a103+"s"+tag, input11, DataResult.af103+"s"+tag);

                calculateResult++;
                if (calculateResult >= 16*cycleTimes) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(ComputeAllActivity.this,StepComputeActivity.class));
                    finish();
//                    myAdapter.notifyDataSetChanged();
                }else if (calculateResult%(16*countExcute)==0){
                    startActivity(new Intent(ComputeAllActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input11.length; i++) {
                    for (int j = i + 1; j < input11.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input11[i] + input11[j])+Integer.parseInt(str11);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input12)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a111+"s"+tag);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af111+"s"+tag);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af111+"s"+tag);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a111 +"s"+tag+ ".txt", DataResult.a112+"s"+tag, input12, DataResult.af112+"s"+tag);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a112 +"s"+tag+ ".txt", DataResult.a113+"s"+tag, input12, DataResult.af113+"s"+tag);

                calculateResult++;
                if (calculateResult >= 16*cycleTimes) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(ComputeAllActivity.this,StepComputeActivity.class));
                    finish();
//                    myAdapter.notifyDataSetChanged();
                }else if (calculateResult%(16*countExcute)==0){
                    startActivity(new Intent(ComputeAllActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input12.length; i++) {
                    for (int j = i + 1; j < input12.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input12[i] + input12[j])+Integer.parseInt(str12);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input13)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a121+"s"+tag);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af121+"s"+tag);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af121+"s"+tag);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a121 +"s"+tag+ ".txt", DataResult.a122+"s"+tag, input13, DataResult.af122+"s"+tag);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a122 +"s"+tag+ ".txt", DataResult.a123+"s"+tag, input13, DataResult.af123+"s"+tag);

                calculateResult++;
                if (calculateResult >= 16*cycleTimes) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(ComputeAllActivity.this,StepComputeActivity.class));
                    finish();
//                    myAdapter.notifyDataSetChanged();
                }else if (calculateResult%(16*countExcute)==0){
                    startActivity(new Intent(ComputeAllActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        });


        pool.execute(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input13.length; i++) {
                    for (int j = i + 1; j < input13.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input13[i] + input13[j])+Integer.parseInt(str13);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input14)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a131+"s"+tag);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af131+"s"+tag);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af131+"s"+tag);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a131 +"s"+tag+ ".txt", DataResult.a132+"s"+tag, input14, DataResult.af132+"s"+tag);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a132 +"s"+tag+ ".txt", DataResult.a133+"s"+tag, input14, DataResult.af133+"s"+tag);

                calculateResult++;
                if (calculateResult >= 16*cycleTimes) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(ComputeAllActivity.this,StepComputeActivity.class));
                    finish();
//                    myAdapter.notifyDataSetChanged();
                }else if (calculateResult%(16*countExcute)==0){
                    startActivity(new Intent(ComputeAllActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        });


        pool.execute(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input14.length; i++) {
                    for (int j = i + 1; j < input14.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input14[i] + input14[j])+Integer.parseInt(str14);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input15)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a141+"s"+tag);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af141+"s"+tag);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af141+"s"+tag);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a141 +"s"+tag+ ".txt", DataResult.a142+"s"+tag, input15, DataResult.af142+"s"+tag);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a142 +"s"+tag+ ".txt", DataResult.a143+"s"+tag, input15, DataResult.af143+"s"+tag);

                calculateResult++;
                if (calculateResult >= 16*cycleTimes) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(ComputeAllActivity.this,StepComputeActivity.class));
                    finish();
//                    myAdapter.notifyDataSetChanged();
                }else if (calculateResult%(16*countExcute)==0){
                    startActivity(new Intent(ComputeAllActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        });


        pool.execute(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input15.length; i++) {
                    for (int j = i + 1; j < input15.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input15[i] + input15[j])+Integer.parseInt(str15);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input16)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a151+"s"+tag);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af151+"s"+tag);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af151+"s"+tag);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a151 +"s"+tag+ ".txt", DataResult.a152+"s"+tag, input16, DataResult.af152+"s"+tag);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a152 +"s"+tag+ ".txt", DataResult.a153+"s"+tag, input16, DataResult.af153+"s"+tag);

                calculateResult++;
                if (calculateResult >= 16*cycleTimes) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(ComputeAllActivity.this,StepComputeActivity.class));
                    finish();
//                    myAdapter.notifyDataSetChanged();
                }else if (calculateResult%(16*countExcute)==0){
                    startActivity(new Intent(ComputeAllActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        });


        pool.execute(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input16.length; i++) {
                    for (int j = i + 1; j < input16.length; j++) {
                        int finalD = (input16[i] + input16[j])+Integer.parseInt(str16);
                        if (finalD>0) {
                            if (finalD > 49) {
                                finalD %= 49;
                            }
                            Tools.saveRecordData(finalD + "", DataResult.a161+"s"+tag);
                        }else {
                            Tools.saveRecordData(49 + "", DataResult.a161+"s"+tag);
                        }
                    }
                }

                //第二次裂变
                caculateDataLast(sdcardPath + DataResult.a161 + ".txt", DataResult.a162+"s"+tag);
                //第三次裂变
                caculateDataLast(sdcardPath + DataResult.a162 + ".txt", DataResult.a163+"s"+tag);

                calculateResult++;
                if (calculateResult >= 16*cycleTimes) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);

//                    startAddData();
                    startActivity(new Intent(ComputeAllActivity.this,StepComputeActivity.class));
                    finish();
//                    myAdapter.notifyDataSetChanged();
                }else if (calculateResult%(16*countExcute)==0){
                    startActivity(new Intent(ComputeAllActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        });



    }


    private void startChange2(final int tag, final String str1, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final String str8, final String str9, final String str10, final String str11, final String str12, final String str13, final String str14, final String str15, final String str16){
        // 21个数的裂变

        pool.execute(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input21.length; i++) {
                    boolean isDiff = false;
                    int finalD=(input21[i]+Integer.parseInt(str1))%49;
                    if (isDifferent(finalD, input2)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(finalD + "", DataResult.a11for21+"s"+tag);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + finalD + "</font>", DataResult.af11for21+"s"+tag);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + finalD + "</font>", DataResult.af11for21+"s"+tag);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a11for21 +"s"+tag+ ".txt", DataResult.a12for21+"s"+tag, input2, DataResult.af12for21+"s"+tag);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a12for21 +"s"+tag+ ".txt", DataResult.a13for21+"s"+tag, input2, DataResult.af13for21+"s"+tag);

                calculateResult++;
                if (calculateResult >= 16*cycleTimes) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(ComputeAllActivity.this,StepComputeActivity.class));
                    finish();
//                    myAdapter.notifyDataSetChanged();
                }else if (calculateResult%(16*countExcute)==0){
                    startActivity(new Intent(ComputeAllActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input22.length; i++) {
                    boolean isDiff = false;
                    int finalD=(input22[i]+Integer.parseInt(str2))%49;
                    if (isDifferent(finalD, input3)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(finalD + "", DataResult.a21for21+"s"+tag);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + finalD + "</font>", DataResult.af21for21+"s"+tag);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + finalD + "</font>", DataResult.af21for21+"s"+tag);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a21for21 +"s"+tag+ ".txt", DataResult.a22for21+"s"+tag, input3, DataResult.af22for21+"s"+tag);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a22for21 +"s"+tag+ ".txt", DataResult.a23for21+"s"+tag, input3, DataResult.af23for21+"s"+tag);

                calculateResult++;
                if (calculateResult >= 16*cycleTimes) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(ComputeAllActivity.this,StepComputeActivity.class));
                    finish();
//                    myAdapter.notifyDataSetChanged();
                }else if (calculateResult%(16*countExcute)==0){
                    startActivity(new Intent(ComputeAllActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input23.length; i++) {
                    boolean isDiff = false;
                    int finalD=(input23[i]+Integer.parseInt(str3))%49;
                    if (isDifferent(finalD, input4)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(finalD + "", DataResult.a31for21+"s"+tag);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + finalD + "</font>", DataResult.af31for21+"s"+tag);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + finalD + "</font>", DataResult.af31for21+"s"+tag);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a31for21 +"s"+tag+ ".txt", DataResult.a32for21+"s"+tag, input4, DataResult.af32for21+"s"+tag);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a32for21 +"s"+tag+ ".txt", DataResult.a33for21+"s"+tag, input4, DataResult.af33for21+"s"+tag);

                calculateResult++;
                if (calculateResult >= 16*cycleTimes) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(ComputeAllActivity.this,StepComputeActivity.class));
                    finish();
//                    myAdapter.notifyDataSetChanged();
                }else if (calculateResult%(16*countExcute)==0){
                    startActivity(new Intent(ComputeAllActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input24.length; i++) {
                    boolean isDiff = false;
                    int finalD=(input24[i]+Integer.parseInt(str4))%49;
                    if (isDifferent(finalD, input5)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(finalD + "", DataResult.a41for21+"s"+tag);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + finalD + "</font>", DataResult.af41for21+"s"+tag);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + finalD + "</font>", DataResult.af41for21+"s"+tag);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a41for21 +"s"+tag+ ".txt", DataResult.a42for21+"s"+tag, input5, DataResult.af42for21+"s"+tag);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a42for21+"s"+tag + ".txt", DataResult.a43for21+"s"+tag, input5, DataResult.af43for21+"s"+tag);

                calculateResult++;
                if (calculateResult >= 16*cycleTimes) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(ComputeAllActivity.this,StepComputeActivity.class));
                    finish();
//                    myAdapter.notifyDataSetChanged();
                }else if (calculateResult%(16*countExcute)==0){
                    startActivity(new Intent(ComputeAllActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input25.length; i++) {
                    boolean isDiff = false;
                    int finalD=(input25[i]+Integer.parseInt(str5))%49;
                    if (isDifferent(finalD, input6)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(finalD + "", DataResult.a51for21+"s"+tag);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + finalD + "</font>", DataResult.af51for21+"s"+tag);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + finalD + "</font>", DataResult.af51for21+"s"+tag);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a51for21 +"s"+tag+ ".txt", DataResult.a52for21+"s"+tag, input6, DataResult.af52for21+"s"+tag);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a52for21 +"s"+tag+ ".txt", DataResult.a53for21+"s"+tag, input6, DataResult.af53for21+"s"+tag);

                calculateResult++;
                if (calculateResult >= 16*cycleTimes) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(ComputeAllActivity.this,StepComputeActivity.class));
                    finish();
//                    myAdapter.notifyDataSetChanged();
                }else if (calculateResult%(16*countExcute)==0){
                    startActivity(new Intent(ComputeAllActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input26.length; i++) {
                    boolean isDiff = false;
                    int finalD=(input26[i]+Integer.parseInt(str6))%49;
                    if (isDifferent(finalD, input7)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(finalD + "", DataResult.a61for21+"s"+tag);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + finalD + "</font>", DataResult.af61for21+"s"+tag);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + finalD + "</font>", DataResult.af61for21+"s"+tag);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a61for21+"s"+tag + ".txt", DataResult.a62for21+"s"+tag, input7, DataResult.af62for21+"s"+tag);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a62for21 +"s"+tag+ ".txt", DataResult.a63for21+"s"+tag, input7, DataResult.af63for21+"s"+tag);

                calculateResult++;
                if (calculateResult >= 16*cycleTimes) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(ComputeAllActivity.this,StepComputeActivity.class));
                    finish();
//                    myAdapter.notifyDataSetChanged();
                }else if (calculateResult%(16*countExcute)==0){
                    startActivity(new Intent(ComputeAllActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input27.length; i++) {
                    boolean isDiff = false;
                    int finalD=(input27[i]+Integer.parseInt(str7))%49;
                    if (isDifferent(finalD, input8)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(finalD + "", DataResult.a71for21+"s"+tag);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + finalD + "</font>", DataResult.af71for21+"s"+tag);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + finalD + "</font>", DataResult.af71for21+"s"+tag);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a71for21 +"s"+tag+ ".txt", DataResult.a72for21+"s"+tag, input8, DataResult.af72for21+"s"+tag);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a72for21 +"s"+tag+ ".txt", DataResult.a73for21+"s"+tag, input8, DataResult.af73for21+"s"+tag);

                calculateResult++;
                if (calculateResult >= 16*cycleTimes) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(ComputeAllActivity.this,StepComputeActivity.class));
                    finish();
//                    myAdapter.notifyDataSetChanged();
                }else if (calculateResult%(16*countExcute)==0){
                    startActivity(new Intent(ComputeAllActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input28.length; i++) {
                    boolean isDiff = false;
                    int finalD=(input28[i]+Integer.parseInt(str8))%49;
                    if (isDifferent(finalD, input9)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(finalD + "", DataResult.a81for21+"s"+tag);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + finalD + "</font>", DataResult.af81for21+"s"+tag);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + finalD + "</font>", DataResult.af81for21+"s"+tag);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a81for21 +"s"+tag+ ".txt", DataResult.a82for21+"s"+tag,input9, DataResult.af82for21+"s"+tag);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a82for21 +"s"+tag+ ".txt", DataResult.a83for21+"s"+tag, input9, DataResult.af83for21+"s"+tag);

                calculateResult++;
                if (calculateResult >= 16*cycleTimes) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(ComputeAllActivity.this,StepComputeActivity.class));
                    finish();
//                    myAdapter.notifyDataSetChanged();
                }else if (calculateResult%(16*countExcute)==0){
                    startActivity(new Intent(ComputeAllActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input29.length; i++) {
                    boolean isDiff = false;
                    int finalD=(input29[i]+Integer.parseInt(str9))%49;
                    if (isDifferent(finalD, input10)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(finalD + "", DataResult.a91for21+"s"+tag);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + finalD + "</font>", DataResult.af91for21+"s"+tag);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + finalD + "</font>", DataResult.af91for21+"s"+tag);
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a91for21 +"s"+tag+ ".txt", DataResult.a92for21+"s"+tag, input10, DataResult.af92for21+"s"+tag);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a92for21 +"s"+tag+ ".txt", DataResult.a93for21+"s"+tag, input10, DataResult.af93for21+"s"+tag);

                calculateResult++;
                if (calculateResult >= 16*cycleTimes) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(ComputeAllActivity.this,StepComputeActivity.class));
                    finish();
//                    myAdapter.notifyDataSetChanged();
                }else if (calculateResult%(16*countExcute)==0){
                    startActivity(new Intent(ComputeAllActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input210.length; i++) {
                    boolean isDiff = false;
                    int finalD=(input210[i]+Integer.parseInt(str10))%49;
                    if (isDifferent(finalD, input11)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(finalD + "", DataResult.a101for21+"s"+tag);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + finalD + "</font>", DataResult.af101for21+"s"+tag);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + finalD + "</font>", DataResult.af101for21+"s"+tag);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a101for21 +"s"+tag+ ".txt", DataResult.a102for21+"s"+tag, input11, DataResult.af102for21+"s"+tag);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a102for21 +"s"+tag+ ".txt", DataResult.a103for21+"s"+tag, input11, DataResult.af103for21+"s"+tag);

                calculateResult++;
                if (calculateResult >= 16*cycleTimes) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(ComputeAllActivity.this,StepComputeActivity.class));
                    finish();
//                    myAdapter.notifyDataSetChanged();
                }else if (calculateResult%(16*countExcute)==0){
                    startActivity(new Intent(ComputeAllActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input211.length; i++) {
                    boolean isDiff = false;
                    int finalD=(input211[i]+Integer.parseInt(str11))%49;
                    if (isDifferent(finalD, input12)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(finalD + "", DataResult.a111for21+"s"+tag);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + finalD + "</font>", DataResult.af111for21+"s"+tag);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + finalD + "</font>", DataResult.af111for21+"s"+tag);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a111for21 +"s"+tag+ ".txt", DataResult.a112for21+"s"+tag, input12, DataResult.af112for21+"s"+tag);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a112for21 +"s"+tag+ ".txt", DataResult.a113for21+"s"+tag, input12, DataResult.af113for21+"s"+tag);

                calculateResult++;
                if (calculateResult >= 16*cycleTimes) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(ComputeAllActivity.this,StepComputeActivity.class));
                    finish();
//                    myAdapter.notifyDataSetChanged();
                }else if (calculateResult%(16*countExcute)==0){
                    startActivity(new Intent(ComputeAllActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input212.length; i++) {
                    boolean isDiff = false;
                    int finalD=(input212[i]+Integer.parseInt(str12))%49;
                    if (isDifferent(finalD, input13)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(finalD + "", DataResult.a121for21+"s"+tag);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + finalD + "</font>", DataResult.af121for21+"s"+tag);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + finalD + "</font>", DataResult.af121for21+"s"+tag);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a121for21 +"s"+tag+ ".txt", DataResult.a122for21+"s"+tag, input13, DataResult.af122for21+"s"+tag);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a122for21 +"s"+tag+ ".txt", DataResult.a123for21+"s"+tag, input13, DataResult.af123for21+"s"+tag);

                calculateResult++;
                if (calculateResult >= 16*cycleTimes) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(ComputeAllActivity.this,StepComputeActivity.class));
                    finish();
//                    myAdapter.notifyDataSetChanged();
                }else if (calculateResult%(16*countExcute)==0){
                    startActivity(new Intent(ComputeAllActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input213.length; i++) {
                    boolean isDiff = false;
                    int finalD=(input213[i]+Integer.parseInt(str13))%49;
                    if (isDifferent(finalD, input14)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(finalD + "", DataResult.a131for21+"s"+tag);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + finalD + "</font>", DataResult.af131for21+"s"+tag);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + finalD + "</font>", DataResult.af131for21+"s"+tag);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a131for21+"s"+tag + ".txt", DataResult.a132for21+"s"+tag, input14, DataResult.af132for21+"s"+tag);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a132for21 +"s"+tag+ ".txt", DataResult.a133for21+"s"+tag, input14, DataResult.af133for21+"s"+tag);

                calculateResult++;
                if (calculateResult >= 16*cycleTimes) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(ComputeAllActivity.this,StepComputeActivity.class));
                    finish();
//                    myAdapter.notifyDataSetChanged();
                }else if (calculateResult%(16*countExcute)==0){
                    startActivity(new Intent(ComputeAllActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input214.length; i++) {
                    boolean isDiff = false;
                    int finalD=(input214[i]+Integer.parseInt(str14))%49;
                    if (isDifferent(finalD, input15)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(finalD + "", DataResult.a141for21+"s"+tag);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + finalD + "</font>", DataResult.af141for21+"s"+tag);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + finalD + "</font>", DataResult.af141for21+"s"+tag);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a141for21+"s"+tag + ".txt", DataResult.a142for21+"s"+tag, input15, DataResult.af142for21+"s"+tag);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a142for21+"s"+tag + ".txt", DataResult.a143for21+"s"+tag, input15, DataResult.af143for21+"s"+tag);

                calculateResult++;
                if (calculateResult >= 16*cycleTimes) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(ComputeAllActivity.this,StepComputeActivity.class));
                    finish();
//                    myAdapter.notifyDataSetChanged();
                }else if (calculateResult%(16*countExcute)==0){
                    startActivity(new Intent(ComputeAllActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input215.length; i++) {
                    boolean isDiff = false;
                    int finalD=(input215[i]+Integer.parseInt(str15))%49;
                    if (isDifferent(finalD, input16)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(finalD + "", DataResult.a151for21+"s"+tag);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + finalD + "</font>", DataResult.af151for21+"s"+tag);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + finalD + "</font>", DataResult.af151for21+"s"+tag);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a151for21 +"s"+tag+ ".txt", DataResult.a152for21+"s"+tag, input16, DataResult.af152for21+"s"+tag);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a152for21 +"s"+tag+ ".txt", DataResult.a153for21+"s"+tag, input16, DataResult.af153for21+"s"+tag);

                calculateResult++;
                if (calculateResult >= 16*cycleTimes) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
//                    startAddData();
                    startActivity(new Intent(ComputeAllActivity.this,StepComputeActivity.class));
                    finish();
//                    myAdapter.notifyDataSetChanged();
                }else if (calculateResult%(16*countExcute)==0){
                    startActivity(new Intent(ComputeAllActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        });


        pool.execute(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input216.length; i++) {
                    int finalD=(input216[i]+Integer.parseInt(str16))%49;
                    if (finalD > 49) {
                        finalD %= 49;
                    }
                    Tools.saveRecordFor21Data(finalD + "", DataResult.a161for21+"s"+tag);

                }

                //第二次裂变
                caculateDataLast(sdcardPath + DataResult.a161for21 +"s"+tag+ ".txt", DataResult.a162for21+"s"+tag);
                //第三次裂变
                caculateDataLast(sdcardPath + DataResult.a162for21 +"s"+tag+ ".txt", DataResult.a163for21+"s"+tag);

                calculateResult++;
                if (calculateResult >= 16*cycleTimes) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);

//                    startAddData();

                    startActivity(new Intent(ComputeAllActivity.this,StepComputeActivity.class));
                    finish();
//                    myAdapter.notifyDataSetChanged();
                }else if (calculateResult%(16*countExcute)==0){
                    startActivity(new Intent(ComputeAllActivity.this,ComputeAllActivity.class));
                    finish();
                }
            }
        });

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




}
