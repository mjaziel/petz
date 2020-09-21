package br.com.petz.exam.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import br.com.petz.exam.model.Cliente;
import br.com.petz.exam.rest.vo.ClienteVO;
import br.com.petz.exam.util.ConverterUtil;

@Component
public class ClienteConverter implements Converter<ClienteVO, Cliente> {
	
	@Override
	public Cliente toModel(ClienteVO vo) {
		Cliente p = new Cliente(); 
		BeanUtils.copyProperties(vo, p);

		p.setCnpj(ConverterUtil.replaceNotNumericos(vo.getCnpj()));
		p.setCpf(ConverterUtil.replaceNotNumericos(vo.getCpf()));
		p.setCep(ConverterUtil.replaceNotNumericos(vo.getCep()));
		
		return p;
	}

	public ClienteVO toVO(Cliente e) {
		ClienteVO vo = new ClienteVO();
		BeanUtils.copyProperties(e, vo);
		return vo;
	}
}