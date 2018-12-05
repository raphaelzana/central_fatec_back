package br.com.raphaelzana.central_fatec.domain.enums;

public enum HorarioAula {
	
	DUAS_PRIMEIRAS(1,"DUAS PRIMEIRAS"),
	DUAS_ULTIMAS(2,"DUAS ULTIMAS"),
	QUATRO_AULAS(3, "QUATRO AULAS");
	
	private Integer id;
	private String label;

	private HorarioAula(Integer id, String label) {
		this.id = id;
		this.label = label;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public static HorarioAula toEnum(Integer id) {
		if(id == null) {return null;}
		for(HorarioAula x : HorarioAula.values()) {
			if(id.equals(x.getId())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + id);
	}

}
