package com.phamqtri.books.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Book {
	@Id
	@GeneratedValue
	private long id;
	
	@Column
	@Size(min = 3, max = 20)
	private String title;
	
	@Column
	@Size(min = 5, max = 200)
	private String description;
	
	@Column
	@Size(min = 3, max = 40)
	private String language;
	
	@Column
	@Min(100)
	private int numberOfPages;
	
	@Column
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date created_at;
	
	@Column
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date updated_at;
	
	public Book() {
		
	}
	
	public Book(String title, String desc, String lang, int pages) {
        this.title = title;
        this.description = desc;
        this.language = lang;
        this.numberOfPages = pages;
        this.created_at = new Date();
        this.updated_at = new Date();
    }
	
	@PrePersist
    protected void onCreate(){
            this.created_at = new Date();
    }
	
    @PreUpdate
    protected void onUpdate(){
            this.updated_at = new Date();
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
}
