package desenvolve.unesc.myapplication.database.model;

public class Entreterimento {

    public static final String
            TABELA_VIAGEM = "tb_vuagens";

    public static final String
            ID = "_id",
            DESTINO = "destino",
            GASOLINA = "gasolina",
            TARIFA_AEREA = "tarifa",
            REFEICAO = "refeicao",
            HOSPEDAGEM = "hospedagem",
            ENTRETERIMENTO = "entreterimento";

    public static final String
            CREATE_TABLE =
            "create table "+TABELA_VIAGEM
                    +"("
                    +   ID + " integer primary key autoincrement, "
                    +   DESTINO + " text not null "
                    +   GASOLINA + "integer"
                    +   TARIFA_AEREA + "integer"
                    +   REFEICAO + "integer"
                    +   HOSPEDAGEM + "integer"
                    +   ENTRETERIMENTO + "integer"
                    +");";

    public static final String
            DROP_TABLE = "drop table if exists "+TABELA_VIAGEM;

    /*=========================================================

    ATRIBUTOS DE MANIPULAÇÃO DA VIAGEM

    ===========================================================*/


    private long id;

    private long vilaEncantada;

    private long zooPomerode;

    private long emprevistos;

    private long total;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getVilaEncantada() {
        return vilaEncantada;
    }

    public void setVilaEncantada(long vilaEncantada) {
        this.vilaEncantada = vilaEncantada;
    }

    public long getZooPomerode() {
        return zooPomerode;
    }

    public void setZooPomerode(long zooPomerode) {
        this.zooPomerode = zooPomerode;
    }

    public long getEmprevistos() {
        return emprevistos;
    }

    public void setEmprevistos(long emprevistos) {
        this.emprevistos = emprevistos;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
