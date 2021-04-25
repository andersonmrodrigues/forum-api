package br.com.desenv.api.repository;

import br.com.desenv.api.model.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    List<Topico> findByTitulo(String nomeCurso);

    Page<Topico> findByCursoNome(String nomeCurso, Pageable pageable);
}
