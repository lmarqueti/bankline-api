package com.dio.santander.bankline.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dio.santander.bankline.api.dto.NovaMovimentacao;
import com.dio.santander.bankline.api.model.Movimentacao;
import com.dio.santander.bankline.api.repository.MovimentacaoRepository;
import com.dio.santander.bankline.api.services.MovimentacaoService;

//classe criada para controlar entrada de novos correntistas

@RestController
@RequestMapping("/movimentacoes")//mapping "@" para qqr lugar externo achar as funções programadas aqui
public class MovimentacaoController {
	@Autowired //atualização automática do repositório
	private MovimentacaoRepository repository;//Classe repository conexão com bd
	
	@Autowired 
	private MovimentacaoService service;//trazer a ação do txtbox pra cá e daqui ir para o repositório
	
	@GetMapping
	public List<Movimentacao> findAll(){
		return repository.findAll();//RETORNAR movimentacao DO BD
	
	}
	@PostMapping
	public void save(@RequestBody NovaMovimentacao movimentacao) {
		service.save(movimentacao); //chama metodo save criado na classe MovimentacaoService, para usar dados do usuário digitou na textbox NovoCorrentista
		
	}

}
