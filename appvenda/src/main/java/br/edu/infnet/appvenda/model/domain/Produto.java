package br.edu.infnet.appvenda.model.domain;

public class Produto {
	
	private String descricao;
	private int codigo;
	private float preco;
	private boolean estoque;
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public float getPreco() {
		return preco;
	}
	
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public boolean isEstoque() {
		return estoque;
	}
	
	public void setEstoque(boolean estoque) {
		this.estoque = estoque;
	}
	
	public String getClassStringed() {
		String aux = String.valueOf(this.getClass());
		return aux.substring(aux.lastIndexOf('.'), aux.length());
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s - %.2f - %s", this.descricao, this.codigo, this.preco, this.estoque);
	}
}
