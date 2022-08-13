package com.example.calculadoraapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.calculadoraapp.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private EditText txt_num1, txt_num2;

    private TextView txt_res;

    private RadioButton rad_sum, rad_sub, rad_div, rad_mul;

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
        rad_sum = (RadioButton) binding.radSum;
        rad_sub = (RadioButton) binding.radSub;
        rad_div = (RadioButton) binding.radDiv;
        rad_mul = (RadioButton) binding.radMul;
        return binding.getRoot();
    }

    //        binding.btnSumar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                sum();
//            }
//        });
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.btnSumar.setOnClickListener((View v) -> {
            if (rad_sum.isChecked()) {
                sum();
            } else if (rad_sub.isChecked()) {
                sub();
            } else if (rad_mul.isChecked()) {
                mul();
            } else if (rad_div.isChecked()) {
                div();
            } else {
                showMessage();
            }
        });
    }

    public void showMessage() {
        Toast.makeText(this.getContext(), "No se ha seleccionado ninguna operación", Toast.LENGTH_SHORT).show();
    }

    public void sum() {
        double val1 = Integer.parseInt(txt_num1.getText().toString());
        double val2 = Integer.parseInt(txt_num2.getText().toString());
        double sum = val1 + val2;
        String res = String.valueOf(sum);
        txt_res.setText(res);
    }

    public void sub() {
        double val1 = Integer.parseInt(txt_num1.getText().toString());
        double val2 = Integer.parseInt(txt_num2.getText().toString());
        double sub = val1 - val2;
        String res = String.valueOf(sub);
        txt_res.setText(res);
    }

    public void mul() {
        double val1 = Integer.parseInt(txt_num1.getText().toString());
        double val2 = Integer.parseInt(txt_num2.getText().toString());
        double mul = val1 * val2;
        String res = String.valueOf(mul);
        txt_res.setText(res);
    }

    public void div() {
        double val1 = Integer.parseInt(txt_num1.getText().toString());
        double val2 = Integer.parseInt(txt_num2.getText().toString());
        if (val2 != 0) {
            double sum = val1 / val2;
            String res = String.valueOf(sum);
            txt_res.setText(res);
        } else {
            Toast.makeText(this.getContext(), "No es posible dividir para 0", Toast.LENGTH_SHORT).show();

        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}