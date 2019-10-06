package com.muzadev.asistenpemrogramanaplikasimobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnToCustomList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnToCustomList = findViewById(R.id.btnCustomList);
        btnToCustomList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent customListIntent = new Intent(MainActivity.this, CustomListViewActivity.class);
                startActivity(customListIntent);
            }
        });
    }
}
