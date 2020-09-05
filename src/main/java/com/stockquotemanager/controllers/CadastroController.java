package com.stockquotemanager.controllers;
import java.util.Optional;

import javax.validation.Valid;

import org.hibernate.event.spi.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.stockquotemanager.models.Cadastro;
import com.stockquotemanager.repository.*;
import com.sun.xml.fastinfoset.stax.events.EventBase;

@Controller
public class CadastroController{
	@Autowired
	private Repository  EnvetRep ; 
	
	@Autowired
	private GerenteRepository GertRep;
	
	@RequestMapping (value = "/cadastrarAcoes",method = RequestMethod.GET)
	public  String form() {
		return "evento/formEvento";
	}
	
	@RequestMapping(value="/cadastrarAcoes", method=RequestMethod.POST)
	public String form(@Valid Cadastro evento, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastrarAcoes";
		}
		
		EnvetRep.save(evento);
		attributes.addFlashAttribute("mensagem", "Evento cadastrado com sucesso!");
		return "redirect:/cadastrarAcoes";
	}
	
	@RequestMapping("/Cadastro")
	public ModelAndView listaAcoes(){
		ModelAndView mv = new ModelAndView("listaAcoes");
		Iterable<Cadastro> Cadastro = EnvetRep.findAll();
		mv.addObject("Cadastro", Cadastro);
		return mv;
	}
	
	@RequestMapping(value="/{nome_da_acao}", method=RequestMethod.GET)
	public <gerente> ModelAndView detalhesEvento(@PathVariable("nome_da_acao") String nome_da_acao){
		Optional<Cadastro> evento = EnvetRep.findById(nome_da_acao);
		ModelAndView mv = new ModelAndView("evento/detalhesEvento");
		mv.addObject("evento", evento);
		
		Iterable<gerente> gerente = GertRep.findByEvento(evento);
		mv.addObject("gerente", gerente);
		
		return mv;
	}
	@RequestMapping("/deletarEvento")
	public String deletarEvento(long nome_da_acao){
		EventBase evento = EnvetRep.findById(nome_da_acao);
		EnvetRep.delete(evento);
		return "redirect:/Cadastro";
	}
	
	
	@RequestMapping(value="/{nome_da_acao}", method=RequestMethod.POST)
	public String detalhesEventoPost(@PathVariable("nome_da_acao") long nome_da_acao, @Valid Gerente gerente,  BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/{nome_da_acao}";
		}
		EventBase evento = EnvetRep.findById(nome_da_acao);
		gerente.setEvento(evento);
		GertRep.save(gerente);
		attributes.addFlashAttribute("mensagem", "gerente adicionado com sucesso!");
		return "redirect:/{nome_da_acao}";
	}
	
	@RequestMapping("/deletarAcoes")
	public String deletarAcoes(String nome_da_acao){
		Optional gerente = GertRep.findById(nome_da_acao);
		GertRep.delete(gerente);
		
		EventType evento = gerente.getEvento();
		long nome_da_acaoLong = evento.getCodigo();
		String nome_da_acao = "" + nome_da_acaoLong;
		return "redirect:/" + nome_da_acao;
	}
	
	
	
	
	
	

}
