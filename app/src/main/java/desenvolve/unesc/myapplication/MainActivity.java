package desenvolve.unesc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView lista;
    private Button btnNovoFilme;
    private Button btnLimparFilmes;
    private Button btnFiltrar;
    private EditText edtFiltro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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