package desenvolve.unesc.myapplication.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import desenvolve.unesc.myapplication.GasolinaActivity;
import desenvolve.unesc.myapplication.MainActivity;
import desenvolve.unesc.myapplication.R;
import desenvolve.unesc.myapplication.TarifaAereaActivity;
import desenvolve.unesc.myapplication.ViagemActivity;
import desenvolve.unesc.myapplication.database.services.ViagemService;
import desenvolve.unesc.myapplication.database.entidades.Viagem;

public class ViagemAdapter extends BaseAdapter {

    private Activity activity;
    private List<Viagem> lista;
    private LayoutInflater inflater;

    public ViagemAdapter(Activity context, List<Viagem> lista) {
        activity = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return -99;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null) {
            inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        View rootView = inflater.inflate(R.layout.list_row, null);

        TextView nome = (TextView) rootView.findViewById(R.id.nome);
        nome.setText("Destino: " + lista.get(position).getDestino());

        Button vizualizar = rootView.findViewById(R.id.btnVizualizar);
        vizualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.viagem = new ViagemService(activity).Find(lista.get(position).getId());

                activity.startActivity(new Intent(activity, ViagemActivity.class));
            }
        });

        return rootView;
    }
}
