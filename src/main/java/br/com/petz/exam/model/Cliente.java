package br.com.petz.exam.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(schema="sql10366096", name="cliente")
public class Cliente {
	
	public static final int NOME_MAXIMO = 128;
	public static final int EMAIL_MAXIMO = 128;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cliente_id")
	private Long id;
	
	@Column(name="nome")
	private String nome;

	@Column(name="sobrenome")
	private String sobrenome;
	
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="cnpj")
	private String cnpj;
	
	@Column(name="dt_nasc")
	private LocalDate dt_nasc;
	
	@Column(name="email")
	private String email;
	
	@Column(name="senha")
	private String senha;
	
	@Column(name="celular")
	private String celular;

	@Column(name="telefone")
	private String telefone;
	
	@Column(name="logradouro")
	private String logradouro;
	
	@Column(name="complemento")
	private String complemento;

	@Column(name="numero")
	private String numero;

	@Column(name="bairro")
	private String bairro;

	@Column(name="cidade")
	private String cidade;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="cep")
	private String cep;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente", fetch = FetchType.LAZY)
	private List<Pet> petList;

	@Column(name="criado")
	private LocalDateTime criado;
	
	@Column(name="alterado")
	private LocalDateTime alterado;
}
