package br.edu.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.appvenda.model.service.VendedorService;

@Controller
public class VendedorController { //TODO: Criar para produto, sapato e filme
	
	@Autowired
	private AppController appController;
	
	@Autowired
	private VendedorService vService;
	
	@GetMapping(value = "/vendedor/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		vService.excluir(id);
		return "redirect:/vendedor/lista";
	}
	
	@GetMapping(value = "/vendedor/lista") //TODO: Criar dentro do respectivo controler de produto, sapato e filme (e tirar do appcontroller)
	public String getVendedorList(Model model) {
		model.addAttribute("listagem", vService.getVendedorList());
		model.addAttribute("rota", "vendedor");
		model.addAttribute("titulo", "Vendedores:");

		return appController.showHome(model);
	}
}
