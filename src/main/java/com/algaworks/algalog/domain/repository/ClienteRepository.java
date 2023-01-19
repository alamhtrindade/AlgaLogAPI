package com.algaworks.algalog.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algalog.api.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository< Cliente, Long >{

	//Busca por nome exatamente
	List<Cliente> findByNome(String nome);
	
	//Busca por parte do nome
	List<Cliente> findByNomeContaining(String nome);
	
	//Busca por email
	Optional<Cliente> findByEmail(String Email);
	
}
