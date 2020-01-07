package com.muzadev.asistenpemrogramanaplikasimobile.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.muzadev.asistenpemrogramanaplikasimobile.R;
import com.muzadev.asistenpemrogramanaplikasimobile.model.Todo;
import com.muzadev.asistenpemrogramanaplikasimobile.view.TodoDetailActivity;

import java.util.ArrayList;
import java.util.List;

public class AdpTodo extends RecyclerView.Adapter<AdpTodo.ViewHolder> {
    private Context context;
    private AdapterCallback adapterCallback;
    private List<Todo> todoList;

    public AdpTodo(Context context, AdapterCallback adapterCallback) {
        this.context = context;
        this.adapterCallback = adapterCallback;
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

    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {
        private TextView tvTodoTitle, tvTodoContent;
        private Todo selectedTodo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTodoTitle = itemView.findViewById(R.id.tvTodoTitle);
            tvTodoContent = itemView.findViewById(R.id.tvTodoContent);
            itemView.setOnCreateContextMenuListener(this);
        }

        public void bindView(final Todo todo) {
            tvTodoTitle.setText(todo.getTitle());
            tvTodoContent.setText(todo.getContent());
            this.selectedTodo = todo;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, TodoDetailActivity.class);
                    intent.putExtra("todo", todo);
                    context.startActivity(intent);
                }
            });
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            // create the context menu
            MenuItem menuEdit = menu.add(Menu.NONE, 1, 1, "Edit");
            MenuItem menuDelete = menu.add(Menu.NONE, 2, 2, "Delete");

            menuEdit.setOnMenuItemClickListener(this);
            menuDelete.setOnMenuItemClickListener(this);
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case 1:
                    // handle edit
                    adapterCallback.menuEdit(selectedTodo);
                    break;
                case 2:
                    // handle delete
                    adapterCallback.menuDelete(selectedTodo);
                    break;
            }
            return true;
        }
    }
}
