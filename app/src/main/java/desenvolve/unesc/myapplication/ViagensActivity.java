package desenvolve.unesc.myapplication;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import desenvolve.unesc.myapplication.adapter.ViagemAdapter;
import desenvolve.unesc.myapplication.database.services.ViagemService;

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
