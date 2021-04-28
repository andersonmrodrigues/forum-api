package br.com.desenv.api.repository;

import br.com.desenv.api.model.Curso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class CursoRepositoryTest {

    @Autowired
    private CursoRepository repository;

    @Autowired
    private TestEntityManager em;

    @Test
    public void deveriaCarregarUmCursoAoBuscarPeloSeuNome() {
        String nomeCUrso = "HTML 5";

        Curso html5 = new Curso();
        html5.setNome(nomeCUrso);
        html5.setCategoria("Programacao");
        em.persist(html5);

        Curso curso = repository.findByNome(nomeCUrso);
        Assertions.assertNotNull(curso);
        Assertions.assertEquals(nomeCUrso, curso.getNome());
    }

    @Test
    public void naoDeveriaCarregarUmCursoCujoNomeNaoEstejaCadastrado() {
        String nomeCUrso = "JPA";
        Curso curso = repository.findByNome(nomeCUrso);
        Assertions.assertNull(curso);
    }

}
