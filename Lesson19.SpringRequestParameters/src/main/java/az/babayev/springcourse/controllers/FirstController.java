package az.babayev.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request) { // HttpServletRequest http requestin bütün sorğularını saxlayır
        String name = request.getParameter("name"); // parametr daxilindəki name və surname key-dir key=value prinsipi ilə işləyir
        String surname = request.getParameter("surname"); //  http://localhost:8080/first/hello?name=Zaur&surname=Babayev
        System.out.println("Hello, " + name + " " + surname); // ekrana Hello Zaur Babayev çapa verəcək
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(@RequestParam(required = false, defaultValue = "") String name,
                              @RequestParam(required = false, defaultValue = "") String surname) {
        System.out.println("Hello, " + name + " " + surname + " from the goodbye page");
        return "first/goodbye";
    }


}
