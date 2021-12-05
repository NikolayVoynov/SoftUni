package com.example.pathfinder.service;

import com.example.pathfinder.model.service.CommentServiceModel;
import com.example.pathfinder.model.view.CommentViewModel;

import java.util.List;

public interface CommentService {

    CommentViewModel createComment(CommentServiceModel commentServiceModel);


    List<CommentViewModel> getComments(Long routeId);

}
