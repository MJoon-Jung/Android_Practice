package com.example.Calendar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;


public class DayFragment extends Fragment {

    private PieChart piechart;
    private HorizontalBarChart barChart;

    private int [] c = new int [] {Color.parseColor("#15ff00"), Color.parseColor("#fbff00"),
            Color.parseColor("#ff2200"), Color.parseColor("#2b00ff")};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_day, container, false);

        barChart = (HorizontalBarChart) v.findViewById(R.id.barChart);
        setBarData();

        piechart = (com.github.mikephil.charting.charts.PieChart) v.findViewById(R.id.piechart);
        setPieData();

        return v;
    }

    //PieChart data setting
    private void setPieData(){
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

    // BarChart data setting
    private void setBarData(){
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1f, 10f));
        barEntries.add(new BarEntry(2f, 20f));
        barEntries.add(new BarEntry(3f, 30f));
        barEntries.add(new BarEntry(4f, 40f));

        ArrayList<String> xAxisName = new ArrayList<>();
        xAxisName.add("Name 1");
        xAxisName.add("Name 2");
        xAxisName.add("Name 3");
        xAxisName.add("Name 4");

        setBar(barEntries,xAxisName);
    }
    private void setBar(ArrayList<BarEntry> arrayList, final ArrayList<String> xAxisValues){
        barChart.setDrawBarShadow(false);
        barChart.setFitBars(true);
        barChart.setDrawValueAboveBar(true);
        barChart.setMaxVisibleValueCount(25);
        barChart.setPinchZoom(true);

        barChart.setDrawGridBackground(true);
        BarDataSet barDataSet = new BarDataSet(arrayList, "Values");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        BarData barData = new BarData(barDataSet);
        barData.setBarWidth(0.9f);
        barData.setValueTextSize(0f);

        barChart.setBackgroundColor(Color.TRANSPARENT); //set whatever color you prefer
        barChart.setDrawGridBackground(false);

        Legend l = barChart.getLegend(); // Customize the ledgends
        l.setTextSize(10f);
        l.setFormSize(10f);
//To set components of x axis
        XAxis xAxis = barChart.getXAxis();
        xAxis.setTextSize(13f);
        xAxis.setPosition(XAxis.XAxisPosition.TOP_INSIDE);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xAxisValues));
        xAxis.setDrawGridLines(false);

        barChart.setData(barData);
    }

}