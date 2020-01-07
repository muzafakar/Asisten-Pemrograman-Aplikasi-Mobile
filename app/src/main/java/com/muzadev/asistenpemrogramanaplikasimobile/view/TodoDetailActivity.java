package com.muzadev.asistenpemrogramanaplikasimobile.view;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.muzadev.asistenpemrogramanaplikasimobile.R;
import com.muzadev.asistenpemrogramanaplikasimobile.model.Todo;

import java.io.Serializable;

public class TodoDetailActivity extends AppCompatActivity {
    private TextView tvTodoTitle, tvTodoContent, tvTodoDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_detail);

        Serializable serializableTodo = getIntent().getSerializableExtra("todo");
        Todo todo = (Todo) serializableTodo;

        tvTodoTitle = findViewById(R.id.tvTodoTitle);
        tvTodoContent = findViewById(R.id.tvTodoContent);
        tvTodoDate = findViewById(R.id.tvTodoDate);

        tvTodoTitle.setText(todo.getTitle());
        tvTodoContent.setText(todo.getContent());
        tvTodoDate.setText(todo.getDate().toString());
    }
}
