package br.com.campos.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.campos.cursomc.domain.Cliente;
import br.com.campos.cursomc.service.ClienteService;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	
	
	@RequestMapping(value = "/find/{id}")
	public ResponseEntity<?> findCliente(@PathVariable Integer id){
		Cliente c = service.findById(id);
		return ResponseEntity.ok().body(c);
	}

}
