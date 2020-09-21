package br.com.petz.exam.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import br.com.petz.exam.model.Pet;
import br.com.petz.exam.rest.vo.PetResponseVO;

@Component
public class PetResponseConverter implements Converter<PetResponseVO, Pet> {
	
	@Override
	public Pet toModel(PetResponseVO vo) {
		Pet p = new Pet();
		BeanUtils.copyProperties(vo, p);
		return p;
	}

	public PetResponseVO toVO(Pet e) {
		PetResponseVO vo = new PetResponseVO();
		BeanUtils.copyProperties(e, vo);
		return vo;
	}
}