package br.com.petz.exam.enums;

public enum PetPorteEnum {

	PEQUENO(1, "PEQUENO"), 
	MEDIO(2, "MEDIO"), 
	GRANDE(3, "GRANDE");

	private Integer id;
	private String descricao;

	private PetPorteEnum(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public PetPorteEnum getEnum(Integer id) {
		PetPorteEnum[] fp = values();
		for (PetPorteEnum t : fp) {
			if (t.getId() == id) {
				return t;
			}
		}
		return null;
	}

	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

}
