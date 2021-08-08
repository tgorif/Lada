package com.tgorif.Lada;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("ItemType")
public class ItemTypeManager {
    public ItemTypeRepository itemTypeRepository;

    public ItemTypeManager(ItemTypeRepository itemTypeRepository){
        this.itemTypeRepository=itemTypeRepository;
    }
    @PostMapping
    public ItemType postItemType(@RequestBody ItemType itemType){
        itemTypeRepository.save(itemType);
        return itemType;
    }
    @GetMapping("{id}")
    public Optional<ItemType> getItemType(@PathVariable String id){
        return itemTypeRepository.findById(id);
    }
    @GetMapping
    public Iterable<ItemType> getItemType(){
        return itemTypeRepository.findAll();
    }
}
interface ItemTypeRepository extends CrudRepository<ItemType,String>{}
