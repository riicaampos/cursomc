package br.com.campos.cursomc.utils;

import java.util.List;

/**
 * 
 * @author ricardo
 *
 * @param <O> Object
 * @param <I> Identifier
 */
public interface BasicCrudService <O,I>{
	
	public void save(O obj);
	
	public void deleteById(I id);
	
	public O findById(I id);
	
	public List<O> findAll();

}
