package com.compasso.uol.controllers;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.compasso.uol.domain.Cliente;
import com.compasso.uol.dto.ClienteDto;
import com.compasso.uol.services.ClienteService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/clientes")
public class ClienteController {
	
	
	@Autowired
	private ClienteService service;
	//busca por id
	//http://localhost:8080/clientes/1
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Optional<Cliente>> find(@PathVariable Integer id) throws ObjectNotFoundException {
		Optional<Cliente> obj = Optional.ofNullable(service.buscar(id));
		return ResponseEntity.ok().body(obj);
	}
	
    //busca pelo nome
	//http://localhost:8080/clientes/nome?value=Maria Silva
	@RequestMapping(value="/nome", method=RequestMethod.GET)
	public ResponseEntity<Cliente> findNome(@RequestParam(value="value") String nome) throws ObjectNotFoundException {
		Cliente obj = service.findNome(nome);
		return ResponseEntity.ok().body(obj);
	}
	
	//inseri novo cliente
	/*
	 * http://localhost:8080/clientes
	 * {
         "nome": "Jamil Andrade",
         "sexo": "M",
         "dataNascimento": "24/06/1971",
         "idade": 50,
         "tipo": 1,
         "cidadeId": 1
    }
	 * */
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Validated @RequestBody ClienteDto objDto) {
		Cliente obj = service.fromDto(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	//Alterar o nome do cliente
	//http://localhost:8080/clientes/1
	/*
	 * {
    		"nome" : "Jane Andrade"
		}
	 * */
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> Update(@Valid @RequestBody ClienteDto objDto, @PathVariable Integer id) throws ObjectNotFoundException{
		Cliente obj = service.fromDto(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	//Deletar cliente
	//http://localhost:8080/clientes/1
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) throws ObjectNotFoundException{
		
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	

}
