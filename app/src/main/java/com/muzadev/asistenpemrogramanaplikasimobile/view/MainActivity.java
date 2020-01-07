package com.muzadev.asistenpemrogramanaplikasimobile.view;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.muzadev.asistenpemrogramanaplikasimobile.R;
import com.muzadev.asistenpemrogramanaplikasimobile.adapter.AdapterCallback;
import com.muzadev.asistenpemrogramanaplikasimobile.adapter.AdpTodo;
import com.muzadev.asistenpemrogramanaplikasimobile.database.AppDatabase;
import com.muzadev.asistenpemrogramanaplikasimobile.database.TodoDao;
import com.muzadev.asistenpemrogramanaplikasimobile.model.Todo;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterCallback {
    private RecyclerView rvTodo;
    private AdpTodo adpTodo;
    private TodoDao todoDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todoDao = AppDatabase.getInstance(this).todoDao();
        adpTodo = new AdpTodo(this, this);
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
        try {
            adpTodo.setData(new ReadTodoAsync().execute().get());
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    @Override
    public void menuEdit(Todo todo) {
        // handle edit
        Intent intent = new Intent(this, TodoActivity.class);
        intent.putExtra("todo", todo);
        startActivity(intent);
    }

    @Override
    public void menuDelete(Todo todo) {
        // handle delete
        new DeleteTodoAsync().execute(todo);
        getTodoData();
    }

    private class ReadTodoAsync extends AsyncTask<Void, Void, List<Todo>> {
        @Override
        protected List<Todo> doInBackground(Void... voids) {
            return todoDao.readAllTodo();
        }
    }

    private class DeleteTodoAsync extends AsyncTask<Todo, Void, Void> {
        @Override
        protected Void doInBackground(Todo... todos) {
            todoDao.deleteTodo(todos[0].getId());
            return null;
        }
    }
}
