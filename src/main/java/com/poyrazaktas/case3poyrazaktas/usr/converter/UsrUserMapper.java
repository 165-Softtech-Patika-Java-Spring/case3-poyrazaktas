package com.poyrazaktas.case3poyrazaktas.usr.converter;

import com.poyrazaktas.case3poyrazaktas.usr.dto.UsrUserDto;
import com.poyrazaktas.case3poyrazaktas.usr.dto.UsrUserSaveReqDto;
import com.poyrazaktas.case3poyrazaktas.usr.dto.UsrUserUpdateReqDto;
import com.poyrazaktas.case3poyrazaktas.usr.entity.UsrUser;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsrUserMapper {
    UsrUserMapper INSTANCE = Mappers.getMapper(UsrUserMapper.class);

    UsrUser convertToUser(UsrUserSaveReqDto userSaveReqDto);

    UsrUser convertToUser(UsrUserUpdateReqDto userUpdateReqDto);

    UsrUserDto convertToUserDto(UsrUser user);

    List<UsrUserDto> convertToUserDtoList(List<UsrUser> userList);
}
