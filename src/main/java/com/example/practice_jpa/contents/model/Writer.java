package com.example.practice_jpa.contents.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Writer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long writerId;

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone")
    private String phone;
}
