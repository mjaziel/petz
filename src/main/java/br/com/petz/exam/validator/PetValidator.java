package br.com.petz.exam.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.petz.exam.enums.ErroEnum;
import br.com.petz.exam.exception.ValidationException;
import br.com.petz.exam.rest.vo.PetVO;
import br.com.petz.exam.service.PetService;

@Component
public class PetValidator {
	
	public void validaNovo(PetVO vo, PetService service) throws ValidationException {
		
		List<ErroEnum> listaErro = new ArrayList<ErroEnum>();

		if (service.existePorRga(vo.getRga())) {
			listaErro.add(ErroEnum.PET_RGA_JA_CADASTRADO);
		}
		
		// Na criação são validados todos os campos : cpf, cnpj, email, etc.

		if (!listaErro.isEmpty()) {
			throw new ValidationException(ErroEnum.toListVO(listaErro));
		}
/*		
		30=Tipo do pet obrigatório!
				31=Raça excedeu o máximo de 128 caracteres!
				32=Pet não encontrado!
*/
		
	}
	
	public void validaAtualiza(Long id, PetVO vo, PetService service) throws ValidationException {
		
	}

}
