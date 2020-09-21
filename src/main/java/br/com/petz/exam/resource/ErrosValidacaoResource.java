package br.com.petz.exam.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.petz.exam.enums.ErroEnum;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(path = "/v1/erros_validacao")
@ApiIgnore
public class ErrosValidacaoResource extends AbstractResource {
	private static final Logger LOGGER = LoggerFactory.getLogger(ErrosValidacaoResource.class);

	@GetMapping()
	@ApiOperation(value = "Lista de Erros de Validação")
	@ApiResponses({ @ApiResponse(code = 200, message = "Sucesso", response = List.class) })
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> buscaTodos() {
		try {
			
			ErroEnum g = ErroEnum.CLIENTE_NOME_MAXIMO; 
			return montaResponse(g.buscaTodos());
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
