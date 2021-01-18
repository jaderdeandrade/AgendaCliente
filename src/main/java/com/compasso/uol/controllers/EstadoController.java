package com.compasso.uol.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.compasso.uol.domain.Cidade;
import com.compasso.uol.domain.Estado;
import com.compasso.uol.dto.CidadeDto;
import com.compasso.uol.dto.CidadeNewDto;
import com.compasso.uol.dto.EstadoDto;
import com.compasso.uol.services.CidadeService;
import com.compasso.uol.services.EstadoService;

@RestController
@RequestMapping(value="/estados")
public class EstadoController {
	
	@Autowired
	private EstadoService service;
	
	@Autowired
	private CidadeService cidadeService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<EstadoDto>> findAll() {
		List<Estado> list = service.findAll();
		List<EstadoDto> listDto = list.stream().map(obj -> new EstadoDto(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	
	//Consultar cidade pelo estado
	//http://localhost:8080/estados/12/cidades
	@RequestMapping(value="/{estadoId}/cidades", method=RequestMethod.GET)
	public ResponseEntity<List<CidadeNewDto>> findCidades(@PathVariable Integer estadoId) {
		List<Cidade> list = cidadeService.findByEstado(estadoId);
		List<CidadeNewDto> listDto = list.stream().map(obj -> new CidadeNewDto(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
}