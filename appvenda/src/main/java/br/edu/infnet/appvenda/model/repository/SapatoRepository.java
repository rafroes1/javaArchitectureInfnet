package br.edu.infnet.appvenda.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appvenda.model.domain.Sapato;

@Repository
public interface SapatoRepository extends CrudRepository<Sapato, Integer>{

	List<Sapato>findAll(Sort sort);
	
	List<Sapato> findByMarca(String marca);
}
