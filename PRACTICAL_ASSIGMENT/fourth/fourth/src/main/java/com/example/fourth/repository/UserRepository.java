package com.example.fourth.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.fourth.entity.User;


public interface UserRepository extends JpaRepository<User,Integer>{

}