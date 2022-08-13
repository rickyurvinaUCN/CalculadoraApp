package com.example.calculadoraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private EditText txt_user, txt_psw, txt_info2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt_user = (EditText) findViewById(R.id.txt_user);
        txt_psw = (EditText) findViewById(R.id.txt_psw);
        txt_info2 = (EditText) findViewById(R.id.txt_info2);
        String infoReceived = getIntent().getStringExtra("info");
        txt_info2.setText(infoReceived);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    //Metodo de login
    public void registrar(View view) {
        String user = txt_user.getText().toString();
        String psw = txt_psw.getText().toString();

        if (user.length() == 0) {
            Toast.makeText(this, "Debes ingresar una password", Toast.LENGTH_SHORT).show();

        }
        if (psw.length() == 0) {
            Toast.makeText(this, "Debes ingresar una password", Toast.LENGTH_SHORT).show();
        }
        if (user.length() != 0 && psw.length() != 0) {
            Toast.makeText(this, "Registro en proceso...", Toast.LENGTH_SHORT).show();
        }
    }

    //metodo para cambiar de activity
    public void toActivity1(View view) {
        Intent previous = new Intent(this, MainActivity.class);
        startActivity(previous);
    }
}