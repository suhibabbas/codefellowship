package com.lab.CodeFellowship.Repositries;

import com.lab.CodeFellowship.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
