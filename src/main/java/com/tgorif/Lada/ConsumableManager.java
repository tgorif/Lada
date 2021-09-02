package com.tgorif.Lada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ConsumableManager {
    @Autowired
    public ConsumableRepository repository;
    public WebClient client = WebClient.create("http://localhost:7634/Consumable");
    public static ConsumableRepository consumableRepository;
    public ConsumableManager(){
    };
    public Consumable findByName(String name){ return consumableRepository.findByName(name);}
    @PostConstruct
    private void initRepository(){
        consumableRepository=repository;
    }

    public List<Consumable> findAll(){
        return consumableRepository.findAll();}
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
    @GetMapping
    public String index(Model model){
        System.out.println("dsad" + repository.findAll().size());
        model.addAllAttributes(repository.findAll());
        return "Consumable";
    }



}
