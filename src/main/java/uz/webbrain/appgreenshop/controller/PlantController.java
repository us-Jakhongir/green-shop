package uz.webbrain.appgreenshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import uz.webbrain.appgreenshop.dto.request.PlantCreateDto;
import uz.webbrain.appgreenshop.dto.response.Response;
import uz.webbrain.appgreenshop.entity.Plant;
import uz.webbrain.appgreenshop.service.PlantService;
import uz.webbrain.appgreenshop.utils.ApiPageable;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/plants")
public class PlantController {
    private final PlantService plantService;

    @PostMapping("/save")
    public Plant save(@RequestBody PlantCreateDto dto) {
        Plant plant = plantService.save(dto);
        return plant;
    }

    // Pageable
    @ApiPageable
    @GetMapping("/page/list")
    public HttpEntity<?> findAllPageable(@ApiIgnore Pageable pageable) {
        Response response = plantService.findAllPageable(pageable);
        return ResponseEntity.status(response.isSuccess() ? 200 : 500).body(response);
    }

    @GetMapping("/list")
    public List<Plant> findAll() {
        List<Plant> plantList = plantService.findAll();
        return plantList;
    }

    @GetMapping("/{id}")
    public Plant findById(@PathVariable("id") Long id) {
        Plant plant = plantService.findById(id);
        return plant;
    }

    @PutMapping("/{id}/update")
    public Plant updateById(@PathVariable("id") Long id,
                            @RequestBody PlantCreateDto dto) {
        Plant plant = plantService.update(id, dto);
        return plant;
    }

    @DeleteMapping("/{id}/delete")
    public Response deleteById(@PathVariable("id") Long id) {
        Response response = plantService.delete(id);
        return new Response("Successfully deleted", response);
    }


}
