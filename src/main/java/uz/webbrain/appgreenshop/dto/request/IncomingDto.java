package uz.webbrain.appgreenshop.dto.request;

/*
 * project:  app-green-shop
 * author:   Jumanazar Said
 * created:  17/02/2022 6:09 PM
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IncomingDto {
    private Double price; // summa
    private Double salePrice; // sale
    private Long plantId;
    private Long quantity;
    private Boolean active;
    private LocalDateTime createdAt;
}
