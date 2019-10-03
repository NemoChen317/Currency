package com.home.currency;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.text.DecimalFormat;
import java.util.concurrent.ExecutionException;

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
            showAlert("Result" , "USD is " + df.format(number));
        }catch (Exception e){
            showAlert("Problem" , "Please enter your NTD amount");
        }
    }

    public void showAlert(String title , String content){
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(content)
                .setPositiveButton("OK" , null)
                .show();
    }
}
