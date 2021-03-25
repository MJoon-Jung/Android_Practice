package com.example.Calendar;

import android.text.style.BackgroundColorSpan;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

import java.util.Date;

public class StudyTimeDecorator implements DayViewDecorator {
    private CalendarDay date;
    private int study_Time = 8;

    public StudyTimeDecorator(){
        date = CalendarDay.today();
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return day.equals(date);
    }

    @Override
    public void decorate(DayViewFacade view) {
        if(study_Time == 0){
            view.addSpan((new BackgroundColorSpan(0xffffffff)));
        }else if(study_Time < 4){
            view.addSpan(new BackgroundColorSpan(0xfffce0bb));
        }else if(study_Time < 7) {
            view.addSpan(new BackgroundColorSpan(0xfffcc479));
        }else if(study_Time < 10){
            view.addSpan(new BackgroundColorSpan(0xfffaa93e));
        }else{
            view.addSpan(new BackgroundColorSpan(0xffff8503));
        }
    }
    public void setDate(Date date){
        this.date = CalendarDay.from(date);
    }

}
