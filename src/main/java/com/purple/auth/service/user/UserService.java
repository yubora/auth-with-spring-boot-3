package com.purple.auth.service.user;

import com.purple.auth.domain.user.User;
import com.purple.auth.domain.user.UserRepository;
import com.purple.auth.dto.user.request.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User join(UserRequest request) {
        User user = User.builder()
                .name(request.getName())
                .acntId(request.getAcntId())
                .password(request.getPassword())
                .build();

        return userRepository.save(user);
    }

    public User getByCredentials(String acntId, String password) {
        return userRepository.findByAcntIdAndPassword(acntId, password);
    }

}
