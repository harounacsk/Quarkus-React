package org.hrn.resource;


import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.SecurityContext;
import org.hrn.dto.Invoice;
import org.hrn.service.CustomerOrderRepository;

import java.util.List;

@Path("/users")
public class UserResource {
    @Inject
    CustomerOrderRepository customerOrderRepository;

    @GET
    @Path("/me")
    @RolesAllowed({"USER","ADMIN"})
    public  String me(@Context SecurityContext ctx){
        String username = ctx.getUserPrincipal().getName();
        return  "you welcome " + username +"!";
    }

    @GET
    @RolesAllowed({"USER","ADMIN"})
    @Path("ten")
    public List<Invoice> topTen(){
        return customerOrderRepository.getTopTen();
    }
}
