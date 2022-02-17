package uz.webbrain.appgreenshop.service;

import org.springframework.data.domain.Sort;
import uz.webbrain.appgreenshop.dto.request.PlantCreateDto;
import uz.webbrain.appgreenshop.dto.response.Response;
import uz.webbrain.appgreenshop.entity.Plant;

import java.util.List;

public interface PlantService {
    /**
     * Plant conservation
     * @param dto
     * @return
     */
    Plant save(PlantCreateDto dto);

    /**
     * List of all plants
     * @return
     */
    List<Plant> findAll();

    Response findAllPageable(Integer page, Integer size, Sort sort);

    /**
     * Find the plant on {id}
     * @param id
     * @return
     */
    Plant findById(Long id);

    /**
     * Update the plants
     * @param id
     * @param dto
     * @return
     */
    Plant update(Long id, PlantCreateDto dto);

    /**
     * Delete plants by id
     * @param id
     * @return
     */
    Response delete(Long id);
}
