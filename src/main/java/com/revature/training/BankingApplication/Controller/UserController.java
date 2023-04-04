package com.revature.training.BankingApplication.Controller;

import com.revature.training.BankingApplication.Exceptions.UnauthorizedUserEcception;
import com.revature.training.BankingApplication.Model.Account;
import com.revature.training.BankingApplication.Model.Users;
import com.revature.training.BankingApplication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin (origins = "*")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    /**- user should be able to make a post to create a user account, first registration with post
    localhost:9000/register
    - user should be able to make a post to login into their account, using post localhost:9000/register
    - user should be able to update or edit their account using their user_id, patch localhost:9000/users/{id}
   */

    @PostMapping("register")
    public Users postUsers(@RequestBody Users user) throws Exception {
        return userService.addUsers(user);
    }

    /** adding the following for login capabilities
    This section handles throwing the exceptions if needed for login endpoint*/
    @PostMapping ("login")
    public ResponseEntity <Users> login(@RequestBody Users users) throws UnauthorizedUserEcception {
        return this.userService.login(users);
    }
    @ExceptionHandler(UnauthorizedUserEcception.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "invalid login credentials")
    public void handleUnauthorized(){}
}


