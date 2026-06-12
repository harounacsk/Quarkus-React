package org.hrn.dto;

import io.quarkus.hibernate.orm.panache.common.ProjectedFieldName;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class Invoice {
    public Long id;
    public String name;
    public Double amount;

    public Invoice(@ProjectedFieldName("customer.id")Long id, @ProjectedFieldName("customer.name") String name, Double amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }
}
