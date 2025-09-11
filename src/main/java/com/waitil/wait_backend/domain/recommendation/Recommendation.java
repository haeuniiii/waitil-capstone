package com.waitil.wait_backend.domain.recommendation;

import com.waitil.wait_backend.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recommendations")
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recommendationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String type; // EX: PLACE, ACTIVITY

    private String name;

    private String location;

    private String description;

    private String imageUrl;
}
