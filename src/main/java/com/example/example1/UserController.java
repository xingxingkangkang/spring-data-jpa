package com.example.example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author A20246
 * @date 2020/7/23
 * @time 16:07
 */
@Controller
@RequestMapping(path = "/demo")
public class UserController {

    @Autowired
    private UserCrudRepository userCrudRepository;

    @GetMapping(path = "/add")
    public void addNewUser(@RequestParam String name, @RequestParam String email){
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userCrudRepository.save(n);
    }

    @GetMapping(path = "/all")
    @ResponseBody
    public Iterable<User> getAllUsers(){
        return userCrudRepository.findAll();
    }

    @GetMapping(path = "/info")
    @ResponseBody
    public Optional<User> findOne(@RequestParam(value = "id", required = false, defaultValue = "1") Integer id){
        return userCrudRepository.findById(id);
    }

    @PostMapping(path = "/delete")
    public void delete(@RequestParam Integer id){
        userCrudRepository.deleteById(id);
    }
}
