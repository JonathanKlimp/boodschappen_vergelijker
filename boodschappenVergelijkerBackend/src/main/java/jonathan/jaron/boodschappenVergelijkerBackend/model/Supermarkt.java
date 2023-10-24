package jonathan.jaron.boodschappenVergelijkerBackend.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

public class Supermarkt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String naam;
    String url;
    String merkNaam;
    String logo;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    List<Product> producten;

    @JsonGetter("naam")
    public String getNaam() {
        return naam;
    }

    @JsonSetter("n")
    public void setNaam(String naam) {
        this.naam = naam;
    }

    @JsonGetter("url")
    public String getUrl() {
        return url;
    }

    @JsonGetter("id")
    public int getId() {
        return id;
    }

    @JsonSetter("u")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonGetter("merkNaam")
    public String getMerkNaam() {
        return merkNaam;
    }

    @JsonSetter("c")
    public void setMerkNaam(String merkNaam) {
        this.merkNaam = merkNaam;
    }

    @JsonGetter("logo")
    public String getLogo() {
        return logo;
    }

    @JsonSetter("i")
    public void setLogo(String logo) {
        this.logo = logo;
    }

    @JsonGetter("d")
    public List<Product> getProducten() {
        return producten;
    }

    @JsonSetter("d")
    public void setProducten(List<Product> producten) {
        this.producten = producten;
    }

    @Override
    public String toString() {
        return "Supermarkt: " + "id=" + id + ", naam='" + naam + '\'' + ", url='" + url + '\'' + ", merkNaam='" + merkNaam + '\'' + ", logo='" + logo + '\'' + '}';
    }

    public void setId(int id) {
        this.id = id;
    }
}
