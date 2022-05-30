package com.example.nobelpicker;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentInfo extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Intent intent = getActivity().getIntent();
        // 0 is used for default selection
        setResults(intent.getIntExtra("selectedIdx",0));
    }

    public FragmentInfo() {
        // Required empty public constructor
    }

    public void setResults(int idx) {
        TextView winnerBio = (TextView) getActivity().findViewById(R.id.winner_bio);
        TextView winnerName = (TextView) getActivity().findViewById(R.id.winner_name);
        ImageView winnerImage = (ImageView) getActivity().findViewById(R.id.winner_photo);
        if( winnerBio ==null || winnerName ==null || winnerImage ==null ) return;
        switch (idx){
            case 0:
                winnerBio.setText(R.string.giorgio_parisi);
                winnerName.setText("Giorgio Parisi");
                winnerImage.setImageResource(R.drawable.parisi);
                break;
            case 1:
                winnerBio.setText(R.string.benjamin_list_bio);
                winnerName.setText("Benjamin List");
                winnerImage.setImageResource(R.drawable.benjamin);
                break;
            case 2:
                winnerBio.setText(R.string.david_julius_bio);
                winnerName.setText("David Julius");
                winnerImage.setImageResource(R.drawable.david);
                break;
            case 3:
                winnerBio.setText(R.string.abdulrazak_gurnah_bio);
                winnerName.setText("Abdulrazak Gurnah");
                winnerImage.setImageResource(R.drawable.abdul);
                break;
        }
    }
}