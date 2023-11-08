package br.edu.infnet.appvenda.model.domain;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "TSapato")  //caso nao queria que a table tenha o nome exatamente igual a da classe voce pode usar essa anotação pra redefinir
public class Sapato extends Produto {
	
	
	private String marca;
	@Positive
	private int tamanho;
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public int getTamanho() {
		return tamanho;
	}
	
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s - %s", super.toString(), this.marca, this.tamanho);
	}
}
