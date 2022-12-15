package my.babincev.spring.controllers;

import my.babincev.spring.models.Dog;
import my.babincev.spring.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dogs")
public class DogController {

    private final DogService dogService;

    @Autowired
    public DogController(DogService DogDAO) {
        this.dogService = DogDAO;
    }

    @GetMapping("/{id}")
    public String getDog(@PathVariable("id") int id, Model model) throws Exception {
        model.addAttribute("dog", dogService.getDog(id));
        return "dogs/show";
    }

    @GetMapping("/{id}/edit")
    public String editDog(@PathVariable("id") int id, Model model) throws Exception {
        model.addAttribute("dog", dogService.getDog(id));
        return "dogs/edit";
    }

    @GetMapping("/new")
    public String newDog(Model model){
        model.addAttribute("dog", new Dog());
        return "dogs/new";
    }

    @PostMapping()
    public String createDog(@ModelAttribute("dog") Dog dog){
        dogService.addDog(dog);
        return "redirect:/dogs";
    }

    @PatchMapping ("/{id}")
    public String editDog(@PathVariable("id") int id, @ModelAttribute("dog") Dog dog){
        dogService.updateDog(id, dog);
        return "redirect:/dogs";
    }

    @DeleteMapping("/{id}")
    public String deleteDog(@PathVariable("id") int id){
        dogService.deleteDog(id);
        return "redirect:/dogs";
    }

    @GetMapping()
    public String getAllDogPage(Model model){
        model.addAttribute("dogs", dogService.getDogs());
        return "dogs/showAll";
    }
}
