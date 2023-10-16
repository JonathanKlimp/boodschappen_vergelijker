package jonathan.jaron.boodschappenVergelijkerBackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.persistence.*;
import jonathan.jaron.boodschappenVergelijkerBackend.tools.ConsoleColors;

@Entity
@Table(name = "product")
public class ProductDto {
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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supermarkt_id")
    SupermarktDto supermarkt;

    @JsonGetter("supermarkt")
    public SupermarktDto getSupermarkt() {
        return supermarkt;
    }

    public void setSupermarkt(SupermarktDto supermarkt) {
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

    public void setId(int id) {
        this.id = id;
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

    public String toShortString() {
        return ConsoleColors.ANSI_GREEN + "(" + naam + ConsoleColors.ANSI_RESET + "\t\t\tvan de\t\t\t" + ConsoleColors.ANSI_BLUE + supermarkt.getMerkNaam() + ")\n" + ConsoleColors.ANSI_RESET;
    }

    @Override
    public String toString() {
        return
                ConsoleColors.ANSI_BLUE + supermarkt + ConsoleColors.ANSI_RESET +
                        ConsoleColors.ANSI_GREEN +
                        "\n\t id=\t\t" + id +
                        "\n\t naam=\t\t" + naam +
                        "\n\t url=\t\t" + url +
                        "\n\t prijs=\t\t" + prijs +
                        "\n\t inhoud=\t" + inhoud +
                        "\n --------------- \n"
                        + ConsoleColors.ANSI_RESET;

    }
}
