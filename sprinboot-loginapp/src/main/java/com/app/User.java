package com.app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Set;


@Data
@Entity
@Table(name ="user")
public class User {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)




    private String user_Id;
    private String password;






    public String getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(String user_Id) {
        this.user_Id = user_Id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}