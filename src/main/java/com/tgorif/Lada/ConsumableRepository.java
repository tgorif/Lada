package com.tgorif.Lada;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ConsumableRepository extends MongoRepository<Consumable, String> {
    public Consumable findByName(String name);
    public default Map<String,Integer> getQuantities(){
        Map<String,Integer> map = new HashMap<>();
        List<Consumable> list = findAll();
        for(Consumable consumable : list){
            if(map.containsKey(consumable.name)) map.replace(consumable.name,map.get(consumable.name)+1);
            else map.put(consumable.name,1);
        }
        for(Map.Entry<String, Integer> e : map.entrySet()){
            System.out.println(e.getKey() + " " +  e.getValue());
        }
        return map;
    }
    public List<Consumable> findAll();
}
