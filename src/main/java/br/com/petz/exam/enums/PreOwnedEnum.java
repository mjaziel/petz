package br.com.petz.exam.enums;

public enum PreOwnedEnum {
	
	S(1, "SIM"),
	N(2, "NAO");
	
	private Integer id;
	private String descricao;

	private PreOwnedEnum(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public PreOwnedEnum getEnum(Integer id) {
		PreOwnedEnum[] fp = values();
		for (PreOwnedEnum t : fp) {
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
