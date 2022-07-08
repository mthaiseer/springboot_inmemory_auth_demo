package io.code.inmemoryauth.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guest")
public class GuestContoller {


    @GetMapping
    public String sayGreetings(){
        //this object used to fetch user details from context
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "Hello "+ user.getUsername() + " , welcome!";
    }
}
