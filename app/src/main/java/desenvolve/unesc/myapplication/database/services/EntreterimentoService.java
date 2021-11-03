package desenvolve.unesc.myapplication.database.services;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import desenvolve.unesc.myapplication.database.DBOpenHelper;
import desenvolve.unesc.myapplication.database.entidades.Entreterimento;

public class EntreterimentoService extends AbstractService {

    private final String[]
        colunas = {
            Entreterimento.ID,
            Entreterimento.VILA_ENCANTADA,
            Entreterimento.ZOO_POMERODE,
            Entreterimento.EMPREVISTOS
    };

    public EntreterimentoService(final Context contexto) {
        helper = new DBOpenHelper(contexto);
    }


    public Long Insert(Entreterimento entreterimento) {

        long linhasAfetadas;

        try {
            Open();

            ContentValues values = Put(entreterimento);
            linhasAfetadas = db.insert(Entreterimento.TABELA, null, values);
        }
        finally {
            Close();
        }

        return linhasAfetadas;
    }

    public ContentValues Put(Entreterimento entreterimento){
        ContentValues values = new ContentValues();
        values.put(Entreterimento.VILA_ENCANTADA, entreterimento.getVilaEncantada());
        values.put(Entreterimento.ZOO_POMERODE, entreterimento.getZooPomerode());
        values.put(Entreterimento.EMPREVISTOS, entreterimento.getEmprevistos());
        return values;
    }

    public void Delete(final Long id) {
        Open();
        db.delete(Entreterimento.TABELA, Entreterimento.ID + " = ?", new String[]{id.toString()});
        Close();
    }


    public Integer Update(final Entreterimento entreterimento) {

        int linhasAfetadas;

        try {
            Open();

            ContentValues values = Put(entreterimento);
            linhasAfetadas = db.update(Entreterimento.TABELA, values, Entreterimento.ID + " = ?", new String[]{entreterimento.getId().toString()});
        }
        finally {
            Close();
        }

        return linhasAfetadas;
    }

    public Entreterimento Select(final Long id) {

       Entreterimento entreterimento = new Entreterimento();

        try {
            Open();
            Cursor cursor = db.query(Entreterimento.TABELA, colunas, Entreterimento.ID + " = ?", new String[] {id.toString()}, null, null, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                entreterimento = CursorToStructure(cursor);
                cursor.moveToNext();
                break;
            }
        }
        finally {
            Close();
        }
        return entreterimento;
    }

    public final Entreterimento CursorToStructure(Cursor cursor) {
        Entreterimento entreterimento = new Entreterimento();
        entreterimento.setId(cursor.getLong(0));
        entreterimento.setVilaEncantada(cursor.getLong(1));
        entreterimento.setZooPomerode(cursor.getLong(2));
        entreterimento.setEmprevistos(cursor.getLong(3));
        return entreterimento;
    }

}
