package br.com.raphaelzana.central_fatec.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.raphaelzana.central_fatec.dto.NoticiaFormularioDTO;

@Entity
public class Noticia  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String titulo;
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date data;
	
	public Noticia() {}
	
	public Noticia(NoticiaFormularioDTO dto) {
		this.titulo = dto.getTitulo();
		this.descricao = dto.getDescricao();
		Usuario user = new Usuario();
		user.setId(1);
		this.usuario = user;
		this.data = new Date(new java.util.Date().getTime());
	}

	public Noticia(Integer id, String titulo, String descricao, Date data, Usuario usuario) {
		super();
		this.setId(id);
		this.setTitulo(titulo);
		this.setDescricao(descricao);
		this.setData(data);
		this.setUsuario(usuario);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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
		Noticia other = (Noticia) obj;
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
	
	

}
