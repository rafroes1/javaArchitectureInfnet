package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Sapato;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.service.SapatoService;

@Order(2)
@Component  
public class SapatoLoader implements ApplicationRunner {
	
	@Autowired
	private SapatoService service;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/sapato.txt");
		BufferedReader reader = new BufferedReader(file);
		String line = reader.readLine();
		
		while (line != null) {
			String[] data = line.split(";");
			
			Sapato sapato = new Sapato();
			sapato.setDescricao(data[0]);
			sapato.setCodigo(Integer.valueOf(data[1].trim()));
			sapato.setPreco(Float.valueOf(data[2].trim()));
			sapato.setEstoque(Boolean.parseBoolean(data[3].trim()));
			sapato.setMarca(data[4]);
			sapato.setTamanho(Integer.valueOf(data[5].trim()));
			sapato.setVendedor(new Vendedor(Integer.valueOf(data[6].trim())));
			
			service.addSapato(sapato);
			
			line = reader.readLine();
		}
		
		for(Sapato sapato: service.getSapatoList()) {
			System.out.println("[Sapato]: " + sapato.toString());
		}
		
		reader.close();
	}
	
}