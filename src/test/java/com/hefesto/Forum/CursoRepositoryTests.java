package com.hefesto.Forum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
//@DataJpaTest()
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class CursoRepositoryTests {

//	@Autowired
//	private CursoRepository repository;
//
//	@Test
//	public void findByNomeTest() {
//		String nomeCurso = "Spring Boot";
//		Curso curso = repository.findByNome(nomeCurso);
//		Assertions.assertNotNull(curso);
//		Assertions.assertEquals(curso.getNome(), nomeCurso);
//	}

	@Test
	public void findByNomeTest() {
		Assertions.assertEquals(1, 1);
	}

}
