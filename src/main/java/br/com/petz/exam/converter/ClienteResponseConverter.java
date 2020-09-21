package br.com.petz.exam.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import br.com.petz.exam.model.Cliente;
import br.com.petz.exam.rest.vo.ClienteResponseVO;

@Component
public class ClienteResponseConverter implements Converter<ClienteResponseVO, Cliente> {
	
	@Override
	public Cliente toModel(ClienteResponseVO vo) {
		Cliente p = new Cliente();
		BeanUtils.copyProperties(vo, p);
		return p;
	}

	public ClienteResponseVO toVO(Cliente e) {
		ClienteResponseVO vo = new ClienteResponseVO();
		BeanUtils.copyProperties(e, vo);
		vo.setSenha(null);
		return vo;
	}
}