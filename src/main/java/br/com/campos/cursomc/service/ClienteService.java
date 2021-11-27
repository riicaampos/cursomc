package br.com.campos.cursomc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.campos.cursomc.domain.Categoria;
import br.com.campos.cursomc.domain.Cliente;
import br.com.campos.cursomc.repository.ClienteRepository;
import br.com.campos.cursomc.utils.BasicCrudService;
import br.com.campos.cursomc.utils.ObjectNotFoundException;

@Service
public class ClienteService implements BasicCrudService<Cliente, Integer> {

	@Autowired
	private ClienteRepository repo;

	@Override
	public void save(Cliente obj) {
		repo.save(obj);

	}

	@Override
	public void deleteById(Integer id) {
		repo.deleteById(id);

	}

	@Override
	public Cliente findById(Integer id) {
		return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada id: "
				+ id +" "+Categoria.class.getName()));
	}

	@Override
	public List<Cliente> findAll() {
		return repo.findAll();
	}

}
