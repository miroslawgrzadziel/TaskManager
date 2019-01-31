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
import javax.validation.groups.Default;
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
    public String registration(@Validated({Default.class, FullValidationUserGroup.class}) User user,
                               BindingResult errors,
                               Model model,
                               HttpServletRequest request,
                               HttpSession session) {

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
            userService.saveUser(user);
            model.addAttribute("user", user);
            session.setAttribute("user", user);
            return "index";
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
                        @Valid User user,
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
    public String logout(HttpSession session) {

        session.removeAttribute("user");
        return "index";
    }

    @RequestMapping("/list")
    public String showAll(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user/list";
    }

    @GetMapping("/edit")
    private String editUser(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "user/edit";
    }

    @PostMapping("/edit")
    public String editUser(@Validated({Default.class, FullValidationUserGroup.class}) User user,
                           BindingResult errors,
                           Model model,
                           HttpSession session,
                           HttpServletRequest request) {

        if (errors.hasErrors()) {
            return "user/edit";
        }

        try {
            if (!userRepository.findByEmail(user.getEmail()).getId().equals(user.getId())) {
                model.addAttribute("userexists", true);
                return "user/edit";
            }
        } catch (NullPointerException e) {
        }

        if (!user.getPassword().equals(user.getPasswordConfirm())) {
            model.addAttribute("passwordError", true);
            return "user/edit";
        }

        userService.saveUser(user);
        model.addAttribute("user", user);
        session.setAttribute("user", user);
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String add(Model model, @PathVariable Long id) {
        model.addAttribute("user", userRepository.findOne(id));
        return "user/register";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, HttpServletRequest request, HttpSession session) {
        User user = userRepository.findOne(id);
        userRepository.delete(user);
        User userSess = (User) session.getAttribute("user");
        if (userSess.getId().equals(user.getId())) {
            session.removeAttribute("user");
        }
        return "redirect:" + request.getContextPath()+ "/user/list";
    }

    @ModelAttribute("users")
    public List<User> users() {
        return userRepository.findAll();
    }
}
