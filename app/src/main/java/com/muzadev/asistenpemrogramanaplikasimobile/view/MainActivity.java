package com.muzadev.asistenpemrogramanaplikasimobile.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.muzadev.asistenpemrogramanaplikasimobile.R;
import com.muzadev.asistenpemrogramanaplikasimobile.adapter.AdpTodo;
import com.muzadev.asistenpemrogramanaplikasimobile.database.AppDatabase;
import com.muzadev.asistenpemrogramanaplikasimobile.database.TodoDao;
import com.muzadev.asistenpemrogramanaplikasimobile.model.Todo;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvTodo;
    private AdpTodo adpTodo;
    private TodoDao todoDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todoDao = AppDatabase.getInstance(this).todoDao();
        adpTodo = new AdpTodo(this);
        rvTodo = findViewById(R.id.rvTodo);
        rvTodo.setLayoutManager(new LinearLayoutManager(this));
        rvTodo.addItemDecoration(new DividerItemDecoration(this, RecyclerView.VERTICAL));
        rvTodo.setAdapter(adpTodo);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getTodoData();
    }

    private void getTodoData() {
        List<Todo> data = todoDao.readAllTodo();
        adpTodo.setData(data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuAdd) {
            startActivity(new Intent(this, TodoActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
