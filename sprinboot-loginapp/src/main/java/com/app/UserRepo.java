package com.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,String>{

    

    @Override
    public Optional<User> findById(String user_Id);






}
