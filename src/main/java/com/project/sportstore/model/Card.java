package com.project.sportstore.model;

import jakarta.persistence.*;

import java.util.Set;

/**
 * @author thang
 */
@Entity
@Table(name = "card")
public class Card {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name="userId",referencedColumnName = "id")
    private User user;
    @OneToMany(mappedBy = "card",fetch = FetchType.EAGER)
    private Set<CardItem> cardItems;
    public Card() {
        super();
    }
    public Card(Integer id, User user, Set<CardItem> cardItems) {
        super();
        this.id = id;
        this.user = user;
        this.cardItems = cardItems;
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
    public Set<CardItem> getCardItems() {
        return cardItems;
    }
    public void setCardItems(Set<CardItem> cardItems) {
        this.cardItems = cardItems;
    }
    public Double totalPrice(){
        Double total =0.0;
        for(CardItem cardItem :cardItems){
            total +=cardItem.getQuantity()*cardItem.getProduct().getPrice();
        }
        return total;
    }
}