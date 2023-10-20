package br.edu.infnet.appvenda.model.domain;

public class Filme extends Produto {
	
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
