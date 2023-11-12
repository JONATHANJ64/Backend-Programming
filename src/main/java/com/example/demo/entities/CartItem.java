package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="cart_items")
@Getter
@Setter

public class CartItem {

    //id: Long
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    Long id;

    //vacation: Vacation
    @ManyToOne
    @JoinColumn(name="vacation_id",nullable = false)
    Vacation vacation;

    //Many To Many( excursions: Set<Excursion> )
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name="excursion_cartitem", joinColumns = @JoinColumn(name="cart_item_id"), inverseJoinColumns = @JoinColumn(name="excursion_id"))
    Set<Excursion> excursions = new HashSet<Excursion>();

    //Many To One( cart: Cart)
    @ManyToOne
    @JoinColumn(name="cart_id",nullable = false)
    Cart cart;

    //create_date: Date
    @Column(name = "create_date")
    @CreationTimestamp
    Date create_date;

    //last_update: Date
    @Column(name = "last_update")
    @UpdateTimestamp
    Date last_update;
}