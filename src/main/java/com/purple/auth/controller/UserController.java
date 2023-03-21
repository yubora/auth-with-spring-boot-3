package com.purple.auth.controller;

import com.purple.auth.domain.user.User;
import com.purple.auth.dto.user.request.UserRequest;
import com.purple.auth.dto.user.response.UserResponse;
import com.purple.auth.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    /**
     * 회원가입
     */
    @PostMapping("/user/join")
    public ResponseEntity<Void> join(@RequestBody UserRequest request) {
        userService.join(request);

        return ResponseEntity.ok().build();
    }

    /**
     * 로그인
     */
    @PostMapping("/user/authenticate")
    public ResponseEntity<UserResponse> authenticate(@RequestBody UserRequest request) {
        User user = userService.getByCredentials(request.getAcntId(), request.getPassword());

        if (user == null) {
            return ResponseEntity.badRequest().build();
        }

        UserResponse response = UserResponse.builder()
                .id(user.getId())
                .acntId(user.getAcntId())
                .password(user.getPassword())
                .name(user.getName())
                .status(user.getStatus())
                .build();

        return ResponseEntity.ok(response);
    }
}
