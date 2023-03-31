package com.revature.training.BankingApplication.Controller;

import com.revature.training.BankingApplication.Exceptions.UnauthorizedUserEcception;
import com.revature.training.BankingApplication.Model.Account;
import com.revature.training.BankingApplication.Model.Users;
import com.revature.training.BankingApplication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    /*- user should be able to make a post to create a user account, first registration with post
    localhost:9000/register
    - user should be able to make a post to login into their account, using post localhost:9000/register
    - user should be able to update or edit their account using their user_id, patch localhost:9000/users/{id}
   */

    //    @PostMapping("register")
//    public User postRegister(@RequestBody User user) throws Exception{
//        return userService.registerUser(user);
//    }
//
//    @PostMapping("login")
//    public User postLogin(@RequestBody User user) throws Exception{
//        return userService.userLogin(user);
//    }
//
    @GetMapping("users")
    public List<Users> getUsers() throws Exception {
        return userService.getAllUsers();
    }

    /**
     * get a specific user by the user's id, using the request verb GET localhost:9000/users/{id}
     **/
    //get by user id fail
    @GetMapping("users/{id}")
    public Users getUserById(@PathVariable("id") long id) {
        return userService.getUserById(id);
    }

    /**
     * This endpoint responds with users associated account, the endpoint
     * GET localhost:/9000/users/{id}/account is used for this.
     */
    @GetMapping("users/{id}/accounts")
    public List<Account> getUserId(@PathVariable("id") long id) throws Exception {
        return userService.getUserAccount(id);
    }

    /**
     * Make a Post request
     **/
    @PostMapping("register")
    public Users postUsers(@RequestBody Users user) throws Exception {
        return userService.addUsers(user);
    }

    /*
    user should be able to delete their lastname using the delete request. The @DeleteMapping helps to make it
    easier*/
    @DeleteMapping("users/{id}")
    public Users del(@PathVariable("id") long id) throws Exception {
        return userService.deleteUser(id);
    }

    // adding the following for login capabilities
    // This section handles throwing the exceptions if needed for login endpoint
    @PostMapping("login")
    public Users login(@RequestBody Users users) throws UnauthorizedUserEcception {
        return userService.login(users);
    }
    @ExceptionHandler(UnauthorizedUserEcception.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "invalid login credentials")
    public void handleUnauthorized(){}
}


