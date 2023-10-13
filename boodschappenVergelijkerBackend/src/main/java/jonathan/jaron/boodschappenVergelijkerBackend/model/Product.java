package jonathan.jaron.boodschappenVergelijkerBackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String naam;

    String url;

    double prijs;

    String inhoud;

    @Column(name = "image_url", length = 255)
    String imageUrl;
    @JsonBackReference
    @ManyToOne
    Supermarkt supermarkt;
    @JsonGetter("supermarkt")

    public Supermarkt getSupermarkt() {
        return supermarkt;
    }
    public void setSupermarkt(Supermarkt supermarkt) {
        this.supermarkt = supermarkt;
    }
    @JsonGetter("imageUrl")
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    @JsonGetter("id")
    public int getId() {
        return id;
    }

    @JsonGetter("naam")
    public String getNaam() {
        return naam;
    }

    @JsonSetter("n")
    public void setNaam(String n) {
        this.naam = n;
    }

    @JsonGetter("url")

    public String getUrl() {
        return url;
    }

    @JsonSetter("l")
    public void setUrl(String l) {
        this.url = l;
    }

    @JsonGetter("prijs")

    public double getPrijs() {
        return prijs;
    }

    @JsonSetter("p")
    public void setPrijs(double p) {
        this.prijs = p;
    }

    @JsonGetter("inhoud")

    public String getInhoud() {
        return inhoud;
    }

    @JsonSetter("s")
    public void setInhoud(String s) {
        this.inhoud = s;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", n='" + naam + '\'' +
                ", l='" + url + '\'' +
                ", p=" + prijs +
                ", s='" + inhoud + '\'' +
                '}';
    }
}
