package com.example.quara.repositories;

import com.example.quara.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    public User save(User user);


    public List<User> findAll();

    public Optional<User> findById(Long id);

}
