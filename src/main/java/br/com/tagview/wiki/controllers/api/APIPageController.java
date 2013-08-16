package br.com.tagview.wiki.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.tagview.wiki.dao.PageDAO;
import br.com.tagview.wiki.dao.WikiDAO;
import br.com.tagview.wiki.models.Wiki;

import com.fasterxml.jackson.core.JsonProcessingException;

@Controller
@RequestMapping("/api/wikis/{wikiId}")
public class APIPageController {
	@Autowired
	PageDAO pageDAO;

	@Autowired
	WikiDAO wikiDAO;

	@RequestMapping(value = "/pages/{pageId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
	@ResponseBody
	public String jsonShow(@PathVariable Long wikiId, @PathVariable Long pageId)
			throws JsonProcessingException {
		Wiki wiki = wikiDAO.findById(wikiId);
		return pageDAO.findById(wiki, pageId).toJSON();
	}
}
