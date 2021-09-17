package desenvolve.unesc.myapplication.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import desenvolve.unesc.myapplication.database.DBOpenHelper;
import desenvolve.unesc.myapplication.database.model.FilmeModel;

public class FilmeDAO extends AbstrataDAO {

    private final String[]
        colunas = {
            FilmeModel.COLUNA_ID,
            FilmeModel.COLUNA_FILME
    };

    public FilmeDAO(final Context contexto) {
        helper = new DBOpenHelper(contexto);
    }

    /**
     * Faz o Insert no banco de dados.
     * @param model
     * @return
     */
    public long Insert(FilmeModel model) {

        long linhasAfetadas;

        try {
            Open();

            ContentValues values = new ContentValues();
            values.put(FilmeModel.COLUNA_FILME, model.getFilme());
            linhasAfetadas = db.insert(FilmeModel.TABELA_NOME, null, values);
        }
        finally {
            Close();
        }

        return linhasAfetadas;
    }

    /**
     * Deleta um usuário do banco de dados.
     */
    public void Delete(final String filme) {
        Open();
        db.delete(FilmeModel.TABELA_NOME, FilmeModel.COLUNA_FILME + " = ?", new String[]{filme});
        Close();
    }

    /**
     * Deleta um usuário do banco de dados.
     */
    public void DeleteAll() {
        Open();
        db.delete(FilmeModel.TABELA_NOME, null, null);
        Close();
    }

    public int Update(final String filme) {

        int linhasAfetadas = 0;

        try {
            Open();

            ContentValues values = new ContentValues();
            values.put(FilmeModel.COLUNA_FILME, filme);
            linhasAfetadas = db.update(FilmeModel.TABELA_NOME, values, FilmeModel.COLUNA_FILME + " = ?", new String[]{filme});
        }
        finally {
            Close();
        }

        return linhasAfetadas;
    }

    /**
     * Executa o SELECT buscando pelo usuario e senha.
     * @return
     */
    public List<FilmeModel> Select(final String filme) {

        List<FilmeModel> lista = new ArrayList<FilmeModel>();

        try {
            Open();
            Cursor cursor = db.query(FilmeModel.TABELA_NOME, colunas, FilmeModel.COLUNA_FILME+" = ?", new String[] {filme}, null, null, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                lista.add(CursorToStructure(cursor));
                cursor.moveToNext();
                break;
            }
        }
        finally {
            Close();
        }
        return lista;
    }

    /**
     * Executa o SELECT no banco de dados trazendo todos os usuários.
     * @return
     */
    public List<FilmeModel> Select() {

        List<FilmeModel> lista = new ArrayList<FilmeModel>();

        try {
            Open();
            Cursor cursor = db.query(FilmeModel.TABELA_NOME, colunas, null, null, null, null, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                lista.add(CursorToStructure(cursor));
                cursor.moveToNext();
            }
        }
        finally {
            Close();
        }
        return lista;
    }

    /**
     * Transforma o cursor em UsuarioModel.
     * @param cursor
     * @return
     */
    public final FilmeModel CursorToStructure(Cursor cursor) {
        FilmeModel model = new FilmeModel();
        model.setId(cursor.getLong(0));
        model.setFilme(cursor.getString(1));
        return model;
    }

}
