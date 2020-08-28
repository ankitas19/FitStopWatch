package com.example.fitstopwatch;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class StopWatchAct extends AppCompatActivity {
    Button btnstart, btnstop, btnpause;
    ImageView icanchor;
    Animation roundingalone;
    Chronometer timerHere;
    private boolean running;
    private long pauseOffset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);
        btnstart=findViewById(R.id.btnstart);
        btnstop=findViewById(R.id.btnstop);
        btnpause=findViewById(R.id.btnpause);
        icanchor=findViewById(R.id.icanchor);
        timerHere=findViewById(R.id.timerHere);
        btnstop.setAlpha(0);
        roundingalone= AnimationUtils.loadAnimation(this,R.anim.roundingalone);
        Typeface MMedium=Typeface.createFromAsset(getAssets(),"fonts/MMedium.ttf");
        btnstart.setTypeface(MMedium);
        btnstop.setTypeface(MMedium);

        btnstart.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            icanchor.startAnimation(roundingalone);
                                            btnstop.animate().alpha(1).translationY(-80).setDuration(300).start();
                                            btnpause.animate().alpha(1).translationY(-80).setDuration(300).start();
                                            btnstart.animate().alpha(0).setDuration(300).start();
                                            timerHere.setBase(SystemClock.elapsedRealtime());
                                            timerHere.start();
                                        }
                                    });
            btnstop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    icanchor.clearAnimation();
                    btnstart.animate().alpha(1).translationY(-80).setDuration(300).start();
                    btnpause.animate().alpha(1).translationY(-80).setDuration(300).start();
                    btnstop.animate().alpha(0).setDuration(300).start();
                    //timerHere.stop();
                    timerHere.setBase(SystemClock.elapsedRealtime());
                    pauseOffset = 0;
                }
        });
        btnpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                icanchor.clearAnimation();
                timerHere.stop();
                }

        });

    }
}