package com.example.mysejahtera.ui.history;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mysejahtera.R;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {

    private static final String TAG = "NotificationAdapter";
    List<History> historyList;

    public HistoryAdapter(List<History> historyList) { this.historyList = historyList; }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_card, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull HistoryAdapter.MyViewHolder holder, int position) {
        History history = historyList.get(position);
        holder.locationTextView.setText(history.getLocation());
        holder.dateTextView.setText(history.getDate());
        holder.timeTextView.setText(history.getTime());
    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView locationTextView, dateTextView, timeTextView;

        public MyViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);

            locationTextView = itemView.findViewById(R.id.location);
            dateTextView = itemView.findViewById(R.id.date);
            timeTextView = itemView.findViewById(R.id.time);
        }
    }
}
