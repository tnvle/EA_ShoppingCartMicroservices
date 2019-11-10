package cs.mum.edu.accountservice.services;

import cs.mum.edu.accountservice.entities.User;

public interface UserService {

    User saveUser(User user);
    User findUser(Integer id);
}
