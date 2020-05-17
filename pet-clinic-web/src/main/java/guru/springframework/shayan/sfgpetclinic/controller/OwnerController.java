package guru.springframework.shayan.sfgpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.shayan.sfgpetclinic.service.OwnerService;

/**
 * Created by Shayan Ahmad (sahmed) on 29-Nov-19.
 */
@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/index", "/index.html"})
    public String listVets(Model model) {
        model.addAttribute("ownersList", ownerService.findAll());

        return "owners/index";
    }

    @RequestMapping("find")
    public String findOwners(){
        return "notImplemented";
    }
}
