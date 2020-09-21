package br.com.petz.exam.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import br.com.petz.exam.model.Pet;
import br.com.petz.exam.rest.vo.PetVO;

@Component
public class PetConverter implements Converter<PetVO, Pet> {
	
	@Override
	public Pet toModel(PetVO vo) {
		Pet p = new Pet(); 
		BeanUtils.copyProperties(vo, p);
		return p;
	}

	public PetVO toVO(Pet e) {
		PetVO vo = new PetVO();
		BeanUtils.copyProperties(e, vo);
		return vo;
	}
}