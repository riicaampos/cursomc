package br.com.campos.cursomc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.campos.cursomc.domain.Estado;
import br.com.campos.cursomc.repository.EstadoRepository;
import br.com.campos.cursomc.utils.BasicCrudService;

public class EstadoService implements BasicCrudService<Estado, Integer> {

	@Autowired
	private EstadoRepository repo;
	
	@Override
	public void save(Estado obj) {
		repo.save(obj);
		
	}

	@Override
	public void deleteById(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public Estado findById(Integer id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Estado> findAll() {
		return repo.findAll();
	}

}
