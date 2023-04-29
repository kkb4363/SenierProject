package com.hanbat.zanbanzero.entity.menu;

import com.hanbat.zanbanzero.dto.menu.MenuUpdateDto;
import com.hanbat.zanbanzero.entity.store.Store;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;

    private String name;
    private int cost;
    private String image;
    private Boolean sold;
    private Boolean usePlanner;

    public void patch(MenuUpdateDto dto) {
        if (dto.getName() != null) {
            this.name = dto.getName();
        }
        if (dto.getCost() != null) {
            this.cost = dto.getCost();
        }
    }

    public static Menu createMenu(MenuUpdateDto dto, Store store, String filePath, Boolean usePlanner) {
        return new Menu(
                null,
                store,
                dto.getName(),
                dto.getCost(),
                filePath,
                true,
                usePlanner
        );
    }

    public void setImage(String path) { image = path; }
    public void setSold(boolean type) {
        sold = type;
    }
}
