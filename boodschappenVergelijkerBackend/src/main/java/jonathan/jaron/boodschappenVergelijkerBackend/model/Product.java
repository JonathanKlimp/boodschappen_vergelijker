package jonathan.jaron.boodschappenVergelijkerBackend.model;

import jakarta.persistence.*;
import jonathan.jaron.boodschappenVergelijkerBackend.repository.ProductRepository;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @ManyToOne
    Supermarkt supermarkt;
    String naam;
    String url;
    double prijs;
    String inhoud;

    public int getId() {
        return id;
    }

    public Supermarkt getSupermarkt() {
        return supermarkt;
    }

    public void setSupermarkt(Supermarkt supermarkt) {
        this.supermarkt = supermarkt;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public String getInhoud() {
        return inhoud;
    }

    public void setInhoud(String inhoud) {
        this.inhoud = inhoud;
    }
}
