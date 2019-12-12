package com.muzadev.asistenpemrogramanaplikasimobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.muzadev.asistenpemrogramanaplikasimobile.R;
import com.muzadev.asistenpemrogramanaplikasimobile.model.Chat;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends BaseAdapter {
    private Context context;
    private List<Chat> chatList;

    public ListAdapter(Context context) {
        this.context = context;
        chatList = new ArrayList<>();
    }

    public void setData(List<Chat> chatData) {
        chatList.clear();
        chatList.addAll(chatData);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return chatList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_chat, parent, false);
        TextView tvUsername = view.findViewById(R.id.tvUsername);
        tvUsername.setText(chatList.get(position).getUsername());

        TextView tvMessage = view.findViewById(R.id.tvMessage);
        tvMessage.setText(chatList.get(position).getMessage());
        return view;
    }
}
