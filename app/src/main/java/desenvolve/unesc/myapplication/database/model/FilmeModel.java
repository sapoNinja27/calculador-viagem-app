package desenvolve.unesc.myapplication.database.model;

public class FilmeModel {

    public static final String
            TABELA_NOME = "tb_filmes";

    public static final String
            COLUNA_ID = "_id",
            COLUNA_FILME = "filme";

    public static final String
            CREATE_TABLE =
            "create table "+TABELA_NOME
                    +"("
                    +   COLUNA_ID + " integer primary key autoincrement, "
                    +   COLUNA_FILME + " text not null "
                    +");";

    public static final String
            DROP_TABLE = "drop table if exists "+TABELA_NOME;

    /*=========================================================

    ATRIBUTOS DE MANIPULAÇÃO DO USUÁRIO

    ===========================================================*/


    private long id;
    private String filme;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFilme() {
        return filme;
    }

    public void setFilme(String filme) {
        this.filme = filme;
    }
}
