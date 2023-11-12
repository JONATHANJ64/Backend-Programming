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
@Table(name="carts")
@Getter
@Setter
public class Cart {
    //id: Long
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    Long id;

    //orderTrackingNumber: String
    @Column(name = "order_tracking_number")
    String order_tracking_number;

    //package_price: BigDecimal
    @Column(name = "package_price")
    BigDecimal package_price;

    //party_size: int
    @Column(name = "party_size")
    int party_size;

    //status: StatusType
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    StatusType status;

    //create_date: Date
    @Column(name = "create_date")
    @CreationTimestamp
    Date create_date;

    //last_update: Date
    @Column(name = "last_Update")
    @UpdateTimestamp
    Date last_update;

    // Many To One( customer: Customer )

    @ManyToOne
    @JoinColumn(name="customer_id", nullable = false)
    Customer customer;

    // One To Many( cartItem: Set<CartItem> )

    @OneToMany(mappedBy = "cart")
    Set<CartItem> cartItem = new HashSet<CartItem>();

    // Adding Item to Cart
    public void add(CartItem item) {
        if (item != null) {
            if (cartItem == null) {
                cartItem = new HashSet<>();
            }

            cartItem.add(item);
            item.setCart(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return id.equals(cart.id);
    }
    //hash id
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}