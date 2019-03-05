package com.codeup.blog.dao;

import com.codeup.blog.models.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends CrudRepository<Post,Long> {
    
    @Query("from Post p where p.title like %:target%")
    List<Post> findByTitleLike(@Param("target") String target);

}
