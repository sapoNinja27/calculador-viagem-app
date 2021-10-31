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
import desenvolve.unesc.myapplication.database.model.Refeicao;
import desenvolve.unesc.myapplication.database.model.TarifaAerea;

public class RefeicaoActivity extends AppCompatActivity {

    private EditText custoRefeicao;
    private EditText refeicoesDia;
    private TextView total;
    private TextView alert;
    private Button next;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refeicoes);

        custoRefeicao = findViewById(R.id.custoRefeicao);
        refeicoesDia = findViewById(R.id.refeicoesDia);

        total = findViewById(R.id.total);
        alert = findViewById(R.id.alert);

        next = findViewById(R.id.adc);


        Refeicao refeicao = new Refeicao();

        custoRefeicao.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                refeicao.setCustoEstimadoRefeicao(Long.parseLong(custoRefeicao.getText().toString()));
                total.setText("Total: "+ refeicao.getTotal().toString());
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}

        });

        refeicoesDia.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                refeicao.setRefeicoesDia(Long.parseLong(refeicoesDia.getText().toString()));
                total.setText("Total: "+ refeicao.getTotal().toString());
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}

        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!custoRefeicao.getText().toString().isEmpty() &&
                        !refeicoesDia.getText().toString().isEmpty()) {

                    MainActivity.viagem.setRefeicao(refeicao);

                    startActivity(new Intent(RefeicaoActivity.this, HospedagemActivity.class));
                }else{
                    alert.setText("Todos os valores são obrigatorios");
                }
            }
        });
    }
}