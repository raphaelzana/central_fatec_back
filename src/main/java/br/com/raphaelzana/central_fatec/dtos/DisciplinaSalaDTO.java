package br.com.raphaelzana.central_fatec.dtos;

import br.com.raphaelzana.central_fatec.domain.enums.HorarioAula;

public class DisciplinaSalaDTO {
	
	private String diaSemana;
	private String bloco;
	private String sala;
	private String aula;
	
	public DisciplinaSalaDTO(String diaSemana, String bloco, String sala, Integer aula) {
		this.diaSemana = diaSemana;
		this.bloco = bloco;
		this.sala = sala;
		this.setAula(HorarioAula.toEnum(aula).getLabel());
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

}
