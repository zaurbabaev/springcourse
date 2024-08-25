package az.babayev.springcourse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping()
    public String sayHello() {
        return "hello_world";
    }

}
