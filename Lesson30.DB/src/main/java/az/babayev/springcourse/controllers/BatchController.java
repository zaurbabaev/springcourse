package az.babayev.springcourse.controllers;

import az.babayev.springcourse.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test-batch-update")
public class BatchController {

    private final PersonDAO dao;

    @Autowired
    public BatchController(PersonDAO dao) {
        this.dao = dao;
    }

    @GetMapping()
    public String index() {
        return "batch/index";
    }

    @GetMapping("/without")
    public String withoutBatch() {
        dao.testMultipleUpdate();
        return "redirect:/people";
    }

    @GetMapping("/with")
    public String withBatch() {
        dao.testBatchUpdate();
        return "redirect:/people";
    }

}
