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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IncomingDto {
    private LocalDate date;
    private Double price; // summa

}
