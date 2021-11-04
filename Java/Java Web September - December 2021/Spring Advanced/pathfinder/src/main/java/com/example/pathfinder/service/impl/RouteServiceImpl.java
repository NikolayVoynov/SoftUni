package com.example.pathfinder.service.impl;

import com.example.pathfinder.model.entity.RouteEntity;
import com.example.pathfinder.model.service.RouteServiceModel;
import com.example.pathfinder.model.view.RouteDetailsViewModel;
import com.example.pathfinder.model.view.RouteViewModel;
import com.example.pathfinder.repository.RouteRepository;
import com.example.pathfinder.service.CategoryService;
import com.example.pathfinder.service.RouteService;
import com.example.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {

    private final ModelMapper modelMapper;
    private final CategoryService categoryService;
    private final UserService userService;
    private final RouteRepository routeRepository;

    public RouteServiceImpl(ModelMapper modelMapper, CategoryService categoryService,
                            UserService userService, RouteRepository routeRepository) {
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
        this.userService = userService;
        this.routeRepository = routeRepository;
    }

    @Override
    public List<RouteViewModel> findAllRoutesView() {
        return routeRepository.
                findAll().
                stream().
                map(routeEntity -> {
                    RouteViewModel routeViewModel = modelMapper.map(routeEntity, RouteViewModel.class);

                    if (routeEntity.getPictures().isEmpty()) {
                        routeViewModel.setPictureUrl("/images/pic4.jpg");
                    } else {
                        routeViewModel.setPictureUrl(routeEntity.getPictures().stream().findFirst().get().getUrl());
                    }

                    return routeViewModel;
                }).collect(Collectors.toList());
    }

    @Override
    public void addNewRoute(RouteServiceModel routeServiceModel) {
        RouteEntity routeEntity = modelMapper.map(routeServiceModel, RouteEntity.class);
        routeEntity.setAuthor(userService.findCurrentLoginUserEntity());

        routeEntity.setCategories(routeServiceModel
                .getCategories()
                .stream()
                .map(categoryService::findCategoryByName)
                .collect(Collectors.toSet()));


        routeRepository.save(routeEntity);

    }

    @Override
    public RouteDetailsViewModel findRouteById(Long id) {
        return routeRepository
                .findById(id)
                .map(routeEntity -> modelMapper.map(routeEntity, RouteDetailsViewModel.class))
                .orElse(null);
    }
}
