package com.masudbappy.fullstackwebapp.repositories;

import com.masudbappy.fullstackwebapp.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
