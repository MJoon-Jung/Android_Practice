package com.example.Calendar;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private long backBtnTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OneDayDecorator oneDayDecorator = new OneDayDecorator();

        MaterialCalendarView materialCalendarView = findViewById(R.id.calendarView);
        materialCalendarView.setSelectedDate(CalendarDay.today());


        materialCalendarView.addDecorators(
                new MySelectorDecorator(this),
                new SundayDecorator(),
                new SaturdayDecoractor(),
                oneDayDecorator,
                new EventDecorator(Color.RED, Collections.singleton(CalendarDay.today()))

        );
    }
}