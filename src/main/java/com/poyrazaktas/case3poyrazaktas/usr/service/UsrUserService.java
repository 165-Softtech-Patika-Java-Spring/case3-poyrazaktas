package com.poyrazaktas.case3poyrazaktas.usr.service;

import com.poyrazaktas.case3poyrazaktas.gen.exception.ItemNotFoundException;
import com.poyrazaktas.case3poyrazaktas.usr.converter.UsrUserMapper;
import com.poyrazaktas.case3poyrazaktas.usr.dto.UsrUserDeleteReqDto;
import com.poyrazaktas.case3poyrazaktas.usr.dto.UsrUserDto;
import com.poyrazaktas.case3poyrazaktas.usr.dto.UsrUserSaveReqDto;
import com.poyrazaktas.case3poyrazaktas.usr.dto.UsrUserUpdateReqDto;
import com.poyrazaktas.case3poyrazaktas.usr.entity.UsrUser;
import com.poyrazaktas.case3poyrazaktas.usr.enums.UsrUserErrorMessage;
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

        UsrUser user = userEntityService.findById(id).orElseThrow(()-> new ItemNotFoundException(UsrUserErrorMessage.ITEM_NOT_FOUND));

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

    public void delete(Long id, UsrUserDeleteReqDto userDeleteReqDto){
        UsrUser user = userEntityService.findById(id).orElseThrow(()-> new ItemNotFoundException(UsrUserErrorMessage.ITEM_NOT_FOUND));
        checkIfUserPhoneIsMatches(user,userDeleteReqDto);
        userEntityService.delete(user);

    }

    private void checkIfUserPhoneIsMatches(UsrUser user,UsrUserDeleteReqDto userDeleteReqDto) {
        if(!user.getPhone().equals(userDeleteReqDto.getPhone())){
            throw new RuntimeException(String.format("%s kullanıcı adı ile %s telefon bilgileri uyuşmamaktadır.", userDeleteReqDto.getUserName(),userDeleteReqDto.getPhone()));
        }
    }

    public UsrUserDto findByUserName(String userName){
        UsrUser user = userEntityService.findByUserName(userName).orElseThrow(()-> new ItemNotFoundException(UsrUserErrorMessage.ITEM_NOT_FOUND));
        return UsrUserMapper.INSTANCE.convertToUserDto(user);
    }

}
