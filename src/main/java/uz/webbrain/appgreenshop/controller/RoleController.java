package uz.webbrain.appgreenshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.webbrain.appgreenshop.dto.RoleCreateDto;
import uz.webbrain.appgreenshop.entity.Role;
import uz.webbrain.appgreenshop.service.RoleService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/roles")
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    public Role save(@RequestBody RoleCreateDto dto) {
        return roleService.saveRole(dto);
    }

    @GetMapping
    public List<Role> findAll() {
        return roleService.findAll();
    }

    @GetMapping("/{role_id}")
    public Role findById(@PathVariable("role_id") Long roleId) {
        return roleService.findById(roleId);
    }

    @PutMapping("/{role_id}")
    public Role edit(@PathVariable("role_id") Long roleId,
                     @RequestBody RoleCreateDto dto) {
        return roleService.updateRole(roleId, dto);
    }

    @DeleteMapping("/{role_id}")
    public String remove(@PathVariable("role_id") Long roleId) {
        return roleService.removeRoleById(roleId);
    }

}
