package com.phongvo.springbootjwt.repositories;

import com.phongvo.springbootjwt.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleName);
}
