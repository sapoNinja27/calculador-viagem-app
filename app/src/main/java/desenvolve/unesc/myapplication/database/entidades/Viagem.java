package desenvolve.unesc.myapplication.database.entidades;

import java.util.Objects;
import java.util.Optional;

public class Viagem {

    public static final String
            TABELA = "tb_viagem";

    public static final String
            ID = "_id",
            DESTINO = "destino",
            QUANTIDADE_PESSOAS = "quantidade_pessoas",
            DURACAO = "duracao",
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
                    +   QUANTIDADE_PESSOAS + " integer, "
                    +   DURACAO + " integer, "
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

    private Long quantidadePessoas;

    private Long duracao;

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

    public Long getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public void setQuantidadePessoas(Long quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }

    public Long getDuracao() {
        return duracao;
    }

    public void setDuracao(Long duracao) {
        this.duracao = duracao;
    }

    public Long getTotal(){

        Long gas = Long.valueOf(0);
        Long tarifa= Long.valueOf(0);
        Long ref= Long.valueOf(0);
        Long hos= Long.valueOf(0);
        Long en= Long.valueOf(0);

        if(Objects.nonNull(gasolina)){
            gas = gasolina.getTotal();
        }
        if(Objects.nonNull(tarifaAerea)){
            tarifa = tarifaAerea.getTotal(quantidadePessoas);
        }
        if(Objects.nonNull(refeicao)){
            ref = refeicao.getTotal(this);
        }
        if(Objects.nonNull(hospedagem)){
            hos =hospedagem.getTotal();
        }
        if(Objects.nonNull(entreterimento)){
            en = entreterimento.getTotal(quantidadePessoas);
        }
        return gas + tarifa + ref +hos + en;
    }
}
