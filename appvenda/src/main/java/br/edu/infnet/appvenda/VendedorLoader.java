package br.edu.infnet.appvenda;

import java.io.*;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.*;
import br.edu.infnet.appvenda.model.service.VendedorService;

@Order(1) //Ordena os components na ordem que deseja executar
@Component  //Sginifica que é uma classe que vai ser chamada no start do programa
public class VendedorLoader implements ApplicationRunner {
	
	@Autowired
	private VendedorService service;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// Funciona como uma thread, ou seja, vai rodar toda vez rodar o programa
		
		FileReader file = new FileReader("files/vendedor.txt");
		BufferedReader reader = new BufferedReader(file);
		String line = reader.readLine();
		
		while (line != null) {
			String[] data = line.split(";");
			
			Vendedor vendedor = new Vendedor();
			vendedor.setNome(data[0]);
			vendedor.setCpf(data[1]);
			vendedor.setEmail(data[2]);
			vendedor.setEndereco(new Endereco(data[3].trim()));
			
			try {
				service.addVendedor(vendedor); //comente se nao quiser adicionar
			} catch (ConstraintViolationException e) {
				System.out.println("[VENDEDOR] " + vendedor);
				FileLogger.logException("[VENDEDOR] " + vendedor + " - " + e.getMessage());
			}
			
			line = reader.readLine();
		}
		
		for(Vendedor vendedor: service.getVendedorList()) {
			System.out.println("[Vendedor]: " + vendedor.toString());
		}
		
		reader.close();
	}
	
}
