package br.com.raphaelzana.central_fatec.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.raphaelzana.central_fatec.domain.enums.TipoObjeto;
import br.com.raphaelzana.central_fatec.dto.ObjetoFormularioDTO;

@Entity
public class Objeto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String objeto;
	private String descricao;
	private String local;
	private Date data;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	private Integer tipo;
	
	public Objeto() {}
	
	public Objeto(ObjetoFormularioDTO dto) {
		this.descricao = dto.getDescricao();
		this.objeto = dto.getObjeto();
		this.local = dto.getLocal();
		this.tipo = dto.getTipo().getId();
		this.data = new Date();
		Usuario user = new Usuario();
		user.setId(3);
		this.usuario = user;
	}

	public Objeto(Integer id, String descricao, String objeto, String local, Date data, Usuario usuario, TipoObjeto tipo) {
		super();
		this.setId(id);
		this.setDescricao(descricao);
		this.setObjeto(objeto);
		this.setLocal(local);
		this.setData(data);
		this.setUsuario(usuario);
		this.tipo = (tipo == null) ? null : tipo.getId();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public TipoObjeto getTipo() {
		return TipoObjeto.toEnum(tipo);
	}

	public void setTipo(TipoObjeto tipo) {
		this.tipo = tipo.getId();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Objeto other = (Objeto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getObjeto() {
		return objeto;
	}

	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}

}
