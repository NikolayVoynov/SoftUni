package com.example.gira.web;

import com.example.gira.model.binding.TaskAddBindingModel;
import com.example.gira.model.service.TaskServiceModel;
import com.example.gira.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final ModelMapper modelMapper;
    private final TaskService taskService;

    public TaskController(ModelMapper modelMapper, TaskService taskService) {
        this.modelMapper = modelMapper;
        this.taskService = taskService;
    }

    @ModelAttribute
    public TaskAddBindingModel taskAddBindingModel() {
        return new TaskAddBindingModel();
    }

    @GetMapping("/add")
    public String add() {
        return "add-task";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid TaskAddBindingModel taskAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("taskAddBindingModel", taskAddBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.taskAddBindingModel", bindingResult);

            return "redirect:add";
        }

        taskService.addTask(modelMapper.map(taskAddBindingModel, TaskServiceModel.class));

        return "redirect:/";
    }
}
