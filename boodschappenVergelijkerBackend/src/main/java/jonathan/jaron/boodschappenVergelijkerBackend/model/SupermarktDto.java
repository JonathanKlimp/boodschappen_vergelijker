package jonathan.jaron.boodschappenVergelijkerBackend.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.persistence.*;

import java.util.List;


public class SupermarktDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String naam;
    String url;
    String merkNaam;
    String logo;

    @JsonManagedReference
    @OneToMany(mappedBy = "supermarkt", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<ProductDto> producten;

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

    @JsonSetter("logo")
    public String getLogo() {
        return logo;
    }

    @JsonSetter("i")
    public void setLogo(String logo) {
        this.logo = logo;
    }

    @JsonGetter("d")
    public List<ProductDto> getProducten() {
        return producten;
    }

    @JsonSetter("d")
    public void setProducten(List<ProductDto> producten) {
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
