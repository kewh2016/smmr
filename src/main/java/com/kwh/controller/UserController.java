package com.kwh.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kwh.dao.RoleMapper;
import com.kwh.dao.UserMapper;
import com.kwh.entity.User;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("users", userMapper.selectByExample(null));
        model.addAttribute("roles", roleMapper.selectByExample(null));
        return "user/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addUser(Model model) {
        model.addAttribute("roles", roleMapper.selectByExample(null));
        return "user/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(User user) {
        user.setPassword(DigestUtils.sha256Hex(user.getUserNo() + user.getPassword()));
        userMapper.insert(user);
        return "redirect:list";
    }
}
