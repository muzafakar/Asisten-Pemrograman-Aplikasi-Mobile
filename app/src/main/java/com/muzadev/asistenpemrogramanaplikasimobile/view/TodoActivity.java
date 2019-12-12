package com.muzadev.asistenpemrogramanaplikasimobile.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.muzadev.asistenpemrogramanaplikasimobile.R;
import com.muzadev.asistenpemrogramanaplikasimobile.database.AppDatabase;
import com.muzadev.asistenpemrogramanaplikasimobile.database.TodoDao;
import com.muzadev.asistenpemrogramanaplikasimobile.model.Todo;

public class TodoActivity extends AppCompatActivity {
    private EditText etTodoContent, etTodoTitle;
    private Button btnSave;
    private TodoDao todoDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        etTodoContent = findViewById(R.id.etTodoContent);
        etTodoTitle = findViewById(R.id.etTodoTitle);
        btnSave = findViewById(R.id.btnSave);

        todoDao = AppDatabase.getInstance(this).todoDao();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveTodo();
            }
        });
    }

    private void saveTodo() {
        String title = etTodoTitle.getText().toString();
        String content = etTodoContent.getText().toString();
        Todo todo = new Todo(title, content);
        todoDao.createTodo(todo);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
