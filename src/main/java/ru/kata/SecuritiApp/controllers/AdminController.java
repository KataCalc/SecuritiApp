package ru.kata.SecuritiApp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kata.SecuritiApp.models.User;
import ru.kata.SecuritiApp.service.RoleService;
import ru.kata.SecuritiApp.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleServise;

    @Autowired
    public AdminController(UserService userService, RoleService roleServise) {
        this.userService = userService;
        this.roleServise = roleServise;
    }
    @GetMapping()
    public String showAllUsers(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "admin/show_all_users";
    }
    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleServise.getAllRole());
        return "admin/new";
    }
    @GetMapping("/user/{id}")
    public String showUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userService.getUser(id));
        return "admin/show";
    }
    @PostMapping
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return "admin/new";
        userService.save(user);
        return "redirect:/admin";
    }
    @GetMapping("/user/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("user", userService.getUser(id));
        model.addAttribute("roles", roleServise.getAllRole()); //getAll
        return "admin/edit";
    }
    @PatchMapping("/user/{id}")
    public String update(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult, @PathVariable("id") int id){
        if (bindingResult.hasErrors())
            return "admin/edit";

        userService.update(user);
        return "redirect:/admin";
    }
    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable("id") int id){
        userService.delete(id);
        return "redirect:/admin";
    }
}
