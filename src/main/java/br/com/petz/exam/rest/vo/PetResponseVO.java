package br.com.petz.exam.rest.vo;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class PetResponseVO  extends PetVO {

	@ApiModelProperty(required = true, position = 6, allowableValues = "range [-infinity, 22]", allowEmptyValue = false, example = "100")
	private Long id;
	
	@ApiModelProperty(required = true, position = 7)
	private ClienteVO cliente;

	@ApiModelProperty(required = true, position = 8, allowableValues = "range [-infinity, 128]", allowEmptyValue = false, example = "2019-06-06T11:33:26.119Z")
	private LocalDateTime criado;
	
	@ApiModelProperty(required = true, position = 9, allowableValues = "range [-infinity, 128]", allowEmptyValue = false, example = "2019-06-06T11:33:26.119Z")
	private LocalDateTime alterado;
}
