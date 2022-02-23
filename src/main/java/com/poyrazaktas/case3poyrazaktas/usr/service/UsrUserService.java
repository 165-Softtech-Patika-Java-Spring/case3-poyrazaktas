package com.poyrazaktas.case3poyrazaktas.usr.service;

import com.poyrazaktas.case3poyrazaktas.gen.exception.ItemNotFoundException;
import com.poyrazaktas.case3poyrazaktas.usr.converter.UsrUserMapper;
import com.poyrazaktas.case3poyrazaktas.usr.dto.UsrUserDto;
import com.poyrazaktas.case3poyrazaktas.usr.dto.UsrUserSaveReqDto;
import com.poyrazaktas.case3poyrazaktas.usr.dto.UsrUserUpdateReqDto;
import com.poyrazaktas.case3poyrazaktas.usr.entity.UsrUser;
import com.poyrazaktas.case3poyrazaktas.usr.service.entityservice.UsrUserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsrUserService {
    private final UsrUserEntityService userEntityService;

    public List<UsrUserDto> findAll(){

        List<UsrUser> userList = userEntityService.findAll();

        return UsrUserMapper.INSTANCE.convertToUserDtoList(userList);
    }

    public UsrUserDto get(Long id){

        UsrUser user = userEntityService.findById(id).orElseThrow(()-> new ItemNotFoundException("User not found!"));

        return UsrUserMapper.INSTANCE.convertToUserDto(user);
    }

    public UsrUserDto save(UsrUserSaveReqDto userSaveReqDto){

        UsrUser user = UsrUserMapper.INSTANCE.convertToUser(userSaveReqDto);
        user = userEntityService.save(user);

        return UsrUserMapper.INSTANCE.convertToUserDto(user);
    }

    public UsrUserDto update(UsrUserUpdateReqDto userUpdateReqDto){

        UsrUser user = UsrUserMapper.INSTANCE.convertToUser(userUpdateReqDto);
        user = userEntityService.save(user);

        return UsrUserMapper.INSTANCE.convertToUserDto(user);
    }

    public void delete(Long id){
        UsrUser user = userEntityService.findById(id).orElseThrow(()-> new ItemNotFoundException("User not found!"));
        userEntityService.delete(user);
    }

}
