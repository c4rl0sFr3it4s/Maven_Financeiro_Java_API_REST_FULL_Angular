package com.example.money.api.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.money.api.model.Lancamento;
import com.example.money.api.repository.LancamentoRepository;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;

//	atualizarLancamento
	public Lancamento atualiza(Long codigo, Lancamento lancamento) {
		Optional<Lancamento> lancamentoSalvo = lancamentoRepository.findById(codigo);
		BeanUtils.copyProperties(lancamento, lancamentoSalvo.get(), "codigo");
		return lancamentoRepository.save(lancamentoSalvo.get());
	}

}
