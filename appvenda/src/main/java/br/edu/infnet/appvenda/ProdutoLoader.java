package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

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
			
			line = reader.readLine();
		}
		
		for(Produto produto: service.getProdutoList()) {
			System.out.println("[Produto" + produto.getClassStringed() + "]: " + produto.toString());
		}
		
		reader.close();
	}
	
}