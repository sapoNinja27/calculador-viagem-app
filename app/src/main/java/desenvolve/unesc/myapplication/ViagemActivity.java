package desenvolve.unesc.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import desenvolve.unesc.myapplication.adapter.ViagemAdapter;
import desenvolve.unesc.myapplication.database.entidades.TarifaAerea;
import desenvolve.unesc.myapplication.database.entidades.Viagem;
import desenvolve.unesc.myapplication.database.services.ViagemService;

public class ViagemActivity extends AppCompatActivity {

    private ViagemService viagemService;
    private TextView totalPessoa;
    private TextView duracao;
    private TextView custo;
    private TextView custoPessoa;
    private Button deletar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viagem);
        viagemService = new ViagemService(ViagemActivity.this);


        totalPessoa = findViewById(R.id.totalPessoas);
        duracao = findViewById(R.id.duracao);
        custo = findViewById(R.id.custo);
        custoPessoa = findViewById(R.id.custoPessoa);

        deletar = findViewById(R.id.apagar);

        Viagem viagem = MainActivity.viagem;
        MainActivity.viagem = null;

        totalPessoa.setText("Quantidade de pessoas:" + viagem.getQuantidadePessoas());
        duracao.setText("Duração:" + viagem.getDuracao());
        custo.setText("Custo total:" + viagem.getTotal());
        custoPessoa.setText("Total por pessoa:" + viagem.getTotal()/viagem.getQuantidadePessoas());

        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viagemService.Delete(viagem.getId());
                startActivity(new Intent(ViagemActivity.this, ViagensActivity.class));
            }
        });
    }
}
