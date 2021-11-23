package br.com.campos.cursomc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.campos.cursomc.domain.Produto;
import br.com.campos.cursomc.repository.ProdutoRepository;
import br.com.campos.cursomc.utils.BasicCrudService;

@Service
public class ProdutoService implements BasicCrudService<Produto, Integer>{

	@Autowired
	private ProdutoRepository repo;
	
	
	@Override
	public void save(Produto obj) {
		repo.save(obj);
		
	}

	@Override
	public void deleteById(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public Produto findById(Integer id) {
      return repo.findById(id).orElse(null);
	}

	@Override
	public List<Produto> findAll() {
	  return repo.findAll();
	}

}
