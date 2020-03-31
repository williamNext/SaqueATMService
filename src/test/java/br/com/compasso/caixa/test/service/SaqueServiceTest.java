package br.com.compasso.caixa.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import br.com.compasso.caixa.controller.dto.SaqueDTO;
import br.com.compasso.caixa.form.SaqueForm;
import br.com.compasso.caixa.modelo.CaixaEletronico;
import br.com.compasso.caixa.service.SaqueCaixaEletronicoService;

class SaqueServiceTest {
	@Mock
	private CaixaEletronico caixaEletronico;
	private SaqueForm saqueForm;
	private Map<String, Integer> mapaDeNotas;
	
	@BeforeEach
	void setUp() {
       saqueForm = new SaqueForm(new BigDecimal(230));
		 
	    mapaDeNotas = new LinkedHashMap<String, Integer>(){
		private static final long serialVersionUID = 1L;
		{put("CEM", 2);  put("VINTE", 1);  put("DEZ", 1);}};
	}
	
	@Test
	void testGetMapaDeNotasComFormCorreto(){
		 SaqueDTO saqueDTO = new SaqueDTO(mapaDeNotas);
			
		 SaqueCaixaEletronicoService saqueService = new SaqueCaixaEletronicoService();
		 Optional<SaqueDTO> resultado = saqueService.getMapaDeNotas(saqueForm);
		 
		 assertEquals(saqueDTO,resultado.get());
		 assertEquals(saqueDTO.getNotas().size(), mapaDeNotas.size());
		 
	}


}
