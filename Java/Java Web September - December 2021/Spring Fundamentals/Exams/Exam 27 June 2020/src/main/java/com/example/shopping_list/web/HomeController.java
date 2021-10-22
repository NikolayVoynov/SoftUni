package com.example.shopping_list.web;

import com.example.shopping_list.model.entity.CategoryNameEnum;
import com.example.shopping_list.model.view.ProductViewModel;
import com.example.shopping_list.sec.CurrentUser;
import com.example.shopping_list.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final ProductService productService;

    public HomeController(CurrentUser currentUser, ProductService productService) {
        this.currentUser = currentUser;
        this.productService = productService;
    }


    @GetMapping()
    public String index(Model model) {

        if (currentUser.getId() == null) {

            return "index";
        }

        List<ProductViewModel> products = productService.findAllProducts();
        List<ProductViewModel> foods = productService.findAllProductsWithCategory(CategoryNameEnum.Food);
        List<ProductViewModel> drinks = productService.findAllProductsWithCategory(CategoryNameEnum.Drink);
        List<ProductViewModel> households = productService.findAllProductsWithCategory(CategoryNameEnum.Household);
        List<ProductViewModel> other = productService.findAllProductsWithCategory(CategoryNameEnum.Other);


        model.addAttribute("totalPrice",
                products
                        .stream()
                        .map(productViewModel -> productViewModel.getPrice())
                        .reduce((a, b) -> a.add(b))
                        .orElse(BigDecimal.valueOf(0))
        );

        model.addAttribute("foods", foods);
        model.addAttribute("drinks", drinks);
        model.addAttribute("households", households);
        model.addAttribute("other", other);

        return "home";
    }
}
