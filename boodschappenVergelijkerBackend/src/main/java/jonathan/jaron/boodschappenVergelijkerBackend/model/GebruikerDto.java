package jonathan.jaron.boodschappenVergelijkerBackend.model;

import jakarta.persistence.*;

import java.util.List;


public class GebruikerDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String gebruikersnaam;

    String wachtwoord;

    @OneToMany
    List<ProductDto> producten;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public void setGebruikersnaam(String gebruikersNaam) {
        this.gebruikersnaam = gebruikersNaam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public List<ProductDto> getProducten() {
        return producten;
    }

    public void setProducten(List<ProductDto> producten) {
        this.producten = producten;
    }
}
