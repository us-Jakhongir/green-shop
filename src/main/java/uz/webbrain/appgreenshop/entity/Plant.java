package uz.webbrain.appgreenshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "plants")
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    private Long category;

    @ManyToOne
    private Plant plant;

    public Plant(String name, String description, Long category, Plant plant) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.plant = plant;
    }
}
