package br.com.tagview.wiki.models;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;

import br.com.tagview.wiki.validators.NotBlank;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	
	public String toJSON() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> wiki = new HashMap<String, Object>();
		wiki.put("id", this.id);
		wiki.put("name", this.name);
		
		return mapper.writeValueAsString(wiki);
	}
	
	@Override
	public boolean equals(Object o) {
		return o instanceof Wiki && ((Wiki) o).id == this.id;
	}
	
	@Override
	public int hashCode() {
		int hash = 17;
		hash = (31 * hash) + (this.id == null ? 0 : this.id.intValue());
		hash = (31 * hash) + this.getClass().getName().hashCode();
		
		return hash;
	}
}
