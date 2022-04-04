package com.lab.CodeFellowship.Repositries;

import com.lab.CodeFellowship.Models.AppUser;
import com.lab.CodeFellowship.Models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
    Post findByAppUser(AppUser appUser);
}
