package br.edu.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.appvenda.model.service.ProdutoService;

@Controller
public class ProdutoController {

	@Autowired
	private AppController appController;
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping(value = "/produto/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		service.excluir(id);
		return "redirect:/produto/lista";
	}
	
	@GetMapping(value = "/produto/lista")
	public String getProdutoList(Model model) {
		model.addAttribute("listagem", service.getProdutoList());
		model.addAttribute("rota", "produto");
		model.addAttribute("titulo", "Produtos:");

		return appController.showHome(model);
	}
}
