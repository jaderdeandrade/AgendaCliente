package com.compasso.uol.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compasso.uol.domain.Cidade;
import com.compasso.uol.domain.Estado;
import com.compasso.uol.dto.CidadeDto;
import com.compasso.uol.dto.CidadeNewDto;
import com.compasso.uol.repositories.CidadeRepository;
import com.compasso.uol.repositories.EstadoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;

	public List<Cidade> findByEstado(Integer estadoId) {
		return cidadeRepository.findCidades(estadoId);
	}
	
	public Cidade buscar(String nome) throws ObjectNotFoundException {

		Cidade obj = cidadeRepository.findByNome(nome);
		if(obj == null) {
			throw new ObjectNotFoundException(
				"Objeto não encontrado! Nome: " + nome + ", Tipo: " + Cidade.class.getName());
		}
		return obj;
	}
	

	@Transactional
	public Cidade insert(Cidade obj) {
		obj.setId(null);
		obj = cidadeRepository.save(obj);
		return obj;
	}
	
	public Cidade fromDto(CidadeDto objDto) {
		Estado estado = new Estado(objDto.getEstadoId(), null);
		Cidade cidade = new Cidade(null, objDto.getNome(), estado);
		return cidade;
	}
		
	
}