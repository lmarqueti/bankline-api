package com.dio.santander.bankline.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.santander.bankline.api.dto.NovoCorrentista;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.repository.CorrentistaRepository;
import com.dio.santander.bankline.api.services.CorrentistaService;

//classe criada para controlar entrada de novos correntistas

@RestController
@RequestMapping("/correntistas")//mapping "@" para qqr lugar externo achar as funções programadas aqui
public class CorrentistaController {
	@Autowired //atualização automática do repositório
	private CorrentistaRepository repository;//Classe repository conexão com bd
	
	@Autowired 
	private CorrentistaService service;//trazer a ação do txtbox pra cá e daqui ir para o repositório
	
	@GetMapping
	public List<Correntista> findAll(){
		return repository.findAll();//RETORNAR CORRENTISTAS DO BD
	
	}
	@PostMapping
	public void save(@RequestBody NovoCorrentista correntista) {
		service.save(correntista); //chama metodo save criado na classe CorrentistasService, para usar dados do usuário digitou na textbox NovoCorrentista
		
	}

}
