package com.poyrazaktas.case3poyrazaktas.usr.service.entityservice;

import com.poyrazaktas.case3poyrazaktas.gen.service.BaseEntityService;
import com.poyrazaktas.case3poyrazaktas.usr.dao.UsrUserDao;
import com.poyrazaktas.case3poyrazaktas.usr.entity.UsrUser;
import org.springframework.stereotype.Service;

@Service
public class UsrUserEntityService extends BaseEntityService<UsrUser, UsrUserDao> {
    public UsrUserEntityService(UsrUserDao dao) {
        super(dao);
    }
}
