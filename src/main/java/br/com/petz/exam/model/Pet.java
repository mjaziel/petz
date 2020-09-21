package br.com.petz.exam.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.petz.exam.enums.PetPorteEnum;
import br.com.petz.exam.enums.PetTipoEnum;
import br.com.petz.exam.enums.PreOwnedEnum;
import lombok.Data;

@Data
@Entity
@Table(schema="sql10366096", name="pet")
public class Pet {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pet_id")
	private Long id;
	
	@Column(name="tipo")
	@Enumerated(EnumType.STRING)
	private PetTipoEnum tipo;
	
	@Column(name="raca")
	private String raca;
	
	@Column(name="porte")
	@Enumerated(EnumType.STRING)
	private PetPorteEnum porte;
	
	@Column(name="rga")
	private String rga;

	@Column(name="dt_nasc")
	private LocalDate dt_nasc;

	@Column(name="pre_owned")
	@Enumerated(EnumType.STRING)
	private PreOwnedEnum pre_owned;
	
	@Column(name="descricao")
	private String descricao;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "cliente_id", nullable = true)
    private Cliente cliente;
	
	@Column(name="criado")
	private LocalDateTime criado;
	
	@Column(name="alterado")
	private LocalDateTime alterado;

}
