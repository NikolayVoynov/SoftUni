package com.example.examspringfund.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity{

    private String fullname;
    private String password;
    private String email;
    private String username;

    public UserEntity() {
    }

    @Column(nullable = false)
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String firstName) {
        this.fullname = firstName;
    }


    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(unique = true, nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(nullable = false, unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
//    public Set<OrderEntity> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(Set<OrderEntity> orders) {
//        this.orders = orders;
//    }
}
