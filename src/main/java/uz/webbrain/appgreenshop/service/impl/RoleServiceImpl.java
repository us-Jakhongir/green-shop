package uz.webbrain.appgreenshop.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.webbrain.appgreenshop.dto.RoleCreateDto;
import uz.webbrain.appgreenshop.entity.Role;
import uz.webbrain.appgreenshop.exception.NotFoundException;
import uz.webbrain.appgreenshop.repository.RoleRepository;
import uz.webbrain.appgreenshop.service.RoleService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;


    @Override
    public Role saveRole(RoleCreateDto dto) {
        Role role = new Role(
                dto.getName()
        );
        return roleRepository.save(role);
    }


    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }


    @Override
    public Role findById(Long roleId) {
        Optional<Role> roleOptional = roleRepository.findById(roleId);
        if (roleOptional.isEmpty())
            throw new NotFoundException("Not Found Role");
        return roleOptional.get();
    }


    @Override
    public Role updateRole(Long roleId, RoleCreateDto dto) {
        Optional<Role> roleOptional = roleRepository.findById(roleId);
        if (roleOptional.isEmpty())
            throw new NotFoundException("Not Found Role");

        Role role = roleOptional.get();
        if (!role.getName().equals(dto.getName())) {
            role.setName(dto.getName());
        }
        return roleRepository.save(role);
    }


    @Override
    public String removeRoleById(Long roleId) {
        roleRepository.deleteById(roleId);
        return "Successfully Deleted";
    }
}
