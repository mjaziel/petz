package br.com.petz.exam.rest.vo;

import java.time.LocalDate;

import org.apache.commons.lang3.StringUtils;

import br.com.petz.exam.enums.PetPorteEnum;
import br.com.petz.exam.enums.PetTipoEnum;
import br.com.petz.exam.enums.PreOwnedEnum;
import br.com.petz.exam.model.Pet;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PetVO {
	
	@ApiModelProperty(required = true, position = 1, example = "\"CACHORRO\"")
	private PetTipoEnum tipo;
	
	@ApiModelProperty(required = true, position = 2, allowableValues = "range [-infinity, 128]", allowEmptyValue = false, example = "\"BEAGLE\"")  //[Beagle | Boxer | Chihuahua | Collie]
	private String raca;
	
	@ApiModelProperty(required = true, position = 3, example = "\"PEQUENO\"")
	private PetPorteEnum porte;
	
	@ApiModelProperty(required = true, position = 2, allowableValues = "range [-infinity, 128]", allowEmptyValue = false, example = "\"123456788\"")  
	private String rga;

	@ApiModelProperty(required = true, position = 4, allowableValues = "range [-infinity, 128]", allowEmptyValue = false, example = "2019-06-06")
	private LocalDate dt_nasc;

	@ApiModelProperty(required = true, position = 5, allowableValues = "range [-infinity, 1]", allowEmptyValue = false, example = "\"S\"")
	private PreOwnedEnum pre_owned;
	
	@ApiModelProperty(required = true, position = 6, allowableValues = "range [-infinity, 128]", allowEmptyValue = false, example = "\"Animal de porte médio com comportamento dócil e saúde plena.\"")
	private String descricao;
	
	
	public void copyToEntity(Pet p) {
		
		if (!StringUtils.isBlank(this.getRaca())) {
			p.setRaca(this.getRaca());
		}
		
		if (!StringUtils.isBlank(this.getRga())) {
			p.setRga(this.getRga());
		}

		if (this.getDt_nasc() !=null ) {
			p.setDt_nasc(this.getDt_nasc());
		}
		
		if (this.getDescricao() != null) {
			p.setDescricao(this.getDescricao());
		}
	}
}
