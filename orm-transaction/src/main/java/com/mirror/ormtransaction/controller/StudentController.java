package com.mirror.ormtransaction.controller;

import com.mirror.ormtransaction.domain.StudentDTO;
import com.mirror.ormtransaction.service.StudentService;
import com.mirror.ormtransaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description:
 * @create: 2020-06-25 11:40
 **/
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @RequestMapping("/addUser")
    public void addData() throws SQLException {
        userService.addData();
    }

    @RequestMapping("/addUser2")
    public void addUser2() throws SQLException {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1);
        studentDTO.setName("姓名");
        studentDTO.setAge(11);
        studentDTO.setSex("未知");
        studentService.saveDataByOrm(studentDTO);
    }

}
