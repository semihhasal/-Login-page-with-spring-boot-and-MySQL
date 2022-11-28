package com.app;


import com.app.UserCrudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApıController {
    @Autowired
    private UserCrudRepo userRepo;
/*

    @GetMapping(value = "/")
    public String getPage(){

        return "Welcome";
    }

 */
    @GetMapping("/users")
    public List<User> getUsers(){

        return userRepo.findAll();
    }

    @PostMapping("/save")
    public String saveUser(@RequestBody User user){
        userRepo.save(user);

        return "Saved...";
    }


    @PutMapping(value = "update/{id}")
    public String updateUser(@PathVariable long id,@RequestBody User user){

        User updatedUser = userRepo.findById(id).get();
        updatedUser.setUser_Id(user.getUser_Id());
        updatedUser.setPassword(user.getPassword());

        userRepo.save(updatedUser);
        return "updated...";
    }
    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id){

        User deletedUser = userRepo.findById(id).get();
        userRepo.delete(deletedUser);
        return "Delete user with the id : "+id;


    }
}
