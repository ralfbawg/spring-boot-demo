package com.example.yy.user.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="user")
@Data
public class UserEntity {
    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue
    private Long id;
    @Column(name ="username")
    private String username;
    @Column(name="age")
    private int age;
}
