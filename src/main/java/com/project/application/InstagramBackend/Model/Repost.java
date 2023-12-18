package com.project.application.InstagramBackend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Repost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     private  String email ;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post originalPost;


}

