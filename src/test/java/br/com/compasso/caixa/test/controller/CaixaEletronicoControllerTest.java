package br.com.compasso.caixa.test.controller;

import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.google.gson.Gson;

import br.com.compasso.caixa.controller.CaixaEletronicoController;
import br.com.compasso.caixa.controller.dto.SaqueDTO;
import br.com.compasso.caixa.form.SaqueForm;
import br.com.compasso.caixa.service.SaqueCaixaEletronicoService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(CaixaEletronicoController.class)
class CaixaEletronicoControllerTest {

	@Autowired
	private MockMvc mockMvc;
//	
	@InjectMocks
	private CaixaEletronicoController caixaController;
	
//
	@Mock
	private SaqueCaixaEletronicoService saqueService;
//	

	  @Test
	    public void testAddEmployee() throws Exception 
	    {
		  Gson gson = new Gson();
		  SaqueForm saqueForm =new SaqueForm(new BigDecimal(100));
		  
	        MockMvcBuilders.standaloneSetup(caixaController).build();
	      
	        Map<String, Integer> valorEsperado = new LinkedHashMap<String, Integer>(){{
				put("CEM", 1);
			}};
			
			SaqueDTO saqueDTO = new SaqueDTO(valorEsperado);
	        
	        when(saqueService.getMapaDeNotas(saqueForm)).thenReturn(Optional.of(saqueDTO));
	        
	        mockMvc.perform(MockMvcRequestBuilders
	        		.post("/caixa")
	        		.content(gson.toJson(saqueForm))
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON)
	                )
			        .andExpect(MockMvcResultMatchers.status().isOk())
	                .andExpect(MockMvcResultMatchers.content().json(gson.toJson(saqueDTO)));
	        		
	        
	        Mockito.verify(saqueService).getMapaDeNotas(saqueForm);
	        
	    
	    }
	
	
	
	

}
