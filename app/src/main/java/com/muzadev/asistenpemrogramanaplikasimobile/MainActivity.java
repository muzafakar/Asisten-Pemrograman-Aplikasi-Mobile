package com.muzadev.asistenpemrogramanaplikasimobile;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.muzadev.asistenpemrogramanaplikasimobile.adapter.ChatAdapter;
import com.muzadev.asistenpemrogramanaplikasimobile.model.Chat;

public class MainActivity extends AppCompatActivity {
    private Button btnSend;
    private EditText etMessage;
    private RecyclerView rvChat;
    private ChatAdapter chatAdapter;

    private String username = "zulfakar";

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference chatReference = database.getReference().child("chat");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSend = findViewById(R.id.btnSend);
        etMessage = findViewById(R.id.etMessage);
        rvChat = findViewById(R.id.rvChat);

        chatAdapter = new ChatAdapter(this);
        rvChat.setLayoutManager(new LinearLayoutManager(this));
        rvChat.setAdapter(chatAdapter);

        listenChatNode();

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }


    private void listenChatNode() {
        chatReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    Chat chat = data.getValue(Chat.class);
                    Log.d("CHAT GAN", chat.toString());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void sendMessage() {
        String message = etMessage.getText().toString();

        Chat chat = new Chat(username, message);
        chatReference.push().setValue(chat);
        etMessage.getText().clear();
    }
}