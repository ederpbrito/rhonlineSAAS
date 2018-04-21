package br.com.rhonline.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.rhonline.model.Colaborador;
import br.com.rhonline.model.Empresa;
import br.com.rhonline.service.EmpresaService;

@Controller
public class HomeController {

	@Autowired
	private EmpresaService service;
	
	@RequestMapping("/")
	@GetMapping("/")
    public String root() {		
        return "index";
    }
	
	@GetMapping("/listarColaboradores")
	public String listarColaboradores(@PathVariable("cnpj") String cnpj, Model model) {
		
		Iterator<Empresa> empresas = service.buscarFuncionarios(cnpj).iterator();
		List<Colaborador> colaboradores = new ArrayList<>();
		
		while(empresas.hasNext()) {
			empresas.next().getContratos().forEach(c -> colaboradores.add(c.getColaborador()));
		}		
		
		model.addAttribute("colaboradores", colaboradores);
		
		return "listafuncionarios";
	}

    @GetMapping("/user")
    @RequestMapping("/user")
    public String userIndex() {
        return "user/index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/error/access-denied";
    }
}
