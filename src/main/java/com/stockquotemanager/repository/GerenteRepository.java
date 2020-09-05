package com.stockquotemanager.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.stockquotemanager.models.Cadastro;

public interface GerenteRepository<gerente, suario> extends CrudRepository<suario,String> {

	Iterable<gerente> findByEvento(Optional<Cadastro> evento);

}
