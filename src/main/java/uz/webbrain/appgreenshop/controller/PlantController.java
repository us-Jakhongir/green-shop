package uz.webbrain.appgreenshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.webbrain.appgreenshop.dto.request.PlantCreateDto;
import uz.webbrain.appgreenshop.dto.response.Response;
import uz.webbrain.appgreenshop.entity.Plant;
import uz.webbrain.appgreenshop.service.PlantService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/plants")
public class PlantController {
    private final PlantService plantService;

    @PostMapping("/save")
    public Plant save(@RequestBody PlantCreateDto dto){
        Plant plant = plantService.save(dto);
        return plant;
    }

    @GetMapping("/list")
    public List<Plant> findAll(){
        List<Plant> plantList = plantService.findAll();
        return plantList;
    }

    @GetMapping("/{id}")
    public Plant findById(@PathVariable("id") Long id){
        Plant plant = plantService.findById(id);
        return plant;
    }

    @PutMapping("/{id}/update")
    public Plant updateById(@PathVariable("id") Long id,
                            @RequestBody PlantCreateDto dto){
        Plant plant = plantService.update(id, dto);
        return plant;
    }

    @DeleteMapping("/{id}/delete")
    public Response deleteById(@PathVariable("id") Long id){
        Response response = plantService.delete(id);
        return new Response("Successfully deleted", response);
    }


}
