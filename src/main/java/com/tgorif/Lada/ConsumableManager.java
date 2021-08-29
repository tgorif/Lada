package com.tgorif.Lada;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsumableManager {
    @Autowired
    private ConsumableRepository consumableRepository;

    public ConsumableManager(){};

    public Consumable findByName(String name){ return consumableRepository.findByName(name);}
    public List<Consumable> findAll(){ return consumableRepository.findAll();}
    public Map<String,Integer> getQuantities(){
        Map<String,Integer> map = new HashMap<>();
        for(Consumable c : findAll()){
            if(map.containsKey(c.name)) map.replace(c.name,map.get(c.name)+1);
            else map.put(c.name,1);
        }
        return map;
    }



}
