package com.example.calculadoraapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.calculadoraapp.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private EditText txt_num1, txt_num2;

    private TextView txt_res;

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        txt_num1 = (EditText) binding.txtNum1;
        txt_num2 = (EditText) binding.txtNum2;
        txt_res = (TextView) binding.txtRes;

        return binding.getRoot();
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        binding.btnSumar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                sum();
//            }
//        });

        binding.btnSumar.setOnClickListener((View v) -> {
            sum();
        });
    }

    public void sum() {
        int val1 = Integer.parseInt(txt_num1.getText().toString());
        int val2 = Integer.parseInt(txt_num2.getText().toString());
        int sum = val1 + val2;
        String res = String.valueOf(sum);
        txt_res.setText(res);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}