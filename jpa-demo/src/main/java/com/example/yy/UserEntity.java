package com.example.yy;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class UserEntity {
    private Long id;
    private String username;
}
