package com.project.application.InstagramBackend.Repository;

import com.project.application.InstagramBackend.Model.Post;
import com.project.application.InstagramBackend.Model.Repost;
import com.project.application.InstagramBackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


public interface IRepostRepo extends JpaRepository<Repost, Integer> {
    boolean existsByUserAndOriginalPost(User user, Post originalPost);





}
