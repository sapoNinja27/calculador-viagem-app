package desenvolve.unesc.myapplication.database.services;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import desenvolve.unesc.myapplication.database.DBOpenHelper;
import desenvolve.unesc.myapplication.database.entidades.Refeicao;

public class RefeicaoService extends AbstractService {

    private final String[]
        colunas = {
            Refeicao.ID,
            Refeicao.CUSTO_ESTIMADO_REFEICAO,
            Refeicao.REFEICOES_DIA
    };

    public RefeicaoService(final Context contexto) {
        helper = new DBOpenHelper(contexto);
    }

    public Long Insert(Refeicao refeicao) {

        long linhasAfetadas;

        try {
            Open();

            ContentValues values = Put(refeicao);
            linhasAfetadas = db.insert(Refeicao.TABELA, null, values);
        }
        finally {
            Close();
        }

        return linhasAfetadas;
    }

    public ContentValues Put(Refeicao refeicao){
        ContentValues values = new ContentValues();
        values.put(Refeicao.CUSTO_ESTIMADO_REFEICAO, refeicao.getCustoEstimadoRefeicao());
        values.put(Refeicao.REFEICOES_DIA, refeicao.getRefeicoesDia());
        return values;
    }

    public void Delete(final Long id) {
        Open();
        db.delete(Refeicao.TABELA, Refeicao.ID + " = ?", new String[]{id.toString()});
        Close();
    }

    public Integer Update(final Refeicao refeicao) {

        int linhasAfetadas;

        try {
            Open();

            ContentValues values = Put(refeicao);
            linhasAfetadas = db.update(Refeicao.TABELA, values, Refeicao.ID + " = ?", new String[]{refeicao.getId().toString()});
        }
        finally {
            Close();
        }

        return linhasAfetadas;
    }

    public Refeicao Select(final Long id) {

       Refeicao refeicao = new Refeicao();

        try {
            Open();
            Cursor cursor = db.query(Refeicao.TABELA, colunas, Refeicao.ID + " = ?", new String[] {id.toString()}, null, null, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                refeicao = CursorToStructure(cursor);
                cursor.moveToNext();
                break;
            }
        }
        finally {
            Close();
        }
        return refeicao;
    }

    public final Refeicao CursorToStructure(Cursor cursor) {
        Refeicao refeicao = new Refeicao();
        refeicao.setId(cursor.getLong(0));
        refeicao.setCustoEstimadoRefeicao(cursor.getLong(1));
        refeicao.setRefeicoesDia(cursor.getLong(2));
        return refeicao;
    }

}
