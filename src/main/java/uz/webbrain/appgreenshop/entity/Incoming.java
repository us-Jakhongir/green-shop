package uz.webbrain.appgreenshop.entity;

/*
 * project:  app-green-shop
 * author:   Jumanazar Said
 * created:  17/02/2022 12:44 PM
 */

import lombok.*;
import uz.webbrain.appgreenshop.entity.template.AbcEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "incoming")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Incoming extends AbcEntity {
    private LocalDate date;
    private Double price; // summa
}
