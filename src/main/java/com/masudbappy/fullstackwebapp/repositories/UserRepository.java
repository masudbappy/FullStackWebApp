package com.masudbappy.fullstackwebapp.repositories;

import com.masudbappy.fullstackwebapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);

    List<User> findByNameLike(String name);
}
