package br.edu.infnet.appvenda.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Filme;
import br.edu.infnet.appvenda.model.repository.FilmeRepository;

@Service
public class FilmeService {
	@Autowired
	private FilmeRepository repository;
	
	public Filme pesquisar(String diretor) {
		return repository.findByDiretor(diretor);
	}
	
	public void addFilme(Filme filme) {
		repository.save(filme);
	}
	
	public Collection<Filme> getFilmeList(){
		return (Collection<Filme>) repository.findAll(Sort.by(Sort.Direction.ASC, "diretor"));
	}
	
	public long count() {
		return repository.count();
	}
	
	public void excluir(Integer id) {
		repository.deleteById(id);
	}
}