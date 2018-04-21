package br.com.rhonline.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rhonline.model.Empresa;
import br.com.rhonline.repository.EmpresaRepository;

@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	public Iterable<Empresa> buscarFuncionarios(String cnpj){
		
		List<String> params = new ArrayList<String>();		
		params.add(cnpj);		
		
		return empresaRepository.findAll(params);
	}	

    public Double calcularFolhaPgto(String cnpj){
        //TODO Calcular Folha de pagamento de uma empresa
        return 0.0;
    }
}
