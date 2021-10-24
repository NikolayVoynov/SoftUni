package com.example.examspringfund.service;

import com.example.examspringfund.model.service.ShipServiceModel;
import com.example.examspringfund.model.view.ShipViewModel;

import java.util.List;

public interface ShipService {
    void addShip(ShipServiceModel shipServiceModel);

    List<ShipViewModel> findAllShips();

    void fireOnTarget(Long attacker, Long defender);
}
