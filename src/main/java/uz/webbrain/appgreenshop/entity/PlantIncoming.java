package uz.webbrain.appgreenshop.entity;

/*
 * project:  app-green-shop
 * author:   Jumanazar Said
 * created:  17/02/2022 12:48 PM
 */

import lombok.*;
import uz.webbrain.appgreenshop.entity.template.AbcEntity;
import javax.persistence.*;

@Entity
@Table(name = "plant_incoming")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PlantIncoming extends AbcEntity {
    private String size;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "plant_id")
    private Plant plant;
    @ManyToOne
    @JoinColumn(name = "incoming_id")
    private Incoming incoming;
    private Long quantity;
    private Boolean active;
}
