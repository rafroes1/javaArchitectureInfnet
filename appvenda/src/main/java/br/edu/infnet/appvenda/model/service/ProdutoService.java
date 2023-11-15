package br.edu.infnet.appvenda.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Produto;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository repository;
	
	public Produto pesquisar(String descricao) {
		return repository.findByDescricao(descricao);
	}
	
	public void addProduto(Produto produto) {
		repository.save(produto);
	}
	
	public Collection<Produto> getProdutoList(){
		return (Collection<Produto>) repository.findAll(Sort.by(Sort.Direction.ASC, "descricao"));
	}
	
	public Collection<Produto> getProductFromVendedor(Vendedor vendedor){
		return (Collection<Produto>) repository.getProductFromVendedor(vendedor.getId());
	}
	
	public long count() {
		return repository.count();
	}
	
	public void excluir(Integer id) {
		repository.deleteById(id);
	}
}
