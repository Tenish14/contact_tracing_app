package com.example.mysejahtera;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StatisticsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NotificationsFragment extends Fragment {

    RecyclerView notificationsView;
    List<Notification> notifications;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NotificationsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StatisticsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StatisticsFragment newInstance(String param1, String param2) {
        StatisticsFragment fragment = new StatisticsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);
        notificationsView = view.findViewById(R.id.notifications_view);
        initData();
        initRecyclerView();

        // Inflate the layout for this fragment
        return view;
    }

    private void initRecyclerView() {
        NotificationsAdapter notificationsAdapter = new NotificationsAdapter(notifications);
        notificationsView.setAdapter(notificationsAdapter);
    }


    private void initData() {
        notifications = new ArrayList<>();
        notifications.add(new Notification("Registration Complete", "You have successfully completed your registration, congrats!"));
        notifications.add(new Notification("Approved for vaccine", "You have been approved for vaccine, your appointment is on 24th May 2025."));
        notifications.add(new Notification("New high score for cases in Malaysia", "Malaysia has achieved a new high score!"));
        notifications.add(new Notification("Why tho", "I don't know"));
        notifications.add(new Notification("Rejected for vaccine", "They don't anna give you :("));
        notifications.add(new Notification("Registration Complete", "You have successfully completed your registration, congrats!"));
        notifications.add(new Notification("Approved for vaccine", "You have been approved for vaccine, your appointment is on 24th May 2025."));
        notifications.add(new Notification("New high score for cases in Malaysia", "Malaysia has achieved a new high score!"));
        notifications.add(new Notification("Why tho", "I don't know"));
        notifications.add(new Notification("Rejected for vaccine", "They don't anna give you :("));

    }
}