package guru.springframework.shayan.sfgpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Shayan Ahmad (sahmed) on 29-Nov-19.
 */
@Controller
public class OwnerController {

    @RequestMapping({"owners/index", "owners", "owners/index.html"})
    public String listVets(){
        return "owners/index";
    }

}
