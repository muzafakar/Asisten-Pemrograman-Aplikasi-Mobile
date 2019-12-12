package com.muzadev.asistenpemrogramanaplikasimobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.muzadev.asistenpemrogramanaplikasimobile.R;
import com.muzadev.asistenpemrogramanaplikasimobile.model.Todo;

import java.util.ArrayList;
import java.util.List;

public class AdpTodo extends RecyclerView.Adapter<AdpTodo.ViewHolder> {
    private Context context;
    private List<Todo> todoList;

    public AdpTodo(Context context) {
        this.context = context;
        todoList = new ArrayList<>();
    }

    public void setData(List<Todo> todoList) {
        this.todoList.clear();
        this.todoList.addAll(todoList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_todo, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindView(todoList.get(position));
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTodoTitle, tvTodoContent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTodoTitle = itemView.findViewById(R.id.tvTodoTitle);
            tvTodoContent = itemView.findViewById(R.id.tvTodoContent);
        }

        public void bindView(Todo todo) {
            tvTodoTitle.setText(todo.getTitle());
            tvTodoContent.setText(todo.getContent());
        }
    }
}
