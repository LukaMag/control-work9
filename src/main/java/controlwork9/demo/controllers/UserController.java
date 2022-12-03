package controlwork9.demo.controllers;

import controlwork9.demo.entity.User;
import controlwork9.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "user-create";
    }

    @PostMapping("/register")
    public String createUser(User user, Model model){
        String msg = "Something went wrong check there";
        if(!userService.createUser(user))
        {
            model.addAttribute("error",msg);
            return "/register";
        }
        return "redirect:/";
    }

}
