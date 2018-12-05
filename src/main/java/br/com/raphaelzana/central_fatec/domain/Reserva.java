package br.com.raphaelzana.central_fatec.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.raphaelzana.central_fatec.domain.enums.PeriodoCurso;

@Entity
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="projetor_id")
	private Projetor projetor;
	
	private Integer periodo;

	@JsonFormat(pattern="dd-MM-yyyy")
	private Date data;
	
	private Integer aula;
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	public Reserva() {}

	public Reserva(Integer id, Projetor projetor, Usuario usuario, Date data, Integer aula, String descricao, PeriodoCurso periodo) {
		super();
		this.setId(id);
		this.setProjetor(projetor);
		this.setUsuario(usuario);
		this.data = data;
		this.aula = aula;
		this.descricao = descricao;
		this.periodo = (periodo == null) ? null : periodo.getId();
	}
	
	public PeriodoCurso getPeriodo() {
		return PeriodoCurso.toEnum(periodo);
	}

	public void setPeriodo(PeriodoCurso periodo) {
		this.periodo = periodo.getId();
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getAula() {
		return aula;
	}

	public void setAula(Integer aula) {
		this.aula = aula;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Projetor getProjetor() {
		return projetor;
	}

	public void setProjetor(Projetor projetor) {
		this.projetor = projetor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		Reserva other = (Reserva) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
