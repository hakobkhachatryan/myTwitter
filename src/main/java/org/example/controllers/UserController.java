package org.example.controller;

import jakarta.validation.Valid;
import org.example.DAO.UserDAO;
import org.example.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/myTwitter")
public class UserController {
    private final UserDAO userDAO;

    @Autowired
    public UserController(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @GetMapping
    public String users(){
        String x = "";
        List<User> users = userDAO.findAll();
        for (int i = 0; i < users.size(); i++) {
            x+=users.get(i).toString();
        }
        return x;
    }

    @GetMapping("/{id}")
    public String user(@PathVariable("id") int id){
        return userDAO.findById(id).toString();
    }

    @PostMapping("/register")
    public void register(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return;
        userDAO.save(user);
    }

    @PutMapping("/update/{id}")
    public void update(@ModelAttribute("person") User user,@PathVariable("id") int id){
        userDAO.update(id,user);
//        System.out.println(personDAO.show(id).getString());
    }






}
