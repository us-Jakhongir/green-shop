package uz.webbrain.appgreenshop.entity;

/*
 * project:  app-green-shop
 * author:   Jumanazar Said
 * created:  17/02/2022 12:44 PM
 */

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "incoming")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Incoming {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private Double price; // summa

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Incoming incoming = (Incoming) o;
        return id != null && Objects.equals(id, incoming.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
