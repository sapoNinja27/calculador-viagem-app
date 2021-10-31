package desenvolve.unesc.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import desenvolve.unesc.myapplication.database.model.Gasolina;

public class GasolinaActivity extends AppCompatActivity {

    private EditText totalKm;
    private EditText mediaKm;
    private EditText custoKm;
    private EditText totalVeiculos;
    private TextView total;
    private Button next;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gasolina);

        totalKm = findViewById(R.id.totalKm);
        mediaKm = findViewById(R.id.mediaKm);
        custoKm = findViewById(R.id.custoL);
        totalVeiculos = findViewById(R.id.totalVeiculos);

        total = findViewById(R.id.total);

        next = findViewById(R.id.adc);


        Gasolina gasolina = new Gasolina();

        totalKm.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                gasolina.setTotalEstimadoQuilometros(Long.parseLong(totalKm.getText().toString()));
                total.setText("Total: "+ gasolina.getTotal().toString());
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}

        });

        mediaKm.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                gasolina.setMediaQuilometrosLitro(Long.parseLong(mediaKm.getText().toString()));
                total.setText("Total: "+ gasolina.getTotal().toString());
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}

        });

        custoKm.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                gasolina.setCustoMedioLitro(Long.parseLong(custoKm.getText().toString()));
                total.setText("Total: "+ gasolina.getTotal().toString());
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}

        });

        totalVeiculos.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                gasolina.setTotalVeiculos(Long.parseLong(totalVeiculos.getText().toString()));
                total.setText("Total: "+ gasolina.getTotal().toString());
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}

        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!totalKm.getText().toString().isEmpty() &&
                        !mediaKm.getText().toString().isEmpty() &&
                        !custoKm.getText().toString().isEmpty() &&
                        !totalVeiculos.getText().toString().isEmpty()) {

                    MainActivity.viagem.setGasolina(gasolina);

                    startActivity(new Intent(GasolinaActivity.this, TarifaAereaActivity.class));
                }else{
                    Toast.makeText(GasolinaActivity.this, "Todos os valores são obrigatorios!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
