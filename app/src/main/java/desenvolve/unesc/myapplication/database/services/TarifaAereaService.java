package desenvolve.unesc.myapplication.database.services;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import desenvolve.unesc.myapplication.database.DBOpenHelper;
import desenvolve.unesc.myapplication.database.entidades.TarifaAerea;

public class TarifaAereaService extends AbstractService {

    private final String[]
        colunas = {
            TarifaAerea.ID,
            TarifaAerea.CUSTO_ESTIMADO_PESSOA,
            TarifaAerea.ALUGUEL_VEICULO
    };

    public TarifaAereaService(final Context contexto) {
        helper = new DBOpenHelper(contexto);
    }

    public Long Insert(TarifaAerea tarifaAerea) {

        long linhasAfetadas;

        try {
            Open();

            ContentValues values = Put(tarifaAerea);
            linhasAfetadas = db.insert(TarifaAerea.TABELA, null, values);
        }
        finally {
            Close();
        }

        return linhasAfetadas;
    }

    public ContentValues Put(TarifaAerea tarifaAerea){
        ContentValues values = new ContentValues();
        values.put(TarifaAerea.CUSTO_ESTIMADO_PESSOA, tarifaAerea.getCustoEstimadoPessoa());
        values.put(TarifaAerea.ALUGUEL_VEICULO, tarifaAerea.getAluguelVeiculo());
        return values;
    }

    public void Delete(final Long id) {
        Open();
        db.delete(TarifaAerea.TABELA, TarifaAerea.ID + " = ?", new String[]{id.toString()});
        Close();
    }

    public Integer Update(final TarifaAerea tarifaAerea) {

        int linhasAfetadas;

        try {
            Open();

            ContentValues values = Put(tarifaAerea);
            linhasAfetadas = db.update(TarifaAerea.TABELA, values, TarifaAerea.ID + " = ?", new String[]{tarifaAerea.getId().toString()});
        }
        finally {
            Close();
        }

        return linhasAfetadas;
    }

    public TarifaAerea Select(final Long id) {

       TarifaAerea tarifaAerea = new TarifaAerea();

        try {
            Open();
            Cursor cursor = db.query(TarifaAerea.TABELA, colunas, TarifaAerea.ID + " = ?", new String[] {id.toString()}, null, null, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                tarifaAerea = CursorToStructure(cursor);
                cursor.moveToNext();
                break;
            }
        }
        finally {
            Close();
        }
        return tarifaAerea;
    }

    public final TarifaAerea CursorToStructure(Cursor cursor) {
        TarifaAerea tarifaAerea = new TarifaAerea();
        tarifaAerea.setId(cursor.getLong(0));
        tarifaAerea.setCustoEstimadoPessoa(cursor.getLong(1));
        tarifaAerea.setAluguelVeiculo(cursor.getLong(2));
        return tarifaAerea;
    }

}
