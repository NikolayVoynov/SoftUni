package com.example.examprep.service;

import com.example.examprep.model.service.OrderServiceModel;
import com.example.examprep.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {
    void addOrder(OrderServiceModel orderServiceModel);

    List<OrderViewModel> findAllOrderOrderByPriceDesc();

    void readyOrder(Long id);

}
