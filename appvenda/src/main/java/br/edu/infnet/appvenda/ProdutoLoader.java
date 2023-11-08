package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Produto;
import br.edu.infnet.appvenda.model.service.ProdutoService;
import br.edu.infnet.appvenda.model.util.ProdutoBuilder;

@Order(4)
@Component  
public class ProdutoLoader implements ApplicationRunner {
	
	@Autowired
	private ProdutoService service;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/produto.txt");
		BufferedReader reader = new BufferedReader(file);
		String line = reader.readLine();
		
		while (line != null) {
			String[] data = line.split(";");
			
			ProdutoBuilder builder = new ProdutoBuilder(data);
			
			Produto produto = builder.build();
			
			service.addProduto(produto);
			
			try { 
				service.addProduto(produto);
			} catch (ConstraintViolationException e) {
				System.out.println("[PRODUTO] " + produto);
				FileLogger.logException("[PRODUTO] " + produto + " - " + e.getMessage());
			}
			
			line = reader.readLine();
		}
		
		//print em todos os produtos
		for(Produto produto: service.getProdutoList()) {
			System.out.println("[Produto" + produto.getClassStringed() + "]: " + produto.toString());
		}
		
		//print em todos os produtos de cada vendedor
		List<Integer> idVendedor = new ArrayList<Integer>();
		
		for(Produto produto: service.getProdutoList()) {
			
			if(!idVendedor.contains(produto.getVendedor().getId())) {
				
				System.out.println(String.format("Lista dos produtos de (%d) -> %s",
						produto.getVendedor().getId(),
						produto.getVendedor().getNome()));
				
				for(Produto p: service.getProductFromVendedor(produto.getVendedor())) {
					System.out.println("[Produto] -> " + p.getDescricao());
				}
				
				idVendedor.add(produto.getVendedor().getId());
			}
		}
		
		reader.close();
	}
	
}