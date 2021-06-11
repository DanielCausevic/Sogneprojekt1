package com.sogne.service;

import com.sogne.models.Commune;
import com.sogne.models.Parish;
import com.sogne.repository.CommuneRepository;
import com.sogne.repository.ParishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParishService {
    @Autowired
    private CommuneRepository communeRepository;
    @Autowired
    private ParishRepository parishRepository;

    public Parish createParish(Parish parish) {
        Commune commune=communeRepository.findById(parish.getCommune().getId()).get();
        parish.setCommune(commune);
        /*if(parish.getStartOfLockdown() != null){
            parish.setLockedDown(true);
        }*/
        return parishRepository.save(parish);
    }

    public void deleteParish(Long Id){
        Parish parish = parishRepository.findById(Id).get();
        parishRepository.delete(parish);
    }

    public String getParishNameById(Long Id){
        String parishName = parishRepository.findById(Id).get().getName();
        return parishName;
    }

    public Parish updateParish(Parish parish){
        return parishRepository.save(parish);
    }

    public List<Parish> getAllParishes(){
        List<Parish> parishes = new ArrayList<>();
        for(Parish parish : parishRepository.findAll()){
            parishes.add(parish);
        }
        return parishes;
    }

    public List<Commune> getAllCommunes(){
        List<Commune> communes = new ArrayList<>();

        for(Commune commune : communeRepository.findAll()){
            double sum = 0;
            double parishes = 0;
            for(Parish parish : parishRepository.findAll()){
                if(parish.getCommune().getId() == commune.getId()){
                    sum += parish.getInfectionPressure();
                    parishes++;
                }
            }
            double average = Math.round(sum / parishes * 100.0) / 100.0;
            commune.setAverageInfectionPressure(average);
            communes.add(commune);
        }
        return communes;
    }
}
