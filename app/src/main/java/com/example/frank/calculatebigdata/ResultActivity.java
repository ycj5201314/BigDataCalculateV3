package com.example.frank.calculatebigdata;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

import com.example.frank.calculatebigdata.config.OriginData;

import java.util.Iterator;
import java.util.Map;

public class ResultActivity extends AppCompatActivity {

    private TextView textView;
    private String dd="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textView=findViewById(R.id.textView10);

        new Thread(new Runnable() {
            @Override
            public void run() {
                //Toast.makeText(StepComputeActivity.this,"查看所有的结果",Toast.LENGTH_LONG).show();
                Iterator iter =OriginData.computeDataResult.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry entry = (Map.Entry) iter.next();
                    dd=dd + entry.getKey()+entry.getValue()+"\n";
                }
                OriginData.result=dd;
                textView.setText(OriginData.result+"");
            }
        }).start();

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode==event.KEYCODE_BACK){
            new AlertDialog.Builder(ResultActivity.this).setTitle("系统提示")
                    .setMessage("正在展示数据统计结果，您是否确定要退出？")
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
