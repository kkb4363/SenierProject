package com.hanbat.zanbanzero.service.menu;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hanbat.zanbanzero.dto.menu.*;
import com.hanbat.zanbanzero.exception.exceptions.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface MenuService {
    MenuUserInfoDtos getMenus();

    List<MenuManagerInfoDto> getMenusForManager();

    Boolean isPlanned();

    MenuDto addMenu(MenuUpdateDto dto, String filePath) throws SameNameException;

    void setFood(Long menuId, Long foodId) throws CantFindByIdException;

    MenuFoodDtos getFood();

    MenuInfoDto updateMenu(MenuUpdateDto dto, MultipartFile file, Long id, String uploadDir) throws CantFindByIdException, UploadFileException;

    MenuDto deleteMenu(Long id) throws CantFindByIdException;

    MenuDto setSoldOut(Long id, String type) throws CantFindByIdException, WrongParameter;

    MenuDto setPlanner(Long id) throws CantFindByIdException, WrongParameter;

    MenuDto changePlanner(Long id) throws CantFindByIdException;

    MenuFoodDto addFood(String name, Map<String, Integer> data) throws JsonProcessingException;

    MenuFoodDto getOneFood(Long id) throws CantFindByIdException;
}
