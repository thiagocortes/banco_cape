package com.capgemini.desafio.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.desafio.dto.MovimentacaoDTO;
import com.capgemini.desafio.exception.BancoException;
import com.capgemini.desafio.iservice.IMovimentacao;
import com.capgemini.desafio.model.Conta;

@Service
public class SaqueService implements IMovimentacao {

	@Autowired
	private ContaService contaService;
	
	@Override
	public Conta movimentar(MovimentacaoDTO dto) {
		Optional<Conta> conta = contaService.findById(dto.getBanco(), dto.getAgencia(), dto.getNumConta());
		return conta.map(item->withdraw(item, dto.getValor())).orElse(null);
	}
	
	private Conta withdraw(Conta conta, BigDecimal valor) {
		conta.setSaldo(conta.getSaldo().subtract(valor));
		if( conta.getSaldo().compareTo(BigDecimal.ZERO) < 0)
			throw new BancoException("Você não possui saldo suficiente");
		return contaService.salvar(conta);
	}

}
