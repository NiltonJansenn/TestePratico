package com.stockquotemanager.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"com.stockquotemaneger.models"})
@EnableJpaRepositories("com.stockquotemaneger.repository")

@Entity
public class Cadastro  implements Serializable {
	
	private static final long serialVersionUID =1L;
	
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String nome_da_acao; 
	

	private String data ;
	private String valor;
	
	
	public String getNoma_da_Acao() {
		return nome_da_acao;
	}
	public void setNoma_da_Acao(String noma_da_Acao) {
		this.nome_da_acao = noma_da_Acao;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
	


	
}
