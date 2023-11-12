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
@Table(name="customers")
@Getter
@Setter
public class Customer {

    //id: Long
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    long id;

    //firstName: String
    @Column(name = "customer_first_name")
    String firstName;

    //lastName: String
    @Column(name = "customer_last_name")
    String lastName;

    //address: String
    @Column(name = "address")
    String address;

    //postal_code: String
    @Column(name = "postal_code")
    String postal_code;

    //phone: String
    @Column(name = "phone")
    String phone;

    //create_date: Date
    @Column(name = "create_date")
    @CreationTimestamp
    Date create_date;

    //last_update: Date
    @Column(name = "last_update")
    @UpdateTimestamp
    Date last_update;

    //Many To One( division: Division )
    @ManyToOne
    @JoinColumn(name="division_id") //, nullable = false)
    Division division;

    //One To Many( carts: Set<Cart> )
    @OneToMany(mappedBy = "customer")
    Set<Cart> carts = new HashSet<Cart>();

}