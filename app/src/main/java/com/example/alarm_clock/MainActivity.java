package com.example.alarm_clock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button butset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butset = findViewById(R.id.but_set);

        butset.setOnClickListener(v ->{
            MaterialTimePicker materialTimePicker = new MaterialTimePicker.Builder()
                    .setTimeFormat(TimeFormat.CLOCK_24H)
                    .setHour(12)
                    .setMinute(0)
                    .setTitleText("Choose time for clock")
                    .build();

            materialTimePicker.addOnPositiveButtonClickListener(view ->{
                Calendar calendar = Calendar.getInstance();
                calendar.set(calendar.SECOND,0);
                calendar.set(calendar.MILLISECOND, 0);
                calendar.set(calendar.MINUTE, materialTimePicker.getMinute());
                calendar.set(calendar.MINUTE, Calendar.HOUR_OF_DAY, materialTimePicker.getHour());

            });

            materialTimePicker.show(getSupportFragmentManager(),"tag_picker");
        });
    }
}