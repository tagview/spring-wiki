package br.com.tagview.wiki.dao;

import java.util.List;

import br.com.tagview.wiki.models.Wiki;

public interface WikiDAO {
	Wiki save(Wiki page);
	
	List<Wiki> all();
	
	Boolean remove(Wiki page);
	
	Wiki findById(Long id);
}
