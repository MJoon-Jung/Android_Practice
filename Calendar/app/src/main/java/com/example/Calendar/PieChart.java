package com.example.Calendar;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

public class PieChart extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        int [] c = new int [] {Color.parseColor("#15ff00"), Color.parseColor("#fbff00"),
                Color.parseColor("#ff2200"), Color.parseColor("#2b00ff")};

        com.github.mikephil.charting.charts.PieChart piechart = (com.github.mikephil.charting.charts.PieChart) findViewById(R.id.piechart);

        List<PieEntry> entries = new ArrayList<>();

        entries.add(new PieEntry(18.5f, "Green"));
        entries.add(new PieEntry(26.7f, "Yellow"));
        entries.add(new PieEntry(30.8f, "Red"));
        entries.add(new PieEntry(24.0f, "Blue"));

        PieDataSet set = new PieDataSet(entries, "Election Results");
        set.setColors(c);
        PieData data = new PieData(set);
        piechart.setData(data);
        piechart.invalidate();

    }
}