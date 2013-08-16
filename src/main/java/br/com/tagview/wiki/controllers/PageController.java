package br.com.tagview.wiki.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.tagview.wiki.dao.PageDAO;
import br.com.tagview.wiki.dao.WikiDAO;
import br.com.tagview.wiki.models.Page;
import br.com.tagview.wiki.models.Wiki;

@Controller
public class PageController {
	@Autowired
	PageDAO pageDAO;
	
	@Autowired
	WikiDAO wikiDAO;
	
	@RequestMapping(value={ "/wikis/{wikiId}/pages", "/wikis/{wikiId}" })
	public String list(@PathVariable Long wikiId, Model view) {
		Wiki wiki = wikiDAO.findById(wikiId);
		
		view.addAttribute("wiki", wiki);
		view.addAttribute("pages", pageDAO.allByWiki(wiki));
		
		return "pages/list";
	}
	
	@RequestMapping("/wikis/{wikiId}/pages/new")
	public String add(@PathVariable Long wikiId, Model view) {		
		view.addAttribute("wiki", wikiDAO.findById(wikiId));
		view.addAttribute("page", new Page());
		
		return "pages/form";
	}
	
	@RequestMapping(value = "/wikis/{wikiId}/pages", method = RequestMethod.POST)
	public String create(@PathVariable Long wikiId, @Valid Page page, BindingResult bindingResult, Model view) {
		Wiki wiki = wikiDAO.findById(wikiId);
		
		if (bindingResult.hasErrors()) {
			view.addAttribute("wiki", wiki);
			view.addAttribute("page", page);
			
			return "pages/form";
		}
		
		page.setWiki(wiki);
		pageDAO.save(page);
		
		return "redirect:/wikis/"+ wikiId +"/pages";
	}
	
	@RequestMapping(value="/wikis/{wikiId}/pages/{pageId}")
	public String show(@PathVariable Long wikiId, @PathVariable Long pageId, Model view) {
		Wiki wiki = wikiDAO.findById(wikiId);
		view.addAttribute("wiki", wiki);
		view.addAttribute("page", pageDAO.findById(wiki, pageId));
		
		return "pages/show";
	}
	
	/**
	 * JSON APIs
	 */
	@RequestMapping(value="/api/wikis/{wikiId}/pages/{pageId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE, headers="Accept=application/json")
	@ResponseBody
	public String jsonShow(@PathVariable Long wikiId, @PathVariable Long pageId) throws JsonProcessingException {
		return pageDAO.findById(pageId).toJSON();
	}
}
