package br.com.tagview.wiki.models;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;

import br.com.tagview.wiki.validators.NotBlank;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Page {
	@Id 
	Long id;
	
	@Index
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
	
	public String toJSON() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> page = new HashMap<String, Object>();
		page.put("id", this.id);
		page.put("title", this.title);
		page.put("body", this.body);
		
		Map<String, Object> wiki = new HashMap<String, Object>();
		wiki.put("id", this.getWiki().getId());
		wiki.put("name", this.getWiki().getName());
		page.put("wiki", wiki);
		
		return mapper.writeValueAsString(page);
	}
}
