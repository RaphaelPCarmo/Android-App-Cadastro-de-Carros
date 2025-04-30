package br.classb.aula4carroapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import br.classb.aula4carroapp.Carro;

public class MainActivity extends AppCompatActivity {

    EditText etPlaca, etModelo, etAno;
    Spinner spCor, spEstado;
    ListView lvCarros;
    Button btnIncluir, btnExcluir;
    TextView tvRA;

    ArrayList<Carro> listaCarros = new ArrayList<>();
    ArrayAdapter<Carro> adapter;
    int selectedIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPlaca = findViewById(R.id.etPlaca);
        etModelo = findViewById(R.id.etModelo);
        etAno = findViewById(R.id.etAno);
        spCor = findViewById(R.id.spCor);
        spEstado = findViewById(R.id.spEstado);
        lvCarros = findViewById(R.id.lvCarros);
        btnIncluir = findViewById(R.id.btnIncluir);
        btnExcluir = findViewById(R.id.btnExcluir);
        tvRA = findViewById(R.id.tvRA);

        tvRA.setText("RA: 12426977 - Nome: Raphael Perim do Carmo");

        ArrayAdapter<CharSequence> adapterCor = ArrayAdapter.createFromResource(this,
                R.array.cores_array, android.R.layout.simple_spinner_item);
        adapterCor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCor.setAdapter(adapterCor);

        ArrayAdapter<CharSequence> adapterEstado = ArrayAdapter.createFromResource(this,
                R.array.estados_array, android.R.layout.simple_spinner_item);
        adapterEstado.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spEstado.setAdapter(adapterEstado);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaCarros);
        lvCarros.setAdapter(adapter);

        lvCarros.setOnItemClickListener((parent, view, position, id) -> selectedIndex = position);

        btnIncluir.setOnClickListener(v -> {
            Carro carro = new Carro(
                    etPlaca.getText().toString(),
                    etModelo.getText().toString(),
                    spCor.getSelectedItem().toString(),
                    etAno.getText().toString(),
                    spEstado.getSelectedItem().toString()
            );
            listaCarros.add(carro);
            adapter.notifyDataSetChanged();
        });

        btnExcluir.setOnClickListener(v -> {
            if (selectedIndex >= 0) {
                listaCarros.remove(selectedIndex);
                adapter.notifyDataSetChanged();
                selectedIndex = -1;
            }
        });
    }
}
