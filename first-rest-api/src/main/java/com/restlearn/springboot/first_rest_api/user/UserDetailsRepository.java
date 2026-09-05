package com.restlearn.springboot.first_rest_api.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetails , Long>
{

}
