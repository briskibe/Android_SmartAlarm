package com.example.bernard.smartalarm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MusicPick extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    String choosenTone = "Tone1";
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_pick);
        RadioGroup rb = (RadioGroup)findViewById(R.id.radioGroup);
        rb.check(R.id.radioTone1);

        btn = (Button) findViewById(R.id.buttonPickMusic);
    }

    public void playTone1(View v)
    {
        stopPlaying();
        int resID = getResources().getIdentifier("tone1", "raw", getPackageName());
        choosenTone = "Tone1";
        mediaPlayer = MediaPlayer.create(this,resID);
        mediaPlayer.start();
    }

    public void playTone2(View v)
    {
        stopPlaying();
        int resID = getResources().getIdentifier("tone2", "raw", getPackageName());
        choosenTone = "Tone2";
        mediaPlayer = MediaPlayer.create(this,resID);
        mediaPlayer.start();
    }

    public void playTone3(View v)
    {
        stopPlaying();
        int resID = getResources().getIdentifier("tone3", "raw", getPackageName());
        choosenTone = "Tone3";
        mediaPlayer = MediaPlayer.create(this,resID);
        mediaPlayer.start();
    }

    public void playTone4(View v)
    {
        stopPlaying();
        int resID = getResources().getIdentifier("tone4", "raw", getPackageName());
        choosenTone = "Tone4";
        mediaPlayer = MediaPlayer.create(this,resID);
        mediaPlayer.start();
    }

    public void confirmMusic(View v)
    {
        stopPlaying();
        /*Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("selectedTone",choosenTone);
        startActivity(intent);*/
        int mode=MODE_PRIVATE;
        SharedPreferences mySharedPreferences=getSharedPreferences("com.example.bernard.smartalarm.preference", mode);
        SharedPreferences.Editor editor=mySharedPreferences.edit();
        editor.putString("selectedTone", choosenTone);
        editor.commit();
        finish();
    }

    public void stopPlaying()
    {
        if(mediaPlayer != null)
        {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

}
