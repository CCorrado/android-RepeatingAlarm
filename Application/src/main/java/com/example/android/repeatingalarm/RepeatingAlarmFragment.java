/*
* Copyright 2013 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.repeatingalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.MenuItem;

import org.parceler.Parcels;

import java.util.Calendar;


public class RepeatingAlarmFragment extends Fragment {

    private static final String TAG = RepeatingAlarmFragment.class.getSimpleName();

    // This value is defined and consumed by app code, so any value will work.
    // There's no significance to this sample using 0.
    public static final int REQUEST_CODE = 0;

    private ParcelModel parcelModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        final String thisIsAnExtra = "Extra_Data!";
        final Long thisIsALong = 133523525L;

        parcelModel = new ParcelModel(thisIsAnExtra, 9001, thisIsALong);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.sample_action) {

            final int FIVE_SEC_MILLIS = 5000;

            //Configure the intent with the data,
            // put the extras to be read in the broadcast receiver.

            Intent intent = new Intent(getContext(), AlarmManagerUtil.class);
            //This action is checked in the AlarmManagerUtil.java class
            intent.setAction(AlarmManagerUtil.SET_NOTIFICATION_INTENT);
            //NOTE: These will work fine during debugging for All android versions,
            // but when the broadcast receiver receives these, they will not be the values defined above.
            intent.putExtra(AlarmManagerUtil.PARCEL_EXTRA, Parcels.wrap(parcelModel));
            intent.putExtra(AlarmManagerUtil.LONG_EXTRA, 133523525L);
            Log.d(TAG, "Intent loaded with: " + parcelModel.testString);

            //Schedule an alarm based on build version and for 5s from the execution.
            AlarmManager alarmManager = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);

            PendingIntent pendingIntent = PendingIntent.getBroadcast(getContext(),
                                                                     REQUEST_CODE, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            if (alarmManager != null) {
                if (Build.VERSION.SDK_INT >= 23) {
                    //We want to send offline reminders about trackers even in Doze mode.
                    alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, Calendar.getInstance().getTimeInMillis() + FIVE_SEC_MILLIS, pendingIntent);
                } else if (Build.VERSION.SDK_INT >= 19) {
                    alarmManager.setExact(AlarmManager.RTC_WAKEUP, Calendar.getInstance().getTimeInMillis() + FIVE_SEC_MILLIS, pendingIntent);
                } else {
                    alarmManager.set(AlarmManager.RTC_WAKEUP, Calendar.getInstance().getTimeInMillis() + FIVE_SEC_MILLIS, pendingIntent);
                }
            }
            Log.d(TAG, "Scheduling alarm for " + Calendar.getInstance().getTimeInMillis() + FIVE_SEC_MILLIS);
        }
        return true;
    }
}