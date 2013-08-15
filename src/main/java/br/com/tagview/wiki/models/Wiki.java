package br.com.tagview.wiki.models;

import javax.validation.constraints.NotNull;

import br.com.tagview.wiki.validators.NotBlank;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Wiki {
	@Id
	Long id;
	
	@NotNull
	@NotBlank
	String name;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
