package br.edu.infnet.appvenda.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appvenda.model.domain.Vendedor;

@Repository
public interface VendedorRepository extends CrudRepository<Vendedor, Integer>{
	//TODO: Fazer para produto e seus filhos
	List<Vendedor>findAll(Sort sort);
	
	//TODO: Fazer para produto e seus filhos (definir um campo para ser pesquisavel)
	Vendedor findByCpf(String cpf);
}
