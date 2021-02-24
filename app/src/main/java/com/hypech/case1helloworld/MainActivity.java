package com.hypech.case1helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnShare = findViewById(R.id.button_share);
        btnShare.setOnClickListener(new L_Click());

    }

    class L_Click implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            allShare();
        }
    }

    /**
     * Android原生分享功能
     * 默认选取手机所有可以分享的APP
     */
    public void allShare(){
        Intent share_intent = new Intent();
        share_intent.setAction(Intent.ACTION_SEND);//设置分享行为
        share_intent.setType("text/plain");//设置分享内容的类型
        share_intent.putExtra(Intent.EXTRA_SUBJECT, "分享");  //添加分享内容标题
        share_intent.putExtra(Intent.EXTRA_TEXT, "见声听力测试App \n3分钟获得听力图。\n"+"http://seeingvoice.com/download");//添加分享内容
        //创建分享的Dialog
        share_intent = Intent.createChooser(share_intent, "分享给朋友");
        startActivity(share_intent);
    }
}