package desenvolve.unesc.myapplication.database.services;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.stream.Collectors;

import desenvolve.unesc.myapplication.database.DBOpenHelper;
import desenvolve.unesc.myapplication.database.entidades.Usuario;
import desenvolve.unesc.myapplication.database.entidades.Viagem;

public class UsuarioService extends AbstractService {

    private final String[]
    colunas = {
            Usuario.ID,
            Usuario.USUARIO,
            Usuario.SENHA
    };
    private  ViagemService viagemService;
    public UsuarioService(final Context contexto) {
        helper = new DBOpenHelper(contexto);
        viagemService = new ViagemService(contexto);
    }

    public Long Insert(Usuario usuario) {

        long linhasAfetadas;

        try {
            Open();

            ContentValues values = new ContentValues();
            values.put(Usuario.USUARIO, usuario.getUsuario());
            values.put(Usuario.SENHA, usuario.getSenha());
            linhasAfetadas = db.insert(Usuario.TABELA, null, values);
        }
        finally {
            Close();
        }

        return linhasAfetadas;
    }

    public void Delete(final Usuario usuario) {
        Open();
        viagemService.Delete(
                usuario.getViagens()
                .stream()
                .map(Viagem::getId)
                .collect(Collectors.toList())
        );

        db.delete(Usuario.TABELA, Usuario.ID + " = ?", new String[]{usuario.getId().toString()});
        Close();
    }

    public Usuario Find(final String nome, String senha) {

        Usuario usuario = null;

        try {
            Open();
            Cursor cursor = db.query
                    (
                            Usuario.TABELA,
                            colunas,
                            Usuario.USUARIO + " = ? and "+Usuario.SENHA+" = ?",
                            new String[]{nome, senha},
                            null,
                            null,
                            null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                usuario = CursorToStructure(cursor);
                break;
            }
        }
        finally {
            Close();
        }

        return usuario;
    }

    public final Usuario CursorToStructure(Cursor cursor) {
        Usuario model = new Usuario();
        model.setId(cursor.getLong(0));
        model.setUsuario(cursor.getString(1));
        model.setSenha(cursor.getString(2));
        try{
            model.setViagens(viagemService.Select(model.getId()));
        }catch(Exception e){
            //caso for o 1 login o sistema vai crashar quando for buscar as viagens
        }
        return model;
    }

}
