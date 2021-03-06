package com.example.bernard.smartalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Bernard on 1/5/2017.
 */
public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {


        Intent ServiceIntent = new Intent(context, RingtonePlayingService.class);

        Bundle data = intent.getExtras();
        if(data != null) {
            String tone = data.getString("Tone");
            String Qs = data.getString("Qs");


            ServiceIntent.putExtra("Tone", tone);
            ServiceIntent.putExtra("Qs", Qs);
        }

        context.startService(ServiceIntent);
    }
}
