package br.com.compasso.caixa.test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import br.com.compasso.caixa.modelo.CaixaEletronico;

class CaixaEletronicoTest {

	@Test
	void CalculoParaRetornoDeQuantidadeDENotasTest() {
		BigDecimal duzentosECinquenta = new BigDecimal(250);
		Map<String, Integer> resultadoEsperado_250= new LinkedHashMap<String, Integer>(){{
			put("CEM", 2);
			put("CINQUENTA", 1);
		}};
		
		
		BigDecimal duzentosETrinta = new BigDecimal(230);
		Map<String, Integer> resultadoEsperado_230= new LinkedHashMap<String, Integer>(){{
			put("CEM", 2);
			put("VINTE", 1);
			put("DEZ", 1);
		}};
				
				
		CaixaEletronico caixaEletronico = new CaixaEletronico();
		
		Map<String, Integer> resultadoReal_250 = caixaEletronico.CalculaNotasDoSaque(duzentosECinquenta);
		assertEquals(resultadoEsperado_250, resultadoReal_250);
		
		Map<String, Integer> resultadoReal_230 = caixaEletronico.CalculaNotasDoSaque(duzentosETrinta);
		assertEquals(resultadoEsperado_230, resultadoReal_230);
		
	}

}
