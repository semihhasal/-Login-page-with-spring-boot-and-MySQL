package com.app;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserCrudRepo extends JpaRepository<User,Long> {
}
