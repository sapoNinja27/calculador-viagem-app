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

import desenvolve.unesc.myapplication.database.entidades.Refeicao;

public class RefeicaoActivity extends AppCompatActivity {

    private EditText custoRefeicao;
    private EditText refeicoesDia;
    private TextView total;
    private Button next;
    private Button skip;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refeicoes);

        custoRefeicao = findViewById(R.id.custoRefeicao);
        refeicoesDia = findViewById(R.id.refeicoesDia);

        total = findViewById(R.id.total);

        next = findViewById(R.id.adc);
        skip = findViewById(R.id.skip);


        Refeicao refeicao = new Refeicao();

        custoRefeicao.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                if("".equals(custoRefeicao.getText().toString())){
                    custoRefeicao.setText("0");
                }
                refeicao.setCustoEstimadoRefeicao(Long.parseLong(custoRefeicao.getText().toString()));
                total.setText("Total: "+ refeicao.getTotal(MainActivity.viagem).toString());
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}

        });

        refeicoesDia.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                if("".equals(refeicoesDia.getText().toString())){
                    refeicoesDia.setText("0");
                }
                refeicao.setRefeicoesDia(Long.parseLong(refeicoesDia.getText().toString()));
                total.setText("Total: "+ refeicao.getTotal(MainActivity.viagem).toString());
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
                    Toast.makeText(RefeicaoActivity.this, "Todos os valores são obrigatorios!", Toast.LENGTH_LONG).show();
                }
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.viagem.setRefeicao(new Refeicao());
                startActivity(new Intent(RefeicaoActivity.this, HospedagemActivity.class));
            }
        });
    }
}