package br.com.raphaelzana.central_fatec.domain.enums;

public enum Perfil {

	ADMIN(1,"ROLE_ADMIN"),
	PROFESSOR(2,"ROLE_PROFESSOR"),
	ALUNO(3, "ROLE_ALUNO");

	private int id;
	private String descricao;
	private Perfil(int id, String descricao) {
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
	
	public static Perfil toEnum(Integer id) {
		if(id == null) {return null;}
		for(Perfil x : Perfil.values()) {
			if(id.equals(x.getId())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + id);
	}
	
}
