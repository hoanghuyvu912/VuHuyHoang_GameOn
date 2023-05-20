package com.nonIt.GameOn.repository;

import com.nonIt.GameOn.entity.Gender;
import com.nonIt.GameOn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);

    List<User> findByGender(@Param("string") Gender gender);
}
