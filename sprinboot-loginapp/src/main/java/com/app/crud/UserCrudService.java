package com.app.crud;
/*
import com.app.User;
import com.app.crud.UserCrudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserCrudService  {

    @Autowired
    private UserCrudRepo userCrudRepo;

    public User saveUser(User user){
        return userCrudRepo.save(user);
    }

    public List<User> saveUsers(List<User> user){
        return userCrudRepo.saveAll(user);
    }


    public List<User> findAllUsers(){
        return userCrudRepo.findAll();
    }

    public User getUserByCrudId(int crudId){
        return userCrudRepo.findById(crudId).orElse(null);

    }
    public User getUserByUser_Id(String user_Id){
        return userCrudRepo.findByName(user_Id);

    }
    public String deleteUserByCrudId(int crudID){

        userCrudRepo.deleteById(crudID);
        return "User removed..." + crudID;
    }
    public User updateUser(User user){
        User existingUser = userCrudRepo.findById(user.getCrudId()).orElse(null);
        existingUser.setUser_Id(user.getUser_Id());
        existingUser.setPassword(user.getPassword());
        return userCrudRepo.save(existingUser);

    }
}


 */

