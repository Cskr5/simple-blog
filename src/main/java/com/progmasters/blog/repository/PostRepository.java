package com.progmasters.blog.repository;

import com.progmasters.blog.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    //List<Post> findAllByOrOrderByCreatedAtAsc();

    @Query("SELECT p FROM Post p ORDER BY p.createdAt DESC")
    List<Post> findAllByDateDesc();
}
