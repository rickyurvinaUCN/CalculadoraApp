package com.example.calculadoraapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.calculadoraapp.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private EditText txt_num1, txt_num2;

    private TextView txt_res;

    private RadioButton rad_sum, rad_sub, rad_div, rad_mul;

    private CheckBox chk_sum, chk_sub, chk_mul, chk_div;

    private RadioGroup rad_group;

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
        chk_sum = (CheckBox) binding.chkSum;
        chk_sub = (CheckBox) binding.chkSub;
        chk_mul = (CheckBox) binding.chkMul;
        chk_div = (CheckBox) binding.chkDiv;
        rad_group = (RadioGroup) binding.radGroup;
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
        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
        binding.btnSumar.setOnClickListener((View v) -> {
            if (chk_sum.isChecked() || chk_sub.isChecked() || chk_mul.isChecked() || chk_div.isChecked()) {
                String res = "";
                uncheckRadios();
                if (chk_sum.isChecked()) {
                    res += " La suma es:" + sum() + " / ";
                }
                if (chk_sub.isChecked()) {
                    res += " La resta es:" + sub() + " / ";
                }
                if (chk_mul.isChecked()) {
                    res += " La mul es:" + mul() + " / ";
                }
                if (chk_div.isChecked()) {
                    res += " La div es:" + div() + " / ";
                }
                txt_res.setText(res);
            }
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

    public void uncheckRadios() {
        rad_group.clearCheck();
    }

    public void showMessage() {
        Toast.makeText(this.getContext(), "No se ha seleccionado ninguna operación", Toast.LENGTH_SHORT).show();
    }

    public String sum() {
        double val1 = Integer.parseInt(txt_num1.getText().toString());
        double val2 = Integer.parseInt(txt_num2.getText().toString());
        double sum = val1 + val2;
        String res = String.valueOf(sum);
        txt_res.setText(res);
        return res;
    }

    public String sub() {
        double val1 = Integer.parseInt(txt_num1.getText().toString());
        double val2 = Integer.parseInt(txt_num2.getText().toString());
        double sub = val1 - val2;
        String res = String.valueOf(sub);
        txt_res.setText(res);
        return res;

    }

    public String mul() {
        double val1 = Integer.parseInt(txt_num1.getText().toString());
        double val2 = Integer.parseInt(txt_num2.getText().toString());
        double mul = val1 * val2;
        String res = String.valueOf(mul);
        txt_res.setText(res);
        return res;

    }

    public String div() {
        double val1 = Integer.parseInt(txt_num1.getText().toString());
        double val2 = Integer.parseInt(txt_num2.getText().toString());
        if (val2 != 0) {
            double sum = val1 / val2;
            String res = String.valueOf(sum);
            txt_res.setText(res);
            return res;

        } else {
            String message = "No es posible dividir para 0";
            Toast.makeText(this.getContext(), message, Toast.LENGTH_SHORT).show();
            return message;
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}