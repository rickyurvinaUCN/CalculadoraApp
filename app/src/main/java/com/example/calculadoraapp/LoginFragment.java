package com.example.calculadoraapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.calculadoraapp.databinding.FragmentLoginBinding;


public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;

    private EditText txt_user, txt_psw;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        txt_user = (EditText) binding.txtUser;
        txt_psw = (EditText) binding.txtPsw;
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnToMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toActivity2();
            }
        });
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrar();
//                NavHostFragment.findNavController(LoginFragment.this)
//                        .navigate(R.id.action_loginFragment2_to_webFragment);
            }
        });
    }

    //metodo para cambiar al main activity
    public void toActivity2() {
        Intent next = new Intent(this.getContext(), MainActivity.class);
        startActivity(next);
    }

    //Metodo de login
    public void registrar() {
        String user = txt_user.getText().toString();
        String psw = txt_psw.getText().toString();

        if (user.length() == 0) {
            Toast.makeText(this.getContext(), "Debes ingresar una password", Toast.LENGTH_SHORT).show();
        }
        if (psw.length() == 0) {
            Toast.makeText(this.getContext(), "Debes ingresar una password", Toast.LENGTH_SHORT).show();
        }
        if (user.length() != 0 && psw.length() != 0) {
            Toast.makeText(this.getContext(), "Registro en proceso...", Toast.LENGTH_SHORT).show();
        }
    }
}