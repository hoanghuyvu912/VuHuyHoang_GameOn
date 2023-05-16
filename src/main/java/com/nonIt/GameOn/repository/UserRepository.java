package com.nonIt.GameOn.repository;

import com.nonIt.GameOn.entity.Gender;
import com.nonIt.GameOn.entity.User;
import com.nonIt.GameOn.service.restDto.UserRestDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByGender(@Param("string")Gender gender);
}
