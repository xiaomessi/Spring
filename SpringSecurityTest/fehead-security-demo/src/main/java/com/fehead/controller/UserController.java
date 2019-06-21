package com.fehead.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.fehead.dto.User;
import com.fehead.exception.UserNotExistException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoaxiao on 2019/6/13
 * Description:
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @DeleteMapping(value = "/{id:\\d+}")
    public void delete(@PathVariable String id){
        System.out.println(id);
    }

    @PutMapping(value = "/{id:\\d+}")
    public User update(@Valid @RequestBody User user,BindingResult errors){

        if(errors.hasErrors()){
            errors.getAllErrors().stream().forEach(error ->{
//                        System.out.println(error.getDefaultMessage())
                    FieldError fieldError = (FieldError)error;
                    String message = fieldError.getField()+":"+error.getDefaultMessage();
                    System.out.println(message);
                });
        }
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());
        user.setId("1");
        return user;
    }

    @PostMapping
    public User create(@Valid @RequestBody User user, BindingResult errors){

        if(errors.hasErrors()){
            errors.getAllErrors().stream().forEach(error ->
                    System.out.println(error.getDefaultMessage()));
        }
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());
        user.setId("1");
        return user;
    }

//    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> query(@RequestParam(value = "username",required = false,defaultValue = "chen") String nickname,
                            @PageableDefault(page = 10,size = 20,sort = "username,asc") Pageable pageable){
        System.out.println(nickname);
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getSort());
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

//    @RequestMapping(value = "/user/{id:\\d+}",method = RequestMethod.GET)
    @GetMapping(value = "/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable(name = "id") String id){
        throw new UserNotExistException(id);
//        User user = new User();
//        user.setUsername("tom");
//        return user;
    }


}
