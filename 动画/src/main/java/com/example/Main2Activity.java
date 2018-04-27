package com.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private Button alpha;
    private Button translate;
    private Button rotate;
    private Button scale;
    private Button set;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        alpha = (Button) findViewById(R.id.alpha);
        translate = (Button) findViewById(R.id.translate);
        rotate = (Button) findViewById(R.id.rotate);
        scale = (Button) findViewById(R.id.scale);
        set = (Button) findViewById(R.id.set);
        iv = (ImageView) findViewById(R.id.iv);
        alpha.setOnClickListener(this);
        translate.setOnClickListener(this);
        rotate.setOnClickListener(this);
        scale.setOnClickListener(this);
        set.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.alpha:
                Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
                iv.startAnimation(animation);
                break;
            case R.id.translate:
                Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.translate);
                iv.startAnimation(animation1);
                break;
            case R.id.rotate:
                Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.rotate);
                iv.startAnimation(animation2);
                break;
            case R.id.scale:
                Animation animation3 = AnimationUtils.loadAnimation(this, R.anim.scale);
                iv.startAnimation(animation3);
                break;
            case R.id.set:
                Animation animation4= AnimationUtils.loadAnimation(this, R.anim.set);
                iv.startAnimation(animation4);
                break;
        }
    }

    private void createByJava() {
        //平移动画
        TranslateAnimation translateAnimation = new TranslateAnimation(
                0, 500, 0, 500);
        translateAnimation.setDuration(2000);
        iv.startAnimation(translateAnimation);

        //淡入淡出动画
        AlphaAnimation alphaAnimation=new AlphaAnimation(0,1);
        alphaAnimation.setDuration(2000);
        iv.startAnimation(alphaAnimation);

        //旋转动画
        RotateAnimation rotateAnimation=new RotateAnimation(0,90);
        rotateAnimation.setDuration(2000);
        iv.startAnimation(rotateAnimation);

        //缩放动画
        ScaleAnimation scaleanimation =new ScaleAnimation(1f,2.0f,1f,2.0f);
        scaleanimation.setDuration(2000);
        iv.startAnimation(scaleanimation);

        //组合动画
        AnimationSet setAnimation = new AnimationSet(true);
        // 步骤1:创建组合动画对象(设置为true)

        // 步骤2:设置组合动画的属性
        // 特别说明以下情况
        // 因为在下面的旋转动画设置了无限循环(RepeatCount = INFINITE)
        // 所以动画不会结束，而是无限循环
        // 所以组合动画的下面两行设置是无效的
        setAnimation.setRepeatMode(Animation.RESTART);
        setAnimation.setRepeatCount(1);// 设置了循环一次,但无效

        setAnimation.addAnimation(alphaAnimation);
        setAnimation.addAnimation(scaleanimation);
        setAnimation.addAnimation(rotateAnimation);
        setAnimation.addAnimation(translateAnimation);

        iv.startAnimation(setAnimation);
        scaleanimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
