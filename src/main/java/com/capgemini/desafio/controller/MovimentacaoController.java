package com.capgemini.desafio.controller;

import java.io.Serializable;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.desafio.dto.ContaDTO;
import com.capgemini.desafio.dto.MovimentacaoDTO;
import com.capgemini.desafio.exception.BancoException;
import com.capgemini.desafio.model.Conta;
import com.capgemini.desafio.service.DepositoService;
import com.capgemini.desafio.service.SaqueService;

@RestController
@RequestMapping(value="/movimentacoes")
public class MovimentacaoController implements Serializable{

	@Autowired
	private SaqueService saqueService;
	
	@Autowired
	private DepositoService depositoService;
	
	@Autowired
    private ModelMapper modelMapper;
	/**
	 * 
	 */
	private static final long serialVersionUID = 2375973673000930882L;
	
	
	@PutMapping(value="withdrawal")
	public ResponseEntity<ContaDTO> withdraw(@Valid @RequestBody MovimentacaoDTO dto) {
		try {
			return new ResponseEntity<>(convertToDto(saqueService.movimentar(dto)), HttpStatus.CREATED);
		}catch(BancoException e) {
			throw new BancoException(e.getMessage());
		}
	}
	
	@PutMapping(value="deposits")
	public ResponseEntity<ContaDTO> deposit(@Valid @RequestBody MovimentacaoDTO dto) {
		return new ResponseEntity<>(convertToDto(depositoService.movimentar(dto)), HttpStatus.CREATED);
	}
	
	private ContaDTO convertToDto(Conta conta) {
		return modelMapper.map(conta, ContaDTO.class);	
	}

}
