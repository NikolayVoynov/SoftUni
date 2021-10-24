package com.example.examspringfund.web;

import com.example.examspringfund.model.binding.AttackBindingModel;
import com.example.examspringfund.model.view.ShipViewModel;
import com.example.examspringfund.sec.CurrentUser;
import com.example.examspringfund.service.ShipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final ShipService shipService;

    public HomeController(CurrentUser currentUser, ShipService shipService) {
        this.currentUser = currentUser;
        this.shipService = shipService;
    }

    @ModelAttribute
    private AttackBindingModel attackBindingModel() {
        return new AttackBindingModel();
    }

    @GetMapping()
    public String index(Model model) {

        if (currentUser.getId() == null) {
            return "index";
        }

        List<ShipViewModel> ships = shipService.findAllShips();
        model.addAttribute("ships", ships);

        return "home";
    }

}
