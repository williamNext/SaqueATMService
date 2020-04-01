package br.com.compasso.caixa.modelo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gson.Gson;

import br.com.compasso.caixa.form.SaqueForm;


public class Teste {
	public static void main(String[] args) {
		Gson gson = new Gson();
		
		CaixaEletronico caixaEletronico = new CaixaEletronico();
		
		SaqueForm saqueForm = new SaqueForm(new BigDecimal(10));
		
		Map<String, Integer> calculaNotasDoSaque = caixaEletronico.calculaNotasDoSaque(saqueForm);
		
		System.out.println(calculaNotasDoSaque);
		
	}
}
