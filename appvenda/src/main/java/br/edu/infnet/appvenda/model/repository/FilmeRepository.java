package br.edu.infnet.appvenda.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appvenda.model.domain.Filme;

@Repository
public interface FilmeRepository extends CrudRepository<Filme, Integer>{
	List<Filme>findAll(Sort sort);
	
	Filme findByDiretor(String diretor);
}
