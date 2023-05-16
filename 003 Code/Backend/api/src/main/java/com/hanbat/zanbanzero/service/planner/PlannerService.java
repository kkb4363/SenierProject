package com.hanbat.zanbanzero.service.planner;

import com.hanbat.zanbanzero.dto.planner.PlannerDto;
import com.hanbat.zanbanzero.entity.menu.Menu;
import com.hanbat.zanbanzero.entity.planner.Planner;
import com.hanbat.zanbanzero.exception.controller.exceptions.WrongParameter;
import com.hanbat.zanbanzero.repository.menu.MenuRepository;
import com.hanbat.zanbanzero.repository.planner.PlannerRepository;
import com.hanbat.zanbanzero.service.DateTools;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlannerService {

    private final PlannerRepository repository;
    private final MenuRepository menuRepository;

    private Menu getPlannerMenu() {
        return menuRepository.findByUsePlanner(true);
    }

    @Transactional
    public void setPlanner(PlannerDto dto, int year, int month, int day) {
        String dateString = DateTools.makeResponseDateFormatString(year, month, day);

        Planner planner = repository.findOnePlanner(dateString);
        if (planner == null) {
            dto.setDate(dateString);

            repository.save(Planner.createPlanner(dto, getPlannerMenu()));
        }
        else planner.setMenus(dto.getMenus());

    }

    public PlannerDto getOnePlanner(int year, int month, int day) {
        String date = DateTools.makeResponseDateFormatString(year, month, day);
        Planner planner = repository.findOnePlanner(date);
        if (planner == null) return null;

        return PlannerDto.createPlannerDto(planner);
    }

    public List<PlannerDto> getPlanner(int year, int month) throws WrongParameter {
        String start = DateTools.makeResponseDateFormatString(year, month, 1);
        String end = DateTools.makeResponseDateFormatString(year, month, DateTools.getLastDay(year, month));

        List<Planner> result = repository.findAllByDateBetween(start, end);
        return result.stream()
                .map(planner -> PlannerDto.createPlannerDto(planner))
                .collect(Collectors.toList());
    }
}
