package my.babincev.spring.controllers;


import my.babincev.spring.dao.PersonDAO;
import my.babincev.spring.models.Person;
import my.babincev.spring.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping()
    public String getPeople(Model model){
        // получение всех людей из DAO и передача на отображение в представление
        model.addAttribute("people", peopleService.getPeople());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String getPerson(@PathVariable("id") int id, Model model) throws Exception {
        // получение одного человека по id из DAO и передача через отображение в представление
        model.addAttribute("person", peopleService.getPerson(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("person", new Person());
        return "people/new";
    }

    @PostMapping()
    public String createPerson(@ModelAttribute("person") @Valid Person person,
                               BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "/people/new";

        peopleService.savePerson(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String editPerson(Model model, @PathVariable("id") int id) throws Exception {
        model.addAttribute("person", peopleService.getPerson(id));
        return "/people/edit";
    }

    @PatchMapping("/{id}")
    public String updatePerson(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult,
                               @PathVariable("id") int id){
        if(bindingResult.hasErrors())
            return "people/edit";

        peopleService.updatePerson(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable("id") int id) throws Exception {
        peopleService.deletePerson(id);
        return "redirect:/people";
    }
}
