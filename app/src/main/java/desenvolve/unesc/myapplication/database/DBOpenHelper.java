package desenvolve.unesc.myapplication.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import desenvolve.unesc.myapplication.database.model.Entreterimento;
import desenvolve.unesc.myapplication.database.model.Gasolina;
import desenvolve.unesc.myapplication.database.model.Hospedagem;
import desenvolve.unesc.myapplication.database.model.Refeicao;
import desenvolve.unesc.myapplication.database.model.TarifaAerea;
import desenvolve.unesc.myapplication.database.model.Usuario;
import desenvolve.unesc.myapplication.database.model.Viagem;


public class DBOpenHelper extends SQLiteOpenHelper {

    public static final String
    DATABASE_NOME = "bancoViagem.db";

    public static final int
    DATABASE_VERSAO = 1;

    public DBOpenHelper(final Context contexto) {
        super(contexto, DATABASE_NOME, null, DATABASE_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Usuario.CREATE_TABLE);
        db.execSQL(Viagem.CREATE_TABLE);
        db.execSQL(Entreterimento.CREATE_TABLE);
        db.execSQL(Gasolina.CREATE_TABLE);
        db.execSQL(Hospedagem.CREATE_TABLE);
        db.execSQL(Refeicao.CREATE_TABLE);
        db.execSQL(TarifaAerea.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion == 2) {
            db.execSQL(Usuario.CREATE_TABLE);
            db.execSQL(Viagem.CREATE_TABLE);
            db.execSQL(Entreterimento.CREATE_TABLE);
            db.execSQL(Gasolina.CREATE_TABLE);
            db.execSQL(Hospedagem.CREATE_TABLE);
            db.execSQL(Refeicao.CREATE_TABLE);
            db.execSQL(TarifaAerea.CREATE_TABLE);
        }
        else {
            db.execSQL(Usuario.CREATE_TABLE);
            db.execSQL(Viagem.CREATE_TABLE);
            db.execSQL(Entreterimento.CREATE_TABLE);
            db.execSQL(Gasolina.CREATE_TABLE);
            db.execSQL(Hospedagem.CREATE_TABLE);
            db.execSQL(Refeicao.CREATE_TABLE);
            db.execSQL(TarifaAerea.CREATE_TABLE);
        }
    }
}
