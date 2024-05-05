package com.project.sportstore.repository;

import com.project.sportstore.model.Card;
import com.project.sportstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author thang
 */
public interface CardRepository extends JpaRepository<Card, Integer> {
    @Query("SELECT COUNT(*) FROM Card c WHERE c.user.id=?1")
    Long countId(Long idUser);
    List<Card> findByUser(User user);
}
