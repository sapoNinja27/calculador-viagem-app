package desenvolve.unesc.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import desenvolve.unesc.myapplication.database.model.Gasolina;
import desenvolve.unesc.myapplication.database.model.TarifaAerea;

public class TarifaAereaActivity extends AppCompatActivity {

    private EditText custoPessoa;
    private EditText aluguelVeiculo;
    private TextView total;
    private TextView alert;
    private Button next;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarifa_aerea);

        custoPessoa = findViewById(R.id.custoEpessoa);
        aluguelVeiculo = findViewById(R.id.aluguelVeiculo);

        total = findViewById(R.id.total);
        alert = findViewById(R.id.alert);

        next = findViewById(R.id.adc);


        TarifaAerea tarifaAerea = new TarifaAerea();

        custoPessoa.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                tarifaAerea.setCustoEstimadoPessoa(Long.parseLong(custoPessoa.getText().toString()));
                total.setText("Total: "+ tarifaAerea.getTotal().toString());
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}

        });

        aluguelVeiculo.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                tarifaAerea.setAluguelVeiculo(Long.parseLong(aluguelVeiculo.getText().toString()));
                total.setText("Total: "+ tarifaAerea.getTotal().toString());
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}

        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!aluguelVeiculo.getText().toString().isEmpty() &&
                        !custoPessoa.getText().toString().isEmpty()) {

                    MainActivity.viagem.setTarifaAerea(tarifaAerea);

                    startActivity(new Intent(TarifaAereaActivity.this, RefeicaoActivity.class));
                }else{
                    alert.setText("Todos os valores são obrigatorios");
                }
            }
        });
    }
}
