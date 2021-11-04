package desenvolve.unesc.myapplication.database.entidades;

public class TarifaAerea {

    public static final String
            TABELA = "tb_tarifa_aerea";

    public static final String
            ID = "_id",
            CUSTO_ESTIMADO_PESSOA = "custoEstimadoPessoa",
            ALUGUEL_VEICULO = "aluguelVeiculo";

    public static final String
            CREATE_TABLE =
            "create table "+TABELA
                    +"("
                    +   ID + " integer primary key autoincrement, "
                    +   CUSTO_ESTIMADO_PESSOA + " integer, "
                    +   ALUGUEL_VEICULO + " integer"
                    +");";

    public static final String
            DROP_TABLE = "drop table if exists "+TABELA;

    private Long id;

    private long custoEstimadoPessoa;

    private long aluguelVeiculo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getTotal(Long quantidadePessoas) {
        return (custoEstimadoPessoa * quantidadePessoas) + aluguelVeiculo;
    }
}
