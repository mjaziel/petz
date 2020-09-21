package br.com.petz.exam.rest.vo;

import java.time.LocalDate;

import org.apache.commons.lang3.StringUtils;

import br.com.petz.exam.model.Cliente;
import br.com.petz.exam.util.ConverterUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ClienteVO {

	@ApiModelProperty(required = true, position = 2, allowableValues = "range [-infinity, 128]", allowEmptyValue = false, example = "\"Jose\"")
	private String nome;

	@ApiModelProperty(required = true, position = 3, allowableValues = "range [-infinity, 100]", allowEmptyValue = false, example = "\"Silva\"")
	private String sobrenome;
	
	@ApiModelProperty(required = true, position = 4, allowableValues = "range [-infinity, 15]", allowEmptyValue = false, example = "\"035.657.001-02\"")
	private String cpf;
	
	@ApiModelProperty(required = true, position = 5, allowableValues = "range [-infinity, 20]", allowEmptyValue = false, example = "\"01.123.123/0001-01\"")
	private String cnpj;
	
	@ApiModelProperty(required = true, position = 6, example = "\"1975-05-31\"")
	private LocalDate dt_nasc;
	
	@ApiModelProperty(required = true, position = 7, allowableValues = "range [-infinity, 100]", allowEmptyValue = false, example = "\"mjaziel@gmail.com\"")
	private String email;
	
	@ApiModelProperty(required = true, position = 8, allowableValues = "range [-infinity, 20]", allowEmptyValue = false, example = "\"JO94893kldfhjodwh@\"")
	private String senha;

	@ApiModelProperty(required = true, position = 9, allowableValues = "range [-infinity, 15]", allowEmptyValue = false, example = "\"(11) 9869-9442\"")
	private String celular;
	
	@ApiModelProperty(required = true, position = 10, allowableValues = "range [-infinity, 15]", allowEmptyValue = false, example = "\"(11) 2738-8839\"")
	private String telefone;
	
	@ApiModelProperty(required = true, position = 11, allowableValues = "range [-infinity, 100]", allowEmptyValue = false, example = "\"Rua Joaquin Silvério\"")
	private String logradouro;
	
	@ApiModelProperty(required = true, position = 12, allowableValues = "range [-infinity, 100]", allowEmptyValue = false, example = "\"Bloco A Sala 13\"")
	private String complemento;

	@ApiModelProperty(required = true, position = 13, allowableValues = "range [-infinity, 100]", allowEmptyValue = false, example = "\"1300\"")
	private String numero;

	@ApiModelProperty(required = true, position = 14, allowableValues = "range [-infinity, 100]", allowEmptyValue = false, example = "\"Saúde\"")
	private String bairro;

	@ApiModelProperty(required = true, position = 15, allowableValues = "range [-infinity, 100]", allowEmptyValue = false, example = "\"São Paulo\"")
	private String cidade;
	
	@ApiModelProperty(required = true, position = 16, allowableValues = "range [-infinity, 100]", allowEmptyValue = false, example = "\"SP\"")
	private String estado;
	
	@ApiModelProperty(required = true, position = 16, allowableValues = "range [-infinity, 10]", allowEmptyValue = false, example = "\"041430-010\"")
	private String cep;
	
	
	public void copyToEntity (Cliente p) {
		
		if (!StringUtils.isBlank(this.getNome())) {
			p.setNome(this.getNome());
		}
		
		if (!StringUtils.isBlank(this.getSobrenome())) {
			p.setSobrenome(this.getSobrenome());
		}

		if (!StringUtils.isBlank(this.getCpf())) {
			p.setCpf(ConverterUtil.replaceNotNumericos(this.getCpf()));
		}
		
		if (!StringUtils.isBlank(this.getCnpj())) {
			p.setCnpj(ConverterUtil.replaceNotNumericos(this.getCnpj()));
		}

		if (this.getDt_nasc() != null) {
			p.setDt_nasc(this.getDt_nasc());
		}

		if (!StringUtils.isBlank(this.getEmail())) {
			p.setEmail(this.getEmail());
		}		
		
		if (!StringUtils.isBlank(this.getSenha())) {
			p.setSenha(this.getSenha());
		}
		
		if (!StringUtils.isBlank(this.getCelular())) {
			p.setCelular(this.getCelular());
		}	
		
		if (!StringUtils.isBlank(this.getTelefone())) {
			p.setTelefone(this.getTelefone());
		}
		
		if (!StringUtils.isBlank(this.getLogradouro())) {
			p.setLogradouro(this.getLogradouro());
		}
		
		if (!StringUtils.isBlank(this.getComplemento())) {
			p.setComplemento(this.getComplemento());
		}
		
		if (!StringUtils.isBlank(this.getNumero())) {
			p.setNumero(this.getNumero());
		}
		
		if (!StringUtils.isBlank(this.getBairro())) {
			p.setBairro(this.getBairro());
		}
		
		if (!StringUtils.isBlank(this.getCidade())) {
			p.setCidade(this.getCidade());
		}
		
		if (!StringUtils.isBlank(this.getEstado())) {
			p.setEstado(this.getEstado());
		}

		if (!StringUtils.isBlank(this.getCep())) {
			p.setCep(this.getCep());
		}
	}
}
