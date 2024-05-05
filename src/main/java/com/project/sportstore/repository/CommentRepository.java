package com.project.sportstore.repository;

/**
 * @author thang
 */
import com.project.sportstore.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CommentRepository extends JpaRepository<Comment, Integer>{

}
