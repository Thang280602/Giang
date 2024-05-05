package com.project.sportstore.service;

import com.project.sportstore.model.Comment;
import com.project.sportstore.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author thang
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Boolean create(Comment comment) {
        try {
            this.commentRepository.save(comment);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public List<Comment> getAll() {
        // TODO Auto-generated method stub
        return this.commentRepository.findAll();
    }

    @Override
    public Comment findById(Integer id) {
        // TODO Auto-generated method stub
        return this.commentRepository.findById(id).get();
    }

    @Override
    public Boolean delete(Integer id) {
        try {
            this.commentRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
