package desenvolve.unesc.myapplication.database.entidades;

public class Hospedagem {

    public static final String
            TABELA = "tb_hospedagem";

    public static final String
            ID = "_id",
            CUSTO_NOITE = "custoNoite",
            TOTAL_NOITES = "totalNoites",
            TOTAL_QUARTOS = "totalQuartos";

    public static final String
            CREATE_TABLE =
            "create table "+TABELA
                    +"("
                    +   ID + " integer primary key autoincrement, "
                    +   CUSTO_NOITE + " integer, "
                    +   TOTAL_NOITES + " integer, "
                    +   TOTAL_QUARTOS + " integer"
                    +");";

    public static final String
            DROP_TABLE = "drop table if exists "+TABELA;


    private Long id;

    private long custoNoite = 1;

    private long totalNoites = 1;

    private long totalQuartos = 1;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getTotal() {
        return custoNoite
                * totalNoites
                * totalQuartos;
    }
}
