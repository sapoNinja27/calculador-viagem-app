package desenvolve.unesc.myapplication.database.model;

public class Gasolina {

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

    ATRIBUTOS DE MANIPULAÇÃO DA GASOLINA

    ===========================================================*/


    private long id;

    private long totalEstimadoQuilometros;

    private long mediaQuilometrosLitro;

    private long custoMedioLitro;

    private long totalVeiculos;

    private long total;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTotalEstimadoQuilometros() {
        return totalEstimadoQuilometros;
    }

    public void setTotalEstimadoQuilometros(long totalEstimadoQuilometros) {
        this.totalEstimadoQuilometros = totalEstimadoQuilometros;
    }

    public long getMediaQuilometrosLitro() {
        return mediaQuilometrosLitro;
    }

    public void setMediaQuilometrosLitro(long mediaQuilometrosLitro) {
        this.mediaQuilometrosLitro = mediaQuilometrosLitro;
    }

    public long getCustoMedioLitro() {
        return custoMedioLitro;
    }

    public void setCustoMedioLitro(long custoMedioLitro) {
        this.custoMedioLitro = custoMedioLitro;
    }

    public long getTotalVeiculos() {
        return totalVeiculos;
    }

    public void setTotalVeiculos(long totalVeiculos) {
        this.totalVeiculos = totalVeiculos;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
