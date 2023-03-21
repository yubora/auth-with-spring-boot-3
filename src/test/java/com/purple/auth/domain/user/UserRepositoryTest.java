package com.purple.auth.domain.user;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @AfterEach
    public void clean() {
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("user 테이블 조회")
    public void getUsers() {

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
        List<User> results = userRepository.findAll();

        // then
        assertThat(results).hasSize(1);
        assertThat(results.get(0).getAcntId()).isEqualTo(acntId);
        assertThat(results.get(0).getPassword()).isEqualTo(password);
        assertThat(results.get(0).getName()).isEqualTo(name);
    }
}
