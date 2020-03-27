package br.com.compasso.caixa.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.caixa.controller.dto.SaqueDTO;
import br.com.compasso.caixa.form.SaqueForm;
import br.com.compasso.caixa.service.SaqueCaixaEletronicoService;
import javassist.tools.web.BadHttpRequest;

@RestController()
@RequestMapping("/caixa")
public class CaixaEletronicoController {
	
	@Autowired
	private SaqueCaixaEletronicoService saqueService;
	
	@PostMapping
	public ResponseEntity<Optional<SaqueDTO>> sacar(@RequestBody @Valid SaqueForm formularioDeSaque) {
		Optional<SaqueDTO> mapaDeNotas = saqueService.getMapaDeNotas(formularioDeSaque);
	
		if (mapaDeNotas.isPresent()) {
			return ResponseEntity.ok(mapaDeNotas);
		}
		
		return ResponseEntity.badRequest().build();		
	}
	
	@GetMapping
	@ResponseBody
	public String rello() {
		return "teste de get";
	}
		

}
