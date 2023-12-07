package com.example.demo.services;

import com.example.demo.entities.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class Purchase {
    Cart cart;
    Set<CartItem> cartItems;
    Customer customer;
}