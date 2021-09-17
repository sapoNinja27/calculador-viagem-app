package desenvolve.unesc.myapplication.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import desenvolve.unesc.myapplication.database.DBOpenHelper;
import desenvolve.unesc.myapplication.database.model.UsuarioModel;

public class UsuarioDAO extends AbstrataDAO {

    private final String[]
    colunas = {
            UsuarioModel.COLUNA_ID,
            UsuarioModel.COLUNA_USUARIO,
            UsuarioModel.COLUNA_SENHA
    };

    public UsuarioDAO(final Context contexto) {
        helper = new DBOpenHelper(contexto);
    }

    /**
     * Faz o Insert no banco de dados.
     * @param model
     * @return
     */
    public long Insert(UsuarioModel model) {

        long linhasAfetadas;

        try {
            Open();

            ContentValues values = new ContentValues();
            values.put(UsuarioModel.COLUNA_USUARIO, model.getUsuario());
            values.put(UsuarioModel.COLUNA_SENHA, model.getSenha());
            linhasAfetadas = db.insert(UsuarioModel.TABELA_NOME, null, values);
        }
        finally {
            Close();
        }

        return linhasAfetadas;
    }

    /**
     * Deleta um usuário do banco de dados.
     * @param usuario
     */
    public void Delete(final String usuario) {
        Open();
        db.delete(UsuarioModel.TABELA_NOME, UsuarioModel.COLUNA_USUARIO + " = ?", new String[]{usuario});
        Close();
    }

    public int Update(final String usuario, final String senha) {

        int linhasAfetadas = 0;

        try {
            Open();

            ContentValues values = new ContentValues();
            values.put(UsuarioModel.COLUNA_SENHA, senha);
            linhasAfetadas = db.update(UsuarioModel.TABELA_NOME, values, UsuarioModel.COLUNA_USUARIO + " = ?", new String[]{usuario});
        }
        finally {
            Close();
        }

        return linhasAfetadas;
    }

    /**
     * Executa o SELECT buscando pelo usuario e senha.
     * @param usuario
     * @param senha
     * @return
     */
    public UsuarioModel Select(final String usuario, final String senha) {

        UsuarioModel model = null;

        try {
            Open();

            // select * from tb_usuario where usuario = ? and senha = ?
            Cursor cursor = db.query
                    (
                        UsuarioModel.TABELA_NOME,
                        colunas,
                        UsuarioModel.COLUNA_USUARIO + " = ? and "+UsuarioModel.COLUNA_SENHA+" = ?",
                        new String[]{usuario, senha},
                        null,
                        null,
                        null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                model = CursorToStructure(cursor);
                break;
            }
        }
        finally {
            Close();
        }

        return model;
    }

    /**
     * Executa o SELECT no banco de dados trazendo todos os usuários.
     * @return
     */
    public List<UsuarioModel> Select() {

        List<UsuarioModel> lista = new ArrayList<UsuarioModel>();

        try {
            Open();
            Cursor cursor = db.query(UsuarioModel.TABELA_NOME, colunas, null, null, null, null, null);
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
    public final UsuarioModel CursorToStructure(Cursor cursor) {
        UsuarioModel model = new UsuarioModel();
        model.setId(cursor.getLong(0));
        model.setUsuario(cursor.getString(1));
        model.setSenha(cursor.getString(2));
        return model;
    }

}
