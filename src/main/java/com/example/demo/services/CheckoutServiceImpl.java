package com.example.demo.services;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import com.example.demo.entities.StatusType;
import com.example.demo.dao.CartRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.UUID;


@Service
public class CheckoutServiceImpl implements CheckoutService{
    private CustomerRepository customerRepository;
    private CartRepository cartRepository;


    public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;

    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        Cart cart = purchase.getCart();

        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> cart.add(item));

        // Set the customer for the cart
        Customer customer = purchase.getCustomer();
        cart.setCustomer(customer);
        cartRepository.save(cart);

        // Handle null customer or empty cart items
        if (customer == null || cartItems.isEmpty()) {
            throw new IllegalArgumentException("Customer cannot be null and cart items cannot be empty.");
        }

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

        return UUID.randomUUID().toString();

    }

}