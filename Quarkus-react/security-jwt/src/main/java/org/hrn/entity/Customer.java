package org.hrn.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Customer extends PanacheEntity {
    public String name;
    public String address;
}
