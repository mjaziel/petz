package br.com.petz.exam.enums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;

import br.com.petz.exam.rest.vo.ErroVO;


public enum ErroEnum {
	
	CLIENTE_NAO_ENCONTRADO(10),
	CLIENTE_NOME_OBRIGATORIO(11),
	CLIENTE_NOME_MAXIMO(12),
	CLIENTE_EMAIL_OBRIGATORIO(13),
	CLIENTE_EMAIL_JA_EXISTENTE(14),
	CLIENTE_SENHA_OBRIGATORIA(15),
	CLIENTE_CPF_JA_EXISTENTE(16),
	CLIENTE_CPF_INVALIDO(17),
	
	PET_TIPO_OBRIGATORIO(30),
	PET_RACA_MAXIMO(31),
	PET_RGA_JA_CADASTRADO(32),
	PET_NAO_ENCONTRADO(33);
	

	
	private Integer codigo;
	private String mensagem;

	private ResourceBundle resource = ResourceBundle.getBundle("mensagensErro");

	private ErroEnum(Integer codigo) {
		this.codigo = codigo;
		this.mensagem = resource.getString(codigo.toString());
	}

	public Integer getCodigo() {
		return codigo;
	}

	public static ErroEnum valueOf(Integer codigo) {
		for (ErroEnum status : values()) {
			if (status.getCodigo().equals(codigo)) {
				return status;
			}
		}

		return null;
	}

	public String getMensagem() {
		return mensagem;
	}

	public ErroVO toVO() {
		return new ErroVO(getCodigo(), getMensagem());
	}

	public static List<ErroVO> toListVO(List<ErroEnum> erros) {
		List<ErroVO> lista = new ArrayList<>(erros.size());

		for (ErroEnum erro : erros) {
			lista.add(new ErroVO(erro.getCodigo(), erro.getMensagem()));
		}

		return lista;
	}

	public List<ErroVO> buscaTodos() {

		List<ErroVO> lista = new ArrayList<>();

		Enumeration<String> keys = resource.getKeys();

		while (keys.hasMoreElements()) {
			String chave = keys.nextElement();
			Integer codigo = Integer.valueOf(chave);
			lista.add(new ErroVO(codigo, resource.getString(chave)));
		}

		Collections.sort(lista, new Comparator<ErroVO>() {
			public int compare(ErroVO s1, ErroVO s2) {
				return s1.getCodigo().compareTo(s2.getCodigo());
			}
		});

		return lista;
	}


}
