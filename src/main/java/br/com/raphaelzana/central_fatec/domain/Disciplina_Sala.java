package br.com.raphaelzana.central_fatec.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Disciplina_Sala implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private Disciplina_SalaPK id = new Disciplina_SalaPK();
	
	@ManyToOne
	@JoinColumn(name="sala_id")
	private Sala sala;
	
	private String diaSemana;
	private Integer aula;
	private Integer semestre;
	
	public Disciplina_Sala() {}

	public Disciplina_Sala(Disciplina disciplina,Curso curso, Sala sala, String diaSemana, Integer aula, Integer semestre) {
		super();
		id.setDisciplina(disciplina);
		id.setCurso(curso);
		this.setSala(sala);
		this.setDiaSemana(diaSemana);
		this.setAula(aula);
		this.semestre = semestre;
	}
	
	public Integer getSemestre() {
		return semestre;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

	public Disciplina getDisciplina() {
		return id.getDisciplina();
	}
	
	public Curso getCurso() {
		return id.getCurso();
	}
	
	public Disciplina_SalaPK getId() {
		return id;
	}

	public void setId(Disciplina_SalaPK id) {
		this.id = id;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public Integer getAula() {
		return aula;
	}

	public void setAula(Integer aula) {
		this.aula = aula;
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
		Disciplina_Sala other = (Disciplina_Sala) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}
