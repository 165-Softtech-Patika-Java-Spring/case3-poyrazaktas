package com.poyrazaktas.case3poyrazaktas.rev.dao;

import com.poyrazaktas.case3poyrazaktas.rev.entity.RevReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevReviewDao extends JpaRepository<RevReview,Long> {
}
