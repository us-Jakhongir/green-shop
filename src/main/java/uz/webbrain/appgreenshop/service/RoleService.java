package uz.webbrain.appgreenshop.service;

import uz.webbrain.appgreenshop.dto.RoleCreateDto;
import uz.webbrain.appgreenshop.entity.Role;

import java.util.List;

public interface RoleService {
    Role saveRole(RoleCreateDto dto);

    List<Role> findAll();

    Role findById(Long roleId);

    Role updateRole(Long roleId, RoleCreateDto dto);

    String removeRoleById(Long roleId);
}
