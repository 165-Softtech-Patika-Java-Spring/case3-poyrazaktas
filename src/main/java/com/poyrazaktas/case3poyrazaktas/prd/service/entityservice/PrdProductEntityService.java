package com.poyrazaktas.case3poyrazaktas.prd.service.entityservice;

import com.poyrazaktas.case3poyrazaktas.gen.service.BaseEntityService;
import com.poyrazaktas.case3poyrazaktas.prd.dao.PrdProductDao;
import com.poyrazaktas.case3poyrazaktas.prd.entity.PrdProduct;
import org.springframework.stereotype.Service;

@Service
public class PrdProductEntityService extends BaseEntityService<PrdProduct, PrdProductDao> {

    public PrdProductEntityService(PrdProductDao dao) {
        super(dao);
    }
}
