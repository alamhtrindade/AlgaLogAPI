package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.api.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;
import com.algaworks.algalog.domain.service.CrudClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clRepo;
	
	@Autowired
	private CrudClienteService crudCliente;
	
	
	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> read( @PathVariable Long clienteId){
		
		return crudCliente.read(clienteId);
		
	}
	
	@GetMapping
	public List<Cliente> getAll(){
		
		return crudCliente.getAll();
		
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente create( @Valid @RequestBody Cliente cliente ) {
		
		
		return crudCliente.create(cliente);
		
	}
	
	
	@PutMapping("/{clienteId}")
	public ResponseEntity<Cliente> update( @PathVariable Long clienteId,@Valid @RequestBody Cliente cliente) {
		
		return crudCliente.update(clienteId,cliente);
	}
	
	
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> delete( @PathVariable Long clienteId) {
		
		if( !clRepo.existsById(clienteId) ) {
			return ResponseEntity.notFound().build();
		}
		
		crudCliente.delete(clienteId);
		return ResponseEntity.noContent().build();
	}
	
	
}
