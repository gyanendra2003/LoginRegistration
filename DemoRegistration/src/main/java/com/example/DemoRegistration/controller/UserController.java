package com.example.DemoRegistration.controller;
import com.example.DemoRegistration.entity.User;
import com.example.DemoRegistration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register"; // returns register.html template
    }

    @PostMapping("/register")
    public String registerUser(User user) {
        userService.saveUser(user);
        return "redirect:/register?success";
    }

    @GetMapping("/users")
    public String showUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users"; // returns users.html template
    }
    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // returns login.html template
    }
    @PostMapping("/login")
    public String loginUser(@RequestParam String email, @RequestParam String password) {
        // Here you would typically validate the credentials
        // For now, let's just assume validation is successful
        if (isValidUser(email, password)) {
            return "redirect:/dashboard"; // Redirect to a secure page after login
        } else {
            return "redirect:/login?error"; // Redirect back to login with an error
        }
    }

    // Example method to validate user (this should be more secure in real apps)
    private boolean isValidUser(String email, String password) {
        // This is just a placeholder. You should implement actual authentication logic.
        return true; // Replace this with real validation
    }



}
