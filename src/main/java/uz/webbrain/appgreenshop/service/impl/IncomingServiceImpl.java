package uz.webbrain.appgreenshop.service.impl;

/*
 * project:  app-green-shop
 * author:   Jumanazar Said
 * created:  17/02/2022 6:13 PM
 */


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.webbrain.appgreenshop.dto.request.IncomingDto;
import uz.webbrain.appgreenshop.entity.Incoming;
import uz.webbrain.appgreenshop.entity.Plant;
import uz.webbrain.appgreenshop.exception.NotFoundException;
import uz.webbrain.appgreenshop.repository.IncomingRepository;
import uz.webbrain.appgreenshop.service.IncomingService;
import uz.webbrain.appgreenshop.service.PlantService;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class IncomingServiceImpl implements IncomingService {

    private final IncomingRepository incomingRepository;
    private final PlantService plantService;

    @Override
    public Incoming addIncoming(IncomingDto incomingDto) {
        Incoming incoming = new Incoming();
        incoming.setPrice(incomingDto.getPrice());
        incoming.setSalePrice(incomingDto.getSalePrice());
        Plant plant = plantService.findById(incomingDto.getPlantId());
        incoming.setPlant(plant);
        incoming.setQuantity(incomingDto.getQuantity());
        incoming.setActive(incomingDto.getActive());
        incoming.setCreatedAt(incomingDto.getCreatedAt());
        return incomingRepository.save(incoming);
    }

    @Override
    public List<Incoming> getAll() {
        return incomingRepository.findAll();
    }

    @Override
    public Incoming editIncoming(Long incomingId, IncomingDto incomingDto) {
        Incoming incomingToBeEdited = findById(incomingId);
        if(incomingToBeEdited == null){
            throw new NotFoundException("No data found with id {" + incomingId + "}.");
        }
        incomingToBeEdited.setPrice(incomingDto.getPrice());
        incomingToBeEdited.setSalePrice(incomingDto.getSalePrice());
        Plant plant = plantService.findById(incomingDto.getPlantId());
        incomingToBeEdited.setPlant(plant);
        incomingToBeEdited.setQuantity(incomingDto.getQuantity());
        incomingToBeEdited.setActive(incomingDto.getActive());
        incomingToBeEdited.setCreatedAt(incomingDto.getCreatedAt());
        return incomingRepository.save(incomingToBeEdited);
    }


    @Override
    public String deleteIncoming(Long incomingId) {
        Incoming incomingToBeDeleted = findById(incomingId);
        if(incomingToBeDeleted == null){
            throw new NotFoundException("No data found with id {" + incomingId + "}.");
        }
        incomingRepository.delete(incomingToBeDeleted);
        return "Data was successfully deleted with id {" + incomingId + "}.";
    }

    @Override
    public Incoming findById(Long id) {
            Incoming incomingFound = null;
            Optional<Incoming> optionalIncoming = incomingRepository.findById(id);
            if(optionalIncoming.isPresent()){
                incomingFound = optionalIncoming.get();
            }
            return incomingFound;
    }
}
