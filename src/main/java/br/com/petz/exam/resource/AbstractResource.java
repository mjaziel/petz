package br.com.petz.exam.resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public abstract class AbstractResource {

	private static final Logger LOGGER = LogManager.getLogger(AbstractResource.class.getName());
	
	protected ResponseEntity<String> montaResponse(Object object) {
		return montaResponse(HttpStatus.OK, object);
	}
	
	protected ResponseEntity<String> montaResponse(HttpStatus status, Object object) {
		ResponseEntity<String> response;
		try {
			if (object != null) {
				ObjectMapper mapper = new ObjectMapper();
				mapper.setSerializationInclusion(Include.NON_NULL);
				mapper.enable(SerializationFeature.INDENT_OUTPUT);
				mapper.registerModule(new JavaTimeModule());
				mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
				
				String json = mapper.writeValueAsString(object);

				response = ResponseEntity.status(status).contentType(MediaType.APPLICATION_JSON).body(json);
			} else {
				response = ResponseEntity.status(status).build();
			}
		} catch (JsonProcessingException e) {
			LOGGER.error(e.getMessage(), e);
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

		return response;
	}
}
