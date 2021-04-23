package br.com.desenv.api.repository;

import br.com.desenv.api.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    List<Topico> findByTitulo(String nomeCurso);

    List<Topico> findByCursoNome(String nomeCurso);
}
