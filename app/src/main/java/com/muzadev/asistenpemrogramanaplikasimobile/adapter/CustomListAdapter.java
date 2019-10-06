package com.muzadev.asistenpemrogramanaplikasimobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.muzadev.asistenpemrogramanaplikasimobile.R;
import com.muzadev.asistenpemrogramanaplikasimobile.model.PlayerModel;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Context context;
    private List<PlayerModel> playerList;

    public CustomListAdapter(Context context, List<PlayerModel> playerList) {
        this.context = context;
        this.playerList = playerList;
    }

    @Override
    public int getCount() {
        return playerList.size();
    }

    @Override
    public Object getItem(int i) {
        return playerList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View layout = LayoutInflater.from(context).inflate(R.layout.item_custom, viewGroup, false);

        TextView tvPlayerName = layout.findViewById(R.id.tvPlayerName);
        TextView tvPlayerPosition = layout.findViewById(R.id.tvPlayerPosition);
        TextView tvPlayerNumber = layout.findViewById(R.id.tvPlayerNumber);

        tvPlayerName.setText(playerList.get(i).getPlayerName());
        tvPlayerPosition.setText(playerList.get(i).getPlayerPosition());
        tvPlayerNumber.setText(Integer.toString(playerList.get(i).getPlayerNumber()));


        return layout;
    }
}
