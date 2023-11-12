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
@Table(name="excursions")
@Getter
@Setter
public class Excursion {
    //id: Long
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id")
    Long id;

    //excursion_title: String
    @Column(name = "excursion_title")
    String excursion_title;

    //excursion_price: BigDecimal
    @Column(name = "excursion_price")
    BigDecimal excursion_price;

    //image_URL: String
    @Column(name = "image_url")
    String image_URL;

    //create_date: Date
    @Column(name = "create_date")
    @CreationTimestamp
    Date create_date;

    //last_update: Date
    @Column(name = "last_Update")
    @UpdateTimestamp
    Date last_update;

    //Many To One( vacation: Vacation )
    @ManyToOne
    @JoinColumn(name="vacation_id",nullable = false)
    Vacation vacation;

    //Many To Many( cartitems:  Set<CartItem> )
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name="excursion_cartitem", joinColumns = @JoinColumn(name="cart_item_id"), inverseJoinColumns = @JoinColumn(name="excursion_id"))
    Set<CartItem> cartitems;

}