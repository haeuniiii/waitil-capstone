package com.waitil.wait_backend.domain.recommendation;

import com.waitil.wait_backend.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {

    // 특정 사용자가 요청한 추천 리스트 조회
    List<Recommendation> findByUser(User user);
}