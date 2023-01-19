package com.algaworks.algalog.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Table(name = "Cliente")
@Entity
public class Cliente {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 60)
	private String nome;
	
	@NotBlank
	@Email
	@Size(max = 256)
	private String email;
	
	@NotBlank
	@Size(max = 20)
	private String telefone;
	
	public Long getId()         { return id;       }
	public String getNome()     { return nome;     }
	public String getEmail()    { return email;    }
	public String getTelefone() { return telefone; }
	
	
	public void setId(Long id)               { this.id = id;             }
	public void setNome(String nome)         { this.nome = nome;         }
	public void setEmail(String email)       { this.email = email;       }
	public void setTelefone(String telefone) { this.telefone = telefone; }
	
	
}
