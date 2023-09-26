package com.hanbat.zanbanzero.entity.store;

import com.hanbat.zanbanzero.dto.store.StoreDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String info;
    private String image;

    public static Store of(Long id, StoreDto dto) {
        return new Store(
                id,
                dto.getName(),
                dto.getInfo(),
                dto.getImage()
        );
    }

    public void setInfo(StoreDto dto) {
        info = dto.getInfo();
    }
    public void setName(StoreDto dto) { name = dto.getName(); }
    public void setImage(String path) { image = path; }
}