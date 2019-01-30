package taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import taskmanager.entity.User;
import taskmanager.repository.UserRepository;
import taskmanager.services.UserService;
import taskmanager.validator.groups.FullValidationUserGroup;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;


    @GetMapping("/registration")
    public String registration(Model model) {

        model.addAttribute("user", new User());
        return "user/registration";
    }

    @PostMapping("/registration")
    public String registration(@Valid User user,
                               BindingResult errors,
                               Model model,
                               HttpServletRequest request) {

        if (errors.hasErrors()) {
            return "user/registration";
        }

        if (userRepository.findByEmail(user.getEmail()) != null) {
            model.addAttribute("userexists", true);
            return "user/registration";
        }

        if (!user.getPassword().equals(user.getPasswordConfirm())) {
            model.addAttribute("passwordError", true);
            return "user/registration";
        } else {
            if (userRepository.findAll().isEmpty()) {
                user.setAdminChck(true);
            }
            userService.registerUser(user);
            return "index";
//            return "redirect:" + request.getContextPath() + "login";
        }
    }

    @GetMapping("/login")
    public String login(Model model) {

        model.addAttribute("user", new User());
        return "user/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session,
                        Model model,
                        @Validated({FullValidationUserGroup.class}) User user,
                        BindingResult errors) {

        boolean log = userService.loginUser(email, password, session);

        if (log) {
            model.addAttribute("user", userRepository.findByEmail(email));
            return "index";
        } else {
            model.addAttribute("passwordError", true);
            return "user/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession sess) {

        sess.removeAttribute("user");
        return "index";
    }


//    @GetMapping("/withoutLogin")
//    public String withoutLogin(HttpServletRequest request){
//
//        return "redirect:"+request.getContextPath()+"/user/list";
//    }


    @RequestMapping("/list")
    public String showAll(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user/list";
    }


    @GetMapping("/account")
    public String showDetails(HttpServletRequest request) {
        return "user/account";
    }

    @GetMapping("/edit/{id}")
    public String add(Model model, @PathVariable Long id) {
        model.addAttribute("user", userRepository.findOne(id));
        return "user/add";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        User user = userRepository.findOne(id);
        userRepository.delete(user);
        return "user/list";
    }

    @ModelAttribute("users")
    public List<User> users() {
        return userRepository.findAll();
    }
}
