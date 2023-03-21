package com.purple.auth.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByAcntIdAndPassword(String acntId, String password);

}
