package com.capgemini.desafio.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="contas")
public class Conta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1003490573322967294L;
	
	@EmbeddedId
	private ContaID id;
	private BigDecimal saldo = BigDecimal.ZERO;
	
	public Conta() {
		this.id = new ContaID();
	}
	
	public ContaID getId() {
		return id;
	}

	public void setId(ContaID id) {
		this.id = id;
	}


	public Conta(Integer banco, Short agencia, Integer numConta, BigDecimal saldo) {
		super();
		this.id = new ContaID(banco, agencia, numConta);
		this.saldo = saldo;
	}
	
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}	
	

}
