package com.indracompany.treinamento.model.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indracompany.treinamento.exception.AplicacaoException;
import com.indracompany.treinamento.exception.ExceptionValidacoes;
import com.indracompany.treinamento.model.entity.ExtratoBancario;
import com.indracompany.treinamento.model.repository.ExtratoBancarioRepository;

@Service
public class ExtratoBancarioService extends GenericCrudService<ExtratoBancario, Long, ExtratoBancarioRepository>{
	
	@Autowired
	private ExtratoBancarioRepository extratoBancarioRepository;
	
	public List<ExtratoBancario> buscarExtratoPorData(LocalDate dataInicial, LocalDate dataFinal, String agencia, String nrConta) {

		
		if (dataInicial == null || dataFinal == null) {
			throw new AplicacaoException(ExceptionValidacoes.ERRO_Data_INVALIDA);
		}

		if (dataFinal.isBefore(dataInicial) || dataInicial.isAfter(dataFinal)) { //ERRO_CAMPO_OBRIGATORIO
			throw new AplicacaoException(ExceptionValidacoes.ERRO_Data_INVALIDA);
		}
		
		List<ExtratoBancario> extrato = extratoBancarioRepository.findByExtratoPorFiltro(dataInicial, dataFinal, agencia, nrConta);
	
		
		return extrato;
	}
}
