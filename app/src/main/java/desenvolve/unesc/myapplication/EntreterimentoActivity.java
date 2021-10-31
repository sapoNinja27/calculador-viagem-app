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

import desenvolve.unesc.myapplication.database.dao.ViagemService;
import desenvolve.unesc.myapplication.database.model.Entreterimento;
import desenvolve.unesc.myapplication.database.model.Gasolina;
import desenvolve.unesc.myapplication.database.model.Hospedagem;

public class EntreterimentoActivity extends AppCompatActivity {

    private EditText vilaEncantada;
    private EditText zooPomerode;
    private EditText imprevistos;
    private TextView total;
    private TextView alert;
    private Button next;
    private ViagemService viagemService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entreterimento);

        viagemService = new ViagemService(EntreterimentoActivity.this);

        vilaEncantada = findViewById(R.id.vilaEncantada);
        zooPomerode = findViewById(R.id.zooPomerode);
        imprevistos = findViewById(R.id.imprevistos);

        total = findViewById(R.id.total);
        alert = findViewById(R.id.alert);

        next = findViewById(R.id.adc);


        Entreterimento entreterimento = new Entreterimento();

        vilaEncantada.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                entreterimento.setVilaEncantada(Long.parseLong(vilaEncantada.getText().toString()));
                total.setText("Total: "+ entreterimento.getTotal().toString());
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}

        });

        zooPomerode.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                entreterimento.setZooPomerode(Long.parseLong(zooPomerode.getText().toString()));
                total.setText("Total: "+ entreterimento.getTotal().toString());
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}

        });

        imprevistos.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                entreterimento.setEmprevistos(Long.parseLong(imprevistos.getText().toString()));
                total.setText("Total: "+ entreterimento.getTotal().toString());
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}

        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!vilaEncantada.getText().toString().isEmpty() &&
                        !zooPomerode.getText().toString().isEmpty() &&
                        !imprevistos.getText().toString().isEmpty()) {

                    MainActivity.viagem.setEntreterimento(entreterimento);
                    MainActivity.viagem.setUsuario(LoginActivity.usuario);

                    viagemService.Insert(MainActivity.viagem);

                    startActivity(new Intent(EntreterimentoActivity.this, MainActivity.class));
                }else{
                    alert.setText("Todos os valores são obrigatorios");
                }
            }
        });
    }
}