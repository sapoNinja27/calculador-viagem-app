package desenvolve.unesc.myapplication.database.entidades;

public class Refeicao {

    public static final String
            TABELA = "tb_refeicao";

    public static final String
            ID = "_id",
            CUSTO_ESTIMADO_REFEICAO = "custoEstimadoRefeicao",
            REFEICOES_DIA = "refeicoesDia";

    public static final String
            CREATE_TABLE =
            "create table "+TABELA
                    +"("
                    +   ID + " integer primary key autoincrement, "
                    +   CUSTO_ESTIMADO_REFEICAO + " integer, "
                    +   REFEICOES_DIA + " integer"
                    +");";

    public static final String
            DROP_TABLE = "drop table if exists "+TABELA;

    private Long id;

    private long custoEstimadoRefeicao = 1;

    private long refeicoesDia = 1;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getTotal(Viagem viagem) {
        return ((refeicoesDia * viagem.getQuantidadePessoas()) * custoEstimadoRefeicao) * viagem.getDuracao();
    }
}
