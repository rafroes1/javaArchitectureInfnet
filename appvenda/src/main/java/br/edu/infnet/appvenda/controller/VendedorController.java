package br.edu.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.service.VendedorService;

@Controller
public class VendedorController {
	
	@Autowired
	private AppController appController;
	
	@Autowired
	private VendedorService service;
	
	@GetMapping(value = "/vendedor/pesquisar")
	public String pesquisar(Model model, String campoBusca) {
		Vendedor vendedor = service.pesquisar(campoBusca);
		
		if(vendedor != null){
			model.addAttribute("objeto", vendedor);
			return appController.showHome(model);
		}
		
		return "redirect:/vendedor/lista";
	}
	
	@GetMapping(value = "/vendedor/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		service.excluir(id);
		return "redirect:/vendedor/lista";
	}
	
	@GetMapping(value = "/vendedor/lista")
	public String getVendedorList(Model model) {
		model.addAttribute("listagem", service.getVendedorList());
		model.addAttribute("rota", "vendedor");
		model.addAttribute("titulo", "Vendedores:");

		return appController.showHome(model);
	}
}
