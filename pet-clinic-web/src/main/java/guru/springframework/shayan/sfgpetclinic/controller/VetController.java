package guru.springframework.shayan.sfgpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.shayan.sfgpetclinic.service.VetService;

/**
 * Created by Shayan Ahmad (sahmed) on 29-Nov-19.
 */
@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"vets/index", "vets", "vets/index.html", "vets.html"})
    public String listVets(Model model) {
        model.addAttribute("vetsList", vetService.findAll());

        return "vets/index";
    }

}
