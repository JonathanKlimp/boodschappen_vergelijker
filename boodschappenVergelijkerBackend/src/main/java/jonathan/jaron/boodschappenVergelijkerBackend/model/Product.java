package jonathan.jaron.boodschappenVergelijkerBackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @JsonProperty("n")
    String naam;

    @JsonProperty("l")
    String url;

    @JsonProperty("p")
    double prijs;

    @JsonProperty("s")
    String inhoud;

    @Column(name = "image_url", length = 255)
    String imageUrl;
    @JsonBackReference
    @ManyToOne
    Supermarkt supermarkt;

    public Supermarkt getSupermarkt() {
        return supermarkt;
    }

    public void setSupermarkt(Supermarkt supermarkt) {
        this.supermarkt = supermarkt;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public int getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String n) {
        this.naam = n;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String l) {
        this.url = l;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double p) {
        this.prijs = p;
    }

    public String getInhoud() {
        return inhoud;
    }

    public void setInhoud(String s) {
        this.inhoud = s;
    }
}
