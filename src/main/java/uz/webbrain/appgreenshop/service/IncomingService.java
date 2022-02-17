package uz.webbrain.appgreenshop.service;

import uz.webbrain.appgreenshop.dto.request.IncomingDto;
import uz.webbrain.appgreenshop.entity.Incoming;

import java.util.List;

public interface IncomingService {

    Incoming addIncoming(IncomingDto incomingDto);

    List<Incoming> getAll();

    Incoming editIncoming(Long incomingId, IncomingDto incomingDto);

    String deleteIncoming(Long incomingId);

    Incoming findById(Long id);
}
