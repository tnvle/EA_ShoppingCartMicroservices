package cs.mum.edu.authenticationservice.services.impl;

import cs.mum.edu.authenticationservice.entities.User;
import cs.mum.edu.authenticationservice.repositories.UserRepository;
import cs.mum.edu.authenticationservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    public User saveUser(User user) {
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userRepository.save(user);
}

    public User findUser(Integer id) {
        return userRepository.findById(id).get();
    }
}
