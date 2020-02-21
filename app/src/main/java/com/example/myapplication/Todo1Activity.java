package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Todo1Activity extends AppCompatActivity {
    TextView date;
    EditText task_name;
    EditText work_discription;
    //CalendarView calendarView;
    Button calender_picker;
    Button add_task;
    private int mYear, mMonth, mDay;
    private View calendar_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo1);

        task_name = (EditText) findViewById(R.id.et_TaskName);
        work_discription = (EditText) findViewById(R.id.et_Discription);
        date = (TextView) findViewById(R.id.date);
        add_task = (Button) findViewById(R.id.btn_addtask);
        calender_picker = (Button) findViewById(R.id.btn_Calendarpicker);
        calender_picker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalenderDialog();
            }
        });

        add_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTask();
            }
        });
    }

    public void showCalenderDialog() {
        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                        date.setVisibility(View.VISIBLE);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.setCancelable(true);
        datePickerDialog.show();
    }

    public void addTask(){
        Intent intent = new Intent();
        Bundle data = new Bundle();
        data.putString("task_name", task_name.getText().toString());
        data.putString("task_desc", work_discription.getText().toString());
        data.putString("date", date.getText().toString());
        intent.putExtras(data);
        setResult(RESULT_OK, intent);
        finish();
    }

}


