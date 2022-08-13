package com.example.calculadoraapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.calculadoraapp.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private EditText txt_num3, txt_num4;
    private TextView txt_res2;
    private Spinner sp_operations;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        txt_num3 = (EditText) binding.txtNum3;
        txt_num4 = (EditText) binding.txtNum4;
        txt_res2 = (TextView) binding.txtRes2;
        sp_operations = (Spinner) binding.spOperations;

        String [] operations=
                {
                        "Sumar",
                        "Restar",
                        "Multiplicar",
                        "Dividir",
                };
//        ArrayAdapter <String> adapter = new ArrayAdapter<>(this.getContext(), android.R.layout.simple_spinner_item, operations);
        ArrayAdapter <String> adapter = new ArrayAdapter<>(this.getContext(), R.layout.spinner_item, operations);
        sp_operations.setAdapter(adapter);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_thirdFragment2);
            }
        });

        binding.btnCalc2.setOnClickListener((View v) -> {
            String selected= sp_operations.getSelectedItem().toString();
            switch (selected){
                case "Sumar":{
                    sum();
                    break;
                }
                case "Restar":{
                    sub();
                    break;
                }
                case "Multiplicar":{
                    mul();
                    break;
                }
                case "Dividir":{
                    div();
                    break;
                }
            }
        });
    }

    public void sum() {
        double val1 = Integer.parseInt(txt_num3.getText().toString());
        double val2 = Integer.parseInt(txt_num4.getText().toString());
        double sum = val1 + val2;
        String res = String.valueOf(sum);
        txt_res2.setText(res);
    }

    public void sub() {
        double val1 = Integer.parseInt(txt_num3.getText().toString());
        double val2 = Integer.parseInt(txt_num4.getText().toString());
        double sub = val1 - val2;
        String res = String.valueOf(sub);
        txt_res2.setText(res);
    }

    public void mul() {
        double val1 = Integer.parseInt(txt_num3.getText().toString());
        double val2 = Integer.parseInt(txt_num4.getText().toString());
        double mul = val1 * val2;
        String res = String.valueOf(mul);
        txt_res2.setText(res);
    }

    public void div() {
        double val1 = Integer.parseInt(txt_num3.getText().toString());
        double val2 = Integer.parseInt(txt_num4.getText().toString());
        if (val2 != 0) {
            double sum = val1 / val2;
            String res = String.valueOf(sum);
            txt_res2.setText(res);

        } else {
            String message = "No es posible dividir para 0";
            Toast.makeText(this.getContext(), message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}