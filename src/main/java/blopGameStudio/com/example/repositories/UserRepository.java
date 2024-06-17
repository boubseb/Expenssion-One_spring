package blopGameStudio.com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import blopGameStudio.com.example.models.User;

public interface UserRepository extends JpaRepository<User,String> {

    User findByPseudo(String pseudo); 
}
