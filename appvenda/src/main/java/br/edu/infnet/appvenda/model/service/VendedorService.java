package br.edu.infnet.appvenda.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.clients.IEnderecoClient;
import br.edu.infnet.appvenda.model.domain.Endereco;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.repository.VendedorRepository;

@Service
public class VendedorService {
	
	@Autowired
	private VendedorRepository repository;
	@Autowired
	private IEnderecoClient enderecoClient;
	
	//TODO: fazer para produto e seus filho
	public Vendedor pesquisar(String cpf) {
		return repository.findByCpf(cpf);
	}
	
	public void addVendedor(Vendedor vendedor) {
		Endereco endereco = enderecoClient.buscarCep(vendedor.getEndereco().getCep());
		vendedor.setEndereco(endereco);
		repository.save(vendedor);
	}
	//TODO: Criar para produto e para cada filho um criterio de ordenação -> olhar vendedor repository
	public Collection<Vendedor> getVendedorList(){
		return (Collection<Vendedor>) repository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
	}
	
	public long count() {
		return repository.count();
	}
	
	public void excluir(Integer id) {
		repository.deleteById(id);
	}
}
