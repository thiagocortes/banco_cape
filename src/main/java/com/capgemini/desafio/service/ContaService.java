package com.capgemini.desafio.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.desafio.dao.ContaDAO;
import com.capgemini.desafio.exception.BancoException;
import com.capgemini.desafio.model.Conta;
import com.capgemini.desafio.model.ContaID;

@Service
public class ContaService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -22240540962998767L;
	
	@Autowired
	private ContaDAO contaDAO;
	
	public Optional<Conta> findById(ContaID id) {
		return Optional.of(contaDAO.findById(id).orElseThrow(()-> new BancoException("Conta não localizada")));
	}
	
	public Optional<Conta> findById(Integer banco, Short agencia, Integer numConta){
		ContaID id = new ContaID(banco, agencia, numConta);
		return findById(id);
	}
	
	public Conta salvar(Conta conta){
		return contaDAO.save(conta);
	}
	
	public List<Conta> findAll() {
		Iterable<Conta> list = contaDAO.findAll();
		return IterableUtils.toList(list);
	}
	
	
}
