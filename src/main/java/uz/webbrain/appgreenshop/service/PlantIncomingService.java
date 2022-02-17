package uz.webbrain.appgreenshop.service;

/*
 * project:  app-green-shop
 * author:   Jumanazar Said
 * created:  17/02/2022 7:02 PM
 */


import uz.webbrain.appgreenshop.dto.request.PlantIncomingDto;
import uz.webbrain.appgreenshop.dto.response.Response;
import uz.webbrain.appgreenshop.entity.PlantIncoming;

import java.util.List;

public interface PlantIncomingService {

    List<PlantIncoming> findAll();

    PlantIncoming addPlantIncoming(PlantIncomingDto dto);

    PlantIncoming edit(Long plant_incoming_id, PlantIncomingDto dto);

    Response delete(Long plant_icoming_id);

    PlantIncoming findById(Long id);
}
