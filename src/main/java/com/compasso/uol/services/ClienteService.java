package com.compasso.uol.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.compasso.uol.domain.Cidade;
import com.compasso.uol.domain.Cliente;
import com.compasso.uol.domain.enums.TipoCliente;
import com.compasso.uol.dto.ClienteDto;
import com.compasso.uol.repositories.CidadeRepository;
import com.compasso.uol.repositories.ClienteRepository;
import com.compasso.uol.services.exception.DataIntegrityException;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public Cliente buscar(Integer id) throws ObjectNotFoundException {

		Optional<Cliente> obj = repo.findById(id);
		if(obj == null) {
			throw new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName());
		}
		return obj.get();
	}
	
	
	public Cliente findNome(String nome) throws ObjectNotFoundException {

		Cliente obj = repo.findByNome(nome);
		if(obj == null) {
			throw new ObjectNotFoundException(
				"Objeto não encontrado! Nome: " + nome + ", Tipo: " + Cliente.class.getName());
		}
		return obj;
	}
	
	

	@Transactional
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

	public Cliente update(Cliente obj) throws ObjectNotFoundException {
		Cliente newObj = buscar(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) throws ObjectNotFoundException {
		buscar(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionados");
		}
	}
	
	public Cliente fromDto(ClienteDto objDto) {
		Cidade cid = new Cidade(objDto.getCidadeId(), null, null);
		Cliente cli = new Cliente(null, objDto.getNome(), objDto.getSexo(), objDto.getDataNascimento(), objDto.getIdade(), TipoCliente.toEnum(objDto.getTipo()), cid);
		return cli;
	}
	

	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());

	}
	
}
