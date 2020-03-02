package com.capgemini.desafio.controller;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.desafio.dto.ContaDTO;
import com.capgemini.desafio.exception.BancoException;
import com.capgemini.desafio.model.Conta;
import com.capgemini.desafio.service.ContaService;

@RestController
@RequestMapping(value="/contas")
public class ContaController implements Serializable{

	@Autowired
	private ContaService service;
	
	@Autowired
    private ModelMapper modelMapper;
	/**
	 * 
	 */
	private static final long serialVersionUID = -8804906497867474406L;
	
	@GetMapping
    public ResponseEntity<List<ContaDTO>> findAll() {
		List<Conta> contas = service.findAll();
        return new ResponseEntity<>(contas.stream().map(this::convertToDto).collect(Collectors.toList()), HttpStatus.OK);
    }
	
	@GetMapping("{banco}/{agencia}/{conta}")
    public ResponseEntity<ContaDTO> findById(@PathVariable("banco") Integer banco, @PathVariable("agencia") Short agencia, @PathVariable("conta") Integer numConta) {
		try {
			return service.findById(banco, agencia, numConta)
		            .map(obj -> new ResponseEntity<>(convertToDto(obj), HttpStatus.OK))
		            .orElse(ResponseEntity.notFound().build());
		}catch(BancoException ex) {
			throw new BancoException(ex.getMessage());
		}
		
    }
	
	private ContaDTO convertToDto(Conta conta) {
		return modelMapper.map(conta, ContaDTO.class);	
	}

}
