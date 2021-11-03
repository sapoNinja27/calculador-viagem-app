package desenvolve.unesc.myapplication.database.services;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import desenvolve.unesc.myapplication.database.DBOpenHelper;
import desenvolve.unesc.myapplication.database.entidades.Hospedagem;

public class HospedagemService extends AbstractService {

    private final String[]
        colunas = {
            Hospedagem.ID,
            Hospedagem.CUSTO_NOITE,
            Hospedagem.TOTAL_NOITES,
            Hospedagem.TOTAL_QUARTOS
    };

    public HospedagemService(final Context contexto) {
        helper = new DBOpenHelper(contexto);
    }

    public Long Insert(Hospedagem hospedagem) {

        long linhasAfetadas;

        try {
            Open();

            ContentValues values = Put(hospedagem);
            linhasAfetadas = db.insert(Hospedagem.TABELA, null, values);
        }
        finally {
            Close();
        }

        return linhasAfetadas;
    }
    public ContentValues Put(Hospedagem hospedagem){
        ContentValues values = new ContentValues();
        values.put(Hospedagem.CUSTO_NOITE, hospedagem.getCustoNoite());
        values.put(Hospedagem.TOTAL_NOITES, hospedagem.getCustoNoite());
        values.put(Hospedagem.TOTAL_QUARTOS, hospedagem.getTotalQuartos());
        return values;
    }

    public void Delete(final Long id) {
        Open();
        db.delete(Hospedagem.TABELA, Hospedagem.ID + " = ?", new String[]{id.toString()});
        Close();
    }

    public Integer Update(final Hospedagem hospedagem) {

        int linhasAfetadas;

        try {
            Open();

            ContentValues values = Put(hospedagem);
            linhasAfetadas = db.update(Hospedagem.TABELA, values, Hospedagem.ID + " = ?", new String[]{hospedagem.getId().toString()});
        }
        finally {
            Close();
        }

        return linhasAfetadas;
    }

    public Hospedagem Select(final Long id) {

       Hospedagem hospedagem = new Hospedagem();

        try {
            Open();
            Cursor cursor = db.query(Hospedagem.TABELA, colunas, Hospedagem.ID + " = ?", new String[] {id.toString()}, null, null, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                hospedagem = CursorToStructure(cursor);
                cursor.moveToNext();
                break;
            }
        }
        finally {
            Close();
        }
        return hospedagem;
    }

    public final Hospedagem CursorToStructure(Cursor cursor) {
        Hospedagem hospedagem = new Hospedagem();
        hospedagem.setId(cursor.getLong(0));
        hospedagem.setCustoNoite(cursor.getLong(1));
        hospedagem.setTotalNoites(cursor.getLong(2));
        hospedagem.setTotalQuartos(cursor.getLong(3));
        return hospedagem;
    }

}
