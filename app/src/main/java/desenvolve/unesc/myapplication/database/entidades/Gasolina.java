package desenvolve.unesc.myapplication.database.entidades;

public class Gasolina {

    public static final String
            TABELA = "tb_gasolina";

    public static final String
            ID = "_id",
            TOTAL_ESTIMADO_QUILOMETROS = "totalEstimadoQuilometros",
            MEDIA_QUILOMETROS = "mediaQuilometrosLitro",
            CUSTO_MEDIO_LITRO = "custoMedioLitro",
            TOTAL_VEICULOS = "totalVeiculos";

    public static final String
            CREATE_TABLE =
            "create table " + TABELA
                    + "("
                    + ID + " integer primary key autoincrement, "
                    + TOTAL_ESTIMADO_QUILOMETROS + " integer, "
                    + MEDIA_QUILOMETROS + " integer, "
                    + CUSTO_MEDIO_LITRO + " integer, "
                    + TOTAL_VEICULOS + " integer"
                    + ");";

    public static final String
            DROP_TABLE = "drop table if exists " + TABELA;

    private Long id;

    private long totalEstimadoQuilometros = 1;

    private long mediaQuilometrosLitro = 1;

    private long custoMedioLitro = 1;

    private long totalVeiculos = 1;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getTotal() {
        return ((totalEstimadoQuilometros
                + mediaQuilometrosLitro)
                * custoMedioLitro)
                / totalVeiculos;
    }
}
