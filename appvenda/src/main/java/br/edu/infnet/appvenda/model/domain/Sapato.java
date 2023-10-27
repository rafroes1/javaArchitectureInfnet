package br.edu.infnet.appvenda.model.domain;

import javax.persistence.*;

@Entity
@Table(name = "TSapato")
public class Sapato extends Produto {
	
	private String marca;
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
