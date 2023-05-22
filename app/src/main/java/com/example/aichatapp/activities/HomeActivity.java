package com.example.aichatapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.aichatapp.R;
import com.example.aichatapp.adapters.MessagesAdapter;
import com.example.aichatapp.models.MessageModel;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    RecyclerView messagesView;
    ArrayList<MessageModel> models;
    MessagesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        messagesView=findViewById(R.id.messages_view);
        models=new ArrayList<>();
        models.add(new MessageModel("Jos Butler","I just got free from game, sorry could not see message earlier","1 hour"));
        models.add(new MessageModel("Mark Wood","I saw you play yesterday, your game is astonishing","2 hour"));
        models.add(new MessageModel("James Anderson","Yeah I was there, do you know who else was there?","45 mins"));
        adapter=new MessagesAdapter(models);
        messagesView.setLayoutManager(new LinearLayoutManager(this));
        messagesView.setAdapter(adapter);
        adapter.setOnItemClicked(new MessagesAdapter.OnItemClicked() {
            @Override
            public void onClick(int position) {
                
            }
        });
    }
}