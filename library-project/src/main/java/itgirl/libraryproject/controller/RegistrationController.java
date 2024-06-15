package itgirl.libraryproject.controller;

import itgirl.libraryproject.model.MyUser;
import itgirl.libraryproject.service.impl.MyUserDetailsService;
import itgirl.libraryproject.service.impl.RegistrationService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
//@AllArgsConstructor
@RequestMapping("/register/")
public class RegistrationController {
    private final RegistrationService registrationService;

    @PostMapping("new-user")
    public String addUser(@RequestBody MyUser user){
        registrationService.addUser(user);
        return "User is saved";
    }
}
