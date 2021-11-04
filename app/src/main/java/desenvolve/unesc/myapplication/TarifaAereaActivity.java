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

import desenvolve.unesc.myapplication.database.entidades.TarifaAerea;

public class TarifaAereaActivity extends AppCompatActivity {

    private EditText custoPessoa;
    private EditText aluguelVeiculo;
    private TextView total;
    private TextView alert;
    private Button next;
    private Button skip;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarifa_aerea);

        custoPessoa = findViewById(R.id.custoEpessoa);
        aluguelVeiculo = findViewById(R.id.aluguelVeiculo);

        total = findViewById(R.id.total);
        alert = findViewById(R.id.alert);

        next = findViewById(R.id.adc);
        skip = findViewById(R.id.skip);

        TarifaAerea tarifaAerea = new TarifaAerea();

        custoPessoa.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                if("".equals(custoPessoa.getText().toString())){
                    custoPessoa.setText("0");
                }
                tarifaAerea.setCustoEstimadoPessoa(Long.parseLong(custoPessoa.getText().toString()));
                total.setText("Total: "+ tarifaAerea.getTotal(MainActivity.viagem.getQuantidadePessoas()).toString());
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}

        });

        aluguelVeiculo.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                if("".equals(aluguelVeiculo.getText().toString())){
                    aluguelVeiculo.setText("0");
                }
                tarifaAerea.setAluguelVeiculo(Long.parseLong(aluguelVeiculo.getText().toString()));
                total.setText("Total: "+ tarifaAerea.getTotal(MainActivity.viagem.getQuantidadePessoas()).toString());
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
                    Toast.makeText(TarifaAereaActivity.this, "Todos os valores são obrigatorios!", Toast.LENGTH_LONG).show();
                }
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.viagem.setTarifaAerea(new TarifaAerea());
                startActivity(new Intent(TarifaAereaActivity.this, RefeicaoActivity.class));
            }
        });
    }
}
