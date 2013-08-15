package br.com.tagview.wiki.models;

import javax.validation.constraints.NotNull;

import br.com.tagview.wiki.validators.NotBlank;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Parent;

@Entity
public class Page {
	@Id 
	Long id;
	
	@Parent
	Ref<Wiki> wiki;

	@NotNull
	@NotBlank
	String title;
	
	@NotNull
	@NotBlank
	String body;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Wiki getWiki() {
		return wiki.get();
	}

	public void setWiki(Wiki wiki) {
		this.wiki = Ref.create(wiki);
	}
}
