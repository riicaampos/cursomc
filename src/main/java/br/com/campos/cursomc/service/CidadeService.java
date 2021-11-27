package br.com.campos.cursomc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.campos.cursomc.domain.Cidade;
import br.com.campos.cursomc.repository.CidadeRepository;
import br.com.campos.cursomc.utils.BasicCrudService;

public class CidadeService implements BasicCrudService<Cidade, Integer>{

	@Autowired
	private CidadeRepository repo;
	
	
	@Override
	public void save(Cidade obj) {
		repo.save(obj);
		
	}

	@Override
	public void deleteById(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public Cidade findById(Integer id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Cidade> findAll() {
		return repo.findAll();
	}

}
