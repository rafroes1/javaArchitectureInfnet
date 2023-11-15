package br.edu.infnet.appvenda.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.appvenda.model.domain.Sapato;
import br.edu.infnet.appvenda.model.service.SapatoService;

@Controller
public class SapatoController {

	@Autowired
	private AppController appController;
	
	@Autowired
	private SapatoService service;
	
	@GetMapping(value = "/sapato/pesquisar")
	public String pesquisar(Model model, String campoBusca) {
		ArrayList<Sapato> sapatos = (ArrayList<Sapato>) service.pesquisar(campoBusca);
		
		if (!sapatos.isEmpty()) {
			model.addAttribute("objeto", sapatos.get(0));
			return appController.showHome(model);
		} 
		
		System.out.println("lista vazia? " + sapatos.size());
		
		return "redirect:/sapato/lista";
	}
	
	@GetMapping(value = "/sapato/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		service.excluir(id);
		return "redirect:/sapato/lista";
	}
	
	@GetMapping(value = "/sapato/lista")
	public String getSapatoList(Model model) {
		model.addAttribute("listagem", service.getSapatoList());
		model.addAttribute("rota", "sapato");
		model.addAttribute("titulo", "Sapatos:");

		return appController.showHome(model);
	}
}
