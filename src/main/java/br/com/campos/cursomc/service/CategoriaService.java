package br.com.campos.cursomc.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.campos.cursomc.domain.Categoria;
import br.com.campos.cursomc.repository.CategoriaRepository;
import br.com.campos.cursomc.utils.BasicCrudService;
import br.com.campos.cursomc.utils.ObjectNotFoundException;

@Service
public class CategoriaService implements BasicCrudService<Categoria, Integer>{
	
	@Autowired
	private CategoriaRepository repo;

	@Override
	public void save(Categoria obj) {
		repo.save(obj);
		
	}

	@Override
	public void deleteById(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public Categoria findById(Integer id) {
		return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada id: "
				+ id +" "+Categoria.class.getName()));
	}

	@Override
	public List<Categoria> findAll() {
      return repo.findAll();
	}

}
