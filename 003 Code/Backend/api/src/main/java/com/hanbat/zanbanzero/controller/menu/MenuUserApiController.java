package com.hanbat.zanbanzero.controller.menu;

import com.hanbat.zanbanzero.dto.menu.MenuDto;
import com.hanbat.zanbanzero.dto.menu.MenuInfoDto;
import com.hanbat.zanbanzero.exception.exceptions.CantFindByIdException;
import com.hanbat.zanbanzero.service.menu.MenuService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user/")
public class MenuUserApiController {

    private final MenuService menuService;

    @Operation(summary="전체 메뉴 조회")
    @GetMapping("menu")
    public ResponseEntity<List<MenuDto>> getMenus() {
        return ResponseEntity.ok(menuService.getMenus());
    }

    @Operation(summary="특정 메뉴 상세정보 조회")
    @GetMapping("menu/{id}")
    public ResponseEntity<MenuInfoDto> getMenuInfo(@PathVariable Long id) throws CantFindByIdException {
        return ResponseEntity.ok(menuService.getMenuInfo(id));
    }
}