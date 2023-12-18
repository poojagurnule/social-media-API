package com.project.application.InstagramBackend.Controller;

import com.project.application.InstagramBackend.Model.User;
import com.project.application.InstagramBackend.Service.PostService;
import com.project.application.InstagramBackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    UserService userService ;

    @Autowired
    PostService postService;

    @GetMapping("/getAll")
    public List<User> getAllUser(){
           return userService.getAllUser();
    }

    @GetMapping("/{id}")

    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/user")

    public ResponseEntity<String> deleteUser(@RequestParam String userName) {
        try {
            userService.deleteUserByUsername(userName);
            return ResponseEntity.ok("User deleted successfully.");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting user.");
        }
    }


    @DeleteMapping("/delete/post")
    public ResponseEntity<String> deletePost(@RequestParam Integer PostId) {
        try {
            postService.deletePostById(PostId);
            return ResponseEntity.ok("Post deleted successfully.");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found.");
        }
    }


}
