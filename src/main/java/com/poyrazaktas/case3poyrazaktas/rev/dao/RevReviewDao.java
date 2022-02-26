package com.poyrazaktas.case3poyrazaktas.rev.dao;

import com.poyrazaktas.case3poyrazaktas.rev.entity.RevReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RevReviewDao extends JpaRepository<RevReview, Long> {
    List<RevReview> findAllByUserId(Long userId);

    List<RevReview> findAllByProductId(Long productId);
}
