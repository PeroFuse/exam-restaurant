package com.exam.controllers;

import java.util.List;

import com.exam.dto.User;
import com.exam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/userAccount")
public class UserController {

    @Autowired

    UserRepository userRepository;

    /*
     * Mapping url exmaple:
     * http://localhost:8080/userAccount/add?userName=Jerry&password=888888&email=
     * jerry@dev2qa.com
     * http://localhost:8080/userAccount/add?userName=Richard&password=888888&email=
     * richard@google.com
     */
    @PostMapping(path = "/add")
    @ResponseBody
    public String addUser(@RequestParam String name, @RequestParam String surname, @RequestParam String email) {

        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);

        userRepository.save(user);

        String ret = "User account has been added, user name = " + name + ", surname = " + surname + ", email = "
                + email;

        return ret;

    }

    /*
     * Mapping url exmaple: http://localhost:8080/userAccount/findAll
     */
    @GetMapping(path = "/findAll")
    @ResponseBody
    public String findAllUser() {

        StringBuffer retBuf = new StringBuffer();

        List<User> userAccountList = (List<User>) userRepository.findAll();

        if (userAccountList != null) {
            for (User userAccount : userAccountList) {
                retBuf.append("user name = ");
                retBuf.append(userAccount.getName());
                retBuf.append(", password = ");
                retBuf.append(userAccount.getSurname());
                retBuf.append(", email = ");
                retBuf.append(userAccount.getEmail());
                retBuf.append("\r\n");
            }
        }

        if (retBuf.length() == 0) {
            retBuf.append("No record find.");
        } else {
            retBuf.insert(0, "<pre>");
            retBuf.append("</pre>");
        }

        return retBuf.toString();
    }

    /*
     * Mapping url exmaple:
     * http://localhost:8080/userAccount/findByName?userName=Jerry
     */
    @GetMapping(path = "/findByName")
    @ResponseBody
    public String findByName(@RequestParam String name) {

        StringBuffer retBuf = new StringBuffer();

        List<User> userList = (List<User>) userRepository.findByName(name);

        if (userList != null) {
            for (User userAccount : userList) {
                retBuf.append("user name = ");
                retBuf.append(userAccount.getName());
                retBuf.append(", password = ");
                retBuf.append(userAccount.getSurname());
                retBuf.append(", email = ");
                retBuf.append(userAccount.getEmail());
                retBuf.append("\r\n");
            }
        }

        if (retBuf.length() == 0) {
            retBuf.append("No record find.");
        }

        return retBuf.toString();
    }

    /*
     * Mapping url exmaple:
     * http://localhost:8080/userAccount/updateUser?userName=Jerry&password=hello&
     * email=hello_jerry@gmail.com
     */
    @GetMapping(path = "/updateUser")
    @ResponseBody
    public String updateUser(@RequestParam String name, @RequestParam String surname, @RequestParam String email) {

        StringBuffer retBuf = new StringBuffer();

        List<User> userList = userRepository.findByName(name);

        if (userList != null) {
            for (User user : userList) {
                user.setName(name);
                user.setSurname(surname);
                user.setEmail(email);
                userRepository.save(user);
            }
        }

        retBuf.append("User data update successfully.");

        return retBuf.toString();
    }

    /*
     * Mapping url exmaple:
     * http://localhost:8080/userAccount/deleteByUserName?userName=Richard
     */
    @GetMapping(path = "/deleteByUserName")
    @ResponseBody
    public String deleteByName(@RequestParam String name) {

        StringBuffer retBuf = new StringBuffer();

        userRepository.deleteByName(name);

        retBuf.append("User data has been deleted successfully.");

        return retBuf.toString();
    }

}