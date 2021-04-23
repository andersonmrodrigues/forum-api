package br.com.desenv.api.controller.dto;

import br.com.desenv.api.model.Curso;
import br.com.desenv.api.model.Topico;
import br.com.desenv.api.repository.CursoRepository;

public class TopicoFormDto {
    private String titulo;
    private String mensagem;
    private String nomeCurso;

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

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public Topico converter(CursoRepository cursoRepository) {
        Curso curso = cursoRepository.findByNome(this.nomeCurso);
        return new Topico(this.titulo, this.mensagem, curso);
    }
}
