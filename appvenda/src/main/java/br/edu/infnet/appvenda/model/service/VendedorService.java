package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.repository.VendedorRepository;

@Service
public class VendedorService {
	//TODO: Fazer para as outras classes
	
	@Autowired
	private VendedorRepository repository;
	
	public void addVendedor(Vendedor vendedor) {
		repository.save(vendedor);
	}
	
	public Collection<Vendedor> getVendedorList(){
		return (Collection<Vendedor>) repository.findAll();
	}
}
