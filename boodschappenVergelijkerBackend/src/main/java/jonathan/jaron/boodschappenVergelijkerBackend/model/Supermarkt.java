package jonathan.jaron.boodschappenVergelijkerBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Supermarkt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @JsonProperty("n")
    String naam;

    @JsonProperty("u")
    String url;

    @JsonProperty("c")
    String merkNaam;

    @JsonProperty("i")
    String logo;
    @OneToMany(mappedBy = "supermarkt", cascade = CascadeType.ALL)
    @JsonProperty("d")
    List<Product> producten;

    public String getNaam() {
        return naam;
    }

    @Override
    public String toString() {
        return "Supermarkt{" +
                "id=" + id +
                ", n='" + naam + '\'' +
                ", u='" + url + '\'' +
                ", c='" + merkNaam + '\'' +
                ", i='" + logo + '\'' +
                '}';
    }

    public void setNaam(String n) {
        this.naam = n;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String u) {
        this.url = u;
    }

    public String getMerkNaam() {
        return merkNaam;
    }

    public void setMerkNaam(String c) {
        this.merkNaam = c;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String i) {
        this.logo = i;
    }

    public List<Product> getProducten() {
        return producten;
    }

    public void setProducten(List<Product> d) {
        this.producten = d;
    }
}
