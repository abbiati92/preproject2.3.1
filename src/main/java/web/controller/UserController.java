package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.Users;
import web.service.UserService;

@Controller
@RequestMapping()
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getUsersList());
        return "users";
    }
    @GetMapping("/new")
    public String getCreateNewUserForm(Model model) {
        model.addAttribute(new Users());
        return "new_user";
    }

    @PostMapping("/")
    public String addUser(@ModelAttribute("user") Users user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/deleteUser")
    public String removeUser(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @PutMapping("/updateUser")
    public String getEditUserForm(Model model, @RequestParam("id") int id) {
        model.addAttribute("user", userService.getUser(id));
        return "edit_user";
    }

    @PutMapping("/edit")
    public String editUser(@ModelAttribute("user") Users users) {
        userService.editUser(users);
        return "redirect:/";
    }

}
