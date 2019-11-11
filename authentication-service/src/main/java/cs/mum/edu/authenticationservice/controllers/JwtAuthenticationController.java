package cs.mum.edu.authenticationservice.controllers;


import cs.mum.edu.authenticationservice.config.JwtTokenUtil;
import cs.mum.edu.authenticationservice.config.JwtUserDetailsService;
import cs.mum.edu.authenticationservice.entities.User;
import cs.mum.edu.authenticationservice.model.JwtRequest;
import cs.mum.edu.authenticationservice.model.JwtResponse;
import cs.mum.edu.authenticationservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Autowired
    private UserService userService;

    @PostMapping("/addAuthenticate")
    public String addCredentail(@RequestBody JwtRequest newAuthenticate) throws Exception {

        //should check username exists or not in db, then add
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(newAuthenticate.getUsername());
//        if(userDetails != null)
//            return ResponseEntity.ok("Username existed in the system!!!");

        User newUser = new User();
        newUser.setUsername(newAuthenticate.getUsername());
        newUser.setPassword(newAuthenticate.getPassword());
        userService.saveUser(newUser);

        return newUser.getUsername();
    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @GetMapping("/validatetoken")
    public Boolean validateToken(){
        return true;
    }


}