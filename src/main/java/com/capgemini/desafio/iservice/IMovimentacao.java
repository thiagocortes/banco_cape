package com.capgemini.desafio.iservice;

import com.capgemini.desafio.dto.MovimentacaoDTO;
import com.capgemini.desafio.model.Conta;

public interface IMovimentacao {
	
	Conta movimentar(MovimentacaoDTO dto);

}
