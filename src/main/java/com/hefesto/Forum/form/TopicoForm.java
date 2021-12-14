package com.hefesto.Forum.form;

import com.hefesto.Forum.model.Curso;
import com.hefesto.Forum.model.Topico;
import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class TopicoForm {

    @NotNull @NotEmpty @Length(min = 5)
    private String titulo;
    @NotNull @NotEmpty @Length(min = 5)
    private String mensagem;
    @NotNull @NotEmpty
    private String cursoNome;

    public TopicoForm(String titulo, String mensagem, String cursoNome) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.cursoNome = cursoNome;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getCursoNome() {
        return cursoNome;
    }

    public void setCursoNome(String cursoNome) {
        this.cursoNome = cursoNome;
    }

    public Topico toTopico(Curso curso) {
        return new Topico(this.titulo, this.mensagem, curso);
    }
}
