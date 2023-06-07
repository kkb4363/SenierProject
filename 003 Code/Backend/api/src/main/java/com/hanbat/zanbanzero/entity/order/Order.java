package com.hanbat.zanbanzero.entity.order;

import com.hanbat.zanbanzero.entity.menu.Menu;
import com.hanbat.zanbanzero.entity.user.user.User;
import com.hanbat.zanbanzero.dto.order.OrderDto;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String menu;

    private int cost;
    private String orderDate;
    private boolean recognize;

    public void setMenu(Menu menu) {this.menu = menu.getName();}

    public void setRecognizeToCancel() {
        recognize = false;
    }

    public void setRecognizeToUse() { recognize = true; }

    public static Order createNewOrder(User user, String menu, int cost, String date, boolean type) {
        return new Order(
                null,
                user,
                menu,
                cost,
                date,
                type
        );
    }
}
