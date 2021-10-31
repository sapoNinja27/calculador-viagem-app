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

public class ViagemActivity extends AppCompatActivity {

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

                    new UsuarioService(ViagemActivity.this).Insert(model);

                    Toast.makeText(ViagemActivity.this, "CadastroRealizado", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(ViagemActivity.this, MainActivity.class));
                }
            }
        });
    }
}
