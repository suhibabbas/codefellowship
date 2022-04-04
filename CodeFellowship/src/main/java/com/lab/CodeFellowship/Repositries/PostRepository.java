package com.lab.CodeFellowship.Repositries;

import com.lab.CodeFellowship.Models.AppUser;
import com.lab.CodeFellowship.Models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findByAppUser(AppUser appUser);
}
