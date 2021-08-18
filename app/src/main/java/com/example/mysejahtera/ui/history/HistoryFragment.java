package com.example.mysejahtera.ui.history;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mysejahtera.ProfileFragment;
import com.example.mysejahtera.R;
import com.example.mysejahtera.StatisticsFragment;
import com.example.mysejahtera.VaccineEducation;
import com.example.mysejahtera.ui.history.History;
import com.example.mysejahtera.ui.history.HistoryAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StatisticsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HistoryFragment extends Fragment {

    RecyclerView historyView;
    List<History> historyList;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HistoryFragment() {
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
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        historyView = view.findViewById(R.id.history_view);
        initData();
        initRecyclerView();

        ImageView returnArrow = view.findViewById(R.id.return_arrow);

        returnArrow.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction().replace(R.id.container, new ProfileFragment()).commit();
        });

//      Inflate the layout for this fragment
        return view;
    }

    private void initRecyclerView() {
        HistoryAdapter historyAdapter = new HistoryAdapter(historyList);
        historyView.setAdapter(historyAdapter);
    }


    private void initData() {
        historyList = new ArrayList<>();
        historyList.add(new History("Straits Quay", "24/06/2021", "2.31pm"));
        historyList.add(new History("Gurney Plaza", "22/06/2021", "12.34pm"));
        historyList.add(new History("Restaurant", "21/06/2021", "8.31am"));
        historyList.add(new History("Straits Quay", "24/06/2021", "2.31pm"));
        historyList.add(new History("Gurney Plaza", "22/06/2021", "12.34pm"));
        historyList.add(new History("Restaurant", "21/06/2021", "8.31am"));
        historyList.add(new History("Straits Quay", "24/06/2021", "2.31pm"));
        historyList.add(new History("Gurney Plaza", "22/06/2021", "12.34pm"));
        historyList.add(new History("Restaurant", "21/06/2021", "8.31am"));
        historyList.add(new History("Straits Quay", "24/06/2021", "2.31pm"));
        historyList.add(new History("Gurney Plaza", "22/06/2021", "12.34pm"));
        historyList.add(new History("Restaurant", "21/06/2021", "8.31am"));

    }
}