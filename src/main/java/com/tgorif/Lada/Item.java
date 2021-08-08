package com.tgorif.Lada;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class Item {
    @Id
    public ItemType itemType;
    Date added;
    Date expiration;

    public Item(){}

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }
}

