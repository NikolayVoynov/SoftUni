package com.example.pathfinder.service.impl;

import com.example.pathfinder.model.entity.Comment;
import com.example.pathfinder.model.service.CommentServiceModel;
import com.example.pathfinder.model.view.CommentViewModel;
import com.example.pathfinder.repository.CommentRepository;
import com.example.pathfinder.repository.RouteRepository;
import com.example.pathfinder.repository.UserRepository;
import com.example.pathfinder.service.CommentService;
import com.example.pathfinder.service.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private final RouteRepository routeRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    public CommentServiceImpl(RouteRepository routeRepository,
                              UserRepository userRepository,
                              CommentRepository commentRepository) {
        this.routeRepository = routeRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public CommentViewModel createComment(CommentServiceModel commentServiceModel) {

        Objects.requireNonNull(commentServiceModel.getCreator());

        var route = routeRepository.
                findById(commentServiceModel.getRouteId()).
                orElseThrow(() -> new ObjectNotFoundException("Route with id " + commentServiceModel.getRouteId() + " not found!"));

        var author = userRepository.
                findByEmail(commentServiceModel.getCreator()).
                orElseThrow(() -> new ObjectNotFoundException("User with email " + commentServiceModel.getCreator() + " not found!"));

        Comment newComment = new Comment();
        newComment.setApproved(false);
        newComment.setTextContent(commentServiceModel.getMessage());
        newComment.setCreated(LocalDateTime.now());
        newComment.setRoute(route);
        newComment.setAuthor(author);

        Comment savedComment = commentRepository.save(newComment);

        return mapAsComment(savedComment);
    }

    @Transactional
    @Override
    public List<CommentViewModel> getComments(Long routeId) {
        var routeOpt = routeRepository.
                findById(routeId);

        if (routeOpt.isEmpty()) {
            throw new ObjectNotFoundException("Route with id " + routeId + " was not found!");
        }

        return routeOpt.
                get().
                getComments().
                stream().
                map(this::mapAsComment).
                collect(Collectors.toList());
    }

    private CommentViewModel mapAsComment(Comment commentEntity) {
        CommentViewModel commentViewModel = new CommentViewModel();

        commentViewModel.
                setCommentId(commentEntity.getId()).
                setCanApprove(true).
                setCanDelete(true).
                setCreated(commentEntity.getCreated()).
                setMessage(commentEntity.getTextContent()).
                setUser(commentEntity.getAuthor().getFullName());


        return commentViewModel;
    }
}
