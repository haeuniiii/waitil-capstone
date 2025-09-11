package com.waitil.wait_backend.domain.recommendation;

import com.waitil.wait_backend.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recommendations")
public class RecommendationController {

    private final RecommendationService recommendationService;

    @PostMapping
    public Recommendation createRecommendation(@RequestBody Recommendation recommendation) {
        return recommendationService.saveRecommendation(recommendation);
    }

    @GetMapping
    public List<Recommendation> getAllRecommendations() {
        return recommendationService.findAll();
    }

    @GetMapping("/user/{userId}")
    public List<Recommendation> getUserRecommendations(@PathVariable Long userId) {
        User user = User.builder().userId(userId).build();
        return recommendationService.findAllByUser(user);
    }

    @GetMapping("/{id}")
    public Recommendation getRecommendation(@PathVariable Long id) {
        return recommendationService.findById(id);
    }
}
