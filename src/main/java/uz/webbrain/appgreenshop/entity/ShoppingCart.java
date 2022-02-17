package uz.webbrain.appgreenshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double total_price;

    private LocalDate date;

    @ManyToMany
    private List<User> user_id;

    @ManyToMany
    private List<Incoming> incomingList;

    private Boolean is_delete;

    public ShoppingCart(Double total_price, LocalDate date, List<User> user_id, List<Incoming> incomingList, Boolean is_delete) {
        this.total_price = total_price;
        this.date = date;
        this.user_id = user_id;
        this.incomingList = incomingList;
        this.is_delete = is_delete;
    }
}
