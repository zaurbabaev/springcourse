package az.babayev.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        System.out.println("Hello, " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(@RequestParam(required = false, defaultValue = "") String name,
                              @RequestParam(required = false, defaultValue = "") String surname,
                              Model model) {
        model.addAttribute("message",
                "Hello, " + name + " " + surname);
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculate(@RequestParam(required = false) int a,
                            @RequestParam(required = false) int b,
                            @RequestParam(required = false) String action,
                            Model model) {
        double result = switch (action) {
            case "multiplication" -> a * b;
            case "addition" -> a + b;
            case "subtraction" -> a - b;
            case "division" -> (double) a / b;
            default -> 0;
        };
        model.addAttribute("message", "Result is " + result);
        return "first/calculator";
    }


}
