package com.moniker.ccbase.controllers;

import com.moniker.ccbase.models.UserModel;
import com.moniker.ccbase.services.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/crud")
@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new UserModel());
        return "crud/add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid UserModel user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAA ERRORSS");
            return "crud/add-user";
        }
        System.out.println("We had no errors");
        userRepository.save(user);
        return "redirect:index";
    }

    // additional CRUD methods
    @GetMapping("/index")
    public String showUserList(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "crud/index";
    }

    @GetMapping("/edit")
    public String showUpdateForm(@RequestParam long id, Model model) {
        UserModel user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("user", user);
        return "crud/update-user";
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam long id, @Valid UserModel user,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "crud/update-user";
        }

        userRepository.save(user);
        return "redirect:index";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam long id, Model model) {
        UserModel user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);
        return "redirect:index";
    }
}
