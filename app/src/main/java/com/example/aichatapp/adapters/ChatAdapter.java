package com.example.aichatapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aichatapp.models.ChatModel;
import com.example.aichatapp.R;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_SENT = 1;
    private static final int TYPE_RECEIVED = 2;

    private List<ChatModel> chatList;

    public ChatAdapter(List<ChatModel> chatList) {
        this.chatList = chatList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == TYPE_SENT) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_sent, parent, false);
            return new SentViewHolder(view);
        } else if (viewType == TYPE_RECEIVED) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_received, parent, false);
            return new ReceivedViewHolder(view);
        }
        throw new IllegalArgumentException("Invalid view type");
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ChatModel chatModel = chatList.get(position);

        if (holder instanceof SentViewHolder) {
            SentViewHolder sentViewHolder = (SentViewHolder) holder;
            sentViewHolder.message.setText(chatModel.getMessage());
            sentViewHolder.time.setText(chatModel.getTime());
        } else if (holder instanceof ReceivedViewHolder) {
            ReceivedViewHolder receivedViewHolder = (ReceivedViewHolder) holder;
            receivedViewHolder.message.setText(chatModel.getMessage());
            receivedViewHolder.time.setText(chatModel.getTime());
        }
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }

    @Override
    public int getItemViewType(int position) {
        ChatModel chatModel = chatList.get(position);
        return chatModel.isSent() ? TYPE_SENT : TYPE_RECEIVED;
    }

    private static class SentViewHolder extends RecyclerView.ViewHolder {
        TextView message;
        TextView time;

        SentViewHolder(@NonNull View itemView) {
            super(itemView);
            message = itemView.findViewById(R.id.message);
            time = itemView.findViewById(R.id.time);
        }
    }

    private static class ReceivedViewHolder extends RecyclerView.ViewHolder {
        TextView message;
        TextView time;

        ReceivedViewHolder(@NonNull View itemView) {
            super(itemView);
            message = itemView.findViewById(R.id.message);
            time = itemView.findViewById(R.id.time);
        }
    }
}

