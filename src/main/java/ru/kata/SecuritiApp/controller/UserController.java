package ru.kata.SecuritiApp.controller;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.SecuritiApp.model.User;
import ru.kata.SecuritiApp.service.RoleService;
import ru.kata.SecuritiApp.service.UserService;

import javax.security.sasl.AuthenticationException;


@Controller
@RequestMapping("/user")
public class UserController {


    private final UserService userService;
    private final RoleService roleService;



    public UserController(UserService userService, RoleService roleService) {

        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("{id}")
    String getUser(@PathVariable("id") int id, Model model) throws AuthenticationException {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (currentUser.getRoles().stream().allMatch(r -> r.getRoleName().equals("ROLE_USER")) && !(currentUser.getId() == id)) {
            throw new AuthenticationException();
        }
        model.addAttribute("user", userService.getUser(id));
        return "users/show";
    }

    @GetMapping("/user/new")
    public String newUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("allRoles", roleService.getAllRole());
        return "users/show";
    }
}