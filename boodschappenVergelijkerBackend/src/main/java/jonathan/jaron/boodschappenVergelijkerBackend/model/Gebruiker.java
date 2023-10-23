package jonathan.jaron.boodschappenVergelijkerBackend.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Gebruiker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String gebruikersnaam;

    String wachtwoord;

    @OneToMany
    List<ProductDto> producten = new ArrayList<>();

    public void setId(int id) {
        this.id = id;
    }

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

    public List<ProductDto> getProducten() {
        return producten;
    }

    public void setProducten(List<ProductDto> producten) {
        this.producten = producten;
    }

    public void addProduct(ProductDto productDto) {
        this.producten.add(productDto);
    }

    @Override
    public String toString() {
        return "Gebruiker{" +
                "id=" + id +
                ", gebruikersnaam='" + gebruikersnaam + '\'' +
                ", wachtwoord='" + wachtwoord + '\'' +
                ", producten=" + producten +
                '}';
    }
}

