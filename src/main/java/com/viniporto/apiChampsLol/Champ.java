package com.viniporto.apiChampsLol;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "champsLol")
public class Champ {
    
    @Id
    private String id;
    private String name;
    private String role[];
    private int rpPrice;
    private int eaPrice;
    private String releaseDate;
    private boolean sale;
    private String image;

    public Champ(){

    }

    public Champ(String name, String[] role, int rpPrice, int eaPrice, String releaseDate, boolean sale,
            String image) {
        this.name = name;
        this.role = role;
        this.rpPrice = rpPrice;
        this.eaPrice = eaPrice;
        this.releaseDate = releaseDate;
        this.sale = sale;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String[] getRole() {
        return role;
    }

    public int getRpPrice() {
        return rpPrice;
    }

    public int getEaPrice() {
        return eaPrice;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public boolean isSale() {
        return sale;
    }

    public String getImage() {
        return image;
    }

    
}
