package org.hrn.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;


@Entity
public class CustomerOrder extends PanacheEntity {

    @ManyToOne
    public Customer customer;
    @ManyToOne
    public Service service;
    public float price;
}
