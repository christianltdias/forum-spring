package com.hefesto.Forum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class AutenticacaoControllerTests {

	@Autowired
	private MockMvc mockMvc;

//	@Test
//	public void deveriaRetornar400CasoDadosIncorretos() throws Exception {
//		URI uri = new URI("/api/auth");
//		String json = "{\"login\":\"invalido\",\"senha\":\"1234\"}";
//
//		mockMvc
//				.perform(MockMvcRequestBuilders
//						.post(uri)
//						.content(json)
//						.contentType(MediaType.APPLICATION_JSON))
//				.andExpect(MockMvcResultMatchers.status().is(HttpStatus.BAD_REQUEST.value()));
//	}

}
