package jonathan.jaron.boodschappenVergelijkerBackend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Gebruiker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String gebruikersnaam;

    String wachtwoord;

    @OneToMany
    List<Product> producten;

    public int getId() {
        return id;
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

    public List<Product> getProducten() {
        return producten;
    }

    public void setProducten(List<Product> producten) {
        this.producten = producten;
    }
}
