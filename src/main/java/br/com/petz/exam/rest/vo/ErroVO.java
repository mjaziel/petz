package br.com.petz.exam.rest.vo;

import br.com.petz.exam.enums.ErroEnum;

public class ErroVO {
	
	private Integer codigo;
	private String mensagem;

	public ErroVO() {
	}

	public ErroVO(ErroEnum erroEnum) {
		super();
		this.codigo = erroEnum.getCodigo();
		this.mensagem = erroEnum.getMensagem();
	}

	public ErroVO(Integer codigo) {
		super();
		this.codigo = codigo;
	}

	public ErroVO(Integer codigo, String mensagem) {
		super();
		this.codigo = codigo;
		this.mensagem = mensagem;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		ErroVO other = (ErroVO) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ErroVO [codigo=");
		builder.append(codigo);
		builder.append(", mensagem=");
		builder.append(mensagem);
		builder.append("]");
		return builder.toString();
	}


}
