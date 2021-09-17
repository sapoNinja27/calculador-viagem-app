package desenvolve.unesc.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import desenvolve.unesc.myapplication.database.dao.FilmeDAO;
import desenvolve.unesc.myapplication.database.model.FilmeModel;

public class RegisterActivity extends AppCompatActivity {

    private EditText edtNome;
    private Button btnSalvar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtNome = findViewById(R.id.edtNome);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edtNome.getText().toString().isEmpty()) {

                    FilmeModel model = new FilmeModel();
                    model.setFilme(edtNome.getText().toString());

                    new FilmeDAO(RegisterActivity.this).Insert(model);

                    Toast.makeText(RegisterActivity.this, "Filme adicionado", Toast.LENGTH_SHORT).show();

                    edtNome.setText("");
                }
            }
        });
    }
}
