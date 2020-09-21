package br.com.petz.exam.rest.vo;

import java.time.LocalDateTime;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ClienteResponseVO extends ClienteVO {
	
	@ApiModelProperty(required = true, position = 1, allowableValues = "range [-infinity, 22]", allowEmptyValue = false, example = "100")
	private Long id;
	
	@ApiModelProperty(required = true, position = 17)
	private List<PetVO> petList;

	@ApiModelProperty(required = true, position = 18, allowableValues = "range [-infinity, 25]", allowEmptyValue = false, example = "2019-06-06T11:33:26.119Z")
	private LocalDateTime criado;
	
	@ApiModelProperty(required = true, position = 19, allowableValues = "range [-infinity, 25]", allowEmptyValue = false, example = "2019-06-06T11:33:26.119Z")
	private LocalDateTime alterado;
	
}