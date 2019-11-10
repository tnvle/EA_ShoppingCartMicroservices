package cs.mum.edu.accountservice.controllers;

import cs.mum.edu.accountservice.entities.User;
import cs.mum.edu.accountservice.model.UserDTO;
//import cs.mum.edu.accountservice.outerservices.AuthenticateServiceClient;
import cs.mum.edu.accountservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {
    @Autowired
    UserService userService;

//    @Autowired
//    private AuthenticateServiceClient authenticateServiceClient;

    @Value("${NEXT_SERVICE:localhost:8888/validatetoken}")
    private String nextService;

    @GetMapping({"/secret"})
    public String firstPage() {
        return "You are an authenticated user";
    }

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody User user) throws Exception {
        User newUser = userService.saveUser(user);
        return ResponseEntity.ok("user added with id:" + newUser.getId());
    }

    @GetMapping({"/user/{id}"})
    public ResponseEntity<?> getPaymentMethods(@PathVariable(name = "id") String id, @RequestHeader(name="Authorization", required = false) String token) {
//        boolean test = authenticateServiceClient.validateToken(request);

        final String uri = String.format("http://%s/", nextService);
//        boolean result = false;
        try{
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", token);
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Boolean> result =
                    restTemplate.exchange(uri, HttpMethod.GET, entity, Boolean.class);
//            result = restTemplate.getForObject(uri, Boolean.class);
//            restTemplate.postForObject(url, request, ResponseBean.class);


            Integer user_id = Integer.parseInt(id);
            User user = userService.findUser(user_id);

            UserDTO userInfo = new UserDTO();
            userInfo.setId(user.getId());
            userInfo.setAddress(user.getAddress());
            userInfo.setPaypal(user.getPaypal());
            userInfo.setCredit(user.getCredit());
            userInfo.setBank(user.getBank());

            return ResponseEntity.ok(userInfo);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok("Unauthorized");
        }


    }
}
