package br.com.tagview.wiki.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.tagview.wiki.models.Page;

import com.googlecode.objectify.Key;

@Repository
public class ObjectifyPageDAO implements PageDAO {

	@Override
	public Page save(Page page) {
		ofy().save().entity(page).now();
		return page;
	}

	@Override
	public List<Page> all() {
		return ofy().load().type(Page.class).list();
	}

	@Override
	public Boolean remove(Page page) {
		ofy().delete().entity(page).now();
		return page.getId() == null;
	}

	@Override
	public Page findById(Long id) {
		Key<Page> key = Key.create(Page.class, id);
		return ofy().load().key(key).now();
	}
}
