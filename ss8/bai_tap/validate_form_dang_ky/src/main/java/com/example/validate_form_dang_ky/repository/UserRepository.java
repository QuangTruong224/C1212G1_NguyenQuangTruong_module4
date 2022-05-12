package com.example.validate_form_dang_ky.repository;

import com.example.validate_form_dang_ky.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserDto,Integer> {
}
