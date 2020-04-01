package br.com.compasso.caixa.modelo;

import java.math.BigDecimal;

public enum Notas {
	CEM(new BigDecimal(100.0)),
	CINQUENTA(new BigDecimal(50.0)),
	VINTE(new BigDecimal(20.0)),
	DEZ(new BigDecimal(10.0));
	
	private BigDecimal value;
	
	private Notas(BigDecimal value) {
		this.value =value;
	}

	public BigDecimal getValue() {
		return value;
	}
}
