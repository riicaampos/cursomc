package br.com.campos.cursomc.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.campos.cursomc.domain.Categoria;
import br.com.campos.cursomc.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService service;

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findOne(@PathVariable Integer id) {
		Categoria c = service.findById(id);
		return ResponseEntity.ok().body(c);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Categoria cat) {
     cat = service.insert(cat);
     URI uri = ServletUriComponentsBuilder
    		    .fromCurrentRequest()
    		    .replacePath("/categorias/find/{id}")
    		    .buildAndExpand(cat.getId())
    		    .toUri();
     return ResponseEntity.created(uri).build();

	}
	

}
