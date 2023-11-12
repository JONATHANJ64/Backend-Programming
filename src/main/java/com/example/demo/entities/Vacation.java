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
@Table(name="vacations")
@Getter
@Setter
public class Vacation {

    //id: Long
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    Long id;

    //vacation_title: String
    @Column(name = "vacation_title")
    String vacation_title;

    //description: String
    @Column(name = "description")
    String description;

    //travel_price: BigDecimal
    @Column(name = "travel_fare_price")
    BigDecimal travel_price;

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

    //One To Many ( excursions: Set<Excursion> )
    @OneToMany(mappedBy = "vacation", fetch = FetchType.EAGER) ]
    Set<Excursion> excursions;

}