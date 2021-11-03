package com.example.mysejahtera;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mysejahtera.ui.history.HistoryFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditProfileFragment extends Fragment {

    SharedPreferences sp;
    EditText nameView, phoneNumberView, stateView, cityView, postcodeView, lineOneView, lineTwoView;
    String name, phoneNumber, state, city, postcode, lineOne, lineTwo;
    Button saveBtn;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EditProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EditProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EditProfileFragment newInstance(String param1, String param2) {
        EditProfileFragment fragment = new EditProfileFragment();
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
        View view = inflater.inflate(R.layout.fragment_edit_profile, container, false);
        ImageView returnArrow = view.findViewById(R.id.return_arrow);

        returnArrow.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction().replace(R.id.container, new DetailsFragment()).commit();
        });

        // Find views
        nameView = view.findViewById(R.id.name);
        phoneNumberView = view.findViewById(R.id.phoneNumber);
        stateView = view.findViewById(R.id.state);
        cityView = view.findViewById(R.id.city);
        postcodeView = view.findViewById(R.id.postcode);
        lineOneView = view.findViewById(R.id.line1);
        lineTwoView = view.findViewById(R.id.line2);
        saveBtn = view.findViewById(R.id.saveBtn);

        sp = getActivity().getSharedPreferences("userPrefs", Context.MODE_PRIVATE);

        // Get shared prefs values
        name = sp.getString("name", "");
        phoneNumber = sp.getString("phoneNumber", "");
        state = sp.getString("state", "");
        city = sp.getString("city", "");
        postcode = sp.getString("postcode", "");
        lineOne = sp.getString("lineOne", "");
        lineTwo = sp.getString("lineTwo", "");

        // Set text if any
        nameView.setText(name.isEmpty() ? "" : name);
        phoneNumberView.setText(phoneNumber.isEmpty() ? "" : phoneNumber);
        stateView.setText(state.isEmpty() ? "" : state);
        cityView.setText(city.isEmpty() ? "" : city);
        postcodeView.setText(postcode.isEmpty() ? "" : postcode);
        lineOneView.setText(lineOne.isEmpty() ? "" : lineOne);
        lineTwoView.setText(lineTwo.isEmpty() ? "" : lineTwo);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (phoneNumberView.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "Phone Number Missing", Toast.LENGTH_LONG).show();
                    return;
                }

                if (nameView.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "Name Missing", Toast.LENGTH_LONG).show();
                    return;
                }
                SharedPreferences.Editor editor = sp.edit();

                editor.putString("name", nameView.getText().toString());
                editor.putString("phoneNumber", phoneNumberView.getText().toString());
                editor.putString("state", stateView.getText().toString());
                editor.putString("city", cityView.getText().toString());
                editor.putString("postcode", postcodeView.getText().toString());
                editor.putString("lineOne", lineOneView.getText().toString());
                editor.putString("lineTwo", lineTwoView.getText().toString());


                editor.apply();
                Toast.makeText(getActivity(), "Edited Successfully", Toast.LENGTH_LONG).show();

                getParentFragmentManager().beginTransaction().replace(R.id.container, new DetailsFragment()).commit();
            }
        });

        return view;
    }
}