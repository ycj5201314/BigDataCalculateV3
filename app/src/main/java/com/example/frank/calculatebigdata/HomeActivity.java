package com.example.frank.calculatebigdata;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        String myString = "2019-06-25";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String nowDate = df.format(new Date());// new Date()为获取当前系统时间
        Date d = null,nowd=null;
        try {
            d = df.parse(myString);
            nowd=df.parse(nowDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        boolean flag = nowd.before(d);
        if(flag){

        }
        else{
            finish();
            System.exit(0);
        }

        findViewById(R.id.button10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(HomeActivity.this,MainActivity.class));
//                startActivity(new Intent(HomeActivity.this,InputSevenActivity.class));
                Intent intent=new Intent(HomeActivity.this,InputSevenActivity.class);
                intent.putExtra("tag","21");
                startActivity(intent);
            }
        });


        findViewById(R.id.button11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent=new Intent(HomeActivity.this,MainActivity.class);
                intent.putExtra("tag","21");
                startActivity(intent);*/
                startActivity(new Intent(HomeActivity.this,SelectDataActivity.class));
            }
        });

        findViewById(R.id.button12).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,InputSevenActivity.class);
                intent.putExtra("tag","7");
                startActivity(intent);
//                startActivity(new Intent(HomeActivity.this,SelectDataActivity.class));
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode==event.KEYCODE_BACK){
            new AlertDialog.Builder(HomeActivity.this).setTitle("系统提示")
                    .setMessage("您是否确定要退出数据计算与统计系统？")
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
