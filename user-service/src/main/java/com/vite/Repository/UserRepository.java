package com.vite.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vite.Model.User;

public interface UserRepository extends JpaRepository<User,Long>{
    
}
