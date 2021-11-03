package com.example.mysejahtera;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    SharedPreferences sp;
    TextView nameView, nricView, phoneNumberView;
    String name, phoneNumber, nric;

    public DetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailsFragment newInstance(String param1, String param2) {
        DetailsFragment fragment = new DetailsFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        ImageView returnArrow = view.findViewById(R.id.return_arrow);

        returnArrow.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction().replace(R.id.container, new ProfileFragment()).commit();
        });

        nameView = view.findViewById(R.id.nameValue);
        nricView = view.findViewById(R.id.icValue);
        phoneNumberView = view.findViewById(R.id.phoneNumValue);

        sp = getActivity().getSharedPreferences("userPrefs", Context.MODE_PRIVATE);

        name = sp.getString("name", "");
        nric = sp.getString("nric", "");
        phoneNumber = sp.getString("phoneNumber", "");

        nameView.setText(name.isEmpty() ? "-" : name);
        nricView.setText(nric.isEmpty() ? "-" : nric);
        phoneNumberView.setText(phoneNumber.isEmpty() ? "-" : phoneNumber);

        return view;
    }
}