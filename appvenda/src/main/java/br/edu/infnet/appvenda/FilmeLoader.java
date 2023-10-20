package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Filme;
import br.edu.infnet.appvenda.model.service.FilmeService;

@Order(3)
@Component  
public class FilmeLoader implements ApplicationRunner {
	
	@Autowired
	private FilmeService service;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/filme.txt");
		BufferedReader reader = new BufferedReader(file);
		String line = reader.readLine();
		
		while (line != null) {
			String[] data = line.split(";");
			
			Filme filme = new Filme();
			filme.setDescricao(data[0]);
			filme.setCodigo(Integer.valueOf(data[1].trim()));
			filme.setPreco(Float.valueOf(data[2].trim()));
			filme.setEstoque(Boolean.parseBoolean(data[3].trim()));
			filme.setDiretor(data[4]);
			filme.setGenero(data[5]);
			
			service.addFilme(filme);
			
			line = reader.readLine();
		}
		
		for(Filme filme: service.getFilmeList()) {
			System.out.println("[Filme]: " + filme.toString());
		}
		
		reader.close();
	}
	
}