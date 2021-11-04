package desenvolve.unesc.myapplication.database.entidades;

public class Entreterimento {

    public static final String
            TABELA = "tb_entreterimento";

    public static final String
            ID = "_id",
            VILA_ENCANTADA = "vilaEncantada",
            ZOO_POMERODE = "zooPomerode",
            EMPREVISTOS = "emprevistos";

    public static final String
            CREATE_TABLE =
            "create table "+TABELA
                    +"("
                    +   ID + " integer primary key autoincrement, "
                    +   VILA_ENCANTADA + " integer, "
                    +   ZOO_POMERODE + " integer, "
                    +   EMPREVISTOS + " integer"
                    +");";

    public static final String
            DROP_TABLE = "drop table if exists "+TABELA;

    private Long id;

    private long vilaEncantada;

    private long zooPomerode;

    private long emprevistos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getVilaEncantada() {
        return vilaEncantada;
    }

    public void setVilaEncantada(long vilaEncantada) {
        this.vilaEncantada = vilaEncantada;
    }

    public long getZooPomerode() {
        return zooPomerode;
    }

    public void setZooPomerode(long zooPomerode) {
        this.zooPomerode = zooPomerode;
    }

    public long getEmprevistos() {
        return emprevistos;
    }

    public void setEmprevistos(long emprevistos) {
        this.emprevistos = emprevistos;
    }

    public Long getTotal(Long totalPessoas) {
        return vilaEncantada *totalPessoas + zooPomerode * totalPessoas + emprevistos;
    }
}
