package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Filme;

@Service
public class FilmeService {
	private Map<Integer, Filme> filmeMap = new HashMap<Integer, Filme>();
	
	public void addFilme(Filme filme) {
		filmeMap.put(filme.getCodigo(), filme);
	}
	
	public Collection<Filme> getFilmeList(){
		return filmeMap.values();
	}
}