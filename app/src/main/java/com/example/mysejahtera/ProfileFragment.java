package com.example.mysejahtera;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mysejahtera.ui.history.HistoryFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    SharedPreferences sp;
    TextView nameView;
    String name;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ImageView profilePic = view.findViewById(R.id.profile_pic);


        // Not dynamic right now, TODO: handle dynamic images

        // To set a circular radius around image
        //get bitmap of the image
        Bitmap imageBitmap= BitmapFactory.decodeResource(getResources(),  R.drawable.empty_pic);
        RoundedBitmapDrawable roundedBitmapDrawable= RoundedBitmapDrawableFactory.create(getResources(), imageBitmap);

        //setting radius
        roundedBitmapDrawable.setCircular(true);
        roundedBitmapDrawable.setAntiAlias(true);
        profilePic.setImageDrawable(roundedBitmapDrawable);

        CardView historyCard = view.findViewById(R.id.history_card);
        CardView profileCard = view.findViewById(R.id.profile_card);
        CardView vaccineCard = view.findViewById(R.id.vaccine_card);
        CardView signOutCard = view.findViewById(R.id.sign_out_card);

        historyCard.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction().replace(R.id.container, new HistoryFragment()).commit();
        });

        profileCard.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction().replace(R.id.container, new DetailsFragment()).commit();
        });

        vaccineCard.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction().replace(R.id.container, new VaccineStats()).commit();
        });

        signOutCard.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), SignIn.class);
            startActivity(intent);
        });

        nameView = view.findViewById(R.id.name);
        sp = getActivity().getSharedPreferences("userPrefs", Context.MODE_PRIVATE);
        name = sp.getString("name", "");
        nameView.setText(name.isEmpty() ? "-" : name);

        // Inflate the layout for this fragment
        return view;
    }

}