package uz.webbrain.appgreenshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.webbrain.appgreenshop.entity.Category;

@Repository
public interface CategoryRespository extends JpaRepository<Category, Long> {
}
