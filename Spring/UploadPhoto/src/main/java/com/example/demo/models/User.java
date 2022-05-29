package com.example.demo.models;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "users")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	 
    @Column(nullable = true, length = 64)
    private String photos;
 
    // other fields and getters, setters are not shown 

 
	@Transient
	 public String getPhotosImagePath() {
	   if (photos == null || id == null) return null;
	         
	    return "/user-photos/" + id + "/" + photos;
	    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}
}
