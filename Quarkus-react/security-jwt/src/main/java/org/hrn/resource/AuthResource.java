package org.hrn.resource;

import io.smallrye.jwt.auth.principal.JWTParser;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.hrn.dto.LoginRequest;
import org.hrn.dto.LoginResponse;
import org.hrn.dto.RegisterRequest;
import org.hrn.dto.TokenResponse;
import org.hrn.entity.User;
import org.hrn.service.AuthService;
import org.hrn.service.JwtService;


@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {
    @Inject
    AuthService authService;

    @Inject
    JwtService jwtService;

    @Inject
    JWTParser jwtParser;

    @POST
    @Path("/register")
    public Response registerUser(RegisterRequest registerRequest) {
        authService.register(registerRequest.email,registerRequest.password);
        return Response.ok().build();
    }

    @POST
    @Path("/login")
    public Response loginUser(LoginRequest loginRequest) {
        User user = authService.authenticate(loginRequest.email,loginRequest.password);
        if(user==null) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        TokenResponse token = jwtService.generate(user);
        return Response.ok(token).build();
    }


}
