package com.hanbat.zanbanzero.entity.planner;

import com.hanbat.zanbanzero.dto.planner.PlannerDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Index;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Planner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Index(name = "planner_date_index")
    private LocalDate date;
    private String menus;

    public static Planner of(PlannerDto dto){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return new Planner(
                null,
                LocalDate.parse(dto.getDate(), formatter),
                dto.getMenus()
        );
    }

    public void setMenus(String menus) {
        this.menus = menus;
    }
}
