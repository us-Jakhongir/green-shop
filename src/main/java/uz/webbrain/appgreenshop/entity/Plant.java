package uz.webbrain.appgreenshop.entity;

/*
 * project:  app-green-shop
 * author:   Jumanazar Said
 * created:  17/02/2022 12:52 PM
 */

import lombok.*;
import uz.webbrain.appgreenshop.entity.template.AbcEntity;
import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "plant")
public class Plant extends AbcEntity {
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "category_id_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "related_id")
    private Plant related;
}
