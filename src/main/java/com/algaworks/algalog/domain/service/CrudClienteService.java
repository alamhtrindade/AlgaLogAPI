package com.algaworks.algalog.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.api.model.Cliente;
import com.algaworks.algalog.domain.exception.DomainException;
import com.algaworks.algalog.domain.repository.ClienteRepository;

@Service
public class CrudClienteService {
	
	@Autowired
	private ClienteRepository clRepository;
	
	
	
	@Transactional
	public Cliente create(Cliente cliente) {
		boolean emailExists = clRepository.findByEmail(cliente.getEmail())
				.stream()
				.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		
		if( emailExists ){
			
			throw new DomainException("Já existe um cliente cadastrado com este email");
		}
		return clRepository.save(cliente);
	
	}
	
	public ResponseEntity<Cliente> read(Long clienteId){
		return clRepository.findById(clienteId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@Transactional
	public ResponseEntity<Cliente> update(Long clienteId, Cliente cliente) {
		
		if( !clRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		
		cliente.setId(clienteId);
		cliente = clRepository.save(cliente);
		return ResponseEntity.ok(cliente);
		
	}
	
	@Transactional
	public void delete(Long clienteId) {
		
		clRepository.deleteById(clienteId);
	
	}
	
	public List<Cliente> getAll() {
		return clRepository.findAll();
	}
	
	
	
	
}
