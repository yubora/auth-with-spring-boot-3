package com.purple.auth.domain.user;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20, nullable = false)
    private String acntId;
    @Column(length = 20, nullable = false)
    private String password;
    @Column(length = 20, nullable = false)
    private String name;
    @Column(columnDefinition = "VARCHAR default 'ACTIVE'", length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusType status;

    @Builder
    public User(Long id, String acntId, String password, String name) {
        this.id = id;
        this.acntId = acntId;
        this.password = password;
        this.name = name;
        this.status = StatusType.ACTIVE;
    }


}
