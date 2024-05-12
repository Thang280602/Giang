package com.project.sportstore.model;

/**
 * @author thang
 */
import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="userId",referencedColumnName = "id")
    private User user;
    @Column(name ="addressShip")
    private String addressShip;
    @Column(name ="phone")
    private String phone;
    @Column(name ="status")
    private Integer status;
    @Column(name ="createAt")
    private Date createAt;
    public Order() {
        super();
    }
    public Order(Integer id, User user, String addressShip, String phone, Integer status, Date createAt) {
        super();
        this.id = id;
        this.user = user;
        this.addressShip = addressShip;
        this.phone = phone;
        this.status = status;
        this.createAt = createAt;
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

    public String getAddressShip() {
        return addressShip;
    }

    public void setAddressShip(String addressShip) {
        this.addressShip = addressShip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}