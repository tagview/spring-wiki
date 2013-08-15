package br.com.tagview.wiki.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.tagview.wiki.dao.WikiDAO;
import br.com.tagview.wiki.models.Wiki;

@Controller
public class WikiController {
	@Autowired
	WikiDAO wikiDAO;
	
	@RequestMapping(value = { "/", "/wikis" })
	public String list(Model view) {
		view.addAttribute("wikis", wikiDAO.all());
		
		return "wikis/list";
	}
	
	@RequestMapping("/wikis/new")
	public String add(Model view) {		
		view.addAttribute("wiki", new Wiki());
		
		return "wikis/form";
	}
	
	@RequestMapping(value = "/wikis", method = RequestMethod.POST)
	public String create(@Valid Wiki wiki, BindingResult bindingResult, Model view) {		
		if (bindingResult.hasErrors()) {
			view.addAttribute("wiki", wiki);
			
			return "wikis/form";
		}
		
		wikiDAO.save(wiki);
		
		return "redirect:/";
	}
}
