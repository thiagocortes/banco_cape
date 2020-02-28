package com.capgemini.desafio.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.desafio.dto.MovimentacaoDTO;
import com.capgemini.desafio.iservice.IMovimentacao;
import com.capgemini.desafio.model.Conta;

@Service
public class DepositoService implements IMovimentacao {

	@Autowired
	private ContaService contaService;
	
	@Override
	public Conta movimentar(MovimentacaoDTO dto) {
		Optional<Conta> conta = contaService.findById(dto.getBanco(), dto.getAgencia(), dto.getNumConta());
		return conta.map(item->deposit(item, dto.getValor())).orElse(null);
	}
	
	private Conta deposit(Conta conta, BigDecimal valor) {
		conta.setSaldo(conta.getSaldo().add(valor));
		return contaService.salvar(conta);
	}

}
