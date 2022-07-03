package com.example.Code_Sharing_Platform.CascadeTAsk;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerId;

    @Column(name = "customer_name")
    private String customerName;

//    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE, orphanRemoval=true)
//    private List<Order> orders = new ArrayList<>();


    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();


    public Customer() {
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }


    public Customer(long customerId, String customerName, List<Order> orders) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", orders=" + orders +
                '}';
    }
}
