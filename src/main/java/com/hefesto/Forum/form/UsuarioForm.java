package com.hefesto.Forum.form;

import com.sun.istack.NotNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.NotEmpty;

public class UsuarioForm {

    @NotEmpty @NotNull
    private String login;
    @NotEmpty @NotNull
    private String senha;

    public UsuarioForm(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UsernamePasswordAuthenticationToken converter() {
        return  new UsernamePasswordAuthenticationToken(login, senha);
    }
}
