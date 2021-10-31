package desenvolve.unesc.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import desenvolve.unesc.myapplication.adapter.ViagemAdapter;
import desenvolve.unesc.myapplication.database.dao.UsuarioService;
import desenvolve.unesc.myapplication.database.dao.ViagemService;
import desenvolve.unesc.myapplication.database.model.Usuario;

public class ViagensActivity extends AppCompatActivity {

    private ListView lista;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viagens);
        lista = findViewById(R.id.list);
        popularFilmes();
    }

    private void popularFilmes() {
        try{
            lista.setAdapter(new ViagemAdapter(ViagensActivity.this, new ViagemService(this).Select(LoginActivity.usuario.getId())));
        }catch (Exception e){}
    }

    @Override
    protected void onResume() {
        super.onResume();
        popularFilmes();
    }
}
