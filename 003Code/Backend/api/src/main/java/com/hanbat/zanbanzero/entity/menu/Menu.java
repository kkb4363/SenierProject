package com.hanbat.zanbanzero.entity.menu;

import com.hanbat.zanbanzero.dto.menu.MenuUpdateDto;
import com.hanbat.zanbanzero.entity.planner.Planner;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private List<Planner> planners;

    @OneToOne(mappedBy = "menu", cascade = CascadeType.ALL)
    private MenuInfo menuInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    private MenuFood menuFood;

    @org.hibernate.annotations.Index(name = "menu_name_index")
    private String name;
    private int cost;
    private String image;
    private Boolean sold;
    private boolean usePlanner;

    public void patch(MenuUpdateDto dto) {
        if (dto.getName() != null) {
            this.name = dto.getName();
        }
        if (dto.getCost() != null) {
            this.cost = dto.getCost();
        }
        if (dto.getUsePlanner() != null) {
            this.usePlanner = dto.getUsePlanner();
        }
    }

    public static Menu of(MenuUpdateDto dto, String filePath) {
        return new Menu(
                null,
                null,
                null,
                null,
                dto.getName(),
                dto.getCost(),
                filePath,
                true,
                dto.getUsePlanner()
        );
    }

    public void setImage(String path) { image = path; }
    public void setSoldTrue() {
        sold = true;
    }
    public void setSoldFalse() {
        sold = false;
    }
    public void setMenuFood(MenuFood food) {
        menuFood = food;
    }
    public void clearMenuFood() {
        menuFood = null;
    }
    public void usePlanner() {
        usePlanner = true;
    }
    public void notUsePlanner() {
        usePlanner = false;
    }
}
