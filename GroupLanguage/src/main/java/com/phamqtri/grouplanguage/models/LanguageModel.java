package com.phamqtri.grouplanguage.models;

import javax.validation.constraints.Size;

public class LanguageModel {
	@Size(min=3, max=20)
	private String name;
	@Size(min=3, max=20)
	private String creator;
	@Size(min=1)
	private String version;
	
	public LanguageModel() {
		
	}
	
	public LanguageModel(String name, String creator, String version) {
		this.name = name;
		this.creator = creator;
		this.version = version;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCreator() {
		return creator;
	}
	
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	public String getVersion() {
		return version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
}
