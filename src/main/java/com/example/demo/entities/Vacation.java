package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="vacations")
@Getter
@Setter
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    Long id;

    @Column(name = "vacation_title")
    String vacation_title;

    @Column(name = "description")
    String description;

    @Column(name = "image_url")
    String image_URL;

    @Column(name = "travel_fare_price")
    BigDecimal travel_price;

    @OneToMany(mappedBy = "vacation", fetch = FetchType.EAGER) // ORIG
    Set<Excursion> excursions;

    @Column(name = "create_date")
    @CreationTimestamp
    Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    Date last_update;
}