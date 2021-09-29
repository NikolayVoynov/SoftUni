package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.binding.UserLoginBindingModel;
import bg.softuni.mobilelele.model.service.UserLoginServiceModel;
import bg.softuni.mobilelele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserLogInController {

    private UserService userService;

    public UserLogInController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login() {
        return "auth-login";
    }

    @PostMapping()
    public String login(UserLoginBindingModel userLoginBindingModel) {

       boolean loginSuccessful = userService
                .login(new UserLoginServiceModel().setUsername(userLoginBindingModel.getUsername())
                        .setRawPassword(userLoginBindingModel.getPassword()));

        return "redirect:/index";
    }


}
