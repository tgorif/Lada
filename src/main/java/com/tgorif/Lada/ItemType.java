package com.tgorif.Lada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemType {
    @Id
    public String barcode;
    public String name;
    public int AmountPerUnit;
    @Autowired
    public ItemRepository itemRepository;

    public ItemType(){};

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmountPerUnit() {
        return AmountPerUnit;
    }

    public void setAmountPerUnit(int amountPerUnit) {
        AmountPerUnit = amountPerUnit;
    }
}
interface ItemRepository extends CrudRepository<Item,String>{}


