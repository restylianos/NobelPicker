package com.example.nobelpicker;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFragment extends Fragment {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button[] mainButtons = new Button[4];
        mainButtons[0] = (Button) getActivity().findViewById(R.id.button_physics);
        mainButtons[1] = (Button) getActivity().findViewById(R.id.button_chemistry);
        mainButtons[2] = (Button) getActivity().findViewById(R.id.button_medicine);
        mainButtons[3] = (Button) getActivity().findViewById(R.id.button_literature);
        for (int i = 0; i < 4; i++) {
            final int idx = i;
            mainButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    handleShowResults(idx);
                }
            });
        }
    }

    private void handleShowResults(int idx) {
        if (getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_LANDSCAPE) {
            System.out.println("insdie if");
            FragmentInfo frag = (FragmentInfo) getFragmentManager().findFragmentById(R.id.fragment_info);
            frag.setResults(idx);
        } else {
            Intent intent = new Intent(getActivity(), ActivityInfo.class);
            intent.putExtra("selectedIdx", idx);
            startActivity(intent);
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}