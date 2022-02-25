package com.poyrazaktas.case3poyrazaktas.usr.service.entityservice;

import com.poyrazaktas.case3poyrazaktas.gen.service.BaseEntityService;
import com.poyrazaktas.case3poyrazaktas.usr.dao.UsrUserDao;
import com.poyrazaktas.case3poyrazaktas.usr.entity.UsrUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsrUserEntityService extends BaseEntityService<UsrUser, UsrUserDao> {
    public UsrUserEntityService(UsrUserDao dao) {
        super(dao);
    }

    public Optional<UsrUser> findByUserName(String userName){
        return getDao().findByUserName(userName);
    }
}
