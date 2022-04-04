package com.lab.CodeFellowship.Repositries;

import com.lab.CodeFellowship.Models.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
