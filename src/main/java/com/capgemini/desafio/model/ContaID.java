package com.capgemini.desafio.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ContaID implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1003490573322967294L;
	
	private Integer banco;
	private Short agencia;
	private Integer numConta;
	
	public ContaID() {
		
	}
	
	public ContaID(Integer banco, Short agencia, Integer numConta) {
		super();
		this.banco = banco;
		this.agencia = agencia;
		this.numConta = numConta;
	}
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

}
