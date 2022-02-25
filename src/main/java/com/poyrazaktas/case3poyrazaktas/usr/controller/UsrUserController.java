package com.poyrazaktas.case3poyrazaktas.usr.controller;

import com.poyrazaktas.case3poyrazaktas.usr.dto.UsrUserDeleteReqDto;
import com.poyrazaktas.case3poyrazaktas.usr.dto.UsrUserDto;
import com.poyrazaktas.case3poyrazaktas.usr.dto.UsrUserSaveReqDto;
import com.poyrazaktas.case3poyrazaktas.usr.dto.UsrUserUpdateReqDto;
import com.poyrazaktas.case3poyrazaktas.usr.service.UsrUserService;
import com.poyrazaktas.case3poyrazaktas.usr.service.entityservice.UsrUserEntityService;
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
    public ResponseEntity<List<UsrUserDto>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UsrUserDto> get(@PathVariable Long id){
        UsrUserDto usrUserDto = userService.get(id);
        return ResponseEntity.ok(usrUserDto);
    }

    @GetMapping("/getByUserName/{userName}")
    public ResponseEntity<UsrUserDto> getByUserName(@PathVariable String userName){
        UsrUserDto usrUserDto = userService.findByUserName(userName);
        return ResponseEntity.ok(usrUserDto);
    }

    @PostMapping("/save")
    public ResponseEntity<UsrUserDto> save(@RequestBody UsrUserSaveReqDto userSaveReqDto){
        UsrUserDto usrUserDto = userService.save(userSaveReqDto);
        return ResponseEntity.ok(usrUserDto);
    }

    @PutMapping("/update")
    public ResponseEntity<UsrUserDto> update(@RequestBody UsrUserUpdateReqDto userUpdateReqDto){
        UsrUserDto usrUserDto = userService.update(userUpdateReqDto);
        return ResponseEntity.ok(usrUserDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id, @RequestBody UsrUserDeleteReqDto userDeleteReqDto){
        userService.delete(id,userDeleteReqDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
