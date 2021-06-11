package com.sogne.controller;

import com.sogne.models.Commune;
import com.sogne.models.Parish;
import com.sogne.repository.ParishRepository;
import com.sogne.service.ParishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@Controller
public class CController {

    @Autowired
    ParishService parishService;
    @Autowired
    private ParishRepository parishRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("parishes", parishService.getAllParishes());
        model.addAttribute("communes", parishService.getAllCommunes());
        return "index";
    }
    @GetMapping("/deleteOnSite/{Id}")
    public String deleteParish(@PathVariable("Id") Long Id){
        parishService.deleteParish(Id);
        return "redirect:/";
    }

    @RequestMapping(value = "/updateOnSite/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") long id, Model model) {
        model.addAttribute("parish", parishService.getAllParishes().get((int) (id-1)));
        return "updateOnSite";
    }
    @PostMapping("/updateOnSite")
    //public String update(@RequestParam Long id, @RequestParam int code, @RequestParam String name, @RequestParam Commune commune, @RequestParam int infectionPressure, @RequestParam Date startOfLockdown){
    public String update(WebRequest webRequest){
        String code = webRequest.getParameter("code");
        String name = webRequest.getParameter("name");
        String commune = webRequest.getParameter("commune");
        String infectionPressure = webRequest.getParameter("infectionPressure");
        String startLockDown = webRequest.getParameter("startLockDown");
        //Parish parish = new Parish(id, code, name, commune, infectionPressure, startOfLockdown);
        //parishRepository.save(parish);
        return "redirect:/";
    }
}
