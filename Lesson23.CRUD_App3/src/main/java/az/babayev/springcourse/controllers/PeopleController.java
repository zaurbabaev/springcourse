package az.babayev.springcourse.controllers;

import az.babayev.springcourse.dao.PersonDAO;
import az.babayev.springcourse.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO dao;
    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO dao, PersonDAO personDAO) {
        this.dao = dao;
        this.personDAO = personDAO;
    }

    @GetMapping
    public String index(Model model) {
        // DAO-dan bütün personları alxırıq və onları html-ə göndəririk.
        model.addAttribute("people", dao.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model) {
        // DAO-dan id-əsasında person alırıq və onu html-lə göndəririk.
        model.addAttribute("person", dao.show(id));
        return "people/show";
    }

//    @GetMapping("/new")
//    public String newPerson(Model model){
//        model.addAttribute("person",new Person());
//        return "people/new";
//    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute Person person) {
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute Person person) {
        dao.save(person);
        return "redirect:/people";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("person", personDAO.show(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute Person person, @PathVariable int id) {
        dao.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        dao.delete(id);
        return "redirect:/people";
    }
}
