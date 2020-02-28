package com.capgemini.desafio.dao;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.desafio.model.Conta;
import com.capgemini.desafio.model.ContaID;

public interface ContaDAO extends CrudRepository<Conta, ContaID> {

}
