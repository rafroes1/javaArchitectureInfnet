package br.edu.infnet.appvenda.model.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TFilme")
public class Filme extends Produto {
	
	@Size(min = 2, max = 50, message = "O diretor deve ter entre {min} e {max} caracteres.")
	private String diretor;
	private String genero;
	
	public String getDiretor() {
		return diretor;
	}
	
	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s - %s", super.toString(), this.diretor, this.genero);
	}
}
