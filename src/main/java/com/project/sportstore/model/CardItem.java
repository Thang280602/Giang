package com.project.sportstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

/**
 * @author thang
 */
@Entity
@Table(name = "cardItem")
public class CardItem {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="cardId",referencedColumnName = "id")
    private Card card;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="productId",referencedColumnName = "id")
    private Product product;
    @Column(name="quantity")
    private Integer quantity;
    public CardItem() {
        super();
    }
    public CardItem(Integer id, Card card, Product product, Integer quantity) {
        super();
        this.id = id;
        this.card = card;
        this.product = product;
        this.quantity = quantity;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Card getCard() {
        return card;
    }
    public void setCard(Card card) {
        this.card = card;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }



}
