package com.example.bernard.smartalarm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Main22Activity extends AppCompatActivity {

    DatePicker datePicker;
    Button submitButton;
    Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);

        datePicker = (DatePicker) findViewById(R.id.datePicker);
        submitButton = (Button)findViewById(R.id.submitButton);
        cancelButton = (Button) findViewById(R.id.cancelButton);
        final Intent i = new Intent(this, MainActivity.class);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //datePicker.setMinDate(System.currentTimeMillis()-1000);
                int date = datePicker.getDayOfMonth();
                int month = datePicker.getMonth();
                int year = datePicker.getYear();

                Calendar c = Calendar.getInstance();
                int todayDate = c.get(Calendar.DAY_OF_MONTH);
                int todayMonth = c.get(Calendar.MONTH);
                int todayYear = c.get(Calendar.YEAR);

                if(todayYear > year) {
                    Toast.makeText(getApplicationContext(), "You must select date in future", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(todayYear <= year && todayMonth > month){
                    Toast.makeText(getApplicationContext(), "You must select date in future", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(todayYear <= year && todayMonth == month && todayDate > date){
                    Toast.makeText(getApplicationContext(), "You must select date in future" + todayDate + " " + todayMonth + " " + todayYear + " " + date + " " + month + " " + year, Toast.LENGTH_SHORT).show();
                    return;
                }


                /*String sendDate = String.valueOf(date)+"."+String.valueOf(month)+"."+String.valueOf(year);
                i.putExtra("newDate",String.valueOf(date));
                i.putExtra("newMonth",String.valueOf(month));
                i.putExtra("newYear",String.valueOf(year));
                startActivity(i);*/
                int mode=MODE_PRIVATE;
                SharedPreferences mySharedPreferences=getSharedPreferences("com.example.bernard.smartalarm.preference", mode);
                SharedPreferences.Editor editor=mySharedPreferences.edit();
                editor.putString("newDate",String.valueOf(date));
                editor.putString("newMonth",String.valueOf(month));
                editor.putString("newYear",String.valueOf(year));
                editor.commit();
                finish();

            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(i);
                finish();
            }
        });


    }

}
