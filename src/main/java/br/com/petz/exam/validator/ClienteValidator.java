package br.com.petz.exam.validator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import br.com.petz.exam.enums.ErroEnum;
import br.com.petz.exam.exception.ValidationException;
import br.com.petz.exam.model.Cliente;
import br.com.petz.exam.rest.vo.ClienteVO;
import br.com.petz.exam.service.ClienteService;

@Component
public class ClienteValidator {

	
	public void validaNovo(ClienteVO vo, ClienteService service) throws ValidationException {
		
		List<ErroEnum> listaErro = new ArrayList<ErroEnum>();

		if (StringUtils.isBlank(vo.getNome())) {
			listaErro.add(ErroEnum.CLIENTE_NOME_OBRIGATORIO);
		} else if (Cliente.NOME_MAXIMO < vo.getNome().length()) {
			listaErro.add(ErroEnum.CLIENTE_NOME_MAXIMO);
		} else if (StringUtils.isBlank(vo.getEmail())) {
			listaErro.add(ErroEnum.CLIENTE_EMAIL_OBRIGATORIO);
		} else if (service.existePorEmail(vo.getEmail())) {
			listaErro.add(ErroEnum.CLIENTE_EMAIL_JA_EXISTENTE);
		}
		
		// Na criação são validados todos os campos : cpf, cnpj, email, etc.

		if (!listaErro.isEmpty()) {
			throw new ValidationException(ErroEnum.toListVO(listaErro));
		}
		
	}
	
	public void validaAtualiza(Long id, ClienteVO vo, ClienteService service) throws ValidationException {
		
		List<ErroEnum> listaErro = new ArrayList<ErroEnum>();

		if (service.existePorId(id)) {
			if (!StringUtils.isBlank(vo.getNome()) && (Cliente.NOME_MAXIMO < vo.getNome().length())) {
				listaErro.add(ErroEnum.CLIENTE_NOME_MAXIMO);
			} else if (!StringUtils.isBlank(vo.getEmail()) && service.existePorEmail(vo.getEmail())) {
				listaErro.add(ErroEnum.CLIENTE_EMAIL_JA_EXISTENTE);
			}
			
			// Na atualização valida-se somente os campos informados : nome, email, cpf, cnpj, etc.
			
		} else {
			listaErro.add(ErroEnum.CLIENTE_NAO_ENCONTRADO);
		}

		if (!listaErro.isEmpty()) {
			throw new ValidationException(ErroEnum.toListVO(listaErro));
		}
	}
}
