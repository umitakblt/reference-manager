package com.umitakbulut.reference_manager.repository;

import com.umitakbulut.reference_manager.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
