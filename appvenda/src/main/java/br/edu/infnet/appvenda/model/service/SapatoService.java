package br.edu.infnet.appvenda.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Sapato;
import br.edu.infnet.appvenda.model.repository.SapatoRepository;

@Service
public class SapatoService {
	@Autowired
	private SapatoRepository repository;
	
	public void addSapato(Sapato sapato) {
		repository.save(sapato);
	}
	
	public Collection<Sapato> getSapatoList(){
		return (Collection<Sapato>) repository.findAll();
	}
	
	public long count() {
		return repository.count();
	}
}
