package desenvolve.unesc.myapplication.database.model;

public class TarifaAerea {

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

    ATRIBUTOS DE MANIPULAÇÃO DA TARIFA AEREA

    ===========================================================*/


    private long id;

    private long custoEstimadoPessoa;

    private long aluguelVeiculo;

    private long total;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustoEstimadoPessoa() {
        return custoEstimadoPessoa;
    }

    public void setCustoEstimadoPessoa(long custoEstimadoPessoa) {
        this.custoEstimadoPessoa = custoEstimadoPessoa;
    }

    public long getAluguelVeiculo() {
        return aluguelVeiculo;
    }

    public void setAluguelVeiculo(long aluguelVeiculo) {
        this.aluguelVeiculo = aluguelVeiculo;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
