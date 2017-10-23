package com.ubt.ubt2kgmotordemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ubt.ip.sdk.api.MotorApi;
import com.ubt.ip.sdk.bean.MotorBean;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testGetMotors();
    }

    private void testGetMotors() {
        new Thread() {
            @Override
            public void run() {
                int[] motorsId = new int[]{1, 2, 3, 4, 5, 6, 7};
                int[] motorsDegree = new int[motorsId.length];
                MotorApi.get().getMotors(motorsId, motorsDegree);
                Log.e(TAG, "motorsId: " + Arrays.toString(motorsId));
                Log.e(TAG, "motorsDegree: " + Arrays.toString(motorsDegree));
            }
        }.start();
    }
}
