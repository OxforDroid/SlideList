package com.slide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);

        ImageView splashimg = (ImageView)findViewById(R.id.splash_img);
        Animation animspl = AnimationUtils.loadAnimation(this, R.anim.rotate);
        splashimg.startAnimation(animspl);


        animspl.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart (Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(Splash2.this,
                        Menu.class
                ));                Splash2.this.finish();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }
    @Override
    protected void onPause() {
        super.onPause();
        ImageView splashimg = (ImageView)findViewById(R.id.splash_img);
        splashimg.clearAnimation();



    }

}

