package com.example.android.repeatingalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.parceler.Parcels;

/**
 * This class is used to clear, schedule the next notification for users
 */
public class AlarmManagerUtil extends BroadcastReceiver {

    public static final String SET_NOTIFICATION_INTENT = "SET_NOTIFICATION";
    public static final String LONG_EXTRA              = "LONG_EXTRA";
    public static final String PARCEL_EXTRA            = "PARCEL_EXTRA";

    private static final String TAG = AlarmManagerUtil.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        switch (action) {
            case SET_NOTIFICATION_INTENT:
                ParcelModel parcelModel = Parcels.unwrap(intent.getParcelableExtra(PARCEL_EXTRA));
                if (parcelModel == null) {
                    Log.e(TAG, "Parcel Model was empty :(");
                } else {
                    Log.i(TAG, "Intent contained Parceled object!");
                }

                Log.i(TAG, "Intent LONG contained: " + intent.getLongExtra(LONG_EXTRA, 0L));
                break;
            case "android.intent.action.TIMEZONE_CHANGED":
            case "android.intent.action.TIME_SET":
            case "android.intent.action.BOOT_COMPLETED":
                Log.v(TAG, action + " received.");
                break;
        }

    }
}
