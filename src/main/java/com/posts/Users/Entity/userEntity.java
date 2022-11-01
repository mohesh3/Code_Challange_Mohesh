package com.posts.Users.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
//@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class userEntity{
    @Id
    private int userId;
    private Long id;
    private String title;
    private String body;
}
