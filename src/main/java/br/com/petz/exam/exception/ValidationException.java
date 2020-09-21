package br.com.petz.exam.exception;

import java.util.ArrayList;
import java.util.List;

import br.com.petz.exam.enums.ErroEnum;
import br.com.petz.exam.rest.vo.ErroVO;

public class ValidationException extends Exception {

	private static final long serialVersionUID = 1L;
	private List<ErroVO> listaErro;

	public ValidationException(List<ErroVO> listaErro) {
		this.listaErro = listaErro;
	}

	public ValidationException(ErroEnum... erros) {
		this.listaErro = new ArrayList<>();
		for(ErroEnum erro: erros){
			this.listaErro.add(new ErroVO(erro.getCodigo(), erro.getMensagem()));
		}
	}

	public List<ErroVO> getListaErro() {
		return listaErro;
	}

	public void setListaErro(List<ErroVO> listaErro) {
		this.listaErro = listaErro;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ValidationException [listaErro=");
		builder.append(listaErro);
		builder.append("]");
		return builder.toString();
	}
}
