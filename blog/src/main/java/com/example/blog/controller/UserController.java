package com.example.blog.controller;

import com.example.blog.entity.User;
import com.example.blog.security.JwtUtil;
import com.example.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // 注册用户
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    // 用户登录（返回 JWT Token）
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> loginRequest) {
        String username = loginRequest.get("username");
        String password = loginRequest.get("password");

        User user = userService.findByUsername(username);

        Map<String, String> response = new HashMap<>();

        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            String token = jwtUtil.generateToken(username);
            response.put("token", token);
            response.put("message", "登录成功");
        } else {
            response.put("message", "用户名或密码错误");
        }
        return response;
    }

    // 获取所有用户（需要登录才能访问）
    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }
}