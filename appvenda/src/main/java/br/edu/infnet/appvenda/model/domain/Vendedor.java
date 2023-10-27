package br.edu.infnet.appvenda.model.domain;

import java.util.List;

import javax.persistence.*;

@Entity //cria essa classe como tabela
@Table(name = "TVendedor") //caso nao queria que a table tenha o nome exatamente igual a da classe voce pode usar essa anotação pra redefinir
public class Vendedor {
	
	@Id //primary key id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment do primary key
	private Integer id;
	private String nome;
	private String cpf;
	private String email;
	@OneToMany 	//@Transient anotação serve para desconsiderar esse campo na criação da tabela
	@JoinColumn(name = "idVendedor")
	private List<Produto> produtos;
	
	
	public Vendedor() {}
	
	public Vendedor(Integer id){
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public String toString() {
		return String.format("%d - %s - %s - %s", this.id, this.nome, this.cpf, this.email);
	}
}
