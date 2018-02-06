package com.dohman.boilaneggbae;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.PorterDuff;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sp;
    SharedPreferences.Editor editor;

    private static final long CURRENT_TIME = 0;
    private long mTimeLeftInMillis = CURRENT_TIME;
    private long mEndTime;
    private TextView mTextViewCountDown;
    private TextView popupMessage;
    private boolean mTimerRunning;
    private Button buttonInstructions;
    private Button buttonGame;
    private Button buttonLargeSize;
    private Button buttonMediumSize;
    private Button buttonSoft;
    private Button buttonMedium;
    private Button buttonHard;
    private Button buttonHellaHard;
    private CountDownTimer mCountDownTimer;
    private EggSize mediumOrLarge;
    private boolean alreadyRunning;


    private enum EggSize {
        UNDEFINED, MEDIUM, LARGE;

        public static EggSize toMyEnum (String myEnumString) {
            try {
                return valueOf(myEnumString);
            } catch (Exception ex) {
                return UNDEFINED;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        sp = this.getPreferences(Context.MODE_PRIVATE);
        editor = sp.edit();
        switch (getMyEnum()) {
            case UNDEFINED: {
                mediumOrLarge = EggSize.UNDEFINED;
                break;
            }
            case MEDIUM: {
                mediumOrLarge = EggSize.MEDIUM;
                break;
            }
            case LARGE: {
                mediumOrLarge = EggSize.LARGE;
                break;
            }
        }

        // Hittar knapparna
        buttonInstructions = findViewById(R.id.buttonInstructions);
        buttonGame = findViewById(R.id.buttonGame);

        buttonMediumSize = findViewById(R.id.buttonMediumSize);
        buttonLargeSize = findViewById(R.id.buttonLargeSize);

        buttonSoft = findViewById(R.id.buttonSoft);
        buttonMedium = findViewById(R.id.buttonMedium);
        buttonHard = findViewById(R.id.buttonHard);
        buttonHellaHard = findViewById(R.id.buttonHellaHard);

        // Sätter på listener på knapparna
        buttonInstructions.setOnClickListener(btnInstructionsClickListener);
        buttonGame.setOnClickListener(btnGameClickListener);

        buttonMediumSize.setOnClickListener(btnMediumSizeClickListener);
        buttonLargeSize.setOnClickListener(btnLargeSizeClickListener);

        buttonSoft.setOnClickListener(btnSoftClickListener);
        buttonMedium.setOnClickListener(btnMediumClickListener);
        buttonHard.setOnClickListener(btnHardClickListener);
        buttonHellaHard.setOnClickListener(btnHellaHardClickListener);

        //Färglägger knapparna
        buttonMediumSize.getBackground().setColorFilter(0x00000000, PorterDuff.Mode.MULTIPLY);
        buttonLargeSize.getBackground().setColorFilter(0x00000000, PorterDuff.Mode.MULTIPLY);
        buttonSoft.getBackground().setColorFilter(0x00000000, PorterDuff.Mode.MULTIPLY);
        buttonMedium.getBackground().setColorFilter(0x00000000, PorterDuff.Mode.MULTIPLY);
        buttonHard.getBackground().setColorFilter(0x00000000, PorterDuff.Mode.MULTIPLY);
        buttonHellaHard.getBackground().setColorFilter(0x00000000, PorterDuff.Mode.MULTIPLY);
        buttonGame.setBackgroundResource(R.drawable.game);

        mTextViewCountDown = findViewById(R.id.time);
        popupMessage = findViewById(R.id.popupMessage);

    }

    public void setMyEnum(EggSize myEnum) {
        editor.putString("MyEnum", myEnum.toString());
        editor.commit();
    }

    public EggSize getMyEnum() {
        String myEnumString = sp.getString("MyEnum", EggSize.UNDEFINED.toString());
        return EggSize.toMyEnum(myEnumString);
    }

    private View.OnClickListener btnInstructionsClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent ins = new Intent(MainActivity.this, Instructions.class);
            startActivity(ins);
        }
    };

    private View.OnClickListener btnGameClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent game = new Intent(MainActivity.this, Game.class);
            startActivity(game);
        }
    };

    private View.OnClickListener btnMediumSizeClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mediumOrLarge = EggSize.MEDIUM;
            setMyEnum(EggSize.MEDIUM);
        }
    };

    private View.OnClickListener btnLargeSizeClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mediumOrLarge = EggSize.LARGE;
            setMyEnum(EggSize.LARGE);
        }
    };

    private View.OnClickListener btnSoftClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if ((mediumOrLarge != EggSize.UNDEFINED) && (alreadyRunning == false)) {
                alreadyRunning = true;
                mTimeLeftInMillis = 1200; //240000;
                start();
            } else {
                alreadyRunning = false;
                cancel();
            }
        }
    };

    private View.OnClickListener btnMediumClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if ((mediumOrLarge != EggSize.UNDEFINED) && (alreadyRunning == false)) {
                alreadyRunning = true;
                mTimeLeftInMillis = 420000;
                start();
            } else {
                alreadyRunning = false;
                cancel();
            }
        }
    };

    private View.OnClickListener btnHardClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if ((mediumOrLarge != EggSize.UNDEFINED) && (alreadyRunning == false)) {
                alreadyRunning = true;
                mTimeLeftInMillis = 660000;
                start();
            } else {
                alreadyRunning = false;
                cancel();
            }
        }
    };

    private View.OnClickListener btnHellaHardClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if ((mediumOrLarge != EggSize.UNDEFINED) && (alreadyRunning == false)) {
                alreadyRunning = true;
                mTimeLeftInMillis = 1800000;
                start();
            } else {
                alreadyRunning = false;
                cancel();
            }
        }
    };

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putLong("millisLeft", mTimeLeftInMillis);
        savedInstanceState.putBoolean("timerRunning", mTimerRunning);
        savedInstanceState.putLong("endTime", mEndTime);
        savedInstanceState.putBoolean("alreadyRunning", alreadyRunning);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mTimeLeftInMillis = savedInstanceState.getLong("millisLeft");
        mTimerRunning = savedInstanceState.getBoolean("timerRunning");
        alreadyRunning = savedInstanceState.getBoolean("alreadyRunning");
        updateCountDownText();

        if (mTimerRunning) {
            mEndTime = savedInstanceState.getLong("endTime");
            mTimeLeftInMillis = mEndTime - System.currentTimeMillis();
            start();
        }
    }

    private void start() {
        mEndTime = System.currentTimeMillis() + mTimeLeftInMillis;

        if (mediumOrLarge == EggSize.MEDIUM) {
            mTimeLeftInMillis -= 60000;
            mEndTime -= 60000;
        }
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Psst...!");
                builder.setMessage(getString(R.string.popup_message));
                builder.setNegativeButton("Cool!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                builder.show();
                mTimerRunning = false;
            }
        }.start();

        mTimerRunning = true;
    }

    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        mTextViewCountDown.setText(timeLeftFormatted);
    }

    private void cancel() {
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
            mCountDownTimer = null;
            mTextViewCountDown.setText("");
        }
    }
}
