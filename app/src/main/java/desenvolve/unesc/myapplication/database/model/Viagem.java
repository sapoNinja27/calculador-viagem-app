package desenvolve.unesc.myapplication.database.model;

public class Viagem {

    public static final String
            TABELA = "tb_viagem";

    public static final String
            ID = "_id",
            DESTINO = "destino",
            GASOLINA = "gasolina",
            TARIFA_AEREA = "tarifa",
            REFEICAO = "refeicao",
            HOSPEDAGEM = "hospedagem",
            ENTRETERIMENTO = "entreterimento",
            USUARIO = "usuario";

    public static final String
            CREATE_TABLE =
            "create table "+ TABELA
                    +"("
                    +   ID + " integer primary key autoincrement, "
                    +   DESTINO + " text not null, "
                    +   GASOLINA + " integer, "
                    +   TARIFA_AEREA + " integer, "
                    +   REFEICAO + " integer, "
                    +   HOSPEDAGEM + " integer, "
                    +   ENTRETERIMENTO + " integer, "
                    +   USUARIO + " integer "
                    +");";

    public static final String
            DROP_TABLE = "drop table if exists "+ TABELA;


    private Long id;

    private String destino;

    private Gasolina gasolina;

    private TarifaAerea tarifaAerea;

    private Refeicao refeicao;

    private Hospedagem hospedagem;

    private Entreterimento entreterimento;

    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Gasolina getGasolina() {
        return gasolina;
    }

    public void setGasolina(Gasolina gasolina) {
        this.gasolina = gasolina;
    }

    public TarifaAerea getTarifaAerea() {
        return tarifaAerea;
    }

    public void setTarifaAerea(TarifaAerea tarifaAerea) {
        this.tarifaAerea = tarifaAerea;
    }

    public Refeicao getRefeicao() {
        return refeicao;
    }

    public void setRefeicao(Refeicao refeicao) {
        this.refeicao = refeicao;
    }

    public Hospedagem getHospedagem() {
        return hospedagem;
    }

    public void setHospedagem(Hospedagem hospedagem) {
        this.hospedagem = hospedagem;
    }

    public Entreterimento getEntreterimento() {
        return entreterimento;
    }

    public void setEntreterimento(Entreterimento entreterimento) {
        this.entreterimento = entreterimento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getTotal(){
        return gasolina.getTotal() +
                tarifaAerea.getTotal() +
                (refeicao.getTotal() * hospedagem.getTotalNoites()) +
                hospedagem.getTotal() +
                entreterimento.getTotal();
    }
}
