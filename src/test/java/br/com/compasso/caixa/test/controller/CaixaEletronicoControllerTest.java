package br.com.compasso.caixa.test.controller;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.google.gson.Gson;

import br.com.compasso.caixa.controller.CaixaEletronicoController;
import br.com.compasso.caixa.controller.dto.SaqueDTO;
import br.com.compasso.caixa.form.SaqueForm;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(CaixaEletronicoController.class)
class CaixaEletronicoControllerTest {

	@Autowired
	private MockMvc mockMvc;

	private Gson gson;

	private SaqueForm saqueForm;

	private CaixaEletronicoController caixa;

	private String badJson;

	@BeforeEach
	void setUp() {
		gson = new Gson();
		saqueForm = new SaqueForm(new BigDecimal(100));
		caixa = Mockito.mock(CaixaEletronicoController.class);
		badJson = "{'valorDeSaque':}";
		
		MockMvcBuilders.standaloneSetup(caixa).build();
	}

	@Test
	public void testaFormValidoCaixaController() throws Exception {
		Map<String, Integer> mapaDenotas = new LinkedHashMap<String, Integer>() {
			private static final long serialVersionUID = 1L;
			{put("CEM", 1);}
		};

		SaqueDTO saqueDTO = new SaqueDTO(mapaDenotas);

		mockMvc.perform(MockMvcRequestBuilders.post("/caixa")
				.content(gson.toJson(saqueForm))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(gson.toJson(saqueDTO)));
	}

	@Test
	void CaixaControllerBadRequestTest() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.post("/caixa")
				.content(badJson)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

}
