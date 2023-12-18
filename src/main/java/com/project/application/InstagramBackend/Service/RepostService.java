package com.project.application.InstagramBackend.Service;

import com.project.application.InstagramBackend.Model.Post;
import com.project.application.InstagramBackend.Model.Repost;
import com.project.application.InstagramBackend.Model.User;
import com.project.application.InstagramBackend.Repository.IPostRepo;
import com.project.application.InstagramBackend.Repository.IRepostRepo;

import com.project.application.InstagramBackend.Repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



@Service
public class RepostService {
    @Autowired
    IRepostRepo repostRepo ;

    @Autowired
    IUserRepo userRepo ;
@Autowired
IPostRepo postRepo ;
    public  String repost(Integer originalPostId, String email) {


        User user =userRepo.findByUserEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));


        Post originalPost = postRepo.findById(originalPostId)
                .orElseThrow(() -> new RuntimeException("Original post not found"));

        // Check if the user has already reposted this post
        if (repostRepo.existsByUserAndOriginalPost(user, originalPost)) {
            return "You have already reposted this post";
        }

        // Create a new repost relationship
        Repost repost = new Repost();
        repost.setUser(user);
        repost.setOriginalPost(originalPost);

        repostRepo.save(repost);

        return "Post reposted successfully";
    }

}
