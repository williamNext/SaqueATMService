package br.com.compasso.caixa.config.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.core.JsonParseException;

@RestControllerAdvice
public class ErroDeValidacaoHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler({MethodArgumentNotValidException.class})
	public List<ErroDeFormularioDTO> handleFieldErrors( MethodArgumentNotValidException exception ) {
		
		List<ErroDeFormularioDTO> dto = new ArrayList<ErroDeFormularioDTO>();
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		
		fieldErrors.forEach(e -> {
				ErroDeFormularioDTO erroDeFormularioDTO = new ErroDeFormularioDTO(
						e.getField(),
						messageSource.getMessage(e,LocaleContextHolder.getLocale())
						);
				dto.add(erroDeFormularioDTO);
		});
		
		return dto;
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
	public  ErroDeFormularioDTO JsonParseHandler(HttpMessageNotReadableException exception ) {
		
		return new ErroDeFormularioDTO("valorDeSaque", "Erro no parse do Json, campo deve existir e conter valores válidos");
	}
	
}
