package com.eje_c.rajawalicardboard;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.vrtoolkit.cardboard.CardboardActivity;

/**
 * Created by Dobbie on 2015/9/12.
 */
public class MainActivity extends CardboardActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                MainActivity.this.finish();
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        }, 1000);
    }
}
