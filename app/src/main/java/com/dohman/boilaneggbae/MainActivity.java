package com.dohman.boilaneggbae;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView time;
    private Button buttonLargeSize;
    private Button buttonMediumSize;
    private Button buttonSoft;
    private Button buttonMedium;
    private Button buttonHard;
    private CountDownTimer countDownTimer;
    private boolean alreadyRunning = false;

    private View.OnClickListener btnSoftClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (alreadyRunning == false) {
                alreadyRunning = true;
                start(220);
            } else {
                alreadyRunning = false;
                cancel();
            }
        }
    };

    private View.OnClickListener btnMediumClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (alreadyRunning == false) {
                alreadyRunning = true;
                start(420);
            } else {
                alreadyRunning = false;
                cancel();
            }
        }
    };

    private View.OnClickListener btnHardClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (alreadyRunning == false) {
                alreadyRunning = true;
                start(660);
            } else {
                alreadyRunning = false;
                cancel();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hittar knapparna
        buttonSoft = findViewById(R.id.buttonSoft);
        buttonMedium = findViewById(R.id.buttonMedium);
        buttonHard = findViewById(R.id.buttonHard);

        // Sätter på listener på knapparna
        buttonSoft.setOnClickListener(btnSoftClickListener);
        buttonMedium.setOnClickListener(btnMediumClickListener);
        buttonHard.setOnClickListener(btnHardClickListener);

        time = findViewById(R.id.time);
    }

    private void start(int duration) {
        time.setText("");

        countDownTimer = new CountDownTimer(duration * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time.setText("" + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                time.setText("The egg is done!");
            }
        };

       countDownTimer.start();
    }

    private void cancel() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
            countDownTimer = null;
            time.setText("Stopped");
        }
    }
}
