package com.example.examspringfund.web;

import com.example.examspringfund.model.binding.ShipAddBindingModel;
import com.example.examspringfund.model.binding.AttackBindingModel;
import com.example.examspringfund.model.service.ShipServiceModel;
import com.example.examspringfund.service.ShipService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/ships")
public class ShipController {

    private final ModelMapper modelMapper;
    private final ShipService shipService;

    public ShipController(ModelMapper modelMapper, ShipService shipService) {
        this.modelMapper = modelMapper;
        this.shipService = shipService;
    }

    @ModelAttribute
    public ShipAddBindingModel shipAddBindingModel() {
        return new ShipAddBindingModel();
    }

    @GetMapping("/add")
    public String add() {
        return "ship-add";
    }


    @PostMapping("/add")
    public String addConfirm(@Valid ShipAddBindingModel shipAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("shipAddBindingModel", shipAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.shipAddBindingModel", bindingResult);


            return "redirect:add";
        }

        shipService.addShip(modelMapper
                .map(shipAddBindingModel, ShipServiceModel.class));

        return "redirect:/";
    }

    @PostMapping("/attack")
    public String attackShip(AttackBindingModel attackBindingModel) {
        Long attacker = attackBindingModel.getAttackShip();
        Long defender = attackBindingModel.getDefendShip();

        if (attacker.equals(defender)) {
            return "redirect:/";
        }

        shipService.fireOnTarget(attacker, defender);
        return "redirect:/";
    }



}
