package org.hrn.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;


@Entity
public class Service extends PanacheEntity {
    @Column(unique = true)
    public String name;
}
