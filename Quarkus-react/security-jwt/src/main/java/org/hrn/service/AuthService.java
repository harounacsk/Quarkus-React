package org.hrn.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.hrn.entity.User;
import org.mindrot.jbcrypt.BCrypt;

@ApplicationScoped
public class AuthService {

    @Transactional
    public void register(String email,String password) {
        if(User.find("email",email).firstResult()!=null) {
            throw new RuntimeException("Email already exists");
        }
        User user = new User();
        user.email = email;
        user.password = BCrypt.hashpw(password,BCrypt.gensalt());
        user.role = "USER";
        user.persist();
    }


    public User authenticate( String email,  String password) {
        User user = User.find("email", email).firstResult();
        if(user == null) {
            return null;
        }
        if(!BCrypt.checkpw(password, user.password)) {
            return null;
        }
        return user;
    }

}
