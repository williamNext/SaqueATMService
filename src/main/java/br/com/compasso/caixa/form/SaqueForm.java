package br.com.compasso.caixa.form;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import br.com.compasso.caixa.config.validation.annotations.DivisibleBy;

public class SaqueForm {

	@NotNull
	@DecimalMin("10.0")
	@DivisibleBy(divisor = 10)
	private BigDecimal valorDeSaque;

	public SaqueForm() {
	}

	public SaqueForm(@NotNull @DecimalMin("10.0") BigDecimal valorDeSaque) {
		this.valorDeSaque = valorDeSaque;
	}

	public BigDecimal getValorDeSaque() {
		return valorDeSaque;
	}

	public void setValorDeSaque(BigDecimal valorDeSaque) {
		this.valorDeSaque = valorDeSaque;
	}

}
