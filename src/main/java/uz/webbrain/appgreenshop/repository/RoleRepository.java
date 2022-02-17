package uz.webbrain.appgreenshop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.webbrain.appgreenshop.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
