package br.edu.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.appvenda.model.service.FilmeService;
import br.edu.infnet.appvenda.model.service.ProdutoService;
import br.edu.infnet.appvenda.model.service.SapatoService;
import br.edu.infnet.appvenda.model.service.InformacaoService;
import br.edu.infnet.appvenda.model.service.VendedorService;

@Controller
public class AppController {
	
	@Autowired
	private VendedorService vService;
	@Autowired
	private ProdutoService pService;
	@Autowired
	private SapatoService sService;
	@Autowired
	private FilmeService fService;
	@Autowired
	private InformacaoService iService;
	
	@GetMapping(value = "/")
	public String showHome(Model model) {
		
		model.addAttribute("qtdeVendedor", vService.count());
		model.addAttribute("qtdeProduto", pService.count());
		model.addAttribute("qtdeSapato", sService.count());
		model.addAttribute("qtdeFilme", fService.count());
		
		model.addAttribute("informacoes", iService.obterLista());
		
		return "index";
	}
}
