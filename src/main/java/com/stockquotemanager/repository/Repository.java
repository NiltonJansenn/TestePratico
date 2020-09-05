package com.stockquotemanager.repository;

import org.springframework.data.repository.CrudRepository;

import com.stockquotemanager.models.Cadastro;
import com.sun.xml.fastinfoset.stax.events.EventBase;

public interface Repository extends CrudRepository <Cadastro, String>{

	EventBase findByCodigo(long nome_da_acao);

	EventBase findById(long nome_da_acao);

	void delete(EventBase evento);

}
