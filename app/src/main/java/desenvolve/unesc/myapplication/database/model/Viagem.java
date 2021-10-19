package desenvolve.unesc.myapplication.database.model;

public class Viagem {

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

    private String destino;

    private Gasolina gasolina;

    private TarifaAerea tarifaAerea;

    private Refeicao refeicao;

    private Hospedagem hospedagem;

    private Entreterimento entreterimento;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTotal(){
        return gasolina.getTotal() +
                tarifaAerea.getTotal() +
                refeicao.getTotal() +
                hospedagem.getTotal() +
                entreterimento.getTotal();
    }
}
