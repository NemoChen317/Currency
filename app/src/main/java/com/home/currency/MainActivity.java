package com.home.currency;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText ndt;
    private Double us = 30.9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
    }

    private void findViews() {
        ndt = findViewById(R.id.ntd);
    }

    public void convert(View view){
        try {
            Double number = Double.parseDouble(ndt.getText().toString());
            Log.d(TAG, "convert: " + number);
            number = number / us;
            DecimalFormat df = new DecimalFormat("#.0000");
            showAlert(getString(R.string.result) , getString(R.string.usd_is) + df.format(number));
        }catch (Exception e){
            showAlert(getString(R.string.problem) , getString(R.string.please_enter_ntd));
        }
    }

    public void showAlert(String title , String content){
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(content)
                .setPositiveButton(getString(R.string.ok) , null)
                .show();
    }
}
