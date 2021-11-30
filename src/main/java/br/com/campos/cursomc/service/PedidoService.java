package br.com.campos.cursomc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.campos.cursomc.domain.Pedido;
import br.com.campos.cursomc.repository.PedidoRepository;
import br.com.campos.cursomc.utils.BasicCrudService;

@Service
public class PedidoService implements BasicCrudService<Pedido, Integer> {

	@Autowired
	private PedidoRepository repo;
	
	@Override
	public void save(Pedido obj) {
		repo.save(obj);
		
	}

	@Override
	public void deleteById(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public Pedido findById(Integer id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Pedido> findAll() {
		return repo.findAll();
	}

}
