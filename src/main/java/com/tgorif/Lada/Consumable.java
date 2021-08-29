package com.tgorif.Lada;
import org.springframework.data.annotation.Id;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Consumable {
    @Id
    public String id;
    public String name;
    public Date expiration;
    public String location;
    public boolean inConsumption;

    public Consumable(){}
    public Consumable(String name,String expiration,String location,boolean inConsumption){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.name=name;
            this.expiration = (Date) dateFormat.parse(expiration);
            this.location=location;
            this.inConsumption=inConsumption;
        }
        catch (ParseException e){
            System.out.println("Parse Exception for " + expiration  + " " + name);
        }
    }
    @Override
    public String toString() {
        return String.format(
                "Consumable[id=%s, name='%s', expiration='%s']",
                id, name, expiration.toString());
    }
}
