package br.com.campos.cursomc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.campos.cursomc.domain.Pagamento;
import br.com.campos.cursomc.repository.PagamentoRepository;
import br.com.campos.cursomc.utils.BasicCrudService;

@Service
public class PagamentoService implements BasicCrudService<Pagamento, Integer> {

	
	@Autowired
	private PagamentoRepository repo;

	@Override
	public void save(Pagamento obj) {
		repo.save(obj);
		
	}

	@Override
	public void deleteById(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public Pagamento findById(Integer id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Pagamento> findAll() {
		return repo.findAll();
	}
	
	
}
