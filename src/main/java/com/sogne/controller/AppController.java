package com.sogne.controller;

import com.sogne.models.Commune;
import com.sogne.models.Parish;
import com.sogne.repository.CommuneRepository;
import com.sogne.repository.ParishRepository;
import com.sogne.service.ParishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class AppController {

    @Autowired
    private ParishService parishService;
    private ParishRepository parishRepository;
    /*@Autowired
    private CommuneRepository communeRepository;
    @Autowired
    private ParishRepository parishRepository;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() throws ParseException{
        Commune commune = new Commune();
        commune.setName("Københavns kommune");

        communeRepository.save(commune);

        Parish parish = new Parish();
        parish.setName("Sankt Andreas Sogn");
        parish.setCode(7004);
        parish.setInfectionPressure(1.5);
        String date1 = "2021-12-12";
        Date smd=new SimpleDateFormat("YYYY-MM-DD").parse(date1);
        parish.setStartOfLockdown(smd);
        parish.setCommune(commune);

        parishRepository.save(parish);
        return "";
    }*/

    @PostMapping("/create")
    public Parish createParish(@RequestBody Parish parish){
        return parishService.createParish(parish);
    }

    @GetMapping("/delete/{Id}")
    public String deleteParish(@PathVariable("Id") Long Id){
        parishService.deleteParish(Id);
        return "Sognen " + parishService.getParishNameById(Id) + " med id'et " + Id + " er blevet slettet fra listen.";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Model model) {
        model.addAttribute("parish", parishRepository.findById(id));
        return "update";
    }
    @PostMapping("/update")
    public String updateParish(@RequestBody Parish parish){
        parishService.updateParish(parish);
        return "redirect:/";
    }

    @GetMapping("/getAllParishes")
    public List<Parish> getParishes(){
        ArrayList<Parish> parishes = new ArrayList<>();
        return parishService.getAllParishes();
    }

    @GetMapping("/getAllCommunes")
    public List<Commune> getCommunes(){
        ArrayList<Commune> communes = new ArrayList<>();
        return parishService.getAllCommunes();
    }
}
