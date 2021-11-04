package desenvolve.unesc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import desenvolve.unesc.myapplication.database.services.UsuarioService;
import desenvolve.unesc.myapplication.database.services.ViagemService;
import desenvolve.unesc.myapplication.database.entidades.Viagem;

public class MainActivity extends AppCompatActivity {

    private Button btnNovaViagem;
    private Button btnDeletar;
    private UsuarioService usuarioService;
    private Button btnViagens;
    private EditText edtDestino;
    private EditText duracao;
    private EditText quantidade;
    private ViagemService viagemService;
    public static Viagem viagem = new Viagem();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viagemService = new ViagemService(MainActivity.this);

        btnNovaViagem = findViewById(R.id.btnNviagem);
        btnViagens = findViewById(R.id.btnViagens);
        btnDeletar = findViewById(R.id.btnDeletar);

        btnNovaViagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtDestino = findViewById(R.id.edtDestino);
                quantidade = findViewById(R.id.quantidade);
                duracao = findViewById(R.id.duracao);
                if (!edtDestino.getText().toString().isEmpty() && !quantidade.getText().toString().isEmpty() && !duracao.getText().toString().isEmpty()) {
                    viagem.setDestino(edtDestino.getText().toString());
                    viagem.setDuracao(Long.parseLong(duracao.getText().toString()));
                    viagem.setQuantidadePessoas(Long.parseLong(quantidade.getText().toString()));
                    startActivity(new Intent(MainActivity.this, GasolinaActivity.class));
                }else {
                    Toast.makeText(MainActivity.this, "Todos os valores são obrigatorios!", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnViagens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ViagensActivity.class));
            }
        });

        btnDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuarioService = new UsuarioService(MainActivity.this);
                usuarioService.Delete(LoginActivity.usuario);
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });



    }
}