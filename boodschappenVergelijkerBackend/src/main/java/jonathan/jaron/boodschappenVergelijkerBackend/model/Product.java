package jonathan.jaron.boodschappenVergelijkerBackend.model;

import com.fasterxml.jackson.annotation.*;
import com.sun.tools.jconsole.JConsoleContext;
import jakarta.persistence.*;
import jonathan.jaron.boodschappenVergelijkerBackend.tools.ConsoleColors;

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

    //Nodig voor het vullen
    //@JsonBackReference(value = "producten")
    //Nodig voor het uitlezen
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supermarkt_id")
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
