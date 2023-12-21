package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.Users;
import web.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("ListOfUsers", userService.getAllUsers());
        return "hello";
    }

    @GetMapping("/new")
    public String addUser(@ModelAttribute("users") Users users) {
        return "new";
    }
    @PostMapping("/")
    public String create(@ModelAttribute("users") @Valid Users users) {
        userService.addUser(users);
        return "redirect:/";
    }


    @GetMapping("/edit")
    public String editUser(@RequestParam("id") int id, Model model) {
        model.addAttribute("editUser" , userService.getUserById(id));
        return "edit";
    }
    @PatchMapping("/edit")
    public String update(@RequestParam("id") int id, @ModelAttribute("editUsers") @Valid Users updateUsers) {
        userService.editUser(id, updateUsers);
        return "redirect:/";
    }


    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

}
