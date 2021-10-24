package com.example.examspringfund.service.impl;

import com.example.examspringfund.model.entity.ShipEntity;
import com.example.examspringfund.model.service.ShipServiceModel;
import com.example.examspringfund.model.view.ShipViewModel;
import com.example.examspringfund.repository.ShipRepository;
import com.example.examspringfund.sec.CurrentUser;
import com.example.examspringfund.service.CategoryService;
import com.example.examspringfund.service.ShipService;
import com.example.examspringfund.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipServiceImpl implements ShipService {

    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;
    private final ShipRepository shipRepository;

    public ShipServiceImpl(ModelMapper modelMapper, CurrentUser currentUser, UserService userService, CategoryService categoryService, ShipRepository shipRepository) {
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
        this.shipRepository = shipRepository;
    }

    @Override
    public void addShip(ShipServiceModel shipServiceModel) {

        ShipEntity shipEntity = modelMapper.map(shipServiceModel, ShipEntity.class);
        shipEntity.setUser(userService.findById(currentUser.getId()));
        shipEntity.setCategory(categoryService.findByCategoryNameEnum(shipServiceModel.getCategory()));

        shipRepository.save(shipEntity);
    }


    @Override
    public List<ShipViewModel> findAllShips() {
        return shipRepository.findAll()
                .stream()
                .map(s -> modelMapper.map(s, ShipViewModel.class))
                .collect(Collectors.toList());
    }


    @Override
    public void fireOnTarget(Long attacker, Long defender) {
        ShipEntity attacking = shipRepository.findById(attacker).orElse(null);
        ShipEntity defending = shipRepository.findById(defender).orElse(null);

        if (defending != null && attacking != null) {
            if (attacking.getUser().getId().equals(defending.getUser().getId())) {
                return;
            }

            defending.setHealth(defending.getHealth() - attacking.getPower());
            shipRepository.save(defending);
            if (defending.getHealth() <= 0) {
                shipRepository.deleteById(defender);
            }
        }

    }



}
