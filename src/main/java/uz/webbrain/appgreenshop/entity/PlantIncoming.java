package uz.webbrain.appgreenshop.entity;

/*
 * project:  app-green-shop
 * author:   Jumanazar Said
 * created:  17/02/2022 12:48 PM
 */

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "plant_incoming")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PlantIncoming {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PlantIncoming that = (PlantIncoming) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
