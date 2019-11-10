package cs.mum.edu.authenticationservice.services;

import cs.mum.edu.authenticationservice.entities.User;

public interface UserService {

    User saveUser(User user);
    User findUser(Integer id);
}
