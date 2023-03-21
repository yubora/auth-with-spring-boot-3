package com.purple.auth.service.user;

import com.purple.auth.domain.user.User;
import com.purple.auth.domain.user.UserRepository;
import com.purple.auth.dto.user.request.UserRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @AfterEach
    public void clean() {
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("회원가입 정상")
    public void jonTest() {

        // given
        String acntId = "purple";
        String password = "1234";
        String name = "유보라";
        UserRequest request = UserRequest.builder()
                .acntId(acntId)
                .password(password)
                .name(name)
                .build();

        // when
        User user = userService.join(request);

        // then
        assertThat(user).isNotNull();
        assertThat(user.getAcntId()).isEqualTo(acntId);
        assertThat(user.getPassword()).isEqualTo(password);
        assertThat(user.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("회원 존재 여부 조회")
    public void getByCredentialsTest() {

        // given
        Long id = 1L;
        String acntId = "purple";
        String password = "1234";
        String name = "유보라";
        userRepository.save(User.builder()
                .id(id)
                .acntId(acntId)
                .password(password)
                .name(name)
                .build());

        // when
        User user = userService.getByCredentials(acntId, password);

        // then
        assertThat(user).isNotNull();
        assertThat(user.getAcntId()).isEqualTo(acntId);
        assertThat(user.getPassword()).isEqualTo(password);
        assertThat(user.getName()).isEqualTo(name);
    }
}
