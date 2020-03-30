package br.com.compasso.caixa.test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import br.com.compasso.caixa.form.SaqueForm;
import br.com.compasso.caixa.modelo.CaixaEletronico;

class CaixaEletronicoTest {

	private static BigDecimal valor =new BigDecimal(230);
	
	@Test
	void CalculoParaRetornoDeQuantidadeDENotasTest() {
		SaqueForm saqueForm = new SaqueForm(valor);
		
		Map<String, Integer> valorEsperado = new LinkedHashMap<String, Integer>(){{
			put("CEM", 2);
			put("VINTE", 1);
			put("DEZ", 1);
		}};
				
		CaixaEletronico caixaEletronico = new CaixaEletronico();
		
		Map<String, Integer> valorReal = caixaEletronico.CalculaNotasDoSaque(saqueForm);
		assertEquals(valorEsperado, valorReal);
		
	}
	
}
