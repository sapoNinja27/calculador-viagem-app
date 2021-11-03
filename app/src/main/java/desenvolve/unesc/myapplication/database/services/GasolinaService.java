package desenvolve.unesc.myapplication.database.services;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import desenvolve.unesc.myapplication.database.DBOpenHelper;
import desenvolve.unesc.myapplication.database.entidades.Gasolina;

public class GasolinaService extends AbstractService {

    private final String[]
        colunas = {
            Gasolina.ID,
            Gasolina.TOTAL_ESTIMADO_QUILOMETROS,
            Gasolina.MEDIA_QUILOMETROS,
            Gasolina.CUSTO_MEDIO_LITRO,
            Gasolina.TOTAL_VEICULOS
    };

    public GasolinaService(final Context contexto) {
        helper = new DBOpenHelper(contexto);
    }

    public long Insert(Gasolina gasolina) {

        long linhasAfetadas;

        try {
            Open();

            ContentValues values = Put(gasolina);
            linhasAfetadas = db.insert(Gasolina.TABELA, null, values);
        }
        finally {
            Close();
        }

        return linhasAfetadas;
    }

    public ContentValues Put(Gasolina gasolina){
        ContentValues values = new ContentValues();
        values.put(Gasolina.TOTAL_ESTIMADO_QUILOMETROS, gasolina.getTotalEstimadoQuilometros());
        values.put(Gasolina.MEDIA_QUILOMETROS, gasolina.getMediaQuilometrosLitro());
        values.put(Gasolina.CUSTO_MEDIO_LITRO, gasolina.getCustoMedioLitro());
        values.put(Gasolina.TOTAL_VEICULOS, gasolina.getTotalVeiculos());
        return values;
    }

    public void Delete(final Long id) {
        Open();
        db.delete(Gasolina.TABELA, Gasolina.ID + " = ?", new String[]{id.toString()});
        Close();
    }

    public Integer Update(final Gasolina gasolina) {

        int linhasAfetadas;

        try {
            Open();

            ContentValues values = Put(gasolina);
            linhasAfetadas = db.update(Gasolina.TABELA, values, Gasolina.ID + " = ?", new String[]{gasolina.getId().toString()});
        }
        finally {
            Close();
        }

        return linhasAfetadas;
    }

    public Gasolina Select(final Long id) {

       Gasolina gasolina = new Gasolina();

        try {
            Open();
            Cursor cursor = db.query(Gasolina.TABELA, colunas, Gasolina.ID + " = ?", new String[] {id.toString()}, null, null, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                gasolina = CursorToStructure(cursor);
                cursor.moveToNext();
                break;
            }
        }
        finally {
            Close();
        }
        return gasolina;
    }

    public final Gasolina CursorToStructure(Cursor cursor) {
        Gasolina gasolina = new Gasolina();
        gasolina.setId(cursor.getLong(0));
        gasolina.setTotalEstimadoQuilometros(cursor.getLong(1));
        gasolina.setMediaQuilometrosLitro(cursor.getLong(2));
        gasolina.setCustoMedioLitro(cursor.getLong(3));
        gasolina.setTotalVeiculos(cursor.getLong(4));
        return gasolina;
    }

}
