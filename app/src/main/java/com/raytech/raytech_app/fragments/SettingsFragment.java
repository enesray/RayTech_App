package com.raytech.raytech_app.fragments;

import static com.raytech.raytech_app.util.DialogUtils.showPopupDialogYesOrNo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.raytech.raytech_app.R;

public class SettingsFragment extends Fragment {

    RelativeLayout exitLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        init(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        events();
    }

    private void init(View view) {
        exitLayout = view.findViewById(R.id.exitLayout);
    }

    private void events() {
        exitLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupDialogYesOrNo(getContext(), R.string.exit_description);
            }
        });
    }
}