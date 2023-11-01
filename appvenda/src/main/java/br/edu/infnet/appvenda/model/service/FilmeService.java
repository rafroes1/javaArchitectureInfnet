package br.edu.infnet.appvenda.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Filme;
import br.edu.infnet.appvenda.model.repository.FilmeRepository;

@Service
public class FilmeService {
	@Autowired
	private FilmeRepository repository;
	
	public void addFilme(Filme filme) {
		repository.save(filme);
	}
	
	public Collection<Filme> getFilmeList(){
		return (Collection<Filme>) repository.findAll();
	}
	
	public long count() {
		return repository.count();
	}
}