package desenvolve.unesc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import desenvolve.unesc.myapplication.database.dao.ViagemService;
import desenvolve.unesc.myapplication.database.model.Viagem;

public class MainActivity extends AppCompatActivity {

    private Button btnNovaViagem;
    private Button btnViagens;
    private EditText edtDestino;
    private ViagemService viagemService;
    public static Viagem viagem = new Viagem();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viagemService = new ViagemService(MainActivity.this);

        btnNovaViagem = findViewById(R.id.btnNviagem);
        btnViagens = findViewById(R.id.btnViagens);

        btnNovaViagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtDestino = findViewById(R.id.edtDestino);
                if (!edtDestino.getText().toString().isEmpty()) {
                    viagem.setDestino(edtDestino.getText().toString());
                    startActivity(new Intent(MainActivity.this, GasolinaActivity.class));
                }
            }
        });

        btnViagens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ViagensActivity.class));
            }
        });



    }
}