package br.edu.infnet.appvenda.model.util;

import br.edu.infnet.appvenda.model.domain.Filme;
import br.edu.infnet.appvenda.model.domain.Produto;
import br.edu.infnet.appvenda.model.domain.Sapato;

public class ProdutoBuilder {
	private String[] data;
	
	public ProdutoBuilder(String[] data) {
		this.data = data;
	}
	
	public Produto build() {
		switch(data[0].trim()) {
			case "s":
				return this.buildSapato();
			case "f":
				return this.buildFilme();
			default:
				System.out.println("Should not enter here rsrs");
				return null;
		}
	}
	
	private Filme buildFilme() {
		Filme filme = new Filme();
		filme.setDescricao(this.data[1].trim());
		filme.setCodigo(Integer.valueOf(this.data[2].trim()));
		filme.setPreco(Float.valueOf(this.data[3].trim()));
		filme.setEstoque(Boolean.parseBoolean(this.data[4].trim()));
		filme.setDiretor(this.data[5]);
		filme.setGenero(this.data[6]);
		return filme;
	}
	
	private Sapato buildSapato() {
		Sapato sapato = new Sapato();
		sapato.setDescricao(this.data[1].trim());
		sapato.setCodigo(Integer.valueOf(this.data[2].trim()));
		sapato.setPreco(Float.valueOf(this.data[3].trim()));
		sapato.setEstoque(Boolean.parseBoolean(this.data[4].trim()));
		sapato.setMarca(this.data[5]);
		sapato.setTamanho(Integer.valueOf(this.data[6].trim()));
		return  sapato;
	}

}
