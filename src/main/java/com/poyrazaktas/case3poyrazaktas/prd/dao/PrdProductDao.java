package com.poyrazaktas.case3poyrazaktas.prd.dao;

import com.poyrazaktas.case3poyrazaktas.prd.entity.PrdProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrdProductDao extends JpaRepository<PrdProduct,Long> {
}
