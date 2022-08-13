package com.example.calculadoraapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.calculadoraapp.databinding.FragmentThirdBinding;

import org.w3c.dom.Text;

public class ThirdFragment extends Fragment {

    private FragmentThirdBinding binding;
    private TextView txt_info;
    private ListView lv_peopleList1;

    private String names[] = {"Ingrid Medina", "Ricardo Urvina", "Liliana Cordova"};
    private String ages[] = {"26", "26", "55"};

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentThirdBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnToFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ThirdFragment.this)
                        .navigate(R.id.action_thirdFragment_to_SecondFragment);
            }
        });

        binding.btnToActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toActivity2();
            }
        });

        txt_info = (TextView) binding.txtInfo;
        lv_peopleList1 = (ListView) binding.lvPeopleList1;

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getContext(), R.layout.list_item, names);
        lv_peopleList1.setAdapter(adapter);

        lv_peopleList1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                txt_info.setText("La edad de " + lv_peopleList1.getItemAtPosition(i) + " es:" + ages[i] + " años");

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    //metodo para cambiar de activity y pasar datos entre los activities
    public void toActivity2() {
        Intent next = new Intent(this.getContext(), MainActivity2.class);
        next.putExtra("info", txt_info.getText().toString());
        startActivity(next);

    }

}