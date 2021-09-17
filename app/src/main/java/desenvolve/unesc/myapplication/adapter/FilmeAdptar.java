package desenvolve.unesc.myapplication.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import desenvolve.unesc.myapplication.R;
import desenvolve.unesc.myapplication.database.dao.FilmeDAO;
import desenvolve.unesc.myapplication.database.model.FilmeModel;

public class FilmeAdptar extends BaseAdapter {

    private Activity activity;
    private List<FilmeModel> lista;
    private LayoutInflater inflater;

    public FilmeAdptar(Activity context, List<FilmeModel> lista) {
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
        nome.setText(lista.get(position).getFilme());
        Button btnDeletar = rootView.findViewById(R.id.btnDeletar);
        btnDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FilmeDAO(activity).Delete(lista.get(position).getFilme());
                lista.remove(position);
                notifyDataSetChanged();
            }
        });

        return rootView;
    }
}
