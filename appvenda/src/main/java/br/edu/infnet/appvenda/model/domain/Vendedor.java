package br.edu.infnet.appvenda.model.domain;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity //cria essa classe como tabela
@Table(name = "TVendedor", 
	uniqueConstraints = {
			@UniqueConstraint(columnNames = {"cpf"}),
			@UniqueConstraint(columnNames = {"email"})
			}
)
public class Vendedor {
	
	@Id //primary key id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment do primary key
	private Integer id;
	@Size(min = 2, max = 50)
	private String nome;
	@Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")
	private String cpf;
	@Size(min = 2, max = 50)
	@Column(unique = true)
	private String email;
	@OneToMany 	//@Transient anotação serve para desconsiderar esse campo na criação da tabela
	@JoinColumn(name = "idVendedor")
	private List<Produto> produtos;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idEndereco")
	private Endereco endereco;
	
	public Vendedor() {}
	
	public Vendedor(Integer id){
		this.id = id;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
		return String.format("id: %d - nome: %s - cpf: %s - email: %s - endereço: %s", this.id, this.nome, this.cpf, this.email, this.endereco);
	}
}
