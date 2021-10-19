package desenvolve.unesc.myapplication.database.model;

public class Hospedagem {

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

    private long custoNoite;

    private long totalNoites;

    private long totalQuartos;

    private long total;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustoNoite() {
        return custoNoite;
    }

    public void setCustoNoite(long custoNoite) {
        this.custoNoite = custoNoite;
    }

    public long getTotalNoites() {
        return totalNoites;
    }

    public void setTotalNoites(long totalNoites) {
        this.totalNoites = totalNoites;
    }

    public long getTotalQuartos() {
        return totalQuartos;
    }

    public void setTotalQuartos(long totalQuartos) {
        this.totalQuartos = totalQuartos;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}