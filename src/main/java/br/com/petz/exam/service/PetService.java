package br.com.petz.exam.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petz.exam.converter.PetConverter;
import br.com.petz.exam.converter.PetResponseConverter;
import br.com.petz.exam.enums.ErroEnum;
import br.com.petz.exam.exception.ValidationException;
import br.com.petz.exam.model.Pet;
import br.com.petz.exam.repository.PetRepository;
import br.com.petz.exam.rest.vo.PetResponseVO;
import br.com.petz.exam.rest.vo.PetVO;
import br.com.petz.exam.validator.PetValidator;

@Service
public class PetService {
	
	@Autowired
	private PetRepository repository;
	
	@Autowired
	private PetConverter converter;
	
	@Autowired
	private PetValidator validator;
	
	@Autowired
	private PetResponseConverter responseConverter;
	
	
	public PetResponseVO novo(PetVO vo) throws ValidationException {
		validator.validaNovo(vo, this);

		Pet pet = converter.toModel(vo);
		pet = repository.save(pet);
		return responseConverter.toVO(pet);
	}
	
	
	public PetResponseVO atualiza(Long id, PetVO vo) throws ValidationException {
		validator.validaAtualiza(id, vo, this);

		Pet p = repository.getOne(id);
		
		vo.copyToEntity(p);   // Na alteração é feita somente a cópia dos campos informados.

		p.setAlterado(LocalDateTime.now());
		
		p = repository.save(p);

		return responseConverter.toVO(p);
	}
	
	public void remove(Long id) throws ValidationException {
		Pet p = repository.findById(id).orElseThrow(() -> new ValidationException(ErroEnum.PET_NAO_ENCONTRADO));
		repository.delete(p);
	}

	public List<PetResponseVO> buscaTodos() {
		List<Pet> list = repository.findAll();

		List<PetResponseVO> lista = list.stream().map(p -> {
			return responseConverter.toVO(p);
		}).collect(Collectors.toList());

		return lista;
	}

	public PetResponseVO busca(Long id) throws ValidationException {
		Pet p = repository.findById(id).orElseThrow(() -> new ValidationException(ErroEnum.PET_NAO_ENCONTRADO));
		return responseConverter.toVO(p);
	}
	
	public boolean existePorId(Long id) {
		return repository.existsById(id);
	}
	
	public boolean existePorRga(String rga) {
		return repository.countByRga(rga) > 0;
	}

	

}
