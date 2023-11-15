package br.edu.infnet.appvenda.model.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appvenda.model.domain.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer>{

	@Query("from Produto p where p.vendedor.id = :vendedorId") //dois pontos significa um parametro
	Collection<Produto> getProductFromVendedor(Integer vendedorId);
	
	List<Produto>findAll(Sort sort);
	
	Produto findByDescricao(String descricao);
}
