package br.com.petz.exam.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.base.Predicates;

import io.swagger.models.auth.In;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Autowired
	private BuildProperties buildProperties;
	
	@Value("${server.servlet.context-path}")
	private String contextPath;
	
	@Bean
    public Docket api() { 
    	
    	List<SecurityScheme> auth = new ArrayList<SecurityScheme>();
		auth.add(new BasicAuth("basicAuth"));
		auth.add(new ApiKey("TokenAuth", HttpHeaders.AUTHORIZATION, In.HEADER.name()));
    	
		List<ResponseMessage> responseMessages = new ArrayList<>();
		responseMessages.add(new ResponseMessageBuilder()
				.code(400)
				.message("Formato de JSON inválido")
				.build());
		responseMessages.add(new ResponseMessageBuilder()
				.code(401)
				.message("Não autorizado")
				.build());
		responseMessages.add(new ResponseMessageBuilder()
				.code(422)
				.message("Erro de validação")
				.build());
		responseMessages.add(new ResponseMessageBuilder()
				.code(500)
				.message("Erro interno no Servidor")
				.build());
		responseMessages.add(new ResponseMessageBuilder()
				.code(503)
				.message("Serviço indisponível")
				.build());
		
        return new Docket(DocumentationType.SWAGGER_2)  
        		.securitySchemes(auth)
        		.globalResponseMessage(RequestMethod.GET, responseMessages)
        		.globalResponseMessage(RequestMethod.POST, responseMessages)
        		.globalResponseMessage(RequestMethod.PUT, responseMessages)
        		.useDefaultResponseMessages(false)
        		.apiInfo(apiInfo())
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("br.com.petz.exam"))              
          .paths(PathSelectors.any())                       
          .paths(Predicates.not(PathSelectors.regex("/erros_validacao")))
          .build();                                           
    }
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Petz")
				.description("Exam Petz - Cliente and Pet Registration. Erros de validação <a href=\"" + contextPath + "/v1/erros_validacao\" target=\"blank\">Erros de Validação</a>")
				.version(buildProperties.getVersion())
				.build();
	}
}
