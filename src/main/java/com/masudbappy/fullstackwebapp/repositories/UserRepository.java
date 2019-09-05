package com.masudbappy.fullstackwebapp.repositories;

import com.masudbappy.fullstackwebapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
