package br.com.raphaelzana.central_fatec.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UsuarioNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Prenchimento obrigatorio")
	@Email(message="Email invalido")
	private String email;
	
	@NotEmpty(message="Prenchimento obrigatorio")
	private String senha;
	
	public UsuarioNewDTO() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
