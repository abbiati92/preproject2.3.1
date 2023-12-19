package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.service.UserService;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String printWelcome() {
        return "hello";
    }
    @GetMapping("/new")
    public String addUser() {
        return "new";
    }
    @GetMapping("/change")
    public String changeUser() {
        return "change";
    }
    @GetMapping("/delete")
    public String deleteUser() {
        return "delete";
    }

}
