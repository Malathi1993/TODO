package com.example.myapplication;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.ViewHolder>{
    private List<Task> data;
    private Context context;

    public TasksAdapter(Context context, List<Task> data) {
        this.data = data;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_activity, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Task task = ((Task) data.get(position));
        holder.name.setText(task.getTaskName());
        holder.desc.setText(task.getTaskDescription());
        holder.date.setText(task.getDate());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void updateItems(List<Task> latestItems){
        data.clear();
        data.addAll(latestItems);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView desc;
        public TextView date;

        public ViewHolder(@NonNull View v) {
            super(v);

            name = (TextView) v.findViewById(R.id.tv_name);
            desc = (TextView) v.findViewById(R.id.tv_name1);
            date = (TextView) v.findViewById(R.id.tv_name2);

        }
    }
}
