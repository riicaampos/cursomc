package br.com.campos.cursomc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.campos.cursomc.domain.Endereco;
import br.com.campos.cursomc.repository.EnderecoRepository;
import br.com.campos.cursomc.utils.BasicCrudService;

@Service
public class EnderecoService implements BasicCrudService<Endereco, Integer> {

	@Autowired
	private EnderecoRepository repo;
	
	@Override
	public void save(Endereco obj) {
		repo.save(obj);
		
	}

	@Override
	public void deleteById(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public Endereco findById(Integer id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Endereco> findAll() {
	   return repo.findAll();
	}

}
