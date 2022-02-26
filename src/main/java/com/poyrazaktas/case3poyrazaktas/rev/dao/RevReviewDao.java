package com.poyrazaktas.case3poyrazaktas.rev.dao;

import com.poyrazaktas.case3poyrazaktas.rev.entity.RevReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RevReviewDao extends JpaRepository<RevReview, Long> {
    @Query("SELECT review from RevReview review where review.userId=?1")
    List<RevReview> findAllByUserId(Long userId);

    @Query("SELECT review from RevReview review where review.productId=?1")
    List<RevReview> findAllByProductId(Long productId);
}
