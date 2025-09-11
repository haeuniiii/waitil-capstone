package com.waitil.wait_backend.domain.recommendation;

import com.waitil.wait_backend.domain.user.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RecommendationService {

    private final RecommendationRepository recommendationRepository;

    public Recommendation saveRecommendation(Recommendation recommendation) {
        return recommendationRepository.save(recommendation);
    }

    public List<Recommendation> findAllByUser(User user) {
        return recommendationRepository.findByUser(user);
    }

    public List<Recommendation> findAll() {
        return recommendationRepository.findAll();
    }

    public Recommendation findById(Long id) {
        return recommendationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 추천이 존재하지 않습니다. ID = " + id));
    }
}
