package com.example.aichatapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.aichatapp.R;
import com.example.aichatapp.adapters.ChatAdapter;
import com.example.aichatapp.models.ChatModel;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {

    RecyclerView chatView;
    ChatAdapter adapter;
    ArrayList<ChatModel> chats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        chatView=findViewById(R.id.chats);
        chats=new ArrayList<>();
        chats.add(new ChatModel("12:43 PM","Lorem ipsum dolor sit amet, consectetur adipiscing elit",false));
        chats.add(new ChatModel("09:14 AM","Lorem ipsum dolor sit amet, consectetur adipiscing elit",true));
        chats.add(new ChatModel("08:31 PM","Lorem ipsum dolor sit amet, consectetur adipiscing elit",false));
        chats.add(new ChatModel("02:00 PM","Lorem ipsum dolor sit amet, consectetur adipiscing elit",true));
        chats.add(new ChatModel("07:15 PM","Lorem ipsum dolor sit amet, consectetur adipiscing elit",false));
        adapter=new ChatAdapter(chats);
        chatView.setAdapter(adapter);
        chatView.setLayoutManager(new LinearLayoutManager(this));
    }
}