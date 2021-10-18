package desenvolve.unesc.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import desenvolve.unesc.myapplication.database.dao.UsuarioDAO;
import desenvolve.unesc.myapplication.database.model.UsuarioModel;

public class LoginActivity extends AppCompatActivity {

    private EditText edtUsuario, edtSenha;
    private Button btnEntrar, btnGravar, btnAtualizar, btnDeletar;
    private UsuarioDAO dao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Instancia o banco de dados.
        dao = new UsuarioDAO(LoginActivity.this);

        // Cria os componentes.
        edtUsuario = findViewById(R.id.edtUsuario);
        edtSenha = findViewById(R.id.edtSenha);

        // Faz o UPDATE do usuário.
//        btnAtualizar = findViewById(R.id.btnAtualizar);
//        btnAtualizar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (dao.Update(edtUsuario.getText().toString(), edtSenha.getText().toString()) > 0) {
//                    Toast.makeText(LoginActivity.this, "Usuário Atualizado!", Toast.LENGTH_LONG).show();
//                }
//                else {
//                    Toast.makeText(LoginActivity.this, "Falha na atualização!", Toast.LENGTH_LONG).show();
//                }
//            }
//        });

        // Faz o SELECT e entra no aplicativo.
        btnEntrar = findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*List<UsuarioModel> model = dao.Select();
                for (UsuarioModel usuario : model) {
                    System.out.println("************************ >>>>>>>>>>>>> "+usuario.getUsuario());
                }*/

//                UsuarioModel model = dao.Select(edtUsuario.getText().toString(), edtSenha.getText().toString());
//                if (model != null) {
//                    Toast.makeText(LoginActivity.this, "Usuário Entrado!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                }
//                else {
//                    Toast.makeText(LoginActivity.this, "Usuário Não Encontrado!", Toast.LENGTH_LONG).show();
//                }
            }
        });

        // Grava um novo usário.
//        btnGravar = findViewById(R.id.btnGravar);
//        btnGravar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                UsuarioModel model = new UsuarioModel();
//                model.setUsuario(edtUsuario.getText().toString());
//                model.setSenha(edtSenha.getText().toString());
//
//                if (dao.Insert(model) != -1) {
//                    Toast.makeText(LoginActivity.this, "Usuário Inserido!", Toast.LENGTH_LONG).show();
//                }
//            }
//        });

//        btnDeletar = findViewById(R.id.btnDeletar);
//        btnDeletar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dao.Delete(edtUsuario.getText().toString());
//            }
//        });
    }
}
