package br.com.petz.exam.enums;

public enum PetTipoEnum {

	CACHORRO(1, "CACHORRO"),
	GATO(2, "GATO"),
	PASSARO(3, "PASSARO"),
	PEIXE(4, "PEIXE"),
    COELHO(5, "COELHO");

	private Integer id;
	private String descricao;

	private PetTipoEnum(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public PetTipoEnum getEnum(Integer id) {
		PetTipoEnum[] fp = values();
		for (PetTipoEnum t : fp) {
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




