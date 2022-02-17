package uz.webbrain.appgreenshop.controller;

/*
 * project:  app-green-shop
 * author:   Jumanazar Said
 * created:  17/02/2022 6:06 PM
 */


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.webbrain.appgreenshop.dto.request.PlantIncomingDto;
import uz.webbrain.appgreenshop.dto.response.Response;
import uz.webbrain.appgreenshop.entity.PlantIncoming;
import uz.webbrain.appgreenshop.service.PlantIncomingService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/plantincoming")
public class PlantIncomingController {
    private final PlantIncomingService plantIncomingService;

    @GetMapping("/")
    public List<PlantIncoming> getAll(){
        return plantIncomingService.findAll();
    }

    @PostMapping("/add")
    public PlantIncoming add(@RequestBody PlantIncomingDto dto){
        return plantIncomingService.addPlantIncoming(dto);
    }

    @PutMapping("/{plant_icoming_id}")
    public PlantIncoming edit(@PathVariable Long plant_incoming_id, @RequestBody PlantIncomingDto dto){
        return plantIncomingService.edit(plant_incoming_id, dto);
    }

    @DeleteMapping("/{plant_icoming_id}")
    public Response delete(@PathVariable Long plant_icoming_id){
        return plantIncomingService.delete(plant_icoming_id);
    }
}
