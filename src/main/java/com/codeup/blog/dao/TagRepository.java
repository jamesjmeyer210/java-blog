package com.codeup.blog.dao;

import com.codeup.blog.models.Tag;
import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag,Long> {

}
