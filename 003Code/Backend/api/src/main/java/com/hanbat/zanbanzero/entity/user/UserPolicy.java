package com.hanbat.zanbanzero.entity.user;

import com.hanbat.zanbanzero.dto.user.user.UserPolicyDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserPolicy {
    @Id
    private Long id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    private boolean monday;
    private boolean tuesday;
    private boolean wednesday;
    private boolean thursday;
    private boolean friday;

    private Long defaultMenu;

    public static UserPolicy createNewUserPolicy(User user) {
        return new UserPolicy(
                null,
                user,
                false,
                false,
                false,
                false,
                false,
                null
        );
    }

    public void setPolicy(UserPolicyDto dto) {
        monday = dto.isMonday();
        tuesday = dto.isTuesday();
        wednesday = dto.isWednesday();
        thursday = dto.isThursday();
        friday = dto.isFriday();
        defaultMenu = dto.getDefaultMenu();
    }

    public void setDefaultMenu(Long id) {
        defaultMenu = id;
    }
    public void clearDefaultMenu() {
        defaultMenu = null;
    }
}
