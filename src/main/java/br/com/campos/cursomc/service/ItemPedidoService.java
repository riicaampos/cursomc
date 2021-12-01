package br.com.campos.cursomc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.campos.cursomc.domain.ItemPedido;
import br.com.campos.cursomc.domain.ItemPedidoPK;
import br.com.campos.cursomc.repository.ItemPedidoRepository;
import br.com.campos.cursomc.utils.BasicCrudService;

@Service
public class ItemPedidoService implements BasicCrudService<ItemPedido, ItemPedidoPK> {

	@Autowired
	private ItemPedidoRepository repo;
	
	@Override
	public void save(ItemPedido obj) {
		repo.save(obj);
		
	}

	@Override
	public void deleteById(ItemPedidoPK id) {
		repo.deleteById(id);
		
	}

	@Override
	public ItemPedido findById(ItemPedidoPK id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<ItemPedido> findAll() {
		return repo.findAll();
	}

}
