package com.example.demo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="products")
public class Product {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @NotNull(message="Must be not null")
	    @Size(min=3,message="Neme Product must be at leaste three character")
	    private String productName;
	    
	    @Column(nullable = true, length = 64)
	    private String photos;
	    
	    
	 
	    
	    @Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date createdAt;
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;
	    
	    
		public Product() {
			
		}

		@Transient
		 public String getPhotosImagePath() {
		   if (photos == null || id == null) return null;
		         
		    return "/user-photos/" + id + "/" + photos;
		    }
		public String getPhotos() {
			return photos;
		}

		public void setPhotos(String photos) {
			this.photos = photos;
		}

		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getProductName() {
			return productName;
		}


		public void setProductName(String productName) {
			this.productName = productName;
		}


	




	
	    
//	    @Lob
//	    @Column(name="product_picture")
//	    ByteArray productPicture;
	    
		




		@PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
		
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
	    
}
