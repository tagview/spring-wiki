package br.com.tagview.wiki.dao.objectify;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.googlecode.objectify.Key;

import br.com.tagview.wiki.dao.WikiDAO;
import br.com.tagview.wiki.models.Wiki;

@Repository
public class ObjectfyWikiDAO implements WikiDAO {

	@Override
	public Wiki save(Wiki wiki) {
		ofy().save().entity(wiki).now();
		return wiki;
	}

	@Override
	public List<Wiki> all() {
		return ofy().load().type(Wiki.class).list();
	}

	@Override
	public Boolean remove(Wiki wiki) {
		ofy().delete().entity(wiki).now();
		return wiki.getId() == null;
	}

	@Override
	public Wiki findById(Long id) {
		Key<Wiki> key = Key.create(Wiki.class, id);
		return ofy().load().key(key).now();
	}

}
