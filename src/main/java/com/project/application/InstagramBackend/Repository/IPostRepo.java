package com.project.application.InstagramBackend.Repository;

import com.project.application.InstagramBackend.Model.Admin;
import com.project.application.InstagramBackend.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface IPostRepo extends JpaRepository<Post,Integer> {
}