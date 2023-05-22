package com.example.aichatapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.LayoutInflaterCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aichatapp.R;
import com.example.aichatapp.models.MessageModel;

import java.util.ArrayList;

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.MessagesViewHolder> {

    ArrayList<MessageModel> models;

    public MessagesAdapter(ArrayList<MessageModel> models) {
        this.models = models;
    }

    public interface OnItemClicked{
        void onClick(int position);
    }

    OnItemClicked onItemClicked;

    public void setOnItemClicked(OnItemClicked onItemClicked) {
        this.onItemClicked = onItemClicked;
    }

    @NonNull
    @Override
    public MessagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MessagesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_messages,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MessagesViewHolder holder, int position) {
        holder.hour.setText(models.get(position).getTime());
        holder.name.setText(models.get(position).getName());
        holder.initial.setText(String.valueOf(Character.toUpperCase(models.get(position).getName().charAt(0))));
        holder.message.setText(models.get(position).getLastMessage());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class MessagesViewHolder extends RecyclerView.ViewHolder{
        TextView name,initial,hour,message;
        public MessagesViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClicked.onClick(getAdapterPosition());
                    name=itemView.findViewById(R.id.name);
                    initial=itemView.findViewById(R.id.initial);
                    hour=itemView.findViewById(R.id.time);
                    message=itemView.findViewById(R.id.message);
                }
            });
        }
    }
}
