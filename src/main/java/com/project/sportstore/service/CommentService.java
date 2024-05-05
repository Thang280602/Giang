package com.project.sportstore.service;

import com.project.sportstore.model.Comment;

import java.util.List;

/**
 * @author thang
 */
public interface CommentService {
    List<Comment> getAll();
    Boolean create(Comment comment);
    Comment findById(Integer id);
    Boolean delete(Integer id);
}
