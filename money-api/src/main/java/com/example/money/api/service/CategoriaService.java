package com.example.money.api.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.money.api.model.Categoria;
import com.example.money.api.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

//	atualizarCategoria	
	public Categoria atualizar(Long codigo, Categoria categoria) {
		Optional<Categoria> categoriaSalva = categoriaRepository.findById(codigo);
		BeanUtils.copyProperties(categoria, categoriaSalva, "codigo");
		return categoriaRepository.save(categoriaSalva.get());
	}
	
}
