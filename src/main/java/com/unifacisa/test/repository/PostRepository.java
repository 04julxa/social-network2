package com.unifacisa.test.repository;

import com.unifacisa.test.model.Post;
import com.unifacisa.test.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

}

