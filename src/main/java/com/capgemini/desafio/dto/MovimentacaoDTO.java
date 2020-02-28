package com.capgemini.desafio.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class MovimentacaoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9184950945026722337L;
	private Integer banco;
	private Short agencia;
	private Integer numConta;
	private BigDecimal valor;
	
	public Integer getBanco() {
		return banco;
	}
	public void setBanco(Integer banco) {
		this.banco = banco;
	}
	public Short getAgencia() {
		return agencia;
	}
	public void setAgencia(Short agencia) {
		this.agencia = agencia;
	}
	public Integer getNumConta() {
		return numConta;
	}
	public void setNumConta(Integer numConta) {
		this.numConta = numConta;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	
}
