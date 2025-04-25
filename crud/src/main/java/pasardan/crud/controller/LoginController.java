package pasardan.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class LoginController {
     @GetMapping("/login")
    public String showLoginPage() {
        return "login";  // This corresponds to login.html
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username, @RequestParam String password) {
        // Implement your login logic here
        return "redirect:/dashboard";  // Redirect after successful login
    }
}
