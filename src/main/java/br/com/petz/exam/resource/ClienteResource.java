package br.com.petz.exam.resource;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.petz.exam.exception.ValidationException;
import br.com.petz.exam.rest.vo.ClienteResponseVO;
import br.com.petz.exam.rest.vo.ClienteVO;
import br.com.petz.exam.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/v1/clientes")
@Api(value = "clientes")
public class ClienteResource extends AbstractResource {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClienteResource.class);
	
	@Autowired
	private ClienteService service;
	
	@GetMapping()
	@ApiOperation(value = "Lista de Clientes")
	@ApiResponses({ @ApiResponse(code = 200, message = "Sucesso", response = ClienteResponseVO.class, responseContainer = "List" ) })
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> buscaTodos() {
		try {
			return montaResponse(service.buscaTodos());
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	

	@GetMapping("/{id}")
	@ApiOperation(value = "Busca Cliente por Id")
	@ApiResponses({ @ApiResponse(code = 200, message = "Sucesso", response = ClienteResponseVO.class) })
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> busca(@PathVariable("id") Long id) {
		try {
			return montaResponse(service.busca(id));
		} catch (ValidationException e) {
			return ResponseEntity.unprocessableEntity().body(e.getListaErro());
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	@PostMapping()
	@ApiOperation(value = "Novo Cliente")
	@ApiResponses({ @ApiResponse(code = 201, message = "Criado", response = ClienteResponseVO.class) })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> novo(HttpServletRequest request, @RequestBody ClienteVO clienteVO) {
		try {
			return montaResponse(HttpStatus.CREATED, service.novo(clienteVO));
		} catch (ValidationException e) {
			return ResponseEntity.unprocessableEntity().body(e.getListaErro());
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza Cliente")
	@ApiResponses({ @ApiResponse(code = 200, message = "Sucesso", response = ClienteResponseVO.class) })
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> atualiza(@PathVariable("id") Long id, @RequestBody ClienteVO clienteVO) {
		try {
			return montaResponse(service.atualiza(id, clienteVO));
		} catch (ValidationException e) {
			return ResponseEntity.unprocessableEntity().body(e.getListaErro());
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Remove Cliente")
	@ApiResponses({ @ApiResponse(code = 200, message = "Sucesso") })
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> remove(@PathVariable("id") Long id) {
		try {
			service.remove(id);
			return ResponseEntity.ok().build();
		} catch (ValidationException e) {
			return ResponseEntity.unprocessableEntity().body(e.getListaErro());
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
