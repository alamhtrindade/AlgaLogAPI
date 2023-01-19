package com.algaworks.algalog.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Excessao {
	
	private Integer status;
	private LocalDateTime dataHora;
	private String titulo;
	private List<Campo> campos;
	
	
	
	
	public Integer getStatus()         { return status;   }
	public LocalDateTime getDataHora() { return dataHora; }
	public String getTitulo()          { return titulo;   }
	public List<Campo> getCampos()     { return campos;   }
	
	public void setStatus(Integer status)           { this.status = status;     }	
	public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
	public void setTitulo(String titulo)            { this.titulo = titulo;     }
	public void setCampos(List<Campo> campo) 	    { this.campos = campo;      }
	
	
}
