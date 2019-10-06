package com.muzadev.asistenpemrogramanaplikasimobile;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.muzadev.asistenpemrogramanaplikasimobile.adapter.CustomListAdapter;
import com.muzadev.asistenpemrogramanaplikasimobile.model.PlayerModel;

import java.util.ArrayList;
import java.util.List;

public class CustomListViewActivity extends AppCompatActivity {
    private CustomListAdapter adapter;
    private List<PlayerModel> playerModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);
        generateDummyData();

        adapter = new CustomListAdapter(this, playerModelList);
        ListView listView = findViewById(R.id.lvCustom);
        listView.setAdapter(adapter);
    }

    private void generateDummyData() {
        playerModelList = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            PlayerModel playerModel = new PlayerModel(
                    "Player-" + i,
                    "Position" + 1,
                    i
            );

            playerModelList.add(playerModel);
        }
    }
}
