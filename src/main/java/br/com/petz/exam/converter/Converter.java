package br.com.petz.exam.converter;

public interface Converter<VO, E> {
	
	public E toModel(VO vo);
	
	public VO toVO(E e);
}
