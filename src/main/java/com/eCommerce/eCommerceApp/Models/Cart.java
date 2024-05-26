package com.eCommerce.eCommerceApp.Models;
import jakarta.persistence.*;
import org.apache.catalina.User;

import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Users user;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems;


    public Cart() {
    }

    public Cart(Users user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return (User) user;
    }

    public void setUser(User user) {
        this.user = (Users) user;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
