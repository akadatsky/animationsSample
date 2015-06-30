package com.example.testanimations;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    private boolean resized = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View frameView = findViewById(R.id.frame);
        final View testView = findViewById(R.id.test);
        final Animation anim = AnimationUtils.loadAnimation(this, R.anim.move);

        findViewById(R.id.run).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testView.startAnimation(anim);
            }
        });

        findViewById(R.id.anim).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResizeAnimation anim;
                if (resized) {
                    anim = new ResizeAnimation(frameView, frameView.getWidth(), 0, frameView.getWidth(), convertDpToPixel(300), 600);
                } else {
                    anim = new ResizeAnimation(frameView, frameView.getWidth(), frameView.getHeight(), frameView.getWidth(), 0, 600);
                }
                resized = !resized;
                frameView.requestFocusFromTouch();
                frameView.startAnimation(anim);
            }
        });

    }

    public float convertDpToPixel(float dp) {
        Resources resources = getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return px;
    }

}
