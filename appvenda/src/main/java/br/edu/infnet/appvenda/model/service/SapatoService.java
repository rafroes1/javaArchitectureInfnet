package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Sapato;

@Service
public class SapatoService {
	private Map<Integer, Sapato> mapaSapato = new HashMap<Integer, Sapato>();
	
	public void addSapato(Sapato sapato) {
		mapaSapato.put(sapato.getCodigo(), sapato);
	}
	
	public Collection<Sapato> getSapatoList(){
		return mapaSapato.values();
	}
}
