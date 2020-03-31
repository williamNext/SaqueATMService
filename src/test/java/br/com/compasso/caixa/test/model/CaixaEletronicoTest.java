package br.com.compasso.caixa.test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.compasso.caixa.form.SaqueForm;
import br.com.compasso.caixa.modelo.CaixaEletronico;

class CaixaEletronicoTest {

	private static BigDecimal valor;
	private Map<String, Integer> mapaDeNotas;
	
	@BeforeEach
	void setUp() {
		valor =new BigDecimal(230);
		
		mapaDeNotas = new LinkedHashMap<String, Integer>(){
		private static final long serialVersionUID = 1L;
		{put("CEM", 2);  put("VINTE", 1);  put("DEZ", 1);}
		};
	}
	
	@Test
	void CalculoParaRetornoDeQuantidadeDENotasTest() {
		SaqueForm saqueForm = new SaqueForm(valor);
		
		CaixaEletronico caixaEletronico = new CaixaEletronico();
		Map<String, Integer> valorReal = caixaEletronico.calculaNotasDoSaque(saqueForm);
		assertEquals(mapaDeNotas, valorReal);
	}
	
}
