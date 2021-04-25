package br.com.desenv.api.controller.dto;

import br.com.desenv.api.model.Topico;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

public class TopicoDto {

    private final Long id;
    private final String titulo;
    private final String mensagem;
    private final LocalDateTime dataCriacao;

    public TopicoDto(Topico topico) {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
    }

    public static Page<TopicoDto> converter(Page<Topico> topicoList) {
        return topicoList.map(TopicoDto::new);
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
