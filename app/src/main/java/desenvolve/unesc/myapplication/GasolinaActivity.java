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

import desenvolve.unesc.myapplication.database.entidades.Gasolina;

public class GasolinaActivity extends AppCompatActivity {

    private EditText totalKm;
    private EditText mediaKm;
    private EditText custoKm;
    private EditText totalVeiculos;
    private TextView total;
    private Button next;
    private Button skip;

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
        skip = findViewById(R.id.skip);


        Gasolina gasolina = new Gasolina();

        totalKm.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                if("".equals(totalKm.getText().toString())){
                    totalKm.setText("0");
                }
                gasolina.setTotalEstimadoQuilometros(Long.parseLong(totalKm.getText().toString()));
                total.setText("Total: "+ gasolina.getTotal().toString());
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}

        });

        mediaKm.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                if("".equals(mediaKm.getText().toString())){
                    mediaKm.setText("0");
                }
                gasolina.setMediaQuilometrosLitro(Long.parseLong(mediaKm.getText().toString()));
                total.setText("Total: "+ gasolina.getTotal().toString());
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}

        });

        custoKm.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                if("".equals(custoKm.getText().toString())){
                    custoKm.setText("0");
                }
                gasolina.setCustoMedioLitro(Long.parseLong(custoKm.getText().toString()));
                total.setText("Total: "+ gasolina.getTotal().toString());
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}

        });

        totalVeiculos.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                if("".equals(totalVeiculos.getText().toString())){
                    totalVeiculos.setText("0");
                }
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
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.viagem.setGasolina(new Gasolina());
                startActivity(new Intent(GasolinaActivity.this, TarifaAereaActivity.class));
            }
        });
    }
}
