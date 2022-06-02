package com.dio.santander.bankline.api.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.santander.bankline.api.dto.NovoCorrentista;
import com.dio.santander.bankline.api.model.Conta;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.repository.CorrentistaRepository;

//Ação da "textbox" usada na classe NovoCorrentista
@Service
public class CorrentistaService {
	@Autowired
	private CorrentistaRepository repository;//salvamento automático autowired no repositorio do correntista
	public void save(NovoCorrentista novoCorrentista) {
		Correntista correntista=new Correntista();//Aqui ele insere o novo correntista na tabela Correntista
		correntista.setCpf(novoCorrentista.getCpf());//Aqui ele insere o cpf novo correntista na tabela Correntista
		correntista.setNome(novoCorrentista.getNome());
		
		Conta conta = new Conta();//precisa ser criado na tabela da classe Conta o n da conta do novo correntista
		conta.setSaldo(0.0);//conta criada o saldo é zero né
		conta.setNumero(new Date().getTime());//o numero ficticio vai ser usada a data atual
		correntista.setConta(conta);
		
		repository.save(correntista);//sim ele precisa chamar o .save pra salvar
		
		
		
		
	}

}
