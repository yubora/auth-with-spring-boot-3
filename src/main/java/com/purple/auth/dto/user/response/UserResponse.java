package com.purple.auth.dto.user.response;

import com.purple.auth.domain.user.StatusType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class UserResponse {

    private Long id;
    private String token;
    private String acntId;
    private String password;
    private String name;
    private StatusType status;
}
