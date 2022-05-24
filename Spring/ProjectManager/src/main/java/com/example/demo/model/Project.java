package com.example.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;



@Entity
@Table(name="projects")
public class Project {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @NotEmpty
	    @Size
	    private String title;
	    
	    @NotEmpty
	    @Size
	    private String description;
	    
	    @NotNull
	    @Future
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date duedate;
	    
	    @Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date createdAt;
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;
	    
	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	        name = "project_manger", 
	        joinColumns = @JoinColumn(name = "project_id"), 
	        inverseJoinColumns = @JoinColumn(name = "user_id")
	    )
	    private List<User> users;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="project_leader")
	    private User projectLeader;

	    
		public Project() {
			
		}

		public Project(String title,String description,Date duedate, List<User> users) {
			
			this.title = title;
			this.description = description;
			this.duedate = duedate;
			this.users = users;
		}

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

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Date getDuedate() {
			return duedate;
		}

		public void setDuedate(Date duedate) {
			this.duedate = duedate;
		}

		public List<User> getUsers() {
			return users;
		}

		public void setUsers(List<User> users) {
			this.users = users;
		}
		
		
		
		public User getProjectLeader() {
			return projectLeader;
		}

		public void setProjectLeader(User projectLeader) {
			this.projectLeader = projectLeader;
		}

		// other getters and setters removed for brevity
	    @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
	    

}
