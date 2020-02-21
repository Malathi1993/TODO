package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab;
    public static final int REQUEST_CODE = 100;
    public ArrayList<Task> taskList = new ArrayList<>();
    RecyclerView taskRecyclerview;
    TasksAdapter tasksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         fab = (FloatingActionButton) findViewById(R.id.fab);
         taskRecyclerview = (RecyclerView) findViewById(R.id.rv_tasks);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Todo1Activity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        taskRecyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        tasksAdapter = new TasksAdapter(this,taskList);
        taskRecyclerview.setAdapter(tasksAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            Bundle result;
            if(data != null) {
                result = data.getExtras();
                Task task = new Task();
                task.setTaskName(result.getString("task_name"));
                task.setTaskDescription(result.getString("task_desc"));
                task.setDate(result.getString("date"));
                taskList.add(task);
                tasksAdapter.updateItems(taskList);
                tasksAdapter.notifyDataSetChanged();
                Toast.makeText(this, task.getTaskName()+""+task.getTaskDescription()+""+task.getDate(), Toast.LENGTH_LONG).show();
            }
        }
    }
}

