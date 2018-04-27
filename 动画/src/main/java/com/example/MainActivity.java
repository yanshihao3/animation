package com.example;

import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void initView() {
        iv = (ImageView) findViewById(R.id.iv);
        //获取image view的背景
        AnimationDrawable background = (AnimationDrawable) iv.getBackground();
        background.start();


        //
      /*  iv.setBackgroundResource(R.drawable.frame_animation);
        AnimationDrawable background1 = (AnimationDrawable) iv.getBackground();

        //
        AnimationDrawable animationDrawable = (AnimationDrawable) getResources().getDrawable(
                R.drawable.frame_animation);
        iv.setBackground(animationDrawable);*/
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void frameAnimation(){
       AnimationDrawable animationDrawable = new AnimationDrawable();
        // 为AnimationDrawable添加动画帧
        animationDrawable.addFrame(
                getResources().getDrawable(R.drawable.alipay_msp_success1), 50);
        animationDrawable.addFrame(
                getResources().getDrawable(R.drawable.alipay_msp_success2), 50);
        animationDrawable.addFrame(
                getResources().getDrawable(R.drawable.alipay_msp_success3), 50);
        animationDrawable.addFrame(
                getResources().getDrawable(R.drawable.alipay_msp_success4), 50);

        // 设置为循环播放
        animationDrawable.setOneShot(false);
        iv.setBackground(animationDrawable);
        animationDrawable.start();
    }

}
