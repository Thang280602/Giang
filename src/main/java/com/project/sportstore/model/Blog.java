package com.project.sportstore.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "blog")
public class Blog {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name =  "blogName",length=4000)
	private String blogName;
	@Column(name = "blogImage")
	private String blogImage;
	@Lob
	@Column(name = "blogContent",columnDefinition = "text")
	private String blogContent;
	@Column(name = "date")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	public Blog() {
		super();
	}
	public Blog(Integer id, String blogName, String blogImage, String blogContent, Date date) {
		super();
		this.id = id;
		this.blogName = blogName;
		this.blogImage = blogImage;
		this.blogContent = blogContent;
		this.date = date;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBlogName() {
		return blogName;
	}
	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}
	public String getBlogImage() {
		return blogImage;
	}
	public void setBlogImage(String blogImage) {
		this.blogImage = blogImage;
	}
	public String getBlogContent() {
		return blogContent;
	}
	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
