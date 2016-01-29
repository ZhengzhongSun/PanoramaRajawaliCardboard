package com.eje_c.rajawalicardboard;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

/**
 * Created by Dobbie on 2015/9/12.
 */
public class HomeActivity extends Activity implements View.OnClickListener {
    Button Button1 = null;
    Button Button2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        findview();
    }
    public void findview(){
        Button1 = (Button)findViewById(R.id.button);
        Button2 = (Button)findViewById(R.id.button2);
        Button1.setOnClickListener(this);
        Button2.setOnClickListener(this);
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Intent intent1 = new Intent(HomeActivity.this,PhotoActivity.class);
                startActivity(intent1);
                break;
            case R.id.button2:
                Intent intent2 = new Intent (HomeActivity.this,VideoActivity.class);
                startActivity(intent2);
                break;
            default:
                break;
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            showSureDialogPlay();
        }

        return super.onKeyDown(keyCode, event);
    }
    public void showSureDialogPlay() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.exit_alert);
        builder.setPositiveButton(R.string.str_ok,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        HomeActivity.this.finish();
                    }
                });
        builder.setNegativeButton(R.string.str_cancel, null);
        builder.show();
    }
}
