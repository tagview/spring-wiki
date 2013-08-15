package br.com.tagview.wiki.dao;

import java.util.List;

import br.com.tagview.wiki.models.Page;

public interface PageDAO {

	Page save(Page page);
	
	List<Page> all();
	
	Boolean remove(Page page);
	
	Page findById(Long id);
}