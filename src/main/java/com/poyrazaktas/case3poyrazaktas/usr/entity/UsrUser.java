package com.poyrazaktas.case3poyrazaktas.usr.entity;

import com.poyrazaktas.case3poyrazaktas.usr.enums.UsrUserType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "USR_USER")
@Getter
@Setter
public class UsrUser {

    @Id
    @GeneratedValue(generator = "UsrUser")
    @SequenceGenerator(name = "UsrUser", sequenceName = "SEQ_USR_USER")
    private Long id;

    @Column(name = "USER_NAME",length = 30,unique = true,nullable = false)
    private String userName;

    @Column(name = "EMAIL",unique = true,nullable = false)
    private String email;

    @Column(name = "PHONE",unique = true,nullable = false)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "USER_TYPE", length = 30,nullable = false)
    private UsrUserType userType;

}
