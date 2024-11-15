package com.arquitecturajava.webcliente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.arquitecturajava.webspring.dtos.PersonaDTO;

@RestController
public class ClienteRestPersona {
	
	@RequestMapping("/personascliente")
	public List<PersonaDTO> listaPersonas() {
		
		RestTemplate plantilla = new RestTemplate();
		
		ResponseEntity<PersonaDTO[]> lista = plantilla.getForEntity("http://springservidor:8083/personas", PersonaDTO[].class);
		PersonaDTO[] nuevaLista = lista.getBody();
		return Arrays.asList(nuevaLista);
	}

}
