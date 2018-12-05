package br.com.raphaelzana.central_fatec.domain.enums;

public enum PeriodoCurso {

	NOITE(1,"Noite"),
	TARDE(2,"Tarde"),
	MANHA(3,"Manha");

	private int id;
	private String descricao;
	private PeriodoCurso(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static PeriodoCurso toEnum(Integer id) {
		if(id == null) {return null;}
		for(PeriodoCurso x : PeriodoCurso.values()) {
			if(id.equals(x.getId())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + id);
	}
	
}
