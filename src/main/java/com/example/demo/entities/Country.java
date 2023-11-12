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
@Table(name="countries")
@Getter
@Setter
public class Country {

    //id: Long
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    Long id;

    //country_name: String
    @Column(name = "country")
    String country_name;

    //create_date: Date
    @Column(name = "create_date")
    @CreationTimestamp
    Date create_date;

    //last_update: Date
    @Column(name = "last_update")
    @UpdateTimestamp
    Date last_update;

    //One To Many( divisions: Set<Division> )
    @OneToMany(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"} )
    Set<Division> divisions;
}