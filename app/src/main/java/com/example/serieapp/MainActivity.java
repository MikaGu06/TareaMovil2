package com.example.serieapp;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etN;
    Button btnGenerar;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etN = findViewById(R.id.etN);
        btnGenerar = findViewById(R.id.btnGenerar);
        tvResultado = findViewById(R.id.tvResultado);

        btnGenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String valor = etN.getText().toString();

                if (valor.isEmpty()) {
                    etN.setError("Ingrese un valor");
                    return;
                }

                int n;
                try {
                    n = Integer.parseInt(valor);
                } catch (Exception e) {
                    etN.setError("Solo números");
                    return;
                }

                if (n <= 0) {
                    etN.setError("n debe ser mayor a 0");
                    return;
                }

                String resultado = "";
                double suma = 0;

                for (int i = 1; i <= n; i++) {

                    double termino = Math.pow(-1, i + 1) * (i * i - 0.5 * (i - 1));

                    resultado += termino;

                    if (i < n) {
                        resultado += ", ";
                    }

                    suma += termino;
                }

                resultado += "\nSuma: " + suma;

                tvResultado.setText(resultado);
            }
        });
    }
}