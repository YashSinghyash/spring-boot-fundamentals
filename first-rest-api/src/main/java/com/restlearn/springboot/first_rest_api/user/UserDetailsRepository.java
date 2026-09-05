package com.restlearn.springboot.first_rest_api.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDetailsRepository extends JpaRepository<UserDetails , Long>
{
    List<UserDetails> findByRole(String role);
}
