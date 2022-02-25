package com.poyrazaktas.case3poyrazaktas.usr.dao;

import com.poyrazaktas.case3poyrazaktas.usr.entity.UsrUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsrUserDao extends JpaRepository<UsrUser,Long> {
    @Query("SELECT u from UsrUser u where u.userName=?1")
    Optional<UsrUser> findByUserName(String userName);

}
