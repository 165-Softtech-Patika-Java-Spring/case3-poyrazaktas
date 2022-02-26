package com.poyrazaktas.case3poyrazaktas.rev.service.entityservice;

import com.poyrazaktas.case3poyrazaktas.gen.service.BaseEntityService;
import com.poyrazaktas.case3poyrazaktas.rev.dao.RevReviewDao;
import com.poyrazaktas.case3poyrazaktas.rev.entity.RevReview;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevReviewEntityService extends BaseEntityService<RevReview, RevReviewDao> {
    public RevReviewEntityService(RevReviewDao dao) {
        super(dao);
    }

    public List<RevReview> findAllByUserId(Long userId){
        return this.getDao().findAllByUserId(userId);
    }

    public List<RevReview> findAllByProductId(Long productId){
        return this.getDao().findAllByProductId(productId);
    }
}
