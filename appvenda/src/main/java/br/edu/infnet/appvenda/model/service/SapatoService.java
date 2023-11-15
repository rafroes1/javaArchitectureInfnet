package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Sapato;
import br.edu.infnet.appvenda.model.repository.SapatoRepository;

@Service
public class SapatoService {
	@Autowired
	private SapatoRepository repository;
	
	public List<Sapato> pesquisar(String marca) {
		return repository.findByMarca(marca);
	}
	
	public void addSapato(Sapato sapato) {
		repository.save(sapato);
	}
	
	public Collection<Sapato> getSapatoList(){
		return (Collection<Sapato>) repository.findAll(Sort.by(Sort.Direction.ASC, "marca"));
	}
	
	public long count() {
		return repository.count();
	}
	
	public void excluir(Integer id) {
		repository.deleteById(id);
	}
}
