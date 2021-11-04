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

import desenvolve.unesc.myapplication.database.services.ViagemService;
import desenvolve.unesc.myapplication.database.entidades.Entreterimento;

public class EntreterimentoActivity extends AppCompatActivity {

    private EditText vilaEncantada;
    private EditText zooPomerode;
    private EditText imprevistos;
    private TextView total;
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

        next = findViewById(R.id.adc);


        Entreterimento entreterimento = new Entreterimento();

        vilaEncantada.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                if("".equals(vilaEncantada.getText().toString())){
                    vilaEncantada.setText("0");
                }
                entreterimento.setVilaEncantada(Long.parseLong(vilaEncantada.getText().toString()));
                total.setText("Total: "+ entreterimento.getTotal(MainActivity.viagem.getQuantidadePessoas()).toString());
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}

        });

        zooPomerode.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                if("".equals(zooPomerode.getText().toString())){
                    zooPomerode.setText("0");
                }
                entreterimento.setZooPomerode(Long.parseLong(zooPomerode.getText().toString()));
                total.setText("Total: "+ entreterimento.getTotal(MainActivity.viagem.getQuantidadePessoas()).toString());
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}

        });

        imprevistos.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                if("".equals(imprevistos.getText().toString())){
                    imprevistos.setText("0");
                }
                entreterimento.setEmprevistos(Long.parseLong(imprevistos.getText().toString()));
                total.setText("Total: "+ entreterimento.getTotal(MainActivity.viagem.getQuantidadePessoas()).toString());
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}

        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.viagem.setEntreterimento(entreterimento);
                MainActivity.viagem.setUsuario(LoginActivity.usuario);

                viagemService.Insert(MainActivity.viagem);

                startActivity(new Intent(EntreterimentoActivity.this, MainActivity.class));
            }
        });
    }
}