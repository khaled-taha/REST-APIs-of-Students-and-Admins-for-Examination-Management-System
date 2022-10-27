package com.OnlineExaminationSystem.App.repository;

import com.OnlineExaminationSystem.App.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

      Optional<Role> findRoleById(int id);
      Optional<Role> deleteRoleById(int id);
}
