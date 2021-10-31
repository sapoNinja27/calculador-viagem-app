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
import desenvolve.unesc.myapplication.database.model.Hospedagem;
import desenvolve.unesc.myapplication.database.model.TarifaAerea;

public class HospedagemActivity extends AppCompatActivity {

    private EditText custoHospedagem;
    private EditText totalNoites;
    private EditText totalQuartos;
    private TextView total;
    private Button next;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospedagem);

        custoHospedagem = findViewById(R.id.custoHospedagem);
        totalNoites = findViewById(R.id.totalNoites);
        totalQuartos = findViewById(R.id.totalQuartos);

        total = findViewById(R.id.total);

        next = findViewById(R.id.adc);


        Hospedagem hospedagem = new Hospedagem();

        custoHospedagem.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                hospedagem.setCustoNoite(Long.parseLong(custoHospedagem.getText().toString()));
                total.setText("Total: "+ hospedagem.getTotal().toString());
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}

        });

        totalNoites.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                hospedagem.setTotalNoites(Long.parseLong(totalNoites.getText().toString()));
                total.setText("Total: "+ hospedagem.getTotal().toString());
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}

        });

        totalQuartos.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                hospedagem.setTotalQuartos(Long.parseLong(totalQuartos.getText().toString()));
                total.setText("Total: "+ hospedagem.getTotal().toString());
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}

        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!totalQuartos.getText().toString().isEmpty() &&
                        !totalNoites.getText().toString().isEmpty() &&
                        !custoHospedagem.getText().toString().isEmpty()) {

                    MainActivity.viagem.setHospedagem(hospedagem);

                    startActivity(new Intent(HospedagemActivity.this, EntreterimentoActivity.class));
                }else{
                    Toast.makeText(HospedagemActivity.this, "Todos os valores são obrigatorios!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
