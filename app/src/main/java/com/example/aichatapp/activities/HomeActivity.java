package com.example.aichatapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.aichatapp.R;
import com.example.aichatapp.adapters.MessagesAdapter;
import com.example.aichatapp.models.MessageModel;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    RecyclerView messagesView;
    ArrayList<MessageModel> models;
    MessagesAdapter adapter;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        back=findViewById(R.id.back);
        messagesView=findViewById(R.id.messages_view);
        models=new ArrayList<>();
        models.add(new MessageModel("Jos Butler","Lorem ipsum dolor sit amet, consectetur adipiscing elit","1 hour"));
        models.add(new MessageModel("Mark Wood","Lorem ipsum dolor sit amet, consectetur adipiscing elit","2 hour"));
        models.add(new MessageModel("James Anderson","Lorem ipsum dolor sit amet, consectetur adipiscing elit","45 mins"));
        adapter=new MessagesAdapter(models);
        messagesView.setLayoutManager(new LinearLayoutManager(this));
        messagesView.setAdapter(adapter);
        adapter.setOnItemClicked(new MessagesAdapter.OnItemClicked() {
            @Override
            public void onClick(int position) {
                startActivity(new Intent(HomeActivity.this,ChatActivity.class));
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeActivity.super.onBackPressed();
            }
        });
    }
}