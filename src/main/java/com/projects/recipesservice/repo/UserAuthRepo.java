package com.projects.recipesservice.repo;

import com.projects.recipesservice.entity.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthRepo extends JpaRepository<UserAuth, Long> {
}
