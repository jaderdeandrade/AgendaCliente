package com.compasso.uol.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.compasso.uol.domain.Cidade;
import com.compasso.uol.dto.CidadeDto;
import com.compasso.uol.services.CidadeService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/cidades")
public class CidadeController {
	
	
	@Autowired
	private CidadeService service;
	
	
	//busca cidade pelo nome
	//http://localhost:8080/cidade/nome?value=Belo Horizonte
	@RequestMapping(value="/{nome}", method=RequestMethod.GET)
	public ResponseEntity<Cidade> find(@RequestParam(value="value") String nome) throws ObjectNotFoundException {
		Cidade obj = service.buscar(nome);
		return ResponseEntity.ok().body(obj);
	}
	
	// inseri nova cidade
	/*
	 * {
    "nome": "Contagem",
    "estadoId": 1
     }
	 * */
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Validated @RequestBody CidadeDto objDto) {
		Cidade obj = service.fromDto(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}


}
