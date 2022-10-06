package com.indracompany.treinamento.model.entity;


import java.time.LocalDate;

// não sei se era pra ter essa importacao
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "extratoBancarioRita")
@Data
@EqualsAndHashCode(callSuper = true)
public class ExtratoBancario extends GenericEntity<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50)
	private String tipoDeOperacao;
		
	@Column()
	private LocalDate data;
	
	@Column(nullable = false)
	private Double valor;
	
	// relacionamento ????
	@ManyToOne
	@JoinColumn(name = "fk_conta_id")
	private ContaBancaria conta;
	
}
