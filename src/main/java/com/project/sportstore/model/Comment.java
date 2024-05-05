package com.project.sportstore.model;

import jakarta.persistence.*;

/**
 * @author thang
 */
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="userId",referencedColumnName = "id")
    private User user;
    @Column(name="content")
    private String content;
    public Comment() {
        super();
    }
    public Comment(Integer id, User user, String content) {
        super();
        this.id = id;
        this.user = user;
        this.content = content;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}