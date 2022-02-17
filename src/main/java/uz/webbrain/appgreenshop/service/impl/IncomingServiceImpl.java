package uz.webbrain.appgreenshop.service.impl;

/*
 * project:  app-green-shop
 * author:   Jumanazar Said
 * created:  17/02/2022 6:13 PM
 */


import org.springframework.stereotype.Service;
import uz.webbrain.appgreenshop.dto.request.IncomingDto;
import uz.webbrain.appgreenshop.entity.Incoming;
import uz.webbrain.appgreenshop.exception.NotFoundException;
import uz.webbrain.appgreenshop.repository.IncomingRepository;
import uz.webbrain.appgreenshop.service.IncomingService;

import java.util.List;
import java.util.Optional;
@Service
public class IncomingServiceImpl implements IncomingService {

    private final IncomingRepository incomingRepository;
    public IncomingServiceImpl(IncomingRepository incomingRepository){
        this.incomingRepository = incomingRepository;
    }

    @Override
    public Incoming addIncoming(IncomingDto incomingDto) {
        Incoming newIncoming = new Incoming();
        newIncoming.setDate(incomingDto.getDate());
        newIncoming.setPrice(incomingDto.getPrice());
        return incomingRepository.save(newIncoming);
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
        incomingToBeEdited.setDate(incomingDto.getDate());
        incomingToBeEdited.setPrice(incomingDto.getPrice());
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
