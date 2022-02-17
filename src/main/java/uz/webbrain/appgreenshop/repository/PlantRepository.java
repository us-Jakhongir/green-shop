package uz.webbrain.appgreenshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.webbrain.appgreenshop.entity.Plant;

public interface PlantRepository extends JpaRepository<Plant, Long> {
}
