package uz.webbrain.appgreenshop.dto.request;

/*
 * project:  app-green-shop
 * author:   Jumanazar Said
 * created:  17/02/2022 7:03 PM
 */


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlantIncomingDto {
    private String size;
    private Double price;
    private Long plantId;
    private Long incomingId;
    private Long quantity;
    private Boolean active;
}
