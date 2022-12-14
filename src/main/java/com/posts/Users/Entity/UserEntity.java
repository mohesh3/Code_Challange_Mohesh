package com.posts.Users.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class UserEntity {
    @Id
    private int userId;
    private Long id;
    private String title;
    private String body;
}
