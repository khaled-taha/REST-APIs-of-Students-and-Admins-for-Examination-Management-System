package com.OnlineExaminationSystem.App.service;

import com.OnlineExaminationSystem.App.entity.Role;
import com.OnlineExaminationSystem.App.exceptions.ApiException;
import com.OnlineExaminationSystem.App.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public Role addAndUpdateRole(Role role){
        this.roleRepository.save(role);
        return role;
    }

    public List<Role> getAllRoles(){
        return this.roleRepository.findAll();
    }

    public Role deleteRoleById(int id){
       return this.roleRepository.deleteRoleById(id)
               .orElseThrow(() -> new ApiException("Role not found"));
    }

    public Role findRoleById(int id){
        return this.roleRepository.findRoleById(id)
                .orElseThrow(() -> new ApiException("Role not found"));
    }


}
