package desenvolve.unesc.myapplication.database.entidades;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    public static final String
    TABELA = "tb_usuario";

    public static final String
    ID = "_id",
    USUARIO = "usuario",
    SENHA = "senha";

    public static final String
    CREATE_TABLE =
    "create table "+TABELA
    +"("
    +   ID + " integer primary key autoincrement, "
    +   USUARIO + " text not null, "
    +   SENHA + " text not null "
    +");";

    public static final String
    DROP_TABLE = "drop table if exists "+TABELA;

    private Long id;

    private String usuario;

    private String senha;

    private List<Viagem> viagens = new ArrayList<>();

    public Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public Usuario(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Viagem> getViagens() {
        return viagens;
    }

    public void setViagens(List<Viagem> viagens) {
        this.viagens = viagens;
    }
}
