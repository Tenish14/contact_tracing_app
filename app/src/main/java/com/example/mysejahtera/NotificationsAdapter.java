package com.example.mysejahtera;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotificationsAdapter extends RecyclerView.Adapter<NotificationsAdapter.MyViewHolder> {

    private static final String TAG = "NotificationAdapter";
    List<Notification> notifications;

    public NotificationsAdapter(List<Notification> notifications) { this.notifications = notifications; }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_card, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull NotificationsAdapter.MyViewHolder holder, int position) {
        Notification notification = notifications.get(position);
        holder.titleTextView.setText(notification.getTitle());
        holder.descTextView.setText(notification.getDesc());

        boolean isExpanded = notifications.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titleTextView, descTextView;
        ConstraintLayout expandableLayout, textContainer;

        public MyViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.titleTextView);
            descTextView = itemView.findViewById(R.id.descTextView);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);
            textContainer = itemView.findViewById(R.id.textContainer);

            textContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Notification notification = notifications.get(getAdapterPosition());
                    notification.setExpanded(!notification.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
