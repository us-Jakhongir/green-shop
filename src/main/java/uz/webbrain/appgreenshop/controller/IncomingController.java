package uz.webbrain.appgreenshop.controller;

/*
 * project:  app-green-shop
 * author:   Jumanazar Said
 * created:  17/02/2022 1:13 PM
 */

import org.springframework.web.bind.annotation.*;
import uz.webbrain.appgreenshop.dto.request.IncomingDto;
import uz.webbrain.appgreenshop.entity.Incoming;
import uz.webbrain.appgreenshop.service.IncomingService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/incoming")
public class IncomingController {

    private final IncomingService incomingService;
    public IncomingController(IncomingService incomingService){
        this.incomingService = incomingService;
    }

    @GetMapping("/")
    public List<Incoming> getAll(){
        return incomingService.getAll();
    }

    @PostMapping("/add")
    public Incoming addIncoming(@RequestBody IncomingDto incomingDto){
        return incomingService.addIncoming(incomingDto);
    }

    @PutMapping("/{incoming_id}")
    public Incoming editIncoming(@PathVariable Long incoming_id, @RequestBody IncomingDto incomingDto){
        return incomingService.editIncoming(incoming_id, incomingDto);
    }

    @DeleteMapping("/{incoming_id}")
    public String deleteIncoming(@PathVariable Long incoming_id){
        return incomingService.deleteIncoming(incoming_id);
    }

}
