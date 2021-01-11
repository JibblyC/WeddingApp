package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private TextView mdaysLeftHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mdaysLeftHolder = (TextView) findViewById(R.id.daysLeftHolder);
        calculateDatesAndShow();
    }

    @Override
    protected void onResume() {
        super.onResume();
        calculateDatesAndShow();
    }

    private void calculateDatesAndShow(){
        Date currentDate =  new Date();
        Date weddingDate = null;
        try {
            weddingDate = new SimpleDateFormat("yyyy-MM-dd").parse("2022-03-04");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Long diff = TimeUnit.DAYS.convert(currentDate.getTime() - weddingDate.getTime(), TimeUnit.MILLISECONDS);

        if (mdaysLeftHolder != null)
            mdaysLeftHolder.setText(Integer.toString((diff.intValue() * -1) + 1));
    }

    public void sendTheLove(View view) {
        Toast toast = Toast.makeText(this,R.string.toast_message,Toast.LENGTH_SHORT);
        toast.show();
    }
}