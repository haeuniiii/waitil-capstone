package com.waitil.wait_backend.domain.user;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true)
    private String socialId;

    @Column(nullable = false)
    private String provider;

    @Column(nullable = false)
    private String nickname;

    private String profileImage;

    @Column(nullable = false, updatable = false, insertable = false,
            columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private String createdAt;
}
