package com.capgemini.desafio.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ContaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5405498089784436619L;
	
	private Integer idBanco;
	private Short idAgencia;
	private Integer idNumConta;
	private BigDecimal saldo;
	
	public Integer getIdBanco() {
		return idBanco;
	}
	public void setIdBanco(Integer idBanco) {
		this.idBanco = idBanco;
	}
	public Short getIdAgencia() {
		return idAgencia;
	}
	public void setIdAgencia(Short idAgencia) {
		this.idAgencia = idAgencia;
	}
	public Integer getIdNumConta() {
		return idNumConta;
	}
	public void setIdNumConta(Integer idNumConta) {
		this.idNumConta = idNumConta;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	
	
	
}
