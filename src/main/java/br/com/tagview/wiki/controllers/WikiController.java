package br.com.tagview.wiki.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.tagview.wiki.dao.PageDAO;
import br.com.tagview.wiki.models.Page;

@Controller
public class WikiController {
	
	@Autowired
	PageDAO pageDAO;
	
	@RequestMapping("/")
	public String list(Model model) {
		List<Page> pages = pageDAO.all();
		
		model.addAttribute("pages", pages);
		
		return "listPages";
	}
	
	@RequestMapping("/pages/new")
	public String addPage(Model model) {
		model.addAttribute("page", new Page());
		
		return "addPage";
	}
	
	@RequestMapping(value = "/pages", method = RequestMethod.POST)
	public String createPage(@Valid Page page, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("page", page);
			
			return "addPage";
		}
		
		pageDAO.save(page);
		
		return "redirect:/";
	}
}
