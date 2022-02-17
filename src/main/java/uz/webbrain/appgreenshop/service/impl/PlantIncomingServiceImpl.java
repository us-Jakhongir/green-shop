package uz.webbrain.appgreenshop.service.impl;

/*
 * project:  app-green-shop
 * author:   Jumanazar Said
 * created:  17/02/2022 7:08 PM
 */


import lombok.RequiredArgsConstructor;
import uz.webbrain.appgreenshop.dto.request.PlantIncomingDto;
import uz.webbrain.appgreenshop.dto.response.Response;
import uz.webbrain.appgreenshop.entity.Incoming;
import uz.webbrain.appgreenshop.entity.Plant;
import uz.webbrain.appgreenshop.entity.PlantIncoming;
import uz.webbrain.appgreenshop.exception.NotFoundException;
import uz.webbrain.appgreenshop.repository.PlantIncomingRepository;
import uz.webbrain.appgreenshop.service.IncomingService;
import uz.webbrain.appgreenshop.service.PlantIncomingService;
import uz.webbrain.appgreenshop.service.PlantService;

import java.util.List;
@RequiredArgsConstructor
public class PlantIncomingServiceImpl implements PlantIncomingService {
    private final PlantIncomingRepository plantIncomingRepository;
    private final PlantService plantService;
    private final IncomingService incomingService;

    @Override
    public List<PlantIncoming> findAll() {
        return plantIncomingRepository.findAll();
    }

    @Override
    public PlantIncoming addPlantIncoming(PlantIncomingDto dto) {
        PlantIncoming plantIncomingNew = new PlantIncoming();
        plantIncomingNew.setSize(dto.getSize());
        plantIncomingNew.setPrice(dto.getPrice());

        Plant plant = plantService.findById(dto.getPlantId());
        plantIncomingNew.setPlant(plant);
        Incoming incoming = incomingService.findById(dto.getIncomingId());
        plantIncomingNew.setIncoming(incoming);

        plantIncomingNew.setQuantity(dto.getQuantity());
        plantIncomingNew.setActive(dto.getActive());

        return plantIncomingRepository.save(plantIncomingNew);
    }

    @Override
    public PlantIncoming edit(Long plant_incoming_id, PlantIncomingDto dto) {
        PlantIncoming plantIncomingToBeEdited = findById(plant_incoming_id);
        if(plantIncomingToBeEdited == null){
            throw new NotFoundException("Data was not found with id {" + plant_incoming_id + "}.");
        }
        plantIncomingToBeEdited.setSize(dto.getSize());
        plantIncomingToBeEdited.setPrice(dto.getPrice());

        Plant plant = plantService.findById(dto.getPlantId());
        plantIncomingToBeEdited.setPlant(plant);
        Incoming incoming = incomingService.findById(dto.getIncomingId());
        plantIncomingToBeEdited.setIncoming(incoming);

        plantIncomingToBeEdited.setQuantity(dto.getQuantity());
        plantIncomingToBeEdited.setActive(dto.getActive());

        return plantIncomingRepository.save(plantIncomingToBeEdited);
    }

    @Override
    public Response delete(Long plant_incoming_id) {
        PlantIncoming plantIncomingToBeDeleted = findById(plant_incoming_id);
        if(plantIncomingToBeDeleted == null){
            throw new NotFoundException("Data was not found with id {" + plant_incoming_id + "}.");
        }
        plantIncomingRepository.delete(plantIncomingToBeDeleted);
        return new Response("Data was successfully deleted.", plantIncomingToBeDeleted);
    }

    @Override
    public PlantIncoming findById(Long id) {
        return null;
    }
}
