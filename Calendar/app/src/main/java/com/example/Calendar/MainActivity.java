package com.example.Calendar;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private RequestQueue requestQueue;
    private String userID = "gjgjajaj";
    private ArrayList<String> studyTimes = new ArrayList<>();
    private ArrayList<String> studyDates = new ArrayList<>();
    private MaterialCalendarView materialCalendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Volley Queue  & request json
        requestQueue = Volley.newRequestQueue(this);
        parseJson();

        OneDayDecorator oneDayDecorator = new OneDayDecorator();

        materialCalendarView = findViewById(R.id.calendarView);
        materialCalendarView.setSelectedDate(CalendarDay.today());

        // calendar view setting
        materialCalendarView.state().edit()
                .setFirstDayOfWeek(Calendar.SUNDAY)
                .setMinimumDate(CalendarDay.from(2000, 1, 1))
                .setMaximumDate(CalendarDay.from(2049, 12, 31))
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                .commit();

        //Decorator event  customizing
        materialCalendarView.addDecorators(
                new MySelectorDecorator(this),
                new SundayDecorator(),
                new SaturdayDecoractor(),
                oneDayDecorator,
                new EventDecorator(Color.RED, Collections.singleton(CalendarDay.today()))
        );
    }
    // _GET request json
    private void parseJson(){
        String url = String.format("http://gjgjajaj.dothome.co.kr/study.php?userID=%s",userID);
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try {
                            //json object >> {response:[{key : value}, {.....
                            JSONObject jsonObject = new JSONObject(response);

                            //object start name : response  >>>>> array
                            JSONArray jsonArray = jsonObject.getJSONArray("response");

                            for(int i = 0; i < jsonArray.length(); i++){

                                // {time : ? , date : ? } ......
                                JSONObject studyObject = jsonArray.getJSONObject(i);
                                String time = studyObject.getString("studyTime");
                                String date = studyObject.getString("studyDate");
//                                studyTime.add(time);
//                                studyDate.add(date);
                                materialCalendarView.addDecorator(new StudyDate(MainActivity.this, time, date));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(request);
    }
}