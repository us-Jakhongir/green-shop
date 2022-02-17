package uz.webbrain.appgreenshop.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.webbrain.appgreenshop.drr.dto.PlantCreateDto;
import uz.webbrain.appgreenshop.drr.response.Response;
import uz.webbrain.appgreenshop.entity.Plant;
import uz.webbrain.appgreenshop.exception.PlantNotFoundException;
import uz.webbrain.appgreenshop.repository.PlantRepository;
import uz.webbrain.appgreenshop.service.PlantService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlantServiceImpl implements PlantService {
    private final PlantRepository plantRepository;

    @Override
    public Plant save(PlantCreateDto dto) {
        Optional<Plant> optionalPlant = plantRepository.findById(dto.getPlantId());
        if (optionalPlant.isPresent())
            throw new PlantNotFoundException("Plant id{" + dto.getPlantId() + "} not found");
        Plant plant1 = optionalPlant.get();
        Plant plant = new Plant(
                dto.getName(),
                dto.getDescription(),
                dto.getCategoryId(),
                plant1);
        Plant savedPlant = plantRepository.save(plant);
        return savedPlant;
    }

    @Override
    public List<Plant> findAll() {
        List<Plant> plantList = plantRepository.findAll();
        return plantList;
    }

    @Override
    public Plant findById(Long id) {
        Optional<Plant> optionalPlant = plantRepository.findById(id);
        if (optionalPlant.isPresent())
            throw new PlantNotFoundException("Plant id{" + id + "} not found");
        Plant plant = optionalPlant.get();
        return plant;
    }

    @Override
    public Plant update(Long id, PlantCreateDto dto) {
        Optional<Plant> optionalPlant = plantRepository.findById(id);
        if (optionalPlant.isPresent())
            throw new PlantNotFoundException("Plant id{" + id + "} not found");
        Plant plant1 = optionalPlant.get();
        Plant plant = new Plant(
                dto.getName(),
                dto.getDescription(),
                dto.getCategoryId(),
                plant1);
        return plant;
    }

    @Override
    public Response delete(Long id) {
        Optional<Plant> optionalPlant = plantRepository.findById(id);
        if (optionalPlant.isPresent())
            throw new PlantNotFoundException("Plant id{" + id + "} not found");
        Plant plant = optionalPlant.get();
        return new Response("Successfully deleted", plant);
    }
}
