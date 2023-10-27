package br.edu.infnet.appvenda.model.domain;

import javax.persistence.*;

@Entity
@Table(name = "TProduto")
@Inheritance(strategy = InheritanceType.JOINED)
public class Produto {
	
	@Id //nao precisa por nos filhos
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private int codigo;
	private float preco;
	private boolean estoque;
	@ManyToOne //varios produtos para um vendedor
	@JoinColumn(name = "idVendedor")
	private Vendedor vendedor;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
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
	
	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	public String getClassStringed() {
		String aux = String.valueOf(this.getClass());
		return aux.substring(aux.lastIndexOf('.'), aux.length());
	}
	
	@Override
	public String toString() {
		return String.format("%d - %s - %s - %.2f - %s", this.id, this.descricao, this.codigo, this.preco, this.estoque);
	}
}
