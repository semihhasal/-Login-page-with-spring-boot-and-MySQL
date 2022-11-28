package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired(required = true)
    private UserRepo userRepo;

    @GetMapping("/")
    public String login(Model model){
       User user =new User();
       model.addAttribute("user",user);
        return "login";
    }
/*
    @GetMapping("/users")
    public List<User> getUsers(){

        return userRepo.findAll();
    }

 */

/*
    @PostMapping("/save")
    public String saveUser(@RequestBody User user){
        userRepo.save(user);

        return "Saved...";
    }

 */
    /*
    @PutMapping(value = "update/{id}")
    public String updateUser(@PathVariable long id,@RequestBody User user){
        String userId =user.getUser_Id();
        Optional<User> userdata = userRepo.findById(userId);
        User updatedUser = new User();
        updatedUser.setUser_Id(user.getUser_Id());
        updatedUser.setPassword(user.getPassword());

        userRepo.save(updatedUser);
        return "updated...";
    }

     */
  /*  @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id,@RequestBody User user){

        String userId =user.getUser_Id();
        Optional<User> deletedUser = userRepo.findById(userId);
        userRepo.delete(deletedUser);
        return "Delete user with the id : "+id;


    }

   */
    @PostMapping("/userLogin")
    public String loginUser(@ModelAttribute("user") User user ){
        String userId =user.getUser_Id();
        Optional<User> userdata = userRepo.findById(userId);
        if (user.getPassword().equals(userdata.get().getPassword())){

            return "output.txt";
        }
        else {
            return "error";
        }

    }



}
