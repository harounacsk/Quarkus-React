package org.hrn.service;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.hrn.dto.Invoice;
import org.hrn.entity.CustomerOrder;

import java.util.List;

@ApplicationScoped
public class CustomerOrderRepository implements PanacheRepository<CustomerOrder> {
    public List<Invoice> getTopTen() {
       return CustomerOrder.find(
               "SELECT c.id AS id, c.name, ROUND(SUM(co.price),2) AS amount FROM CustomerOrder AS co INNER JOIN Customer AS c ON c.id=co.customer.id GROUP BY co.customer,c.name ORDER BY SUM(co.price) DESC LIMIT 10")
                .project(Invoice.class)
                .list();
    }

}
