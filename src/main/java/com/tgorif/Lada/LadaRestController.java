package com.tgorif.Lada;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumable")
public class LadaRestController {
    @PostMapping
    Consumable postConsumable(@RequestBody Consumable consumable){
        return ConsumableManager.put(consumable);
    }
}
