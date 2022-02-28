package com.poyrazaktas.case3poyrazaktas.usr.controller;

import com.poyrazaktas.case3poyrazaktas.gen.dto.RestResponse;
import com.poyrazaktas.case3poyrazaktas.usr.dto.UsrUserDeleteReqDto;
import com.poyrazaktas.case3poyrazaktas.usr.dto.UsrUserDto;
import com.poyrazaktas.case3poyrazaktas.usr.dto.UsrUserSaveReqDto;
import com.poyrazaktas.case3poyrazaktas.usr.dto.UsrUserUpdateReqDto;
import com.poyrazaktas.case3poyrazaktas.usr.service.UsrUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UsrUserController {
    private final UsrUserService userService;

    @GetMapping("/findAll")
    public ResponseEntity findAll(){
        List<UsrUserDto> all = userService.findAll();
        RestResponse<List<UsrUserDto>> response = RestResponse.of(all);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity get(@PathVariable Long id){
        UsrUserDto usrUserDto = userService.get(id);
        RestResponse<UsrUserDto> response = RestResponse.of(usrUserDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getByUserName/{userName}")
    public ResponseEntity getByUserName(@PathVariable String userName){
        UsrUserDto usrUserDto = userService.findByUserName(userName);
        RestResponse<UsrUserDto> response = RestResponse.of(usrUserDto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody UsrUserSaveReqDto userSaveReqDto){
        UsrUserDto usrUserDto = userService.save(userSaveReqDto);
        RestResponse<UsrUserDto> response = RestResponse.of(usrUserDto);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody UsrUserUpdateReqDto userUpdateReqDto){
        UsrUserDto usrUserDto = userService.update(userUpdateReqDto);
        RestResponse<UsrUserDto> response = RestResponse.of(usrUserDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id, @RequestBody UsrUserDeleteReqDto userDeleteReqDto){
        userService.delete(id,userDeleteReqDto);
        return ResponseEntity.ok(RestResponse.empty());
    }
}
