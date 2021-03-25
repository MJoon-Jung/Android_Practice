//package com.example.Calendar;
//
//import android.app.AlertDialog;
//import android.app.DatePickerDialog;
//import android.app.Dialog;
//import android.os.Bundle;
//import android.widget.DatePicker;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.DialogFragment;
//
//import java.util.Calendar;
//
//public class DatePickerDialogTheme1 extends DialogFragment implements DatePickerDialog.OnDateSetListener{
//    @NonNull
//    @Override
//    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
//        final Calendar calendar = Calendar.getInstance();
//        int year = calendar.get(Calendar.YEAR);
//        int month = calendar.get(Calendar.MONTH);
//        int day = calendar.get(Calendar.DAY_OF_MONTH);
//
//        DatePickerDialog datepickerdialog = new DatePickerDialog(getActivity(),
//                AlertDialog.THEME_HOLO_DARK,this,year,month,day);
//
//        return datepickerdialog;
//    }
//    public void onDateSet(DatePicker view, int year, int month, int day){
//
//        TextView textview = (TextView)getActivity().findViewById(R.id.text_colorpicker);
//
//        textview.setText(day + ":" + (month+1) + ":" + year);
//
//    }
//}