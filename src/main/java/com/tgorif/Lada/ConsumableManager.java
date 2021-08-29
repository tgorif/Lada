package com.tgorif.Lada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class ConsumableManager {
    @Autowired
    public static ConsumableRepository consumableRepository;
    public ConsumableManager(ConsumableRepository consumableRepository){consumableRepository=consumableRepository;};
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
    public static Consumable put(Consumable consumable){
        consumableRepository.save(consumable);
        return consumable;
    }



}
