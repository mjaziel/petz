package br.com.petz.exam.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petz.exam.converter.ClienteConverter;
import br.com.petz.exam.converter.ClienteResponseConverter;
import br.com.petz.exam.enums.ErroEnum;
import br.com.petz.exam.exception.ValidationException;
import br.com.petz.exam.model.Cliente;
import br.com.petz.exam.repository.ClienteRepository;
import br.com.petz.exam.rest.vo.ClienteResponseVO;
import br.com.petz.exam.rest.vo.ClienteVO;
import br.com.petz.exam.validator.ClienteValidator;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private ClienteConverter converter;
	
	@Autowired
	private ClienteValidator validator;
	
	@Autowired
	private ClienteResponseConverter responseConverter;
	
	
	public ClienteResponseVO novo(ClienteVO vo) throws ValidationException {
		validator.validaNovo(vo, this);

		Cliente cliente = converter.toModel(vo);
		cliente = repository.save(cliente);
		return responseConverter.toVO(cliente);
	}
	
	
	public ClienteResponseVO atualiza(Long id, ClienteVO vo) throws ValidationException {
		validator.validaAtualiza(id, vo, this);

		Cliente p = repository.getOne(id);
		
		vo.copyToEntity(p);   // Na alteração é feita somente a cópia dos campos informados.

		p.setAlterado(LocalDateTime.now());
		
		p = repository.save(p);

		return responseConverter.toVO(p);
	}
	
	public void remove(Long id) throws ValidationException {
		Cliente p = repository.findById(id).orElseThrow(() -> new ValidationException(ErroEnum.CLIENTE_NAO_ENCONTRADO));
		repository.delete(p);
	}

	public List<ClienteResponseVO> buscaTodos() {
		List<Cliente> list = repository.findAll();

		List<ClienteResponseVO> lista = list.stream().map(p -> {
			return responseConverter.toVO(p);
		}).collect(Collectors.toList());

		return lista;
	}

	public ClienteResponseVO busca(Long id) throws ValidationException {
		Cliente p = repository.findById(id).orElseThrow(() -> new ValidationException(ErroEnum.CLIENTE_NAO_ENCONTRADO));
		return responseConverter.toVO(p);
	}
	
	public boolean existePorId(Long id) {
		return repository.existsById(id);
	}
	
	public boolean existePorEmail(String email) {
		return repository.countByEmail(email) > 0;
	}

}
