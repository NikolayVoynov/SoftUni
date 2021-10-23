package com.example.gira.service.impl;

import com.example.gira.model.entity.TaskEntity;
import com.example.gira.model.entity.enums.ProgressNameEnum;
import com.example.gira.model.service.TaskServiceModel;
import com.example.gira.model.view.TaskViewModel;
import com.example.gira.repository.TaskRepository;
import com.example.gira.sec.CurrentUser;
import com.example.gira.service.ClassificationService;
import com.example.gira.service.TaskService;
import com.example.gira.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ClassificationService classificationService;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CurrentUser currentUser;

    public TaskServiceImpl(TaskRepository taskRepository, ClassificationService classificationService,
                           ModelMapper modelMapper, UserService userService, CurrentUser currentUser) {
        this.taskRepository = taskRepository;
        this.classificationService = classificationService;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.currentUser = currentUser;
    }


    @Override
    public void addTask(TaskServiceModel taskServiceModel) {

        TaskEntity taskEntity = modelMapper.map(taskServiceModel, TaskEntity.class);
        taskEntity.setUser(userService.findById(currentUser.getId()));
        taskEntity.setClassification(classificationService.findByClassificationNameEnum(taskServiceModel.getClassification()));
        taskEntity.setProgress(ProgressNameEnum.OPEN);

        taskRepository.save(taskEntity);
    }

    @Override
    public List<TaskViewModel> findAllTasks(Long id) {
        return taskRepository
                .findAllByUserId(id)
                .stream()
                .map(taskEntity -> {
                    TaskViewModel taskViewModel = modelMapper.map(taskEntity, TaskViewModel.class);
                    taskViewModel.setUsername(taskEntity.getUser().getUsername());

                    return taskViewModel;
                })
                .collect(Collectors.toList());
    }


    @Override
    public TaskViewModel findTaskByIdAndSetProgress(Long id) {
        TaskEntity taskEntity = taskRepository.findById(id).orElse(null);

        switch (Objects.requireNonNull(taskEntity).getProgress().name()) {
            case "OPEN":
                taskEntity.setProgress(ProgressNameEnum.IN_PROGRESS);
                taskRepository.save(taskEntity);
                break;
            case "IN_PROGRESS":
                taskEntity.setProgress(ProgressNameEnum.COMPLETED);
                taskRepository.save(taskEntity);
                break;
            case "COMPLETED":
                taskRepository.delete(taskEntity);
                break;
        }

        return modelMapper.map(taskEntity, TaskViewModel.class);
    }
}
