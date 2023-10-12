package jonathan.jaron.boodschappenVergelijkerBackend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonManagedReference
    @OneToMany(mappedBy = "supermarkt", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getUrl() {
        return url;
    }

    public int getId() {
        return id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMerkNaam() {
        return merkNaam;
    }

    public void setMerkNaam(String merkNaam) {
        this.merkNaam = merkNaam;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<Product> getProducten() {
        return producten;
    }

    public void setProducten(List<Product> producten) {
        this.producten = producten;
    }
}
