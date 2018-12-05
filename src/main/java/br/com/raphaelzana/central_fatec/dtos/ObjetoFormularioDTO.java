package br.com.raphaelzana.central_fatec.dtos;

import br.com.raphaelzana.central_fatec.domain.enums.TipoObjeto;

public class ObjetoFormularioDTO {

	private String objeto;
	private String descricao;
	private String local;
	private TipoObjeto tipo;

	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getLocal() {
		return local;
	}
	
	public void setLocal(String local) {
		this.local = local;
	}
	
	public TipoObjeto getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoObjeto tipo) {
		this.tipo = tipo;
	}

	public String getObjeto() {
		return objeto;
	}

	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}
	
}
