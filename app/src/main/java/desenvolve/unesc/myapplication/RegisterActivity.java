package desenvolve.unesc.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import desenvolve.unesc.myapplication.database.services.UsuarioService;
import desenvolve.unesc.myapplication.database.entidades.Usuario;

public class RegisterActivity extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtSenha;
    private Button btnSalvar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edtNome = findViewById(R.id.edtNome);
                edtSenha = findViewById(R.id.edtSenha);

                if (!edtNome.getText().toString().isEmpty() && !edtSenha.getText().toString().isEmpty()) {

                    Usuario model = new Usuario(edtNome.getText().toString(), edtSenha.getText().toString());

                    new UsuarioService(RegisterActivity.this).Insert(model);

                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                }
            }
        });
    }
}
