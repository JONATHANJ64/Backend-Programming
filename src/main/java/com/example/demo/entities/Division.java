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
@Table(name="divisions")
@Getter
@Setter
public class Division {

    //id: Long
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    Long id;

    //division_name: String
    @Column(name = "division")
    String division_name;

    //create_date: Date
    @Column(name = "create_date")
    @CreationTimestamp
    Date create_date;

    //last_update: Date
    @Column(name = "last_Update")
    @UpdateTimestamp
    Date last_update;

    //Many To One( country: Country )
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="country_id", nullable = false, insertable = false, updatable = false)
    Country country;

    //country_id: Long
    @Column(name = "country_id")
    Long country_id;
    public void setCountry(Country country) {
        setCountry_id(country.getId());
        this.country = country;
    }
    //One To Many( customers: Set<Customer> )
    @OneToMany(mappedBy="division")
    Set<Customer> customers = new HashSet<Customer>();

}