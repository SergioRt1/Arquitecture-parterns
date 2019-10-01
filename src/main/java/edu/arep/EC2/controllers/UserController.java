package edu.arep.EC2.controllers;

import edu.arep.EC2.Router;
import edu.arep.EC2.entities.User;
import edu.arep.EC2.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(Router.USER)
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public @ResponseBody List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping(Router.BY_ID)
    public @ResponseBody User getById(@PathVariable int id) {
        return userService.getById(id);
    }

    @PostMapping
    public @ResponseBody int saveUser(@RequestBody User user) {
        return userService.save(user);
    }
}
