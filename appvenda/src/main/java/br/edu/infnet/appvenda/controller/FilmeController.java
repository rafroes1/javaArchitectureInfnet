package br.edu.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.appvenda.model.domain.Filme;
import br.edu.infnet.appvenda.model.service.FilmeService;

@Controller
public class FilmeController {

	@Autowired
	private AppController appController;
	
	@Autowired
	private FilmeService service;
	
	@GetMapping(value = "/filme/pesquisar")
	public String pesquisar(Model model, String campoBusca) {
		Filme filme = service.pesquisar(campoBusca);
		
		if(filme != null){
			model.addAttribute("objeto", filme);
			return appController.showHome(model);
		}
		
		return "redirect:/filme/lista";
	}
	
	@GetMapping(value = "/filme/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		service.excluir(id);
		return "redirect:/filme/lista";
	}
	
	@GetMapping(value = "/filme/lista")
	public String getFilmeList(Model model) {
		model.addAttribute("listagem", service.getFilmeList());
		model.addAttribute("rota", "filme");
		model.addAttribute("titulo", "Filmes:");

		return appController.showHome(model);
	}
}
