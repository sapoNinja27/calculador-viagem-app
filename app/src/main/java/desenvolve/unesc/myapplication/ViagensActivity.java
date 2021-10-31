package desenvolve.unesc.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import desenvolve.unesc.myapplication.database.dao.UsuarioService;
import desenvolve.unesc.myapplication.database.model.Usuario;

public class ViagensActivity extends AppCompatActivity {

    private EditText edtUsuario;
    private EditText edtSenha;
    private Button btnSalvar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtUsuario = findViewById(R.id.edtUsuario);
        edtSenha = findViewById(R.id.edtSenha);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edtUsuario.getText().toString().isEmpty() && !edtSenha.getText().toString().isEmpty()) {

                    Usuario model = new Usuario(edtUsuario.getText().toString(), edtSenha.getText().toString());

                    new UsuarioService(ViagensActivity.this).Insert(model);

                    Toast.makeText(ViagensActivity.this, "CadastroRealizado", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(ViagensActivity.this, MainActivity.class));
                }
            }
        });
        //        lista = findViewById(R.id.list);
//
//        edtFiltro = findViewById(R.id.edtFiltro);
//
//        btnNovoFilme = findViewById(R.id.btnNovoFilme);
//        btnNovoFilme.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
//            }
//        });
//
//        btnLimparFilmes = findViewById(R.id.btnLimparFilmes);
//        btnLimparFilmes.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new FilmeDAO(MainActivity.this).DeleteAll();
//                popularFilmes();
//            }
//        });
//
//        btnFiltrar = findViewById(R.id.btnFiltrar);
//        btnFiltrar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!edtFiltro.getText().toString().isEmpty()) {
//                    lista.setAdapter(new FilmeAdptar(MainActivity.this, new FilmeDAO(MainActivity.this).Select(edtFiltro.getText().toString())));
//                }
//                else {
//                    popularFilmes();
//                }
//            }
//        });
//
//        popularFilmes();
//    }
//
//    private void popularFilmes() {
//        lista.setAdapter(new FilmeAdptar(MainActivity.this, new FilmeDAO(this).Select()));
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        popularFilmes();
    }
}
