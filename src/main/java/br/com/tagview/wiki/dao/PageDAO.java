package br.com.tagview.wiki.dao;

import java.util.List;

import br.com.tagview.wiki.models.Page;
import br.com.tagview.wiki.models.Wiki;

public interface PageDAO {

	Page save(Page page);
	
	List<Page> all();
	
	Boolean remove(Page page);
	
	Page findById(Long id);
	Page findById(Wiki wiki, Long id);
	
	List<Page> allByWiki(Wiki wiki);
}