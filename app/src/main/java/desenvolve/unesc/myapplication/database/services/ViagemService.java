package desenvolve.unesc.myapplication.database.services;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import desenvolve.unesc.myapplication.LoginActivity;
import desenvolve.unesc.myapplication.database.DBOpenHelper;
import desenvolve.unesc.myapplication.database.entidades.Usuario;
import desenvolve.unesc.myapplication.database.entidades.Viagem;

public class ViagemService extends AbstractService {

    private final String[]
        colunas = {
            Viagem.ID,
            Viagem.DESTINO,
            Viagem.QUANTIDADE_PESSOAS,
            Viagem.DURACAO,
            Viagem.GASOLINA,
            Viagem.HOSPEDAGEM,
            Viagem.ENTRETERIMENTO,
            Viagem.REFEICAO,
            Viagem.TARIFA_AEREA,
            Viagem.USUARIO
    };

    HospedagemService hospedagemService ;
    TarifaAereaService tarifaAereaService;
    GasolinaService gasolinaService;
    RefeicaoService refeicaoService;
    EntreterimentoService entreterimentoService;

    public ViagemService(final Context contexto) {
        helper = new DBOpenHelper(contexto);
        hospedagemService = new HospedagemService(contexto);
        tarifaAereaService = new TarifaAereaService(contexto);
        gasolinaService = new GasolinaService(contexto);
        refeicaoService = new RefeicaoService(contexto);
        entreterimentoService = new EntreterimentoService(contexto);

    }


    public long Insert(Viagem viagem) {

        long linhasAfetadas;
        try {

            Open();

            ContentValues values = new ContentValues();
            values.put(Viagem.DESTINO, viagem.getDestino());
            values.put(Viagem.QUANTIDADE_PESSOAS, viagem.getQuantidadePessoas());
            values.put(Viagem.DURACAO, viagem.getDuracao());
            values.put(Viagem.GASOLINA,gasolinaService.Insert(viagem.getGasolina()));
            values.put(Viagem.TARIFA_AEREA,tarifaAereaService.Insert(viagem.getTarifaAerea()));
            values.put(Viagem.REFEICAO,refeicaoService.Insert(viagem.getRefeicao()));
            values.put(Viagem.HOSPEDAGEM, hospedagemService.Insert(viagem.getHospedagem()));
            values.put(Viagem.ENTRETERIMENTO, entreterimentoService.Insert(viagem.getEntreterimento()));
            values.put(Viagem.USUARIO, viagem.getUsuario().getId());
            linhasAfetadas = db.insert(Viagem.TABELA, null, values);
        }
        finally {
            Close();
        }

        return linhasAfetadas;
    }


    public void Delete(final Long id) {
        Open();
        gasolinaService.Delete(id);
        tarifaAereaService.Delete(id);
        refeicaoService.Delete(id);
        hospedagemService.Delete(id);
        entreterimentoService.Delete(id);
        db.delete(Viagem.TABELA, Viagem.ID + " = ?", new String[]{id.toString()});
        Close();
    }


    public void Delete(List<Long> ids) {
        Open();
        for (Long id:ids
             ) {
            gasolinaService.Delete(id);
            tarifaAereaService.Delete(id);
            refeicaoService.Delete(id);
            hospedagemService.Delete(id);
            entreterimentoService.Delete(id);
            db.delete(Viagem.TABELA, Viagem.ID + " = ?", new String[]{id.toString()});
        }
        Close();
    }

    public List<Viagem> Select(final Long id) {

        List<Viagem> viagens = new ArrayList<>();

        try {
            Open();
            Cursor cursor = db.query(Viagem.TABELA, colunas, Viagem.USUARIO + " = ?", new String[] {id.toString()}, null, null, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                viagens.add(CursorToStructure(cursor));
                cursor.moveToNext();
            }
        }
        finally {
            Close();
        }
        LoginActivity.usuario.setViagens(viagens);
        return viagens;
    }

    public Viagem Find(final Long id) {

        Viagem viagem = new Viagem();

        try {
            Open();
            Cursor cursor = db.query(Viagem.TABELA, colunas, Viagem.USUARIO + " = ?", new String[] {id.toString()}, null, null, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                viagem = CursorToStructure(cursor);
                cursor.moveToNext();
                break;
            }
        }
        finally {
            Close();
        }
        return viagem;
    }

    public final Viagem CursorToStructure(Cursor cursor) {
        Viagem viagem = new Viagem();
        viagem.setId(cursor.getLong(0));
        viagem.setDestino(cursor.getString(1));
        viagem.setQuantidadePessoas(cursor.getLong(2));
        viagem.setDuracao(cursor.getLong(3));
        viagem.setGasolina(gasolinaService.Select(cursor.getLong(4)));
        viagem.setTarifaAerea(tarifaAereaService.Select(cursor.getLong(5)));
        viagem.setRefeicao(refeicaoService.Select(cursor.getLong(6)));
        viagem.setHospedagem(hospedagemService.Select(cursor.getLong(7)));
        viagem.setEntreterimento(entreterimentoService.Select(cursor.getLong(8)));
        return viagem;
    }

}
