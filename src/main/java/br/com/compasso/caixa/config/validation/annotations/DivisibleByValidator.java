package br.com.compasso.caixa.config.validation.annotations;
import java.math.BigDecimal;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DivisibleByValidator implements
  ConstraintValidator<DivisibleBy, BigDecimal> {
	
	private int divisor;
	
	@Override
    public void initialize(DivisibleBy constraint) {
		divisor =constraint.divisor();
	}
 
	@Override
	public boolean isValid(BigDecimal value, ConstraintValidatorContext context) {
		if (value.remainder(new BigDecimal(divisor)).equals(new BigDecimal(0))) {
			return true;
		}
		return false;
	}


 
}