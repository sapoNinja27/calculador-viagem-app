package desenvolve.unesc.myapplication.database.model;

public class Refeicao {

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

    ATRIBUTOS DE MANIPULAÇÃO DA REFEIÇÃO

    ===========================================================*/


    private long id;

    private long custoEstimadoRefeicao;

    private long refeicoesDia;

    private long total;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustoEstimadoRefeicao() {
        return custoEstimadoRefeicao;
    }

    public void setCustoEstimadoRefeicao(long custoEstimadoRefeicao) {
        this.custoEstimadoRefeicao = custoEstimadoRefeicao;
    }

    public long getRefeicoesDia() {
        return refeicoesDia;
    }

    public void setRefeicoesDia(long refeicoesDia) {
        this.refeicoesDia = refeicoesDia;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
