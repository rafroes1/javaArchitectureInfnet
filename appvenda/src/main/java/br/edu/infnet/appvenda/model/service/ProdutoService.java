package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Produto;

@Service
public class ProdutoService {
	private Map<Integer, Produto> produtoMap = new HashMap<Integer, Produto>();
	
	public void addProduto(Produto produto) {
		produtoMap.put(produto.getCodigo(), produto);
	}
	
	public Collection<Produto> getProdutoList(){
		return produtoMap.values();
	}
}
