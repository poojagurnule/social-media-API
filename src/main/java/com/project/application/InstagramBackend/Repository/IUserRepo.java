package com.project.application.InstagramBackend.Repository;

import com.project.application.InstagramBackend.Model.Admin;
import com.project.application.InstagramBackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface IUserRepo extends JpaRepository<User,Integer> {
    User findFirstByUserEmail(String newEmail);



    Optional<User> findByUserEmail(String userEmail);

    Optional<User> findByUserName(String userName);
}