package com.pxp.SNILS.demo.controller;

import com.pxp.SNILS.demo.service.SnilsService;
import com.pxp.SNILS.demo.entity.Snils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SnilsController {

    @Autowired
    private SnilsService SnilsService;

//    @RequestMapping(value = "info", method = RequestMethod.GET)
//    public String info(){
//        return "The application is up...";
//    }

    @RequestMapping(value = "createSnils", method = RequestMethod.POST)
    public String createSnils(@RequestParam int id, @RequestParam String number){
        Snils snils=new Snils(id,number);
        return SnilsService.createSnils(snils);
    }

    @GetMapping("/")
    public String readSnils(Model model){
        try {
            Iterable<Snils> snilsList = SnilsService.readSnils();
            model.addAttribute("snilsList", snilsList);
        }catch(NullPointerException e){}
        return "index";
    }

//    @RequestMapping(value = "updateSnils", method = RequestMethod.PUT)
//    public String updateSnils(@RequestBody Snils Snils){
//        return SnilsService.updateSnils(Snils);
//    }
//
//    @RequestMapping(value = "deleteSnils", method = RequestMethod.DELETE)
//    public String deleteSnils(@RequestBody Snils Snils){
//        return SnilsService.deleteSnils(Snils);
//    }
}
